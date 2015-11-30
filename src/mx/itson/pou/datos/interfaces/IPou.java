/**
 * 
 */
package mx.itson.pou.datos.interfaces;

import mx.itson.pou.datos.entidades.Pou;


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
	public Pou Comer(int id, Pou pou);
	
	/**
	 * Modifica los niveles de pou al consumir una pocima del botiquin
	 * @param pocima
	 * @param pou
	 */
	public Pou Tomar(int id, Pou pou);
	
	/**
	 * Modifica los niveles de pou al ponerse una cosa del closet
	 * @param cosa
	 * @param pou
	 */
	public Pou Usar(int id, Pou pou);
}
