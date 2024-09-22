package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.ClienteDAO;
import es.pildoras.aop.dao.ClienteVIPDAO;
import es.pildoras.aop.servicios.MedicionServicio;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// Leer la configuracón de Spring
		
		AnnotationConfigApplicationContext contexto= new AnnotationConfigApplicationContext(Configuracion.class);
		
		// Obtener el bean del contenedor de Spring
		
/*		ClienteDAO elCliente=contexto.getBean("clienteDAO", ClienteDAO.class);

		try {
		boolean miParam= false;
		
		elCliente.encuentraClientes(miParam);
		}catch(Exception miEx) {
			
			System.out.println("Excepción lanzada desde la clase principal");
			System.out.println(miEx.getMessage());
			
		}
		
		System.out.println("Aquí continuaría la ejecución del programa "); */
		
		MedicionServicio elServicio=contexto.getBean("medicionServicio", MedicionServicio.class);
		
		System.out.println("Llamando al método getServicio()");
		
		String datos=elServicio.getServicio();
		
		System.out.println("Devolución del método: " + datos);
		
		contexto.close();
	}

}
