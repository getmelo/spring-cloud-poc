package com.getmelo.poc.paymentservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 3875291376273997386L;

    private Long id;

    @NotBlank
    private String name;

}
