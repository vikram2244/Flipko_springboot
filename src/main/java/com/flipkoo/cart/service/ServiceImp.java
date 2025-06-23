package com.flipkoo.cart.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkoo.cart.entity.AcEntity;
import com.flipkoo.cart.entity.BooksEntity;
import com.flipkoo.cart.entity.CartEntity;
import com.flipkoo.cart.entity.ComputerEntity;
import com.flipkoo.cart.entity.FridgeEntity;
import com.flipkoo.cart.entity.FurnitureEntity;
import com.flipkoo.cart.entity.KitchenData;
import com.flipkoo.cart.entity.LoginEntity;
import com.flipkoo.cart.entity.MenData;
import com.flipkoo.cart.entity.MobileEntity;
import com.flipkoo.cart.entity.SpeakersData;
import com.flipkoo.cart.entity.TvsData;
import com.flipkoo.cart.entity.WatchesData;
import com.flipkoo.cart.entity.WomenData;
import com.flipkoo.cart.entity.UserEntity;
import com.flipkoo.cart.repo.AcRepo;
import com.flipkoo.cart.repo.BooksRepo;
import com.flipkoo.cart.repo.CartRepository;
import com.flipkoo.cart.repo.ComputerRepo;
import com.flipkoo.cart.repo.FridgesRepo;
import com.flipkoo.cart.repo.FurnitureRepo;
import com.flipkoo.cart.repo.KitchenRepo;
import com.flipkoo.cart.repo.LoginRepo;
import com.flipkoo.cart.repo.MenRepo;
import com.flipkoo.cart.repo.MobileRepo;
import com.flipkoo.cart.repo.SpeakersRepo;
import com.flipkoo.cart.repo.TvRepo;
import com.flipkoo.cart.repo.WatchesRepo;
import com.flipkoo.cart.repo.WomenRepo;
import com.flipkoo.cart.repo.UserRepo;

@Service
public class ServiceImp implements UserService {

    private final RestTemplate restTemplate;
    private CartRepository cartRepository;
    
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
    public ServiceImp(MobileRepo mobileRepo, AcRepo acRepo, BooksRepo booksRepo, ComputerRepo computerRepo,
                      FridgesRepo fridgeRepo, FurnitureRepo furnitureRepo, KitchenRepo kitchenRepo, MenRepo menRepo,
                      SpeakersRepo speakersRepo, TvRepo tvsRepo, WatchesRepo watchesRepo, WomenRepo womenRepo,
                      RestTemplate restTemplate, UserRepo userRepo, ObjectMapper objectMapper,CartRepository cartRepository) {
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
    }

