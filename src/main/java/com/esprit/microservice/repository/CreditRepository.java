package com.esprit.microservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.microservice.entities.Credit;

public interface CreditRepository extends JpaRepository<Credit, Integer>{
	@Query("select c from Credit c where c.nom like :nom")
	public Page<Credit> CreditByNom(@Param("nom") String n, Pageable pageable);
}
