package com.jpadomain.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TClientes")
@SequenceGenerator(allocationSize=1,initialValue=1,name="seqCliente", sequenceName="SEQ_CLIENTES")
public class Cliente {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCliente")
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="APELLIDO",nullable=false)
	private String apellido;
	
	@Temporal(TemporalType.DATE)
	private Calendar fechaNacimiento;
	
	@OneToOne(optional=false,cascade={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REMOVE})
	@JoinColumn(name="FK_DOMICILIO", nullable=false,unique=true)
	private Domicilio domicilio;
	
	
	@OneToMany(mappedBy="cliente")
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Domicilio getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}


	public List<Cuenta> getCuentas() {
		return cuentas;
	}


	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
}
