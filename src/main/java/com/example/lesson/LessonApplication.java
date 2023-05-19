package com.example.lesson;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.service.PgProductService;
import com.example.lesson.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =
			SpringApplication.run(LessonApplication.class, args);

		ProductService productService = context.getBean(ProductService.class);

		var list = productService.findAll();
		System.out.println("findAll:");
		list.forEach(System.out::println);

		var product = productService.findById(2);
		System.out.println("findById:" + product);

		productService.insert(new ProductRecord(null,"定規", 100));
		list = productService.findAll();
		System.out.println("findAll-insert:");
		list.forEach(System.out::println);

		productService.update(new ProductRecord(4, "定規1000本", 100000));
		product = productService.findById(4);
		System.out.println("findById-update:" + product);

		productService.delete(4);
		list = productService.findAll();
		System.out.println("findAll-delete:");
		list.forEach(System.out::println);

	}

}
