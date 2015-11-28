/**
 * 
 */
package mx.itson.pou.datos.interfaces;

import mx.itson.pou.cocina.entidades.Comida;
import mx.itson.pou.datos.entidades.Pou;
import mx.itson.pou.dormitorio.entidades.Cosa;
import mx.itson.pou.laboratorio.entidades.Pocima;

/**
 * @author LagunaJS
 *
 */
public interface IPou {
	
	/**
	 * Obtiene los datos de Pou
	 * @return un objeto tipo @Pou
	 */
	public Pou getPou();
	
	/**
	 * Guarda los datos de pou
	 * @Param recibe un objeto tipo @Pou
	 */
	public void setPou(Pou pou);

	/**
	 * Modifica los niveles de pou al consumir una comida del refrigerador
	 * @param comida
	 * @param pou
	 */
	public Pou Comer(Comida comida, Pou pou);
	
	/**
	 * Modifica los niveles de pou al consumir una pocima del botiquin
	 * @param pocima
	 * @param pou
	 */
	public Pou Tomar(Pocima pocima, Pou pou);
	
	/**
	 * Modifica los niveles de pou al ponerse una cosa del closet
	 * @param cosa
	 * @param pou
	 */
	public Pou Usar(Cosa cosa, Pou pou);
}
