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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Controller
public class ECommerceController {
    private final ECommerceService eCommerceService;

    @Autowired
    public ECommerceController(ECommerceService eCommerceService) {
        this.eCommerceService = eCommerceService;
    }

    @GetMapping("/Price")
    public ResponseEntity<FinalPriceResponse> getPriceByAppDateProductIdAndBrandId(@RequestParam("applicationDate")String applicationDate,
                                                                                   @RequestParam("productId") Integer productId,
                                                                                   @RequestParam("brandId") Integer brandId){

        LocalDateTime applicationDateParsed;
        try {
             applicationDateParsed = LocalDateTime.parse(applicationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } catch (DateTimeParseException e) {
            // Handle parsing exception if required
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FinalPriceResponse response = eCommerceService.getProductPrice(FinalPriceRequest.builder()
                    .applicationDate(applicationDateParsed).productId(productId)
                    .brandId(brandId).build());

            return response == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(response,HttpStatus.OK);
    }
}
