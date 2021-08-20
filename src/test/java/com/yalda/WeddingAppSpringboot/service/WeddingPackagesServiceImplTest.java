package com.yalda.WeddingAppSpringboot.service;

import com.yalda.WeddingAppSpringboot.model.AddOn;
import com.yalda.WeddingAppSpringboot.model.DrinkPackage;
import com.yalda.WeddingAppSpringboot.model.WeddingPackage;
import com.yalda.WeddingAppSpringboot.repository.DrinkPackageRepository;
import com.yalda.WeddingAppSpringboot.repository.WeddingPackagesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeddingPackagesServiceImplTest {

    @Autowired
    private WeddingPackagesService weddingPackagesService;

    @Test
    void getAllWeddingPackages() {
        List<WeddingPackage> wPackages = weddingPackagesService.getAllWeddingPackages();
        assertNotEquals(0, wPackages.size());
    }
    @Test
    void getAllDrinkPackages() {
        List<DrinkPackage> dPackages = weddingPackagesService.getAllDrinkPackages();
        assertNotEquals(0, dPackages.size());
    }
    @Test
    void getAllAddOns() {
        List<AddOn> addOn = weddingPackagesService.getAllAddOns();
        assertNotEquals(0, addOn.size());
    }

    @Test
    void updateWeddingPackage() {
        WeddingPackage newPackage = new WeddingPackage();
        newPackage.setId(12L);
        newPackage.setHours(8);
        newPackage.setStyles("Roving");
        newPackage.setPrice(160.0);
        int correct = weddingPackagesService.updateWeddingPackage(newPackage);
        assertEquals(1,correct);
    }
    @Test
    void updateDrinkPackage() {
        DrinkPackage newPackage = new DrinkPackage();
        newPackage.setId(12L);
        newPackage.setName("Gold Package");
        newPackage.setDetails("Gold wines and beers");
        newPackage.setPrice(50.0);
        int correct = weddingPackagesService.updateDrinkPackage(newPackage);
        assertEquals(1,correct);
    }
    @Test
    void updateAddOn() {
        AddOn newAddon = new AddOn();
        newAddon.setId(12L);
        newAddon.setName("Photo Booth");
        newAddon.setDetails("Photo Booth will be placed in the venue");
        newAddon.setPrice(500);
        int correct = weddingPackagesService.updateAddOn(newAddon);
        assertEquals(1,correct);
    }

    @Test
    void deleteWeddingPackage() {
        WeddingPackage newPackage = new WeddingPackage();
        newPackage.setId(15L);
        newPackage.setHours(8);
        newPackage.setStyles("Roving");
        newPackage.setPrice(160.0);
        weddingPackagesService.updateWeddingPackage(newPackage);

        weddingPackagesService.deleteWeddingPackage(newPackage.getId());
        //assertEquals(" Employee not found for id :: 15",weddingPackagesService.getWeddingPackageById(15L));
    }



    @Test
    void deleteDrinkPackage() {
    }

    @Test
    void deleteAddOn() {
    }

    @Test
    void getWeddingPackageById() {
        WeddingPackage newPackage = new WeddingPackage();
        newPackage.setId(15L);
        newPackage.setHours(8);
        newPackage.setStyles("Roving");
        newPackage.setPrice(160.0);
        assertEquals(newPackage,weddingPackagesService.getWeddingPackageById(newPackage.getId()));
    }

    @Test
    void getDrinkPackageById() {

    }

    @Test
    void getAddOnById() {
    }

    @Test
    void calculateTotalPrice() {
        WeddingPackage newWeddingPackage = new WeddingPackage();
        newWeddingPackage.setId(12L);
        newWeddingPackage.setHours(8);
        newWeddingPackage.setStyles("Roving");
        newWeddingPackage.setPrice(160.0);

        DrinkPackage newDrinkPackage = new DrinkPackage();
        newDrinkPackage.setId(12L);
        newDrinkPackage.setName("Gold Package");
        newDrinkPackage.setDetails("Gold wines and beers");
        newDrinkPackage.setPrice(50.0);

        AddOn newAddon = new AddOn();
        newAddon.setId(12L);
        newAddon.setName("Photo Booth");
        newAddon.setDetails("Photo Booth will be placed in the venue");
        newAddon.setPrice(500);

        double totalPrice = weddingPackagesService.calculateTotalPrice(newWeddingPackage,newDrinkPackage,newAddon,100);
        assertEquals(21500,totalPrice);

    }
}