package com.products.microcreditstore.service;

import com.products.microcreditstore.dto.ApiResponse;
import com.products.microcreditstore.dto.BuyProductDto;
import com.products.microcreditstore.dto.OrdersDto;
import com.products.microcreditstore.dto.ProductDto;
import com.products.microcreditstore.entity.Orders;
import com.products.microcreditstore.entity.Product;
import com.products.microcreditstore.repository.OrderRepository;
import com.products.microcreditstore.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ApiResponse getAllProducts() throws Exception {
        ApiResponse response = new ApiResponse();
        List<Product> products = productRepository.findAll();
        if (!products.isEmpty()) {
            List<ProductDto> productDtos = products.stream().map(product -> {
                        ProductDto productDto = new ProductDto();
                        BeanUtils.copyProperties(product, productDto);
                        return productDto;
                    }
            ).collect(Collectors.toList());
            response.setProductDtos(productDtos);
        } else {
            throw new Exception("No products found");
        }
        return response;
    }

    @Override
    public Double getTotalAmount(BuyProductDto buyProductDto) {
        List<ProductDto> productDtoList = buyProductDto.getProducts();
        Double totalAmount = productDtoList.stream().map(productDto -> {
            double totalCost = 0;
            Optional<Product> productOptional = productRepository.findById(productDto.getProductId());
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                productDto.setPrice(product.getPrice());
                totalCost = productDto.getAvailableQty() * product.getPrice();
                productDto.setTotalAmount(totalCost);
            }
            return productDto;
        }).collect(Collectors.summingDouble(ProductDto::getTotalAmount));
        return totalAmount;
    }

    @Override
    public OrdersDto placeOrder(BuyProductDto buyProductDto) {
        OrdersDto ordersDto = new OrdersDto();
        Orders orders = new Orders();
        orders.setDate(LocalDate.now());
        orders.setPrice(getTotalAmount(buyProductDto));

        orders.setProductId(buyProductDto.getProducts().get(0).getProductId());
        orders.setQty(buyProductDto.getProducts().get(0).getAvailableQty());
        orders = orderRepository.save(orders);
        BeanUtils.copyProperties(orders, ordersDto);
        return ordersDto;
    }
}
