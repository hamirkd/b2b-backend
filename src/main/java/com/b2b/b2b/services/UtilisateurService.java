package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface UtilisateurService <T> {
	
	List<T> findAll();
	T findById(String id);
	T add(T t);
	T update(T t);
	void deleteById(String id);
}
