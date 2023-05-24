package com.example.lesson.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ProductForm {

    @NotEmpty
    @Length(min = 1, max = 50)
    private String name;

    @NotNull
    @Digits(message = "正しい数値を入力してください", integer = Integer.MAX_VALUE, fraction = 0)
    //@Pattern(regexp = "[0-9]+")
    @PositiveOrZero
    private Integer price;

    private Integer id;

}
