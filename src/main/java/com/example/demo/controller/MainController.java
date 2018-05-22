package com.example.demo.controller;

import com.example.demo.Product;
import com.example.demo.Terrasoft;
import com.example.demo.wsdl.ContactInfo;
import com.example.demo.wsdl.GetOfferingInfoForInternetShopResponse;
import com.example.demo.wsdl.LoginCheckResponse;
import com.example.demo.wsdl.OfferingInfoForInternetShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    Terrasoft terrasoft;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/detail")
    public String saveDetails(
            @RequestParam("name") String name,
            @RequestParam("pass") String pass,
            ModelMap modelMap) {
        LoginCheckResponse response = terrasoft.loginCheck(name, pass);
        ContactInfo info = response.getCInfo().getValue();
        modelMap.addAttribute("name", info.getFirstName().getValue());
        modelMap.addAttribute("pass", info.getLastName().getValue());
        modelMap.addAttribute("other", info.getClientStoreCityName().getValue());
        modelMap.addAttribute("log",info.getLogin().getValue());


        return "detail";
    }

    @GetMapping("/product/{index}")
    public String product(
            @PathVariable("index") Integer index,
            ModelMap modelMap) {


        GetOfferingInfoForInternetShopResponse offeringInfoForInternetShop = terrasoft.getOfferingInfoForInternetShop(index);
        OfferingInfoForInternetShop value = offeringInfoForInternetShop.getGetOfferingInfoForInternetShopResult().getValue();
        modelMap.addAttribute("product", new Product(
                value.getName(),
                value.getIndex()
        ));

        return "product";
    }


}