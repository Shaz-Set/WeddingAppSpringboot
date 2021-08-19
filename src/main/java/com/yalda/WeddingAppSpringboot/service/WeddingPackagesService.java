package com.yalda.WeddingAppSpringboot.service;

import com.yalda.WeddingAppSpringboot.model.AddOn;
import com.yalda.WeddingAppSpringboot.model.DrinkPackage;
import com.yalda.WeddingAppSpringboot.model.WeddingPackage;

import java.util.List;

public interface WeddingPackagesService {
     //get
     List<WeddingPackage> getAllWeddingPackages();
     List<DrinkPackage> getAllDrinkPackages();
     List<AddOn> getAllAddOns();
     //update
     int updateWeddingPackage(WeddingPackage weddingPackage);
     int updateDrinkPackage(DrinkPackage drinkPackage);
     int updateAddOn(AddOn addOn);
     //delete
     void deleteWeddingPackage(Long id);
     void deleteDrinkPackage(Long id);
     void deleteAddOn(Long id);
     //find
     WeddingPackage getWeddingPackageById(long id);
     DrinkPackage getDrinkPackageById(long id);
     AddOn getAddOnById(long id);

     void calculateTotalPrice(WeddingPackage wp, DrinkPackage dp, AddOn ao, int guests);
}
