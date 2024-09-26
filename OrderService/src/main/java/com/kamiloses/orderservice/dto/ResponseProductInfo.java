package com.kamiloses.orderservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseProductInfo {

    private String productName;

    private Double pricePerUnit;

}
