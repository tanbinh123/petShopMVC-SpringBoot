package com.petshop.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CLIENTES")
public class ClienteEntity {

	//Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="sobrenome")
    private String sobrenome;
    
    @Column(name="brinquedo")
    private String brinquedo;
    
    @Column(name="email", nullable=false, length=200)
    private String email;
    
    
    //Metodos gets e sets
    public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getBrinquedo() {
		return brinquedo;
	}


	public void setBrinquedo(String brinquedo) {
		this.brinquedo = brinquedo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "ClienteEntity [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", brinquedo=" + brinquedo
				+ ", email=" + email + "]";
	}
}