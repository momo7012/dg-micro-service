package com.dgpay.persistence.notification.repository;

import com.dgpay.persistence.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Mohammadreza Momeni (mohamad7012@gmail.com)
 * 8/14/2020
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT * FROM notification.notification WHERE status = ?1 AND try_count < max_count")
    List<Notification> findByStatus(Integer status);


}



