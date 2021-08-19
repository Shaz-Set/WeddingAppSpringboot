package com.yalda.WeddingAppSpringboot.service;

import com.yalda.WeddingAppSpringboot.model.WeddingPackage;
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
        List<WeddingPackage> packages = weddingPackagesService.getAllWeddingPackages();
        assertNotEquals(0, packages.size());
    }

    @Test
    void getAllDrinkPackages() {
    }

    @Test
    void getAllAddOns() {
    }

    @Test
    void updateWeddingPackage() {
    }

    @Test
    void updateDrinkPackage() {
    }

    @Test
    void updateAddOn() {
    }

    @Test
    void deleteWeddingPackage() {
    }

    @Test
    void deleteDrinkPackage() {
    }

    @Test
    void deleteAddOn() {
    }

    @Test
    void getWeddingPackageById() {
    }

    @Test
    void getDrinkPackageById() {
    }

    @Test
    void getAddOnById() {
    }

    @Test
    void calculateTotalPrice() {
    }
}