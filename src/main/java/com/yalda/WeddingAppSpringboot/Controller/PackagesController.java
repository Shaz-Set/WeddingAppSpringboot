package com.yalda.WeddingAppSpringboot.Controller;

import com.yalda.WeddingAppSpringboot.model.AddOn;
import com.yalda.WeddingAppSpringboot.model.DrinkPackage;
import com.yalda.WeddingAppSpringboot.model.WeddingPackage;
import com.yalda.WeddingAppSpringboot.service.WeddingPackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PackagesController {

    @Autowired
    private  WeddingPackagesService weddingPackagesService;

    @GetMapping("/adminWeddingPackages")
    public String viewWeddingPackagesPage(Model model){
       model.addAttribute("listWeddingPackages", weddingPackagesService.getAllWeddingPackages());
        model.addAttribute("weddingPackage", new WeddingPackage());
        return "adminWeddingPackages";
    }

    @GetMapping("/adminAddOns")
    public String viewAddOnPage(Model model){
        model.addAttribute("listAddOns", weddingPackagesService.getAllAddOns());
        model.addAttribute("addOn", new AddOn());
        return "adminAddOns";
    }

    @GetMapping("/adminDrinkPackages")
    public String viewDrinkPackagesPage(Model model){
        model.addAttribute("listDrinkPackages", weddingPackagesService.getAllDrinkPackages());
        model.addAttribute("drinkPackage", new DrinkPackage());
        return "adminDrinkPackages";
    }

    @PostMapping("/adminWeddingPackages")
    public String saveWeddingPackage(@ModelAttribute("adminWeddingPackage") WeddingPackage weddingPackage) {
        weddingPackagesService.updateWeddingPackage(weddingPackage);
        return "adminWeddingPackages";
    }

    @GetMapping("/")
    public String landingPage(Model model){
        return "Index";
    }

    @RequestMapping("/process")
    public String process(Model model, @RequestParam String sourceText){
        int val = Integer.parseInt(sourceText);
        System.out.println("model = " + model + ", sourceText = " + Integer.parseInt(sourceText));
        return "Index";
    }
}
