package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.dto.*;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.*;
import com.example.amazingpcbackend.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final TypesRepository typesRepository;
    private final CategoriesRepository categoriesRepository;
    private final PartitionsRepository partitionsRepository;
    private final PartsRepository partsRepository;
    private final PurchasesService purchasesService;
    private final PcCategoriesRepository pcCategoriesRepository;
    private final PcTypesRepository pcTypesRepository;
    private final PcModelGroupsRepository pcModelGroupsRepository;
    private final PcService pcService;
    private final ConfiguratorService configuratorService;
    private final CartService cartService;
    private final PurchaseItemRepository purchaseItemRepository;
    private final UsersRepository usersRepository;
    private final CompareService compareService;

    @GetMapping("/types")
    public List<Types> getTypes() {
        return typesRepository.findAll();
    }

    @GetMapping("/categories")
    public List<Categories> getCategories() {
        return categoriesRepository.findAll();
    }

    @GetMapping("/partitions")
    public List<Partitions> getPartitions() {
        return partitionsRepository.findAll();
    }

    @GetMapping("/parts")
    public List<Parts> getParts() {
        return partsRepository.findAll();
    }

    @GetMapping("/parts/{id}")
    public Parts getPartById(@PathVariable String id) {
        return partsRepository.findById(id).orElse(null);
    }

    @GetMapping("/types/{id}")
    public Types getTypeByID(@PathVariable String id) {
        return typesRepository.findById(id).orElse(null);
    }

    @GetMapping("/partitions/{id}")
    public Partitions getPartitionByID(@PathVariable String id) {
        return partitionsRepository.findById(id).orElse(null);
    }

    @GetMapping("/user-cart/{id}")
    public List<PurchaseItem> getUserCartItems(@PathVariable String id) {
        return purchasesService.getUserCartItems(id);
    }

    @GetMapping("/pc-categories")
    public List<PcCategories> getPcCategories() {
        return pcCategoriesRepository.findAll();
    }

    @GetMapping("/not-empty-pc-categories")
    public List<PcCategories> getNotEmptyPcCategories() {
        return pcService.getNonEmptyPcCategories();
    }

    @GetMapping("/pc-types")
    public List<PcTypes> getPcTypes() {
        return pcTypesRepository.findAll();
    }

    @GetMapping("/gaming-pc-catalog")
    public List<CatalogDto> getGamingPcCatalog() {
        return pcService.getCatalog(pcTypesRepository.findByValue("gaming-pc").get());
    }

    @GetMapping("/notebooks-catalog")
    public List<CatalogDto> getNotebooksCatalog() {
        return pcService.getCatalog(pcTypesRepository.findByValue("notebook").get());
    }

    @GetMapping("/workstations-catalog")
    public List<CatalogDto> getWorkstationsCatalog() {
        return pcService.getCatalog(pcTypesRepository.findByValue("workstation").get());
    }

    @GetMapping("/get-pc-by-model-group-name/{modelGroupName}")
    public List<Pc> getPcsByModelGroupName(@PathVariable String modelGroupName) {
        return pcService.getPcsByModelGroupName(modelGroupName);
    }

    @GetMapping("/configurator-parts")
    public ConfiguratorComponentsListDto getConfiguratorParts() {
        return configuratorService.getComponentsList();
    }

    @PutMapping("/edit-purchase-item-quantity")
    public HttpStatus editPurchaseItemQuantity(@RequestBody EditPurchaseItemQuantityDto editPurchaseItemQuantityDto) {
        return cartService.editPurchaseItemQuantity(editPurchaseItemQuantityDto.getId(), editPurchaseItemQuantityDto.getQuantity());
    }

    @DeleteMapping("/purchase-items/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deletePurchaseItem(@PathVariable String id) throws Exception {
        try {
            return cartService.deleteCartItem(id);
        } catch (Exception e) {
            throw new Exception("can't delete purchase item", e);
        }
    }

    @PostMapping("/configurations")
    @ResponseStatus(HttpStatus.OK)
    public IdDto saveConfiguration(@RequestBody PcConfigurationDto configuration) throws Exception {
        try {
            return pcService.addPcConfiguration(configuration);
        } catch (Exception e) {
            throw new Exception("can't save configuration", e);
        }
    }

    @PutMapping("/configurations")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editConfiguration(@RequestBody PcConfigurationDto configuration) throws Exception {
        try {
            return pcService.editPcConfiguration(configuration);
        } catch (Exception e) {
            throw new Exception("can't save configuration", e);
        }
    }

    @GetMapping("/configurations/{id}")
    public Pc getConfiguration(@PathVariable String id) {
        return pcService.getConfiguration(id);
    }

    @PostMapping("/configurator-products-to-cart")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus ConfiguratorProductsToCart(@RequestBody ConfiguratorProductsDto productsDto) throws Exception {
        try {
            List<String> ids = purchasesService.addConfiguratorProductsToPurchaseItems(productsDto);
            return cartService.addCartItemsFromConfigurator(ids, productsDto.getUserId());
        } catch (Exception e) {
            throw new Exception("can't save configuration", e);
        }
    }

    @PostMapping("/pc-to-cart")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus PcToCart(@RequestBody PcToCartDto pcToCartDto) throws Exception {
        try {
            String id = purchasesService.addPurchaseItemPc(new PcIdWithQuantity(pcToCartDto.getPcId(), pcToCartDto.getQuantity()));
            cartService.addCartItemFromPurchaseItem(purchaseItemRepository.findById(id).get(), usersRepository.findById(pcToCartDto.getUserId()).get());
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new Exception("can't save configuration", e);
        }
    }

    @GetMapping("/compare/{userId}")
    public CompareItemsDto getCompareItems(@PathVariable String userId) {
        Users user = usersRepository.findById(userId).get();
        return compareService.getCompareItems(user);
    }

    @GetMapping("/compare-count/{userId}")
    public int getCompareItemsCount(@PathVariable String userId) {
        Users user = usersRepository.findById(userId).get();
        return compareService.getCompareItemsCount(user);
    }

    @DeleteMapping("/compare/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deleteCompareItem(@PathVariable String id) throws Exception {
            return compareService.deleteItemById(id);
    }

    @DeleteMapping("/compare")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deleteAllCompareItems() throws Exception {
        return compareService.deleteAllItems();
    }

    @PostMapping("/compare")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus addCompareItem(@RequestBody AddCompareItemDto addCompareItemDto) throws Exception {
        Users user = usersRepository.findById(addCompareItemDto.getUserId()).get();
        return compareService.addCompareItem(user,addCompareItemDto.getProductId());
    }
}
