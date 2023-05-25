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
    //@Digits(integer = Integer.MAX_VALUE, fraction = 0)
    @Pattern(regexp = "^\\d$")
    @PositiveOrZero
    private Integer price;

    private Integer id;

}
