package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

import es.pildoras.aop.Cliente;

@Component
public class ClienteDAO {
	
	private String valoracionClienteNormal;
	
	private String codigoClienteNormal;
	
	public void insertaCliente(Cliente elCliente, String tipo) {
		
		System.out.println("Trabajo realizado OK. Cliente insertado correctamente");
				
	}

	public String getValoracionClienteNormal() {
		System.out.println("Obteniendo valoración del Cliente");
		return valoracionClienteNormal;
	}

	public void setValoracionClienteNormal(String valoracionClienteNormal) {
		System.out.println("Estableciendo valoración del Cliente");
		this.valoracionClienteNormal = valoracionClienteNormal;
	}

	public String getCodigoClienteNormal() {
		System.out.println("Obteniendo código del Cliente");
		return codigoClienteNormal;
	}

	public void setCodigoClienteNormal(String codigoClienteNormal) {
		System.out.println("Estableciendo código del Cliente");
		this.codigoClienteNormal = codigoClienteNormal;
	}

	
	
}
