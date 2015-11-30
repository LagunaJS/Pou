/**
 * 
 */
package mx.itson.pou.datos.implementacion;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mx.itson.pou.cocina.entidades.Comida;
import mx.itson.pou.cocina.entidades.Refrigerador;
import mx.itson.pou.cocina.implementacion.ComidaImplementacion;
import mx.itson.pou.cocina.implementacion.RefrigeradorImplementacion;
import mx.itson.pou.cocina.interfaces.IComida;
import mx.itson.pou.cocina.interfaces.IRefrigerador;
import mx.itson.pou.datos.entidades.Pou;
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
public class PouImplementacion implements IPou {
	static IComida icomida = new ComidaImplementacion();
	static IPocima ipocima = new PocimaImplementacion();
	static ICosa icosa = new CosaImplementacion();


	@Override
	public Pou getPou() {
		Pou pou = new Pou();
		try {
			Session sesion = HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = sesion.createCriteria(Pou.class);
			criteria.add(Restrictions.eq("id",1));
			pou = (Pou) criteria.uniqueResult();
			sesion.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pou;
	}


	@Override
	public void setPou(Pou pou) {
		try {
			Session sesion = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = sesion.beginTransaction();
			sesion.update(pou);
			transaction.commit();
			sesion.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

	}


	@Override
	public Pou Comer(int id, Pou pou) {
		IRefrigerador refrigerador = new RefrigeradorImplementacion(); 
		Refrigerador refri = new Refrigerador();
		
		Comida comida = new Comida();
		comida = refrigerador.getById(id).getComida();
		try {
			pou.setNivelEnergia(pou.getNivelEnergia() + comida.getNivelEnergia());
			pou.setNivelSalud(pou.getNivelSalud() + comida.getNivelSalud());
			pou.setnivelSatisfaccion(pou.getNivelSatisfaccion() + comida.getNivelSatisfaccion());	
			

			refri = refrigerador.getById(id);
			refrigerador.delete(refri);
			
			setPou(pou);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pou;
	}


	@Override
	public Pou Tomar(int id, Pou pou) {
		IBotiquin botiquin = new BotiquinImplementacion();
		Botiquin b = new Botiquin();
		
		Pocima pocima = new Pocima();
		pocima = botiquin.getById(id).getPocima();
		try {
			pou.setNivelEnergia(pou.getNivelEnergia() + pocima.getNivelEnergia());
			pou.setNivelSalud(pou.getNivelSalud() + pocima.getNivelSalud());
			pou.setnivelSatisfaccion(pou.getNivelSatisfaccion() + pocima.getNivelSatisfaccion());			
			
			b = botiquin.getById(id);
			botiquin.delete(b);
			
			setPou(pou);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pou;
	}


	@Override
	public Pou Usar(int id, Pou pou) {
		ICloset closet = new ClosetImplementacion();
		Closet c = new Closet();
		
		Cosa cosa = new Cosa();
		cosa = closet.getById(id).getCosa();
		try {
			pou.setNivelEnergia(pou.getNivelEnergia() + cosa.getNivelEnergia());			
			

			c = closet.getById(id);
			closet.delete(c);
			
			setPou(pou);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pou;
	}

}
