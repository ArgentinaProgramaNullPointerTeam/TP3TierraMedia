package model;

//Clase abstracta y métodos abstractos
//Hereda a las clases Atraccion y Promocion
public abstract class Producto {

	// Devuelve si hay cupos
	public abstract boolean hayCupo();

	// Devuelve el costo de la visita
	public abstract int getCostoDeVisita();

	public abstract void setTipoAtracciones(int tipoAtraccion);
	
	// Devuelve el id del tipo de atraccion
	public abstract int getTipoAtracciones();

	// Devuelve el tiempo de la visita
	public abstract double getTiempoDeVisita();

	// Devuelve el nombre
	public abstract String getNombre();
	
	public abstract void setNombre(String nombre);

	// Resta cupos
	public abstract void restarCupo();

	// Devuelve si es un producto o no lo es
	public abstract boolean esPromocion();

	// Devuelve String concatenado
	public abstract String ofertas();
	
	// Devuelve String concatenado
	public abstract String getIncluye();
	
	// Retorna los cupos
	public abstract int getCupo();

	// Retorna si contiene dicho producto o no
	public abstract boolean esOContiene(Producto otro);

	// Retorna el id
	public abstract int getId();

	public abstract boolean isStatus();

	public abstract void setStatus(boolean status);
	
	public abstract String getTipo();
}
