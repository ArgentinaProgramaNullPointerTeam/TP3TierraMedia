package model;

import java.util.List;
import java.util.Map;

public class PromocionAbsoluta extends Promocion {
	private int descuento;
	private Map<String, String> errores;

	public PromocionAbsoluta(int id, String nombre, int tipoAtraccion, String tipo, int cantAtracciones, List<Atraccion> atracciones,
			String tipoPromocion, int descuento, Boolean status) {
		super(id, nombre, tipoAtraccion, tipo, cantAtracciones, atracciones, tipoPromocion, status);
		this.descuento = descuento;
	}

	public PromocionAbsoluta(String nombre, int tipoAtraccion, int cantAtracciones, List<Atraccion> atracciones,
			String tipoPromocion, int descuento) {
		super(nombre, tipoAtraccion, cantAtracciones, atracciones, tipoPromocion);
		this.descuento = descuento;
	}

	@Override
	public int getCostoDeVisita() {
		return this.descuento;
	}

	public int getDescuento() {
		return descuento;
	}
	
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public Map<String, String> getErrors() {
		return errores;
	}
	
	@Override
	public String getDesc() {
		return String.valueOf(descuento);
	}
}
