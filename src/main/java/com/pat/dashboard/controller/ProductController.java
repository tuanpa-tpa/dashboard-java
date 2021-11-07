package com.pat.dashboard.controller;

import com.pat.dashboard.model.Product;
import com.pat.dashboard.model.ProductType;
import com.pat.dashboard.service.ProductService;
import com.pat.dashboard.service.ProductTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/add")
    public String add(Product product, Model model) {
        model.addAttribute("product", product);
        List<ProductType> productTypes = productTypeService.findAll();
        model.addAttribute("productTypes", productTypes);
        return "/admin/product/add-edit-product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        List<ProductType> productTypes = productTypeService.findAll();
        model.addAttribute("productTypes", productTypes);
        return "/admin/product/add-edit-product";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        model.addAttribute("product", product);
        List<ProductType> productTypes = productTypeService.findAll();
        model.addAttribute("productTypes", productTypes);
        if (result.hasErrors()) {
            return "/admin/product/add-edit-product";
        }
        productService.save(product);
        return "redirect:/product/list?success";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        productService.delete(id);
        return "redirect:/product/list?delete";
    }

    @GetMapping("/list")
    public String listAll(Model model) {
        List<ProductType> productTypes = productTypeService.findAll();
        model.addAttribute("productTypes", productTypes);
        List<Product> products = productService.findAll();
        model.addAttribute("product", products);
        return "/admin/product/list-product";
    }
}
