package com.example.lesson.controller;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.form.ProductForm;
import com.example.lesson.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("product-list")
    public String productList(Model model) {
        List<ProductRecord> list = productService.findAll();
        model.addAttribute("products", list);

        return "/product-list";
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
        //System.out.println(product.id());
        model.addAttribute("product", product);
        return "/detail";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("addForm") ProductForm productAddForm) {
        return "/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("addForm") ProductForm productAddForm,
                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/add";
        } else {
            //追加処理
            productService.insert(new ProductRecord(null, productAddForm.getName(), productAddForm.getPrice()));

            //product-listに渡す値取得
            List<ProductRecord> list = productService.findAll();
            model.addAttribute("products", list);

            return "/product-list";
        }
    }

    @GetMapping("/product/update/{id}")
    public String update(@ModelAttribute("updateForm") ProductForm productUpdateForm,
                         @PathVariable("id") int id, Model model) {
        ProductRecord product = productService.findById(id);
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("updateForm") ProductForm productUpdateForm,
                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/update";
        } else {

            //追加処理
            productService.update(new ProductRecord(productUpdateForm.getId(), productUpdateForm.getName(),
                    productUpdateForm.getPrice()));

            //product-listに渡す値取得
            List<ProductRecord> list = productService.findAll();
            model.addAttribute("products", list);

            return "/product-list";
        }
    }

    @PostMapping("/delete")
    public String delete(@Validated @ModelAttribute("deleteForm") ProductForm productdeleteForm,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/detail";
        } else {

            //追加処理
            productService.delete(productdeleteForm.getId());

            //product-listに渡す値取得
            List<ProductRecord> list = productService.findAll();
            model.addAttribute("products", list);

            return "/product-list";
        }
    }
}
