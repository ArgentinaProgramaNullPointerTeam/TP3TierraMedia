package model;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	private List<Atraccion> ListaAtracciones;
	private double descuento;
	private int costoDeVisita;

	public PromocionPorcentual(int id, String nombre, int tipoAtraccion, String tipo, int cantAtracciones,
			List<Atraccion> atracciones, String tipoPromocion, Double descuento, Boolean status) {
		super(id, nombre, tipoAtraccion, tipo, cantAtracciones, atracciones, tipoPromocion, status);
		this.ListaAtracciones = atracciones;
		this.descuento = descuento;
	}

	public PromocionPorcentual(String nombre, int tipoAtraccion, int cantAtracciones, List<Atraccion> atracciones,
			String tipoPromocion, Double descuento) {
		super(nombre, tipoAtraccion, cantAtracciones, atracciones, tipoPromocion);
		this.ListaAtracciones = atracciones;
		this.descuento = descuento;
	}

	@Override
	public int getCostoDeVisita() {
		costoDeVisita = 0;
		for (Atraccion atraccion : this.ListaAtracciones) {
			costoDeVisita = costoDeVisita + atraccion.getCostoDeVisita();
		}
		costoDeVisita = (int) (costoDeVisita - (costoDeVisita * descuento));
		return costoDeVisita;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	@Override
	public String getDesc() {
		return String.valueOf(descuento * 100);
	}
}
