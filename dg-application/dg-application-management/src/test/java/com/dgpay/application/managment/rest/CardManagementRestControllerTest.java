package com.dgpay.application.managment.rest;

import com.dgpay.application.ManagementEndpointApplication;
import com.dgpay.application.managment.dto.CardListRequest;
import com.dgpay.persistence.SwitchPersistenceApplication;
import com.dgpay.persistence.sw.model.card.Card;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
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
@ContextConfiguration(classes = ManagementEndpointApplication.class)
public class CardManagementRestControllerTest {


    private static RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getCardList() throws JsonProcessingException {
        CardListRequest cardListRequest = new CardListRequest();
        cardListRequest.setCustomerNumber(1L);


        final List<Card> cardList = (List<Card>) restTemplate.postForEntity("http://{server}:{port}/card/v1/service/getCardList", header(cardListRequest), Object.class,"localhost", "8002");


    }

    @Test
    public void addCard() {
    }

    @Test
    public void deleteCard() {
    }

    private HttpEntity<String> header(CardListRequest request) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAcceptCharset(Arrays.asList(Charset.forName("utf8")));
        HttpEntity<String> httpEntity = new HttpEntity<>(valueAsString, headers);
        return httpEntity;
    }
}