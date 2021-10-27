package com.esprit.microservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credit  implements Serializable{
private static final long serialVersionUID = 6;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom; 
	@Column
	private String  prenom;
	@Column
	private int num;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getnum() {
		return num;
	}
	public void setnum(int num) {
		this.num = num;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Credit() {
		super();
	}
	public Credit(String nom) {
		super();
		this.nom = nom;
	}
	public Credit(int id, String nom, String prenom, int num) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.num = num;
	}
}
