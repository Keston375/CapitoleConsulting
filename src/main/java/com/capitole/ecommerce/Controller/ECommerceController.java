package com.capitole.ecommerce.Controller;

import com.capitole.ecommerce.Model.FinalPriceRequest;
import com.capitole.ecommerce.Model.FinalPriceResponse;
import com.capitole.ecommerce.Service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class ECommerceController {
    private final ECommerceService eCommerceService;

    @Autowired
    public ECommerceController(ECommerceService eCommerceService) {
        this.eCommerceService = eCommerceService;
    }

    @GetMapping("/getPrice")
    public ResponseEntity<FinalPriceResponse> getPriceByAppDateProductIdAndBrandId(@RequestParam("applicationDate")LocalDateTime applicationDate,
                                                                                   @RequestParam("productId") Integer productId,
                                                                                   @RequestParam("brandId") Integer brandId){
            FinalPriceResponse response = eCommerceService.getProductPrice(FinalPriceRequest.builder().applicationDate(applicationDate).productId(productId)
                    .brandId(brandId).build());

            return response == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(response,HttpStatus.OK);
    }
}
