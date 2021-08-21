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
     Long updateWeddingPackage(WeddingPackage weddingPackage);
     Long updateDrinkPackage(DrinkPackage drinkPackage);
     Long updateAddOn(AddOn addOn);
     //delete
     void deleteWeddingPackage(Long id);
     void deleteDrinkPackage(Long id);
     void deleteAddOn(Long id);
     //find
     WeddingPackage getWeddingPackageById(long id);
     DrinkPackage getDrinkPackageById(long id);
     AddOn getAddOnById(long id);

     double calculateTotalPrice(double wpPrice, double dpPrice, double aoPrice, int guests);
}
