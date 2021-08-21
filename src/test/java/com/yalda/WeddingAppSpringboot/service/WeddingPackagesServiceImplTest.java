package com.yalda.WeddingAppSpringboot.service;

import com.yalda.WeddingAppSpringboot.model.AddOn;
import com.yalda.WeddingAppSpringboot.model.DrinkPackage;
import com.yalda.WeddingAppSpringboot.model.WeddingPackage;
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
        Long correct = weddingPackagesService.updateWeddingPackage(newPackage);
        assertEquals(12L,correct);
    }

    @Test
    void updateDrinkPackage() {
        DrinkPackage newPackage = new DrinkPackage();
        newPackage.setId(12L);
        newPackage.setName("Gold Package");
        newPackage.setDetail("Gold wines and beers");
        newPackage.setPrice(50.0);
        Long correct = weddingPackagesService.updateDrinkPackage(newPackage);
        assertEquals(12L,correct);
    }

    @Test
    void updateAddOn() {
        AddOn newAddon = new AddOn();
        newAddon.setId(12L);
        newAddon.setName("Photo Booth");
        newAddon.setDetail("Photo Booth will be placed in the venue");
        newAddon.setPrice(500);
        Long correct = weddingPackagesService.updateAddOn(newAddon);
        assertEquals(12,correct);
    }

    @Test
    void deleteWeddingPackage() {
        WeddingPackage newPackage = new WeddingPackage();
        newPackage.setHours(8);
        newPackage.setStyles("Roving");
        newPackage.setPrice(160.0);
        Long id = weddingPackagesService.updateWeddingPackage(newPackage);
        weddingPackagesService.deleteWeddingPackage(id);
        assertNull(weddingPackagesService.getWeddingPackageById(id));
    }

    @Test
    void deleteDrinkPackage() {
        DrinkPackage newPackage = new DrinkPackage();
        newPackage.setName("Golden Package");
        newPackage.setDetail("Golden wine and beers");
        newPackage.setPrice(50.0);
        Long id = weddingPackagesService.updateDrinkPackage(newPackage);
        weddingPackagesService.deleteDrinkPackage(id);
        assertNull(weddingPackagesService.getDrinkPackageById(id));
    }

    @Test
    void deleteAddOn() {
        AddOn newAddOn = new AddOn();
        newAddOn.setName("Food Station");
        newAddOn.setDetail("Variety foods, and anti-pasto");
        newAddOn.setPrice(1000.0);
        Long id = weddingPackagesService.updateAddOn(newAddOn);
        weddingPackagesService.deleteAddOn(id);
        assertNull(weddingPackagesService.getAddOnById(id));
    }

    @Test
    void getWeddingPackageById() {
        WeddingPackage weddingPackage = weddingPackagesService.getWeddingPackageById(1L);
        assertNotNull(weddingPackage);
        WeddingPackage weddingPackageNotInDB = weddingPackagesService.getWeddingPackageById(99999L);
        assertNull(weddingPackageNotInDB);
    }

    @Test
    void getDrinkPackageById() {
        DrinkPackage drinkPackage = weddingPackagesService.getDrinkPackageById(1L);
        assertNotNull(drinkPackage);
        DrinkPackage drinkPackageNotInDB = weddingPackagesService.getDrinkPackageById(99999L);
        assertNull(drinkPackageNotInDB);
    }

    @Test
    void getAddOnById() {
        AddOn addOn = weddingPackagesService.getAddOnById(1L);
        assertNotNull(addOn);
        AddOn addOnNotInDB = weddingPackagesService.getAddOnById(99999L);
        assertNull(addOnNotInDB);
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
        newDrinkPackage.setDetail("Gold wines and beers");
        newDrinkPackage.setPrice(50.0);

        AddOn newAddon = new AddOn();
        newAddon.setId(12L);
        newAddon.setName("Photo Booth");
        newAddon.setDetail("Photo Booth will be placed in the venue");
        newAddon.setPrice(500);

        double totalPrice = weddingPackagesService.calculateTotalPrice(newWeddingPackage.getPrice()
                ,newDrinkPackage.getPrice(),newAddon.getPrice(),100);
        assertEquals(21500,totalPrice);
    }
}