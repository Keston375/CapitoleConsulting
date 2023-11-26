package com.capitole.ecommerce;

import com.capitole.ecommerce.Model.FinalPriceRequest;
import com.capitole.ecommerce.Model.FinalPriceResponse;
import com.capitole.ecommerce.Service.ECommerceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = {
		"spring.h2.console.enabled=true",
		"spring.h2.console.path=/h2-console"
})
class EcommerceApplicationTests {

	@Autowired
	private ECommerceService eCommerceService;
	@Test
	void getTest1(){
		LocalDateTime applicationDateTime = LocalDateTime
				.parse("2020-06-14 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		FinalPriceRequest request = FinalPriceRequest.builder()
				.applicationDate(applicationDateTime).productId(35455).brandId(1).build();

		FinalPriceResponse response = eCommerceService.getProductPrice(request);

	}

}
