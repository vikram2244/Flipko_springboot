package com.flipkoo.cart.service;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkoo.cart.entity.*;
import com.flipkoo.cart.repo.*;

@Service
@Transactional
public class ServiceImp implements UserService {

    private final RestTemplate restTemplate;
    private final CartRepository cartRepository;
    private final MobileRepo mobileRepo;
    private final AcRepo acRepo;
    private final BooksRepo booksRepo;
    private final ComputerRepo computerRepo;
    private final FridgesRepo fridgeRepo;
    private final FurnitureRepo furnitureRepo;
    private final KitchenRepo kitchenRepo;
    private final MenRepo menRepo;
    private final SpeakersRepo speakersRepo;
    private final TvRepo tvsRepo;
    private final WatchesRepo watchesRepo;
    private final WomenRepo womenRepo;
    private final UserRepo userRepo;
    private final ObjectMapper objectMapper;

    @Value("${api.base-url}")
    private String BASE_API_URL;

    // Cache for product data
    private final Map<String, List<?>> productCache = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public ServiceImp(MobileRepo mobileRepo, AcRepo acRepo, BooksRepo booksRepo, ComputerRepo computerRepo,
                     FridgesRepo fridgeRepo, FurnitureRepo furnitureRepo, KitchenRepo kitchenRepo, MenRepo menRepo,
                     SpeakersRepo speakersRepo, TvRepo tvsRepo, WatchesRepo watchesRepo, WomenRepo womenRepo,
                     RestTemplate restTemplate, UserRepo userRepo, ObjectMapper objectMapper, 
                     CartRepository cartRepository) {
        this.mobileRepo = mobileRepo;
        this.acRepo = acRepo;
        this.booksRepo = booksRepo;
        this.computerRepo = computerRepo;
        this.fridgeRepo = fridgeRepo;
        this.furnitureRepo = furnitureRepo;
        this.kitchenRepo = kitchenRepo;
        this.menRepo = menRepo;
        this.speakersRepo = speakersRepo;
        this.tvsRepo = tvsRepo;
        this.watchesRepo = watchesRepo;
        this.womenRepo = womenRepo;
        this.restTemplate = restTemplate;
        this.userRepo = userRepo;
        this.objectMapper = objectMapper;
        this.cartRepository = cartRepository;

        // Initialize cache refresh scheduler
        scheduler.scheduleAtFixedRate(this::refreshAllCaches, 5, 30, TimeUnit.MINUTES);
    }

    // Generic method to handle all product types
    private <T> List<T> getProductData(String endpoint, Class<T[]> clazz, JpaRepository<T, Integer> repo) {
        List<T> cached = (List<T>) productCache.get(endpoint);
        if (cached != null) {
            return cached;
        }
        T[] dataArray = restTemplate.getForObject(BASE_API_URL + endpoint, clazz);
        if (dataArray == null) {
            return Collections.emptyList();
        }
        Set<Integer> existingIds = repo.findAllById(
            Arrays.stream(dataArray)
                .map(this::getIdFromEntity)
                .collect(Collectors.toList())
        ).stream()
        .map(this::getIdFromEntity)
        .collect(Collectors.toSet());

        // Filter and save new items
        List<T> newData = Arrays.stream(dataArray)
            .filter(entity -> !existingIds.contains(getIdFromEntity(entity)))
            .collect(Collectors.toList());

        if (!newData.isEmpty()) {
            repo.saveAll(newData);
        }

        // Get all data from DB (including newly saved)
        List<T> allData = repo.findAll();
        
        // Update cache
        productCache.put(endpoint, allData);
        
        return allData;
    }

