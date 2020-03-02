package it.beije.cilacap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.cilacap.repository.RubricaRepository;
import it.beije.cilacap.web.rubrica.Contatto;


@Service
public class RubricaService {

	@Autowired
	private RubricaRepository rubricaRepository;

	public Contatto findContatto(Long id) {
		System.out.println("RubricaService: " + this.hashCode());
		
		return rubricaRepository.getOne(id);
	}
}
