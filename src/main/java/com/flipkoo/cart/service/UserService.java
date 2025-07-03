package com.flipkoo.cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
import com.flipkoo.cart.entity.UserEntity;
import com.flipkoo.cart.entity.WatchesData;
import com.flipkoo.cart.entity.WomenData;

@Service
public interface UserService {
	List<MobileEntity> getMobilesData();
	List<AcEntity> getAcData();
	List<BooksEntity> getBooksData();
	List<ComputerEntity> getComputerData();
	List<FridgeEntity> getFridgeData();
	List<FurnitureEntity> getFurnitureData();
	List<KitchenData> getKitchenData();
	List<MenData> getMenData();
	List<SpeakersData> getSpeakersData();
	List<TvsData> getTvsData();
	List<WatchesData> getWatchesData();
	List<WomenData> getWomenData();
	UserEntity signUpData(UserEntity userEntity);
	Boolean checkReg(UserEntity userEntity);
	Boolean isValidUser(LoginEntity loginEntity);
	Object saveProduct(String names, Object productData);
	Object updateProduct(String productType, String id, Object productData);
	CartEntity addToCart(String userId, Integer productId, String productType, Object productDetails);
    List<CartEntity> getCartByUserId(String userId);
    
	
	
}
