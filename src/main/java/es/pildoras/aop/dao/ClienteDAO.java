package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

import es.pildoras.aop.Cliente;

@Component
public class ClienteDAO {
		
	public void insertaCliente(Cliente elCliente, String tipo) {
		
		System.out.println("Trabajo realizado OK. Cliente insertado correctamente");
				
	}
	
	
}
