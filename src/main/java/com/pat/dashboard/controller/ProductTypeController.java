package com.pat.dashboard.controller;

import com.pat.dashboard.model.ProductType;
import com.pat.dashboard.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/producttype")
public class ProductTypeController {

    @Autowired
    public ProductTypeService productTypeService;

    @GetMapping("/add")
    public String addProductType(ProductType productType, Model model) {
        model.addAttribute("producttype", productType);
        return "/admin/producttype/add-edit-producttype";
    }

    @GetMapping("/edit/{id}")
    public String editProductType(@PathVariable("id") long id, Model model) {
        ProductType productType = productTypeService.get(id);
        model.addAttribute("producttype", productType);
        return "/admin/producttype/add-edit-producttype";
    }

    @PostMapping("/save")
    public String saveProductType(@Valid @ModelAttribute("productType") ProductType productType, BindingResult result, Model model) {
        model.addAttribute("producttype", productType);
        if (result.hasErrors()) {
            return "/admin/producttype/add-edit-producttype";
        }
        productTypeService.save(productType);
        return "redirect:/producttype/list?success";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductType(@PathVariable("id") long id) {
        productTypeService.delele(id);
        return "redirect:/producttype/list?delete";
    }

    @GetMapping("/list")
    public String listProductType(Model model) {
        List<ProductType> productTypes = productTypeService.findAll();
        model.addAttribute("listProductTypes", productTypes);
        return "/admin/producttype/list-producttype";
    }
}
