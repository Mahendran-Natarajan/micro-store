package com.products.microcreditstore.controller;

import com.products.microcreditstore.dto.ApiResponse;
import com.products.microcreditstore.dto.BuyProductDto;
import com.products.microcreditstore.dto.CreditCardResponseDto;
import com.products.microcreditstore.dto.OrdersDto;
import com.products.microcreditstore.exception.CustomException;
import com.products.microcreditstore.service.ProductServiceImpl;
import com.products.microcreditstore.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts() throws Exception {
        logger.info("Get all products");
        ApiResponse allProducts = productService.getAllProducts();
        if (!allProducts.getProductDtos().isEmpty()) {
            allProducts.setMessage(Constants.SUCCESS);
            allProducts.setStatusCode(Constants.SUCCESS_CODE);
        }
        logger.info("Get all products");
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> buyProduct(@RequestBody BuyProductDto buyProductDto) {
        ApiResponse response = new ApiResponse();
        double amount = productService.getTotalAmount(buyProductDto);
        logger.debug("Total AMount {}", amount);
        //ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        //String result = restTemplate.getForObject(uri, String.class);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String uri = "http://10.117.189.185:8080/creditcards/users/" + buyProductDto.getUserId() + "/creditcard";

        ResponseEntity<CreditCardResponseDto> creditCarddExchange = restTemplate.exchange(uri,
                HttpMethod.GET, entity, CreditCardResponseDto.class);
        logger.info(creditCarddExchange.getBody().toString());
        validateCreditCard(buyProductDto, response, amount, creditCarddExchange);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void validateCreditCard(@RequestBody BuyProductDto buyProductDto, ApiResponse response, double amount, ResponseEntity<CreditCardResponseDto> creditCarddExchange) {
        CreditCardResponseDto creditCardEntity = creditCarddExchange.getBody();
        if (creditCardEntity.getCardNumber().equals(buyProductDto.getCardNumber())) {
            if (!creditCardEntity.getCvv().equals(buyProductDto.getCvvNumber())) {
                throw new CustomException("CVV not is not matched");
            }

            if (!creditCardEntity.getExpiryDate().isAfter(buyProductDto.getExpiryDate())) {
                throw new CustomException("Card is expired");
            }
        }
        if (creditCardEntity.getBalance() > amount) {
            logger.info("Place an order");
            OrdersDto ordersDto = productService.placeOrder(buyProductDto);
            response.setOrder(ordersDto);
        } else {
            logger.error("Amount is less : " + creditCarddExchange.getBody().getBalance());
            throw new CustomException("Credit card balance is low");
        }
    }

}
