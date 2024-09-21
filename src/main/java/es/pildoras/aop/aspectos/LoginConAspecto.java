package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoginConAspecto {
	
	//@Pointcut("execution(public * insertaCliente*(..))")
	@Pointcut("execution(* es.pildoras.aop.dao.*.*(..))")
	public void paraClientes() {}	//Se declara Public para poder acceder desde otras clases
		
	@Before("paraClientes()")
	public void antesInsertarCliente() {
		
		
		System.out.println("El usuario está logueado");
		
		System.out.println("El perfil para insertar clientes es correcto");
				
	}

}
