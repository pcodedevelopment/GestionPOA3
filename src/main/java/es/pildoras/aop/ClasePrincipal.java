package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.ClienteDAO;
import es.pildoras.aop.dao.ClienteVIPDAO;

public class ClasePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// Leer la configuracón de Spring
		
		AnnotationConfigApplicationContext contexto= new AnnotationConfigApplicationContext(Configuracion.class);
		
		// Obtener el bean del contenedor de Spring
		
		ClienteDAO elCliente=contexto.getBean("clienteDAO", ClienteDAO.class);

		ClienteVIPDAO elClienteVIP=contexto.getBean("clienteVIPDAO", ClienteVIPDAO.class);

		// Llamar al método
		
		elCliente.insertaCliente();  //Este es el nombre del método que debe coincidir con la anotación @Before
		
		elClienteVIP.insertaClienteVIP();  //Este es el nombre del método que debe coincidir con la anotación @Before
		
		// Cerrar el contexto
		
		contexto.close();
	}

}
