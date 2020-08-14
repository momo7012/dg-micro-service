package com.dgpay.application.managment.rest;

import com.dgpay.application.managment.dto.AddCardRequest;
import com.dgpay.application.managment.dto.AddCardResponse;
import com.dgpay.application.managment.dto.CardListRequest;
import com.dgpay.application.managment.dto.DeleteCardRequest;
import com.dgpay.persistence.sw.model.card.Card;
import com.dgpay.persistence.sw.servcie.card.CardPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@RestController
@RequestMapping("/card/v1/service/")
@ComponentScan(basePackages = "com.dgpay.persistence.sw")
public class CardManagementRestController {

    @Autowired
    private CardPersistenceService cardPersistenceService;

    @PostMapping(value = "getCardList")
    public List<Card> getCardList(@RequestBody CardListRequest request) {

        List<Card> cards = cardPersistenceService.getCardListByCustomerNumber(request.getCustomerNumber());

        return cards;
    }

    @PostMapping(value = "addCard")
    public AddCardResponse addCard(@RequestBody AddCardRequest request) {

        Card card = cardPersistenceService.addCard(request.getCustomerNumber());

        AddCardResponse addCardResponse = new AddCardResponse();

        addCardResponse.setExpire_date(card.getExpire_date());
        addCardResponse.setPan(card.getPan());
        addCardResponse.setPin(card.getPin());
        addCardResponse.setPin2(card.getPin2());

        return addCardResponse;
    }

    @PostMapping(value = "deleteCard")
    public void deleteCard(@RequestBody DeleteCardRequest request){

        cardPersistenceService.deleteCardByPanAndCustomerNumber(request.getPan(), request.getCustomerNumber());

    }

}
