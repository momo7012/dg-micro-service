package com.dgpay.persistence.sw.servcie.card;

import com.dgpay.persistence.sw.dao.card.CardDao;
import com.dgpay.persistence.sw.model.card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@Service
public class CardPersistenceService {

    @Autowired
    private CardDao cardDao;

    public List<Card> cardList(Long uid){

        List<Card> cards = cardDao.selectByCustomerUid(uid);

        return cards;
    }

    public void addCard(Card card){

    }

    public void deleteCard(String pan){

    }
}
