package com.example.lesson.controller;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("product-list")
    public String productList(Model model) {
        List<ProductRecord> list = productService.findAll();
        model.addAttribute("products", list);

        return "product-list";
    }

    //URL直接入力
//    @GetMapping("product/{id}")
//    public String product(@PathVariable("id") int id, Model model) {
//        ProductRecord product = productService.findById(id);
//        model.addAttribute("product", product);
//        return "detail";
//    }

    //idのリンクから飛ぶ
    @GetMapping("product")
    public String product(@RequestParam(name="id") int id, Model model) {
        ProductRecord product = productService.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

}
