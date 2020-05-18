package com.b2b.b2b.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.b2b.b2b.models.Langue;
@Service
public interface LangueService {
	List<Langue> findAllLangue();
	Langue findById(String id);
}
