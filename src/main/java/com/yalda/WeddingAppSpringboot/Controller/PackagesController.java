package com.yalda.WeddingAppSpringboot.Controller;

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

    @GetMapping("/weddingPackages")
    public String viewWeddingPackagesPage(Model model){
       model.addAttribute("listWeddingPackages", weddingPackagesService.getAllWeddingPackages());
        model.addAttribute("weddingPackage", new WeddingPackage());
        return "WeddingPackages";
    }

    @PostMapping("/weddingPackages")
    public String saveWeddingPackage(@ModelAttribute("weddingPackage") WeddingPackage weddingPackage) {
        weddingPackagesService.updateWeddingPackage(weddingPackage);
        return "weddingPackages";
    }

    ///admin

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
