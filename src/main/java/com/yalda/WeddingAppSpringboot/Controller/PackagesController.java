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

    @GetMapping("/")
    public String landingPage(Model model){
        return "Index";
    }


    //Wedding Packages
    @GetMapping("/adminWeddingPackages")
    public String viewWeddingPackagesPage(Model model){
       model.addAttribute("listWeddingPackages", weddingPackagesService.getAllWeddingPackages());
        model.addAttribute("weddingPackage", new WeddingPackage());
        return "admin_WeddingPackages";
    }
    @GetMapping("/newWeddingPackageForm")
    public String showNewWeddingPackageForm(Model model) {
        WeddingPackage newWeddingPackage = new WeddingPackage();
        model.addAttribute("weddingPackage", newWeddingPackage);
        return "new_weddingPackage";
    }
    @PostMapping("/saveWeddingPackage")
    public String saveWeddingPackage(@ModelAttribute("weddingPackage") WeddingPackage weddingPackage,Model model) {
        weddingPackagesService.updateWeddingPackage(weddingPackage);
        model.addAttribute("listWeddingPackages", weddingPackagesService.getAllWeddingPackages());
        model.addAttribute("weddingPackage", new WeddingPackage());
        return "admin_WeddingPackages";
    }
    @GetMapping("/updateWeddingPackage/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        WeddingPackage weddingPackage = weddingPackagesService.getWeddingPackageById(id);
        model.addAttribute("weddingPackage", weddingPackage);
        return "update_weddingPackage";
    }
    @GetMapping("/deleteWeddingPackage/{id}")
    public String deleteWeddingPackage(@PathVariable(value = "id") long id,Model model) {
        this.weddingPackagesService.deleteWeddingPackage(id);
        model.addAttribute("listWeddingPackages", weddingPackagesService.getAllWeddingPackages());
        model.addAttribute("weddingPackage", new WeddingPackage());
        return "admin_WeddingPackages";
    }


    //Add-on
    @GetMapping("/adminAddOns")
    public String viewAddOnPage(Model model){
        model.addAttribute("listAddOns", weddingPackagesService.getAllAddOns());
        model.addAttribute("addOn", new AddOn());
        return "admin_AddOns";
    }
    @GetMapping("/newAddOnForm")
    public String showAddOnForm(Model model) {
        AddOn newAddOn = new AddOn();
        model.addAttribute("addOn", newAddOn);
        return "new_addOn";
    }
    @PostMapping("/saveAddOn")
    public String saveAddOn(@ModelAttribute("addOn") AddOn addOn,Model model) {
        weddingPackagesService.updateAddOn(addOn);
        model.addAttribute("listAddOns", weddingPackagesService.getAllAddOns());
        model.addAttribute("addOn", new AddOn());
        return "admin_AddOns";
    }
    @GetMapping("/updateAddOn/{id}")
    public String showFormForAddOnUpdate(@PathVariable(value = "id") long id, Model model) {
        AddOn addOn = weddingPackagesService.getAddOnById(id);
        model.addAttribute("addOn", addOn);
        return "update_addOn";
    }
    @GetMapping("/deleteAddOn/{id}")
    public String deleteAddOn(@PathVariable(value = "id") long id,Model model) {
        this.weddingPackagesService.deleteAddOn(id);
        model.addAttribute("listAddOns", weddingPackagesService.getAllAddOns());
        model.addAttribute("addOn", new AddOn());
        return "admin_AddOns";
    }


    //Drink Packages
    @GetMapping("/adminDrinkPackages")
    public String viewDrinkPackagesPage(Model model){
        model.addAttribute("listDrinkPackages", weddingPackagesService.getAllDrinkPackages());
        model.addAttribute("drinkPackage", new DrinkPackage());
        return "admin_DrinkPackages";
    }
    @GetMapping("/newDrinkPackageForm")
    public String showDrinkPackageForm(Model model) {
        DrinkPackage newDrinkPackage = new DrinkPackage();
        model.addAttribute("drinkPackage", newDrinkPackage);
        return "new_drinkPackage";
    }
    @PostMapping("/saveDrinkPackage")
    public String saveDrinkPackage(@ModelAttribute("drinkPackage") DrinkPackage drinkPackage,Model model) {
        weddingPackagesService.updateDrinkPackage(drinkPackage);
        model.addAttribute("listDrinkPackages", weddingPackagesService.getAllDrinkPackages());
        model.addAttribute("drinkPackage", new DrinkPackage());
        return "admin_DrinkPackages";
    }
    @GetMapping("/updateDrinkPackage/{id}")
    public String showFormForDrinkPackageUpdate(@PathVariable(value = "id") long id, Model model) {
        DrinkPackage drinkPackage = weddingPackagesService.getDrinkPackageById(id);
        model.addAttribute("drinkPackage", drinkPackage);
        return "update_drinkPackage";
    }
    @GetMapping("/deleteDrinkPackage/{id}")
    public String deleteDrinkPackage(@PathVariable(value = "id") long id,Model model) {
        this.weddingPackagesService.deleteDrinkPackage(id);
        model.addAttribute("listDrinkPackages", weddingPackagesService.getAllDrinkPackages());
        model.addAttribute("drinkPackage", new DrinkPackage());
        return "admin_DrinkPackages";
    }

    @GetMapping("/userPage")
    public String landingUserPage(Model model){
        model.addAttribute("listWeddingPackages", weddingPackagesService.getAllWeddingPackages());
        model.addAttribute("weddingPackage", new WeddingPackage());

        model.addAttribute("listAddOns", weddingPackagesService.getAllAddOns());
        model.addAttribute("addOn", new AddOn());

        model.addAttribute("listDrinkPackages", weddingPackagesService.getAllDrinkPackages());
        model.addAttribute("drinkPackage", new DrinkPackage());

        return "user_page";
    }



    @RequestMapping("/process")
    public String process(Model model, @RequestParam int guestNumber,
                          @RequestParam String chooseWPackages,
                          @RequestParam String chooseAddOn,
                          @RequestParam String chooseDPackages){
        System.out.println("model = " + model + ", guestNumber = " + guestNumber + ", chooseWPackages = " + chooseWPackages + ", chooseAddOn = " + chooseAddOn + ", chooseDPackages = " + chooseDPackages);
        //weddingPackagesService.calculateTotalPrice(chooseWPackages,chooseAddOn,chooseAddOn,guestNumber);
        model.addAttribute("totalPrice", 10000);
        return "result";
    }
}
