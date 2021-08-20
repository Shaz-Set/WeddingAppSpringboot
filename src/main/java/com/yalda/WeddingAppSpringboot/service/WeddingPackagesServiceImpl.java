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
    public Long updateWeddingPackage(WeddingPackage weddingPackage) {
        weddingPackagesRepository.save(weddingPackage);
        return weddingPackage.getId();
    }
    @Override
    public Long updateDrinkPackage(DrinkPackage drinkPackage) {
        drinkPackageRepository.save(drinkPackage);
        return drinkPackage.getId();
    }
    @Override
    public Long updateAddOn(AddOn addOn) {
        addOnRepository.save(addOn);
        return addOn.getId();
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
        return optional.orElse(null);
    }
    @Override
    public DrinkPackage getDrinkPackageById(long id) {
        Optional< DrinkPackage > optional = drinkPackageRepository.findById(id);
        return optional.orElse(null);
    }
    @Override
    public AddOn getAddOnById(long id) {
        Optional< AddOn > optional = addOnRepository.findById(id);
        return optional.orElse(null);
    }

    //total price
    @Override
    public double calculateTotalPrice(WeddingPackage wp, DrinkPackage dp, AddOn ao, int guests) {
            //calculating the total price based on the quantity of the guests,
            // wedding package, add-ons, and drink package chosen by the user
            double totalPrice = (wp.getPrice() * guests) +
                    (dp.getPrice() * guests) + ao.getPrice();
            return totalPrice;
    }
}
