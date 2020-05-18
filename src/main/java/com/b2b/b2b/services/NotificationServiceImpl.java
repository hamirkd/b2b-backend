package com.b2b.b2b.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Notification;
import com.b2b.b2b.repositories.NotificationRepository;
@Service
public class NotificationServiceImpl implements NotificationService{
	@Autowired
	  NotificationRepository notificationRepository;

	@Override
	public List<Notification> findAll() {
		
		return notificationRepository.findAll();
	}

	@Override
	public Notification findById(String id) {
		
		return notificationRepository.findById(id).get();
	}

	@Override
	public Notification add(Notification t) {
		
		return notificationRepository.save(t);
	}

	@Override
	public Notification update(Notification t) {
		
		return notificationRepository.save(t);
	}

	@Override
	public void deleteById(String id) {
		
		notificationRepository.deleteById(id);
	}
	
}
