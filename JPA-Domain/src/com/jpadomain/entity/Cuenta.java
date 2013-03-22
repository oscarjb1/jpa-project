package com.jpadomain.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jpadomain.entity.enums.EstatusCuenta;

@Entity
@Table(name="TCuentas")
@SequenceGenerator(allocationSize=1, initialValue=1, name="seqCuenta", sequenceName="SEQ_CUENTAS")
public class Cuenta {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqCuenta")
	private Long id;
	
	@Column(name="saldo", nullable = false)
	private double saldo;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="FK_CLIENTE", nullable=false, updatable=false)
	private Cliente cliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_APERTURA", nullable=false,updatable=false)
	private Calendar fechaApertura;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS", nullable=false)
	private EstatusCuenta status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Calendar fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public EstatusCuenta getStatus() {
		return status;
	}

	public void setStatus(EstatusCuenta status) {
		this.status = status;
	}
}
