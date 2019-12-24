package com.products.microcreditstore.controller;

import com.products.microcreditstore.dto.ApiResponse;
import com.products.microcreditstore.service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {


    @InjectMocks
    private ProductController productController;

    @Mock
    RestTemplate restTemplate;

    @Mock
    private ProductServiceImpl productService;

    public void testGetAllProducts() throws Exception {
        ApiResponse response = new ApiResponse();
        response.setStatusCode(200);
        response.setMessage("Success");
        Mockito.when(productService.getAllProducts()).thenReturn(response);
        ResponseEntity<ApiResponse> allProducts = productController.getAllProducts();
        Assert.assertNotNull(allProducts);
    }


}
