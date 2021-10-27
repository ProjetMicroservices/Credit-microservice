package com.esprit.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entities.Credit;
import com.esprit.microservice.repository.CreditRepository;

@Service
public class CreditService {

	@Autowired
	private CreditRepository CreditRepository; 
	
	//Ajouter un candidat
		public Credit addCredit(Credit Credit) {
			return CreditRepository.save(Credit);
		}
		
		
		//Mettre a jour les informations d'un candidat
		public Credit updateCredit(int id, Credit newCredit) {
			if(CreditRepository.findById(id).isPresent()) {
				Credit existingCredit = CreditRepository.findById(id).get();
				existingCredit.setNom(newCredit.getNom());
				existingCredit.setPrenom(newCredit.getPrenom());
				existingCredit.setnum(newCredit.getnum());
				
				return CreditRepository.save(existingCredit);
			}
			else {
				return null;
			}
		}
		
		
		//Supprimer un candidat
		public String deleteCredit(int id) {
			if(CreditRepository.findById(id).isPresent()) {
				CreditRepository.deleteById(id);
				return "Le credit avec l'id " + id + " a ete supprime";
			}
			else {
				return "Le credit avec l'id " + id + " n'a pas ete supprime";
			}
		}
		
		
		
		//Obtenir tous les candidats
		public  List<Credit> GetCredit() {
			return CreditRepository.findAll();
		}
		
		//Methode additionnelle (Pas dans l'atelier)
		//Chercher un candidat
		public Credit findCredit(int id) {
			if(CreditRepository.findById(id).isPresent()) {
				Credit existingCredit = CreditRepository.findById(id).get();
				return existingCredit;
			}
			else {
				return null;
			}
		}
}
