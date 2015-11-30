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
 * 
 */

/**
 * @author LagunaJS
 *
 */
public class Main {
	
	
	
	static Pou pou = new Pou();
	static IPou p = new PouImplementacion();
	
	// ----------- Cocina -------------
	static Comida comida = new Comida();
	static IComida c =  new ComidaImplementacion();
	static Refrigerador refri = new Refrigerador();
	static IRefrigerador r = new RefrigeradorImplementacion();
	
	
	//------------Dormitorio -------------
	static Cosa cosa = new Cosa();
	static ICosa co = new CosaImplementacion();
	static Closet closet = new Closet();
	static ICloset clo = new ClosetImplementacion();
	
	//---------- Laboratorio -------------
	static Pocima pocima = new Pocima();
	static IPocima po = new PocimaImplementacion();
	static Botiquin botiquin = new Botiquin();
	static IBotiquin bo = new BotiquinImplementacion();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		pocima = po.getById(15);
		System.out.println(pocima.getNombre());
		po.getAll();
		botiquin = bo.getById(1);
		bo.getAll();
		pocima = botiquin.getPocima();
		System.out.println(pocima.getNombre());
		
		pou = p.getPou();
		System.out.println(pou.getNombre() + " " + pou.getNivelSatisfaccion());
		pou.setnivelSatisfaccion(50);
		p.setPou(pou);
		System.out.println(pou.getNombre() + " " + pou.getNivelSatisfaccion());
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		comida = c.getById(1);
		System.out.println(comida.getNombre());
		c.getAll();
		refri = r.getById(2);
		comida = refri.getComida();
		r.getAll();
		System.out.println(comida.getNombre());
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		cosa = co.getById(2);
		co.getAll();
		System.out.println(cosa.getNombre());
		closet = clo.getById(1);
		clo.getAll();
		cosa = closet.getCosa();
		System.out.println(cosa.getNombre());

	}

}
