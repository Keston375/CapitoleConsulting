package com.capitole.ecommerce;

import com.capitole.ecommerce.Model.FinalPriceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EcommerceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void test1(){
		//Petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		String url = "http://localhost:" + port + "/Price?";
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("applicationDate", "2020-06-14 10:00:00");
		queryParams.put("productId", "35455");
		queryParams.put("brandId", "1");

		URI uri = UriComponentsBuilder.fromUriString(url)
				.queryParam("applicationDate", queryParams.get("applicationDate"))
				.queryParam("productId", queryParams.get("productId"))
				.queryParam("brandId", queryParams.get("brandId"))
				.build()
				.toUri();

		ResponseEntity<FinalPriceResponse> response =  restTemplate.getForEntity(uri, FinalPriceResponse.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35.50, response.getBody().getFinalPrice());

	}

	@Test
	void test2(){
		// Petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)

		String url = "http://localhost:" + port + "/Price?";

		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("applicationDate", "2020-06-14 16:00:00");
		queryParams.put("productId", "35455");
		queryParams.put("brandId", "1");

		URI uri = UriComponentsBuilder.fromUriString(url)
				.queryParam("applicationDate", queryParams.get("applicationDate"))
				.queryParam("productId", queryParams.get("productId"))
				.queryParam("brandId", queryParams.get("brandId"))
				.build()
				.toUri();

		ResponseEntity<FinalPriceResponse> response =  restTemplate.getForEntity(uri, FinalPriceResponse.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(25.45, response.getBody().getFinalPrice());

	}

	@Test
	void test3(){
		//Petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
		String url = "http://localhost:" + port + "/Price?";
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("applicationDate", "2020-06-14 21:00:00");
		queryParams.put("productId", "35455");
		queryParams.put("brandId", "1");

		URI uri = UriComponentsBuilder.fromUriString(url)
				.queryParam("applicationDate", queryParams.get("applicationDate"))
				.queryParam("productId", queryParams.get("productId"))
				.queryParam("brandId", queryParams.get("brandId"))
				.build()
				.toUri();

		ResponseEntity<FinalPriceResponse> response =  restTemplate.getForEntity(uri, FinalPriceResponse.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35.50, response.getBody().getFinalPrice());

	}
	@Test
	void test4(){
		//Petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
		String url = "http://localhost:" + port + "/Price?";
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("applicationDate", "2020-06-15 10:00:00");
		queryParams.put("productId", "35455");
		queryParams.put("brandId", "1");

		URI uri = UriComponentsBuilder.fromUriString(url)
				.queryParam("applicationDate", queryParams.get("applicationDate"))
				.queryParam("productId", queryParams.get("productId"))
				.queryParam("brandId", queryParams.get("brandId"))
				.build()
				.toUri();

		ResponseEntity<FinalPriceResponse> response =  restTemplate.getForEntity(uri, FinalPriceResponse.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(30.50, response.getBody().getFinalPrice());

	}
	@Test
	void test5(){
		//Petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
		String url = "http://localhost:" + port + "/Price?";
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("applicationDate", "2020-06-16 21:00:00");
		queryParams.put("productId", "35455");
		queryParams.put("brandId", "1");

		URI uri = UriComponentsBuilder.fromUriString(url)
				.queryParam("applicationDate", queryParams.get("applicationDate"))
				.queryParam("productId", queryParams.get("productId"))
				.queryParam("brandId", queryParams.get("brandId"))
				.build()
				.toUri();

		ResponseEntity<FinalPriceResponse> response =  restTemplate.getForEntity(uri, FinalPriceResponse.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(38.95, response.getBody().getFinalPrice());
	}
}
