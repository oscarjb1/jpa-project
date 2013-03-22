package com.jpadomain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_Domicilios")
@SequenceGenerator(allocationSize=1,initialValue=1,name="seqDomicilio", sequenceName="SEQ_DOMICILIOS")
public class Domicilio {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqDomicilio")
	private Long id;
	
	@Column(name="DIRECCION_LINEA1", length=300)
	private String direccionLinea1;
	
	@Column(name="DIRECCION_LINEA2", length=300)
	private String direccionLinea2;
	
	@Column(name="PAIS", length=20)
	private String pais;
	
	@OneToOne(mappedBy="domicilio")
	private Cliente persona;
	
	/* GETTER y SETTER */
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDireccionLinea1() {
		return direccionLinea1;
	}
	public void setDireccionLinea1(String direccionLinea1) {
		this.direccionLinea1 = direccionLinea1;
	}
	public String getDireccionLinea2() {
		return direccionLinea2;
	}
	public void setDireccionLinea2(String direccionLinea2) {
		this.direccionLinea2 = direccionLinea2;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
}
