package it.beije.cilacap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.cilacap.web.rubrica.Contatto;


@Repository
public interface RubricaRepository extends JpaRepository<Contatto, Long> {

	//Optional<Contatto> findByEmail(String email);
	
}
