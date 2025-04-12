package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.dto.*;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.PurchasesRepository;
import jakarta.mail.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final PurchasesRepository purchasesRepository;

    public List<ProductWithPriceDto> getSalesStatistics(List<Purchases> allPurchases) {
        Map<String, Float> productSalesMap = new HashMap<>();

        for (Purchases purchase : allPurchases) {
            if (purchase.getStatus() != PurchaseStatus.COMPLETED) {
                continue;
            }

            for (PurchaseItem item : purchase.getItemList()) {

                Product product = item.getProduct();

                if (product instanceof Pc && ((Pc) product).getPcType().getValue().equals("configuration")) {
                    String productName = "Пользовательские конфигурации";
                    float total = product.getPrice() * item.getQuantity();
                    productSalesMap.merge(productName, total, Float::sum);
                    continue;
                }

                String productName = product.getName();
                float total = product.getPrice() * item.getQuantity();

                productSalesMap.merge(productName, total, Float::sum);
            }
        }

        return productSalesMap.entrySet().stream()
                .map(entry -> new ProductWithPriceDto(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingDouble(ProductWithPriceDto::getPrice).reversed())
                .limit(8)
                .collect(Collectors.toList());

    }

    public List<ComparingProductsDto> getMostComparedProducts(List<CompareItems> allCompareItems) {
        Map<String, Integer> comparisonCountMap = new HashMap<>();

        for (CompareItems compareItem : allCompareItems) {
            Product product = compareItem.getProduct();

            String productName = product.getName();

            comparisonCountMap.merge(productName, 1, Integer::sum);
        }

        return comparisonCountMap.entrySet().stream()
                .map(entry -> new ComparingProductsDto(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingInt(ComparingProductsDto::getQuantity).reversed())
                .limit(8)
                .collect(Collectors.toList());
    }

    public SellingStatistic getSellingTypes() {
        float partsTotal = 0f;
        float pcTotal = 0f;
        float configurationsTotal = 0f;

        for (Purchases purchase : purchasesRepository.findAll()) {
            if (purchase.getStatus() != PurchaseStatus.COMPLETED) {
                continue;
            }

            for (PurchaseItem item : purchase.getItemList()) {

                Product product = item.getProduct();
                if (product instanceof Pc && ((Pc) product).getPcType().getValue().equals("configuration")) {
                    configurationsTotal += product.getPrice() * item.getQuantity();
                    continue;
                }

                if (product instanceof Pc) {
                    pcTotal += product.getPrice() * item.getQuantity();
                    continue;
                }

                if (product instanceof Parts) {
                    partsTotal += product.getPrice() * item.getQuantity();
                }
            }
        }

        float total = partsTotal + pcTotal + configurationsTotal;
        List<SellingTypesDto> sellingTypes = new ArrayList<>();
        sellingTypes.add(new SellingTypesDto("Комлектующие", (partsTotal/total)*100));
        sellingTypes.add(new SellingTypesDto("Конфигурации пользователей", (configurationsTotal/total)*100));
        sellingTypes.add(new SellingTypesDto("Официальные сборки", (pcTotal/total)*100));

        SellingStatistic sellingStatistic = new SellingStatistic();
        sellingStatistic.setData(sellingTypes.stream().sorted(Comparator.comparingDouble(SellingTypesDto::getPercentage).reversed()).collect(Collectors.toList()));
        sellingStatistic.setTotalSell(total);

        return sellingStatistic;
    }

    public List<SalesIncomePerPeriodDto> getDailySalesIncome() {
        List<Purchases> allPurchases = purchasesRepository.findAll();
        Map<String, Float> incomePerDay = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (Purchases purchase : allPurchases) {
            if (purchase.getStatus() != PurchaseStatus.COMPLETED) continue;

            String dateKey = formatter.format(purchase.getDate());

            float total = 0f;
            for (PurchaseItem item : purchase.getItemList()) {
                Product product = item.getProduct();
                total += product.getPrice() * item.getQuantity();
            }

            incomePerDay.merge(dateKey, total, Float::sum);
        }

        return incomePerDay.entrySet().stream()
                .map(entry -> new SalesIncomePerPeriodDto(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(SalesIncomePerPeriodDto::getDate))
                .collect(Collectors.toList());
    }

}
