package com.products.microcreditstore.controller;

import com.products.microcreditstore.dto.LoginResponseDto;
import com.products.microcreditstore.dto.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Login controller.
 */
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    /**
     * The Rest template.
     */
    @Autowired
    RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * Login user response entity.
     *
     * @param userLogin the user login
     * @return {@Code ResponseEntity} the response entity
     */
    @PostMapping
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody UserLogin userLogin) {
        logger.info("Inside validating user method");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String uri = "http://10.117.189.185:8080/creditcards/login";
        ResponseEntity<LoginResponseDto> loginRespose = restTemplate.exchange(uri,
                HttpMethod.POST, entity, LoginResponseDto.class);
        logger.info(loginRespose.getBody().toString());
        return new ResponseEntity<>(loginRespose.getBody(), HttpStatus.OK);
    }
}