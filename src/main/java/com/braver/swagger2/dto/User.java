package com.braver.swagger2.dto;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @Description:
 * @author: liyuan
 * @data 2020-12-07 18:59
 */
@Data
public class User {
    private Integer id;
    @Size(min = 5, max = 10, message = "{user.name.size}")
    private String name;
    @NotNull(message = "{user.address.notnull}")
    private String address;
    @DecimalMin(value = "1", message = "{user.age.size}")
    @DecimalMax(value = "200", message = "{user.age.size}")
    private Integer age;
    @Email(message = "{user.email.pattern}")
    @NotNull(message = "{user.email.notnull}")
    private String email;
}
