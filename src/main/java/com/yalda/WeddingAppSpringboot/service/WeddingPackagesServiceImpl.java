package com.yalda.WeddingAppSpringboot.service;

import com.yalda.WeddingAppSpringboot.model.AddOn;
import com.yalda.WeddingAppSpringboot.model.DrinkPackage;
import com.yalda.WeddingAppSpringboot.model.WeddingPackage;
import com.yalda.WeddingAppSpringboot.repository.AddOnRepository;
import com.yalda.WeddingAppSpringboot.repository.DrinkPackageRepository;
import com.yalda.WeddingAppSpringboot.repository.WeddingPackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WeddingPackagesServiceImpl implements WeddingPackagesService {

    @Autowired
    private WeddingPackagesRepository weddingPackagesRepository;

    @Autowired
    private DrinkPackageRepository drinkPackageRepository;

    @Autowired
    private AddOnRepository addOnRepository;
    //get
    @Override
    public List<WeddingPackage> getAllWeddingPackages() {
        return weddingPackagesRepository.findAll();
    }
    @Override
    public List<DrinkPackage> getAllDrinkPackages() {
        return drinkPackageRepository.findAll();
    }
    @Override
    public List<AddOn> getAllAddOns() {
        return addOnRepository.findAll();
    }
    //update
    @Override
    public int updateWeddingPackage(WeddingPackage weddingPackage) {
        weddingPackagesRepository.save(weddingPackage);
        return 1;
    }
    @Override
    public int updateDrinkPackage(DrinkPackage drinkPackage) {
        drinkPackageRepository.save(drinkPackage);
        return 1;
    }
    @Override
    public int updateAddOn(AddOn addOn) {
        addOnRepository.save(addOn);
        return 1;
    }
    //delete
    @Override
    public void deleteWeddingPackage(Long id) {
        weddingPackagesRepository.deleteById(id);
    }
    @Override
    public void deleteDrinkPackage(Long id) {
        drinkPackageRepository.deleteById(id);
    }
    @Override
    public void deleteAddOn(Long id) {
        addOnRepository.deleteById(id);
    }
    //find
    @Override
    public WeddingPackage getWeddingPackageById(long id) {
        Optional< WeddingPackage > optional = weddingPackagesRepository.findById(id);
        WeddingPackage wp = null;
        if (optional.isPresent()) {
            wp = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return wp;
    }
    @Override
    public DrinkPackage getDrinkPackageById(long id) {
        Optional< DrinkPackage > optional = drinkPackageRepository.findById(id);
        DrinkPackage dp = null;
        if (optional.isPresent()) {
            dp = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return dp;
    }
    @Override
    public AddOn getAddOnById(long id) {
        Optional< AddOn > optional = addOnRepository.findById(id);
        AddOn ao = null;
        if (optional.isPresent()) {
            ao = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return ao;
    }
    //total price
    @Override
    public void calculateTotalPrice(WeddingPackage wp, DrinkPackage dp, AddOn ao, int guests) {
            //calculating the total price based on the quantity of the guests,
            // wedding package, add-ons, and drink package chosen by the user
            double totalPrice = (getWeddingPackageById(wp.getId()).getPrice() * guests) +
                    (getDrinkPackageById(dp.getId()).getPrice() * guests) + getAddOnById(ao.getId()).getPrice();
    }
}
