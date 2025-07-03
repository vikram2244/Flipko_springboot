package com.flipkoo.cart.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.flipkoo.cart.repo.CartRepository;
import com.flipkoo.cart.repo.MobileRepo;
import com.flipkoo.cart.repo.UserRepo;
import com.flipkoo.cart.service.UserService;

@RestController
@RequestMapping("/api")
public class UserControllers {
    private final UserService userService;
    private final MobileRepo mobileRepo;
    private final CartRepository cartRepository;
    private final UserRepo userRepo;

    public static final List<String> VALID_PRODUCT_TYPES = Arrays.asList(
        "mobiles", "ac", "books", "computers", "fridges", "furniture",
        "kitchen", "men", "speakers", "tvs", "watches", "women"
    );

    public UserControllers(UserService userService, MobileRepo mobileRepo, CartRepository cartRepository, UserRepo userRepo) {
        this.userService = userService;
        this.mobileRepo = mobileRepo;
        this.cartRepository = cartRepository;
        this.userRepo = userRepo;
    }

    @GetMapping("/mobiles")
    public ResponseEntity<?> getMobilesData() {
        try {
            List<MobileEntity> data = userService.getMobilesData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching mobiles: " + e.getMessage());
        }
    }

    @GetMapping("/ac")
    public ResponseEntity<?> getAcData() {
        try {
            List<AcEntity> data = userService.getAcData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching ACs: " + e.getMessage());
        }
    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooksData() {
        try {
            List<BooksEntity> data = userService.getBooksData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching books: " + e.getMessage());
        }
    }

    @GetMapping("/computers")
    public ResponseEntity<?> getComputerData() {
        try {
            List<ComputerEntity> data = userService.getComputerData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching computers: " + e.getMessage());
        }
    }

    @GetMapping("/fridges")
    public ResponseEntity<?> getFridgeData() {
        try {
            List<FridgeEntity> data = userService.getFridgeData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching fridges: " + e.getMessage());
        }
    }

    @GetMapping("/furniture")
    public ResponseEntity<?> getFurnitureData() {
        try {
            List<FurnitureEntity> data = userService.getFurnitureData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching furniture: " + e.getMessage());
        }
    }

    @GetMapping("/kitchen")
    public ResponseEntity<?> getKitchenData() {
        try {
            List<KitchenData> data = userService.getKitchenData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching kitchen items: " + e.getMessage());
        }
    }

    @GetMapping("/men")
    public ResponseEntity<?> getMenData() {
        try {
            List<MenData> data = userService.getMenData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching men's items: " + e.getMessage());
        }
    }

    @GetMapping("/speakers")
    public ResponseEntity<?> getSpeakersData() {
        try {
            List<SpeakersData> data = userService.getSpeakersData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching speakers: " + e.getMessage());
        }
    }

    @GetMapping("/tvs")
    public ResponseEntity<?> getTvsData() {
        try {
            List<TvsData> data = userService.getTvsData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching TVs: " + e.getMessage());
        }
    }

    @GetMapping("/watches")
    public ResponseEntity<?> getWatchesData() {
        try {
            List<WatchesData> data = userService.getWatchesData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching watches: " + e.getMessage());
        }
    }

    @GetMapping("/women")
    public ResponseEntity<?> getWomenData() {
        try {
            List<WomenData> data = userService.getWomenData();
            return data.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching women's items: " + e.getMessage());
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> postSignUp(@RequestBody UserEntity userEntity) {
        try {
            if (userEntity == null || userEntity.getEmail() == null || userEntity.getPassword() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data");
            }
            if (userService.checkReg(userEntity)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
            }
            UserEntity createdUser = userService.signUpData(userEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during signup: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginEntity loginEntity) {
        try {
            if (loginEntity == null || loginEntity.getEmail() == null || loginEntity.getPassword() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email and password cannot be null");
            }
            boolean isValid = userService.isValidUser(loginEntity);
            if (isValid) {
                UserEntity user = userRepo.findByEmail(loginEntity.getEmail()).orElseThrow(() -> new IllegalArgumentException("User not found"));
                return ResponseEntity.ok(Map.of("message", "Login successful", "userId", user.getEmail())); // Return email as userId
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during login: " + e.getMessage());
        }
    }

    @PostMapping("/adminedit/{names}")
    public ResponseEntity<?> adminEdit(@PathVariable("names") String names, @RequestBody Object productData) {
        try {
            if (names == null || names.isEmpty() || productData == null || !VALID_PRODUCT_TYPES.contains(names.toLowerCase())) {
                return ResponseEntity.badRequest().body("Invalid product type or data");
            }
            Object savedEntity = userService.saveProduct(names, productData);
            return ResponseEntity.ok(savedEntity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error saving product: " + e.getMessage());
        }
    }

    @PutMapping("/editadmin/{product}/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable("product") String product, @PathVariable("id") String id, @RequestBody Object productData) {
        try {
            if (product == null || id == null || productData == null || !VALID_PRODUCT_TYPES.contains(product.toLowerCase())) {
                return ResponseEntity.badRequest().body("Invalid product type, ID, or data");
            }
            Object updatedEntity = userService.updateProduct(product, id, productData);
            return ResponseEntity.ok(updatedEntity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error updating product: " + e.getMessage());
        }
    }

    @GetMapping("/mobiles/{id}")
    public ResponseEntity<?> getMobileById(@PathVariable("id") String id) {
        try {
            Integer parsedId = Integer.parseInt(id);
            MobileEntity mobile = mobileRepo.findById(parsedId)
                    .orElseThrow(() -> new IllegalArgumentException("Mobile with ID " + id + " not found"));
            return ResponseEntity.ok(mobile);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid ID format: " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error fetching mobile: " + e.getMessage());
        }
    }

    @GetMapping("/{name}/latest")
    public ResponseEntity<?> getLatestProduct(@PathVariable String name) {
        if (!VALID_PRODUCT_TYPES.contains(name.toLowerCase())) {
            return ResponseEntity.badRequest().body("Invalid product type: " + name);
        }
        Optional<MobileEntity> optionalProduct = mobileRepo.findTopByProductOrderByIdDesc(name);

        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No product found for name: " + name);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<CartEntity> addToCart(
            @RequestParam String userId,
            @RequestParam Integer productId,
            @RequestParam String productType,
            @RequestBody Map<String, Object> productDetails) {
        if (!VALID_PRODUCT_TYPES.contains(productType.toLowerCase())) {
            return ResponseEntity.badRequest().build();
        }
        CartEntity cartItem = userService.addToCart(userId, productId, productType, productDetails);
        return ResponseEntity.ok(cartItem);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartEntity>> getCartByUserId(@PathVariable String userId) {
        System.out.println("Fetching cart for userId: " + userId);
        List<CartEntity> cartItems = userService.getCartByUserId(userId);
        System.out.println("Cart items found: " + cartItems.size());
        return ResponseEntity.ok(cartItems);
    }

    @PutMapping("/cart/update")
    public ResponseEntity<CartEntity> updateCartItem(
            @RequestBody Map<String, Object> request) {
        String userId = request.get("userId").toString();
        Integer productId = Integer.valueOf(request.get("productId").toString());
        String productType = (String) request.get("productType");
        Integer quantity = Integer.valueOf(request.get("quantity").toString());

        if (!VALID_PRODUCT_TYPES.contains(productType.toLowerCase())) {
            return ResponseEntity.badRequest().build();
        }

        CartEntity cartItem = userService.getCartByUserId(userId).stream()
                .filter(item -> item.getProductId().equals(productId) && item.getProductType().equals(productType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cart item not found"));

        if (quantity <= 0) {
            cartRepository.delete(cartItem);
            return ResponseEntity.ok().build();
        } else {
            cartItem.setQuantity(quantity);
            return ResponseEntity.ok(userService.addToCart(userId, productId, productType, cartItem));
        }
    }

    @DeleteMapping("/cart/remove")
    public ResponseEntity<Void> removeCartItem(
            @RequestParam String userId,
            @RequestParam Integer productId,
            @RequestParam String productType) {
        System.out.println("Removing cart item: userId=" + userId + ", productId=" + productId + ", productType=" + productType);
        if (!VALID_PRODUCT_TYPES.contains(productType.toLowerCase())) {
            System.out.println("Invalid product type: " + productType);
            return ResponseEntity.badRequest().build();
        }
        CartEntity cartItem = cartRepository.findByUserIdAndProductIdAndProductType(userId, productId, productType);
        if (cartItem != null) {
            cartRepository.delete(cartItem);
            System.out.println("Cart item removed successfully");
        } else {
            System.out.println("Cart item not found");
        }
        return ResponseEntity.ok().build();
    }
    
}