package com.capitole.ecommerce.Model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FinalPriceRequest {
    private LocalDateTime applicationDate;
    private Integer productId;
    private Integer brandId;
}