    private <T> Integer getIdFromEntity(T entity) {
        if (entity instanceof MobileEntity) return ((MobileEntity) entity).getId();
        if (entity instanceof AcEntity) return ((AcEntity) entity).getId();
        if (entity instanceof BooksEntity) return ((BooksEntity) entity).getId();
        if (entity instanceof ComputerEntity) return ((ComputerEntity) entity).getId();
        if (entity instanceof FridgeEntity) return ((FridgeEntity) entity).getId();
        if (entity instanceof FurnitureEntity) return ((FurnitureEntity) entity).getId();
        if (entity instanceof KitchenData) return ((KitchenData) entity).getId();
        if (entity instanceof MenData) return ((MenData) entity).getId();
        if (entity instanceof SpeakersData) return ((SpeakersData) entity).getId();
        if (entity instanceof TvsData) return ((TvsData) entity).getId();
        if (entity instanceof WatchesData) return ((WatchesData) entity).getId();
        if (entity instanceof WomenData) return ((WomenData) entity).getId();
        throw new IllegalArgumentException("Unsupported entity type");
    }

    @Async
    public void refreshAllCaches() {
        productCache.clear();
        // Pre-load all caches in background
        getMobilesData();
        getAcData();
        getBooksData();
        getComputerData();
        getFridgeData();
        getFurnitureData();
        getKitchenData();
        getMenData();
        getSpeakersData();
        getTvsData();
        getWatchesData();
        getWomenData();
    }

    @Override
    public List<MobileEntity> getMobilesData() {
        return getProductData("/mobiles", MobileEntity[].class, mobileRepo);
    }

    @Override
    public List<AcEntity> getAcData() {
        return getProductData("/ac", AcEntity[].class, acRepo);
    }

    @Override
    public List<BooksEntity> getBooksData() {
        return getProductData("/books", BooksEntity[].class, booksRepo);
    }

    @Override
    public List<ComputerEntity> getComputerData() {
        return getProductData("/computers", ComputerEntity[].class, computerRepo);
    }

    @Override
    public List<FridgeEntity> getFridgeData() {
        return getProductData("/fridges", FridgeEntity[].class, fridgeRepo);
    }

    @Override
    public List<FurnitureEntity> getFurnitureData() {
        return getProductData("/furniture", FurnitureEntity[].class, furnitureRepo);
    }

    @Override
    public List<KitchenData> getKitchenData() {
        return getProductData("/kitchen", KitchenData[].class, kitchenRepo);
    }

    @Override
    public List<MenData> getMenData() {
        return getProductData("/men", MenData[].class, menRepo);
    }

    @Override
    public List<SpeakersData> getSpeakersData() {
        return getProductData("/speakers", SpeakersData[].class, speakersRepo);
    }

    @Override
    public List<TvsData> getTvsData() {
        return getProductData("/tvs", TvsData[].class, tvsRepo);
    }

    @Override
    public List<WatchesData> getWatchesData() {
        return getProductData("/watches", WatchesData[].class, watchesRepo);
    }

    @Override
    public List<WomenData> getWomenData() {
        return getProductData("/women", WomenData[].class, womenRepo);
    }

    @Override
    public UserEntity signUpData(UserEntity userEntity) {
        if (userEntity == null || userEntity.getPassword() == null || userEntity.getPassword().isEmpty()) {
            throw new IllegalArgumentException("User or password cannot be null or empty");
        }
        if (!userEntity.getPassword().equals(userEntity.getConfirmPassword())) {
            throw new IllegalArgumentException("Password and confirm password do not match");
        }
        return userRepo.save(userEntity);
    }

    @Override
    public Boolean checkReg(UserEntity userEntity) {
        if (userEntity == null || userEntity.getEmail() == null || userEntity.getPassword() == null) {
            return false;
        }
        return userRepo.findByEmail(userEntity.getEmail()).isPresent();
    }

    @Override
    public Boolean isValidUser(LoginEntity loginEntity) {
        if (loginEntity == null || loginEntity.getEmail() == null || loginEntity.getPassword() == null) {
            return false;
        }
        return userRepo.findByEmailAndPassword(loginEntity.getEmail(), loginEntity.getPassword()).isPresent();
    }

