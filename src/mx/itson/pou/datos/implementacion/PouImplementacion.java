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
import mx.itson.pou.cocina.implementacion.RefrigeradorImplementacion;
import mx.itson.pou.cocina.interfaces.IRefrigerador;
import mx.itson.pou.datos.entidades.Pou;
import mx.itson.pou.datos.interfaces.IPou;
import mx.itson.pou.dormitorio.entidades.Closet;
import mx.itson.pou.dormitorio.entidades.Cosa;
import mx.itson.pou.dormitorio.implementacion.ClosetImplementacion;
import mx.itson.pou.dormitorio.interfaces.ICloset;
import mx.itson.pou.laboratorio.entidades.Botiquin;
import mx.itson.pou.laboratorio.entidades.Pocima;
import mx.itson.pou.laboratorio.implementacion.BotiquinImplementacion;
import mx.itson.pou.laboratorio.interfaces.IBotiquin;

/**
 * @author LagunaJS
 *
 */
public class PouImplementacion implements IPou {


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
	public Pou Comer(Comida comida, Pou pou) {
		try {
			pou.setNivelEnergia(pou.getNivelEnergia() + comida.getNivelEnergia());
			pou.setNivelSalud(pou.getNivelSalud() + comida.getNivelSalud());
			pou.setNivelSatisfaccions(pou.getNivelSatisfaccion() + comida.getNivelSatisfaccion());			
			setPou(pou);
			
			IRefrigerador refrigerador = new RefrigeradorImplementacion(); 
			Refrigerador refri = new Refrigerador();
			refri.setComida(comida);
			refrigerador.delete(refri);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pou;
	}


	@Override
	public Pou Tomar(Pocima pocima, Pou pou) {
		try {
			pou.setNivelEnergia(pou.getNivelEnergia() + pocima.getNivelEnergia());
			pou.setNivelSalud(pou.getNivelSalud() + pocima.getNivelSalud());
			pou.setNivelSatisfaccions(pou.getNivelSatisfaccion() + pocima.getNivelSatisfaccion());			
			setPou(pou);
			
			IBotiquin botiquin = new BotiquinImplementacion();
			Botiquin b = new Botiquin();
			b.setPocima(pocima);
			botiquin.delete(b);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pou;
	}


	@Override
	public Pou Usar(Cosa cosa, Pou pou) {
		try {
			pou.setNivelEnergia(pou.getNivelEnergia() + cosa.getNivelEnergia());			
			setPou(pou);
			
			ICloset closet = new ClosetImplementacion();
			Closet c = new Closet();
			c.setCosa(cosa);
			closet.delete(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pou;
	}

}
