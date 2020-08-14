package com.dgpay.persistence.sw.servcie.card;

import com.dgpay.persistence.SwitchPersistenceApplication;
import com.dgpay.persistence.sw.model.card.Card;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/13/2020
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SwitchPersistenceApplication.class)
public class CardPersistenceServiceTest {

    @Autowired
    CardPersistenceService cardPersistenceService;


    @Test
    public void addCard() {
        Card card = cardPersistenceService.addCard(1L);
        Assert.assertTrue(card != null);
    }

    @Test
    public void getCardListByCustomerNumber() {
        List<Card> cardListByCustomerNumber = cardPersistenceService.getCardListByCustomerNumber(1L);
        Assert.assertTrue(cardListByCustomerNumber.size() == 4);
    }

    @Test
    public void deleteCardByPanAndCustomerNumber() {
    }

    @Test
    public void getCardInfo() {
        Card cardInfo = cardPersistenceService.getCardInfo("6037999332013381");
        Assert.assertTrue(cardInfo != null);
    }
}