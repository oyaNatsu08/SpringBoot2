package com.example.lesson.controller;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductFormRestController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public List<ProductRecord> list() {
        return productService.findAll();
    }

    @PostMapping("/api/product")
    public void add2(@RequestParam(name = "name")String name,
                             @RequestParam(name = "price")Integer price) {
        productService.insert(new ProductRecord(null, name, price));
    }

    @GetMapping("/product/detail")
    public ProductRecord detailView(@RequestParam(name = "id")Integer id) {
        ProductRecord product = productService.findById(id);
        return product;
    }

//    @GetMapping("product2-update")
    @PutMapping("/api/product/{id}")
    public void update2(@RequestParam(name = "id")Integer id,
                        @RequestParam(name = "name")String name,
                        @RequestParam(name = "price")Integer price) {
        productService.update(new ProductRecord(id, name, price));
    }

    @DeleteMapping("/api/product/{id}")
    public void delete2(@RequestParam(name = "id")Integer id) {
        productService.delete(id);
    }

}
