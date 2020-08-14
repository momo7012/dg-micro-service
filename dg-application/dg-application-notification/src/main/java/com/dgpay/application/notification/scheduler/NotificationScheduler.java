package com.dgpay.application.notification.scheduler;

import com.dgpay.application.notification.external.dto.NotificationRequest;
import com.dgpay.application.notification.external.dto.NotificationResponse;
import com.dgpay.application.notification.external.feign.NotificationFeignClient;
import com.dgpay.persistence.notification.model.Notification;
import com.dgpay.persistence.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
@Component
public class NotificationScheduler {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationFeignClient notificationFeignClient;

    @Scheduled(initialDelayString = "10000", fixedDelayString = "60000")
    public void process() {


        List<Notification> notifications = notificationRepository.findByStatus(0);

        for (Notification notification : notifications) {

            ResponseEntity<NotificationResponse> notificationResponseResponseEntity = notificationFeignClient.sendRequest(new NotificationRequest(notification.getMobile(), notification.getMessage()));
            checkResponse(notificationResponseResponseEntity, notification);
        }

    }


    private void checkResponse(ResponseEntity<NotificationResponse> notificationResponseResponseEntity, Notification notification) {

        HttpStatus statusCode = notificationResponseResponseEntity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            notification.setStatus(1);
        } else {
            notification.setTry_count(notification.getTry_count() + 1);
        }
        notificationRepository.save(notification);

    }
}
