package com.dgpay.endpoint.payment.rest;

import com.dgpay.endpoint.payment.dto.AddCardRequest;
import com.dgpay.endpoint.payment.dto.AddCardResponse;
import com.dgpay.endpoint.payment.dto.CardListRequest;
import com.dgpay.endpoint.payment.dto.DeleteCardRequest;
import com.dgpay.persistence.sw.model.card.Card;
import com.dgpay.persistence.sw.servcie.card.CardPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/payment/v1/service/")
public class PaymentRestController {

    // TODO: 8/12/2020 list
    // TODO: 8/12/2020 add
    // TODO: 8/12/2020 delete
    // TODO: 8/12/2020 transaction

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
