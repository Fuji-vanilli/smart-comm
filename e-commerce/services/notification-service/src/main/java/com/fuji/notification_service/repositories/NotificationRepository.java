package com.fuji.notification_service.repositories;

import com.fuji.notification_service.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
