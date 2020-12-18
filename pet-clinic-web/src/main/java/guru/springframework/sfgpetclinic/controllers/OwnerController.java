package guru.springframework.sfgpetclinic.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


 //Mappatura a livello di classe
@RequestMapping("/owners")
@Controller
public class OwnerController {

    //grazie alla mappatura a livello di classe
    @RequestMapping({"","/", "/index", "/index.html"})
    public String ownerList(){
        return "owners/index";
    }


}
