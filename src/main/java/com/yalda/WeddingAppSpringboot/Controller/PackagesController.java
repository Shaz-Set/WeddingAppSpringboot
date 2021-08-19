package com.yalda.WeddingAppSpringboot.Controller;

import com.yalda.WeddingAppSpringboot.service.WeddingPackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PackagesController {

    @Autowired
    private  WeddingPackagesService weddingPackagesService;

   @GetMapping("/weddingPackages")
    public String viewWeddingPackagesPage(Model model){
       model.addAttribute("listWeddingPackages", weddingPackagesService.getAllWeddingPackages());
        return "WeddingPackages";
    }
}
