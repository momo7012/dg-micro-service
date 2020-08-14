package com.dgpay.persistence.sw.servcie.card;

import com.dgpay.persistence.sw.model.card.Card;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/13/2020
 */

@RunWith(SpringRunner.class)
public class CardPersistenceServiceTest  {

    @Autowired
    CardPersistenceService cardPersistenceService;

    public void testAddCard() {

        cardPersistenceService.addCard(1L);
    }

    public void testGetCardListByCustomerNumber() {
        List<Card> cardListByCustomerNumber = cardPersistenceService.getCardListByCustomerNumber(1L);
        Assert.assertTrue(cardListByCustomerNumber.size() == 4);
    }

    public void testDeleteCardByPanAndCustomerNumber() {
    }
}