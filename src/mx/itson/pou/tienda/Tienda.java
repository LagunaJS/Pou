/**
 * 
 */
package mx.itson.pou.tienda;

import javax.swing.JOptionPane;

import mx.itson.pou.cocina.entidades.Comida;
import mx.itson.pou.cocina.entidades.Refrigerador;
import mx.itson.pou.cocina.implementacion.ComidaImplementacion;
import mx.itson.pou.cocina.implementacion.RefrigeradorImplementacion;
import mx.itson.pou.cocina.interfaces.IComida;
import mx.itson.pou.cocina.interfaces.IRefrigerador;
import mx.itson.pou.datos.entidades.Pou;
import mx.itson.pou.datos.implementacion.PouImplementacion;
import mx.itson.pou.datos.interfaces.IPou;
import mx.itson.pou.dormitorio.entidades.Closet;
import mx.itson.pou.dormitorio.entidades.Cosa;
import mx.itson.pou.dormitorio.implementacion.ClosetImplementacion;
import mx.itson.pou.dormitorio.implementacion.CosaImplementacion;
import mx.itson.pou.dormitorio.interfaces.ICloset;
import mx.itson.pou.dormitorio.interfaces.ICosa;
import mx.itson.pou.laboratorio.entidades.Botiquin;
import mx.itson.pou.laboratorio.entidades.Pocima;
import mx.itson.pou.laboratorio.implementacion.BotiquinImplementacion;
import mx.itson.pou.laboratorio.implementacion.PocimaImplementacion;
import mx.itson.pou.laboratorio.interfaces.IBotiquin;
import mx.itson.pou.laboratorio.interfaces.IPocima;

/**
 * @author LagunaJS
 *
 */
public class Tienda {
	static IPou ipou = new PouImplementacion();
	static IRefrigerador refrigerador = new RefrigeradorImplementacion();
	static IBotiquin botiquin = new BotiquinImplementacion();
	static ICloset closet = new ClosetImplementacion();
	static IComida icomida = new ComidaImplementacion();
	static IPocima ipocima = new PocimaImplementacion();
	static ICosa icosa = new CosaImplementacion();

	/**
	 * Recibe una comida y si pou tiene dinero suficiente la guarda en el refrigerador
	 * @param comida objeto de tipo @Comida
	 * @param pou objeto de tipo @Pou
	 */
	public void ComprarComida(int id, Pou pou){
		Comida comida = icomida.getById(id);
		if (pou.getDinero() > comida.getPrecio()) {
			Refrigerador refri = new Refrigerador();
			refri.setComida(comida);
			try {
				refrigerador.create(refri);
				pou.setDinero(pou.getDinero() - comida.getPrecio());
				ipou.setPou(pou);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			JOptionPane.showMessageDialog(null,	"No tienes suficiente dinero");
		}
	}
	
	/**
	 * Recibe una cosa y si pou tiene dinero suficiente la guarda en el closet
	 * @param cosa objeto de tipo @Cosa
	 * @param pou objeto de tipo @Pou
	 */
	public void ComprarCosa(int id, Pou pou){
		Cosa cosa = icosa.getById(id);
		if (pou.getDinero() > cosa.getPrecio()) {
			Closet c = new Closet();
			c.setCosa(cosa);
			try {
				closet.create(c);
				pou.setDinero(pou.getDinero() - cosa.getPrecio());
				ipou.setPou(pou);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			JOptionPane.showMessageDialog(null,	"No tienes suficiente dinero");
		}
	}
	
	/**
	 * Recibe una pocima y si pou tiene dinero suficiente la guarda en el botiquin
	 * @param pocima objeto de tipo @Pocima
	 * @param pou objeto de tipo @Pou
	 */
	public void ComprarPocima(int id, Pou pou){
		Pocima pocima = ipocima.getById(id);
		if (pou.getDinero() > pocima.getPrecio()) {
			Botiquin b = new Botiquin();
			b.setPocima(pocima);
			try {
				botiquin.create(b);
				pou.setDinero(pou.getDinero() - pocima.getPrecio());
				ipou.setPou(pou);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			JOptionPane.showMessageDialog(null,	"No tienes suficiente dinero");
		}
	}
	

}
