package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Notification;

@Service
public interface NotificationService {
	
	List<Notification> findAll();
	Notification findById(String id);
	Notification add(Notification t);
	Notification update(Notification t);
	void deleteById(String id);
}