    @Override
    public List<MobileEntity> getMobilesData() {
        MobileEntity[] dataArray = restTemplate.getForObject(BASE_API_URL + "/mobiles", MobileEntity[].class);
        List<MobileEntity> newData = Arrays.stream(dataArray).filter(entity -> !mobileRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        mobileRepo.saveAll(newData);
        return mobileRepo.findAll();
    }

    @Override
    public List<AcEntity> getAcData() {
        AcEntity[] dataArray = restTemplate.getForObject(BASE_API_URL + "/ac", AcEntity[].class);
        List<AcEntity> newData = Arrays.stream(dataArray).filter(entity -> !acRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        acRepo.saveAll(newData);
        return acRepo.findAll();
    }

    @Override
    public
    List<BooksEntity> getBooksData() {
        BooksEntity[] dataArray = restTemplate.getForObject(BASE_API_URL + "/books", BooksEntity[].class);
        List<BooksEntity> newData = Arrays.stream(dataArray).filter(entity -> !booksRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        booksRepo.saveAll(newData);
        return booksRepo.findAll();
    }

    @Override
    public List<ComputerEntity> getComputerData() {
        ComputerEntity[] dataArray = restTemplate.getForObject(BASE_API_URL + "/computers", ComputerEntity[].class);
        List<ComputerEntity> newData = Arrays.stream(dataArray)
                .filter(entity -> !computerRepo.existsById(entity.getId())).collect(Collectors.toList());
        computerRepo.saveAll(newData);
        return computerRepo.findAll();
    }

    @Override
    public List<FridgeEntity> getFridgeData() {
        FridgeEntity[] dataArray = restTemplate.getForObject(BASE_API_URL + "/fridges", FridgeEntity[].class);
        List<FridgeEntity> newData = Arrays.stream(dataArray).filter(entity -> !fridgeRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        fridgeRepo.saveAll(newData);
        return fridgeRepo.findAll();
    }

    @Override
    public List<FurnitureEntity> getFurnitureData() {
        FurnitureEntity[] dataArray = restTemplate.getForObject(BASE_API_URL + "/furniture", FurnitureEntity[].class);
        List<FurnitureEntity> newData = Arrays.stream(dataArray)
                .filter(entity -> !furnitureRepo.existsById(entity.getId())).collect(Collectors.toList());
        furnitureRepo.saveAll(newData);
        return furnitureRepo.findAll();
    }

    @Override
    public List<KitchenData> getKitchenData() {
        KitchenData[] dataArray = restTemplate.getForObject(BASE_API_URL + "/kitchen", KitchenData[].class);
        List<KitchenData> newData = Arrays.stream(dataArray).filter(entity -> !kitchenRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        kitchenRepo.saveAll(newData);
        return kitchenRepo.findAll();
    }

    @Override
    public List<MenData> getMenData() {
        MenData[] dataArray = restTemplate.getForObject(BASE_API_URL + "/men", MenData[].class);
        List<MenData> newData = Arrays.stream(dataArray).filter(entity -> !menRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        menRepo.saveAll(newData);
        return menRepo.findAll();
    }

    @Override
    public List<SpeakersData> getSpeakersData() {
        SpeakersData[] dataArray = restTemplate.getForObject(BASE_API_URL + "/speakers", SpeakersData[].class);
        List<SpeakersData> newData = Arrays.stream(dataArray).filter(entity -> !speakersRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        speakersRepo.saveAll(newData);
        return speakersRepo.findAll();
    }

    @Override
    public List<TvsData> getTvsData() {
        TvsData[] dataArray = restTemplate.getForObject(BASE_API_URL + "/tvs", TvsData[].class);
        List<TvsData> newData = Arrays.stream(dataArray).filter(entity -> !tvsRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        tvsRepo.saveAll(newData);
        return tvsRepo.findAll();
    }

    @Override
    public List<WatchesData> getWatchesData() {
        WatchesData[] dataArray = restTemplate.getForObject(BASE_API_URL + "/watches", WatchesData[].class);
        List<WatchesData> newData = Arrays.stream(dataArray).filter(entity -> !watchesRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        watchesRepo.saveAll(newData);
        return watchesRepo.findAll();
    }

    @Override
    public List<WomenData> getWomenData() {
        WomenData[] dataArray = restTemplate.getForObject(BASE_API_URL + "/women", WomenData[].class);
        List<WomenData> newData = Arrays.stream(dataArray).filter(entity -> !womenRepo.existsById(entity.getId()))
                .collect(Collectors.toList());
        womenRepo.saveAll(newData);
        return womenRepo.findAll();
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
        Optional<UserEntity> existingUser = userRepo.findByEmail(userEntity.getEmail());
        return existingUser.isPresent();
    }

    @Override
    public Boolean isValidUser(LoginEntity loginEntity) {
        if (loginEntity == null || loginEntity.getEmail() == null || loginEntity.getPassword() == null) {
            return false;
        }
        Optional<UserEntity> userOpt = userRepo.findByEmail(loginEntity.getEmail());
        if (userOpt.isPresent()) {
            return userOpt.get().getPassword().equals(loginEntity.getPassword());
        }
        return false;
    }

    @Override
    public Object saveProduct(String names, Object productData) {
        try {
            switch (names.toLowerCase()) {
                case "mobiles":
                    MobileEntity mobileEntity = objectMapper.convertValue(productData, MobileEntity.class);
                    return mobileRepo.save(mobileEntity);
                case "ac":
                    AcEntity acEntity = objectMapper.convertValue(productData, AcEntity.class);
                    return acRepo.save(acEntity);
                case "books":
                    BooksEntity booksEntity = objectMapper.convertValue(productData, BooksEntity.class);
                    return booksRepo.save(booksEntity);
                case "computers":
                    ComputerEntity computerEntity = objectMapper.convertValue(productData, ComputerEntity.class);
                    return computerRepo.save(computerEntity);
                case "fridges":
                    FridgeEntity fridgeEntity = objectMapper.convertValue(productData, FridgeEntity.class);
                    return fridgeRepo.save(fridgeEntity);
                case "furniture":
                    FurnitureEntity furnitureEntity = objectMapper.convertValue(productData, FurnitureEntity.class);
                    return furnitureRepo.save(furnitureEntity);
                case "kitchen":
                    KitchenData kitchenData = objectMapper.convertValue(productData, KitchenData.class);
                    return kitchenRepo.save(kitchenData);
                case "men":
                    MenData menData = objectMapper.convertValue(productData, MenData.class);
                    return menRepo.save(menData);
                case "speakers":
                    SpeakersData speakersData = objectMapper.convertValue(productData, SpeakersData.class);
                    return speakersRepo.save(speakersData);
                case "tvs":
                    TvsData tvsData = objectMapper.convertValue(productData, TvsData.class);
                    return tvsRepo.save(tvsData);
                case "watches":
                    WatchesData watchesData = objectMapper.convertValue(productData, WatchesData.class);
                    return watchesRepo.save(watchesData);
                case "women":
                    WomenData womenData = objectMapper.convertValue(productData, WomenData.class);
                    return womenRepo.save(womenData);
                default:
                    throw new IllegalArgumentException("Invalid product type: " + names);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to save product: " + e.getMessage(), e);
        }
    }

    @Override
    public Object updateProduct(String productType, String id, Object productData) {
        try {
            if (productType == null || id == null || productData == null) {
                throw new IllegalArgumentException("Product type, ID, and data cannot be null");
            }

            Integer parsedId;
            try {
                parsedId = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid ID format: " + id, e);
            }

            switch (productType.toLowerCase()) {
                case "mobiles":
                    MobileEntity existingMobile = mobileRepo.findById(parsedId)
                            .orElseThrow(() -> new IllegalArgumentException("Mobile with ID " + id + " not found"));
                    MobileEntity updatedMobile = objectMapper.convertValue(productData, MobileEntity.class);
                    updatedMobile.setId(parsedId);
                    return mobileRepo.save(updatedMobile);
                case "ac":
                    AcEntity existingAc = acRepo.findById(parsedId)
                            .orElseThrow(() -> new IllegalArgumentException("AC with ID " + id + " not found"));
                    AcEntity updatedAc = objectMapper.convertValue(productData, AcEntity.class);
                    return acRepo.save(updatedAc);
                default:
                    throw new IllegalArgumentException("Invalid product type: " + productType);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to update product: " + e.getMessage(), e);
        }
    }
    @Override
    public CartEntity addToCart(String userId, Integer productId, String productType, Object productDetails) {
        CartEntity existingCartItem = cartRepository.findByUserIdAndProductIdAndProductType(userId, productId, productType);
        if (existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
            return cartRepository.save(existingCartItem);
        } else {
            CartEntity cartItem = new CartEntity();
            cartItem.setUserId(userId);
            cartItem.setProductId(productId);
            cartItem.setProductType(productType);
            cartItem.setQuantity(1);
            if (productDetails instanceof Map) {
                Map<String, Object> details = (Map) productDetails;
                cartItem.setBrand((String) details.get("brand"));
                cartItem.setModel((String) details.get("model"));
                cartItem.setPrice(details.get("price") instanceof String 
                    ? Double.parseDouble((String) details.get("price")) 
                    : ((Number) details.get("price")).doubleValue());
                cartItem.setImage((String) details.get("image"));
                cartItem.setCategory((String) details.get("category"));
                cartItem.setDescription((String) details.get("description"));
            }
            return cartRepository.save(cartItem);
        }
    }
    @Override
    public List<CartEntity> getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId);
    }
}

    