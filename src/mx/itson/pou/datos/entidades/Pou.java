package mx.itson.pou.datos.entidades;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Representa la entidad pou.
 * @author LagunaJS
 *
 */

@Entity
public class Pou {
	
	private int id;
	private String nombre;
	private int nivelSalud;
	private int nivelEnergia;
	private int nivelSatisfaccion;
	private int dinero;
	
	/**
	 * @return El valor de la variable id.
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	/**
	 * @param Asigna a id el valor de id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return El valor de la variable nombre.
	 */
	@Basic
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param Asigna a nombre el valor de nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return El valor de la variable nivelSalud.
	 */
	@Basic
	public int getNivelSalud() {
		return nivelSalud;
	}
	/**
	 * @param Asigna a nivelSalud el valor de nivelSalud.
	 */
	public void setNivelSalud(int nivelSalud) {
		this.nivelSalud = nivelSalud;
	}
	/**
	 * @return El valor de la variable nivelEnergia.
	 */
	@Basic
	public int getNivelEnergia() {
		return nivelEnergia;
	}
	/**
	 * @param Asigna a nivelEnergia el valor de nivelEnergia.
	 */
	public void setNivelEnergia(int nivelEnergia) {
		this.nivelEnergia = nivelEnergia;
	}
	
	/**
	 * @return El valor de la variable nivelHambre.
	 */
	@Basic
	public int getNivelSatisfaccion() {
		return nivelSatisfaccion;
	}
	/**
	 * @param Asigna a nivelHambre el valor de nivelHambre.
	 */
	public void setNivelSatisfaccions(int nivelHambre) {
		this.nivelSatisfaccion = nivelHambre;
	}
	/**
	 * @return El valor de la variable dinero.
	 */
	@Basic
	public int getDinero() {
		return dinero;
	}
	/**
	 * @param Asigna a dinero el valor de dinero.
	 */
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	
	

}
