package com.laboratorio.repuestos.pedido.hacerconfirmar.model;

public class Pedido {

	private String codigoConfirmacion;
	private double valor;
	private String tipoSolicitud;
	private Repuesto repuesto;
	public String getCodigoConfirmacion() {
		return codigoConfirmacion;
	}
	public void setCodigoConfirmacion(String codigoConfirmacion) {
		this.codigoConfirmacion = codigoConfirmacion;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Repuesto getRepuesto() {
		return repuesto;
	}
	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	
}
