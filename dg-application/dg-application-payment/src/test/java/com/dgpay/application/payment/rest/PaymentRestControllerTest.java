package com.dgpay.application.payment.rest;

import com.dgpay.application.payment.dto.TransferRequest;
import com.dgpay.persistence.sw.model.card.Card;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PaymentRestControllerTest {




    private static RestTemplate restTemplate = new RestTemplate();



    @Test
    public void transfer() throws JsonProcessingException {
        TransferRequest request = new TransferRequest();
        request.setPan("111");
        request.setDestination("222");


        final List<Card> cardList = (List<Card>) restTemplate.postForEntity("http://{server}:{port}/payment/v1/service/transfer", header(request), Object.class,"localhost", "8004");
    }



    private HttpEntity<String> header(Object request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAcceptCharset(Arrays.asList(Charset.forName("utf8")));
        HttpEntity<String> httpEntity = new HttpEntity<>(valueAsString, headers);
        return httpEntity;
    }
}