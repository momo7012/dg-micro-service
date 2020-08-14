package com.dgpay.persistence.sw.servcie.card;

import com.dgpay.persistence.sw.dao.card.CardDao;
import com.dgpay.persistence.sw.model.card.Card;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/12/2020
 */
@Service
public class CardPersistenceService {

    @Autowired
    private CardDao cardDao;

    public Card addCard(Long customerNumber) {

        // TODO: 8/13/2020 check customer

        Card card = new Card();

        card.setCustomer_uid(customerNumber);
        card.setPan(generatePan());
        card.setPin(generatePin(1));
        card.setPin2(generatePin(2));
        card.setExpire_date(DateUtils.addYears(new Date(), +4));
        card.setStatus(1);

        cardDao.insert(card);
        return card;
    }

    private String generatePin(int type) {
        // TODO: 8/13/2020 generate pin
        return "1111";
    }

    private Long generatePan() {
        // TODO: 8/13/2020 create pan
        return 6037997300000111L;
    }

    public List<Card> getCardListByCustomerNumber(Long customerNumber) {

        List<Card> cards = cardDao.selectByCustomerUid(customerNumber);
        return cards;
    }

    public void deleteCardByPanAndCustomerNumber(Long pan, Long customerNumber) {

        cardDao.deleteCard(pan, customerNumber);
    }

    public Card getCardInfo(String pan) {

        return cardDao.selectByPan(pan);
    }
}
