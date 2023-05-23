package com.example.lesson.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ProductForm {

    @NotEmpty
    @Length(min = 1, max = 50)
    private String name;

    @NotNull
    @Digits(integer = Integer.MAX_VALUE, fraction = 0)
    @PositiveOrZero
    private Integer price;

    private Integer id;

}