    @Override
    public Object saveProduct(String names, Object productData) {
        try {
            switch (names.toLowerCase()) {
                case "mobiles":
                    return saveProductInternal(productData, MobileEntity.class, mobileRepo);
                case "ac":
                    return saveProductInternal(productData, AcEntity.class, acRepo);
                case "books":
                    return saveProductInternal(productData, BooksEntity.class, booksRepo);
                case "computers":
                    return saveProductInternal(productData, ComputerEntity.class, computerRepo);
                case "fridges":
                    return saveProductInternal(productData, FridgeEntity.class, fridgeRepo);
                case "furniture":
                    return saveProductInternal(productData, FurnitureEntity.class, furnitureRepo);
                case "kitchen":
                    return saveProductInternal(productData, KitchenData.class, kitchenRepo);
                case "men":
                    return saveProductInternal(productData, MenData.class, menRepo);
                case "speakers":
                    return saveProductInternal(productData, SpeakersData.class, speakersRepo);
                case "tvs":
                    return saveProductInternal(productData, TvsData.class, tvsRepo);
                case "watches":
                    return saveProductInternal(productData, WatchesData.class, watchesRepo);
                case "women":
                    return saveProductInternal(productData, WomenData.class, womenRepo);
                default:
                    throw new IllegalArgumentException("Invalid product type: " + names);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to save product: " + e.getMessage(), e);
        }
    }

    private <T> T saveProductInternal(Object productData, Class<T> clazz, JpaRepository<T, Integer> repo) {
        T entity = objectMapper.convertValue(productData, clazz);
        T saved = repo.save(entity);
        productCache.clear(); // Invalidate cache
        return saved;
    }

    @Override
    public Object updateProduct(String productType, String id, Object productData) {
        try {
            if (productType == null || id == null || productData == null) {
                throw new IllegalArgumentException("Product type, ID, and data cannot be null");
            }

            Integer parsedId = Integer.parseInt(id);

            switch (productType.toLowerCase()) {
                case "mobiles":
                    return updateProductInternal(parsedId, productData, MobileEntity.class, mobileRepo);
                case "ac":
                    return updateProductInternal(parsedId, productData, AcEntity.class, acRepo);
                // Add other cases as needed
                default:
                    throw new IllegalArgumentException("Invalid product type: " + productType);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID format: " + id, e);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to update product: " + e.getMessage(), e);
        }
    }

    private <T> T updateProductInternal(Integer id, Object productData, Class<T> clazz, JpaRepository<T, Integer> repo) {
        T existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(clazz.getSimpleName() + " with ID " + id + " not found"));
        T updated = objectMapper.convertValue(productData, clazz);
        // Preserve the ID
        if (updated instanceof BaseEntity) {
            ((BaseEntity) updated).setId(id);
        }
        productCache.clear(); // Invalidate cache
        return repo.save(updated);
    }

    @Override
    public CartEntity addToCart(String userId, Integer productId, String productType, Object productDetails) {
        CartEntity existingCartItem = cartRepository.findByUserIdAndProductIdAndProductType(userId, productId, productType);
        
        if (existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
            return cartRepository.save(existingCartItem);
        }

        CartEntity cartItem = new CartEntity();
        cartItem.setUserId(userId);
        cartItem.setProductId(productId);
        cartItem.setProductType(productType);
        cartItem.setQuantity(1);

        if (productDetails instanceof Map) {
            Map<String, Object> details = (Map<String, Object>) productDetails;
            cartItem.setBrand((String) details.get("brand"));
            cartItem.setModel((String) details.get("model"));
            cartItem.setPrice(parsePrice(details.get("price")));
            cartItem.setImage((String) details.get("image"));
            cartItem.setCategory((String) details.get("category"));
            cartItem.setDescription((String) details.get("description"));
        }

        return cartRepository.save(cartItem);
    }

    private double parsePrice(Object priceObj) {
        if (priceObj instanceof String) {
            return Double.parseDouble((String) priceObj);
        } else if (priceObj instanceof Number) {
            return ((Number) priceObj).doubleValue();
        }
        throw new IllegalArgumentException("Invalid price format");
    }

    @Override
    public List<CartEntity> getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId);
    }
}