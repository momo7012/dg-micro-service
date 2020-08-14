package com.dgpay.application.notification.service;

import com.dgpay.application.notification.dto.NotificationRequest;
import com.dgpay.persistence.notification.model.Notification;
import com.dgpay.persistence.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;


    public void process(NotificationRequest notificationRequest) {

        Notification notification = new Notification();
        notification.setMax_try(20);
        notification.setStatus(0);
        notification.setMobile(notificationRequest.getMobile());
        notification.setMessage(notificationRequest.getMessage());

        notificationRepository.save(notification);
    }
}
