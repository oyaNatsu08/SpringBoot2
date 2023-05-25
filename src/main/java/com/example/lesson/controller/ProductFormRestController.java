package com.example.lesson.controller;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductFormRestController {

    @Autowired
    ProductService productService;

    @GetMapping("product2-list")
    public List<ProductRecord> list() {
        return productService.findAll();
    }

    @GetMapping("product-add")
    public void add(@RequestParam(name = "name")String name,
                             @RequestParam(name = "price")Integer price) {
        productService.insert(new ProductRecord(null, name, price));
    }

    @GetMapping("product-detail")
    public ProductRecord detail(@RequestParam(name = "id")Integer id) {
        System.out.println("SECCCC");
        ProductRecord product = productService.findById(id);
        return product;
    }

//    @GetMapping("product2-add")
//    public ProductRecord add() {
//
//    }

}
