package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginConAspecto {
	
	//@Pointcut("execution(public * insertaCliente*(..))")
	@Pointcut("execution(* es.pildoras.aop.dao.*.*(..))")
	private void paraClientes() {}
	
	// pointcut para getters
	@Pointcut("execution(* es.pildoras.aop.dao.*.get*(..))")
	private void paraGettersClientes() {}
	
	//pointcut para setters
	@Pointcut("execution(* es.pildoras.aop.dao.*.set*(..))")
	private void paraSettersClientes() {}
	
	
	// Combinación de pointcuts
	@Pointcut("paraClientes() && !paraSettersClientes()")
	private void paqueteExceptoSetter() {}
	
//	@Before("paraClientes()")
//	@Before("paraSettersClientes()")
	@Before("paqueteExceptoSetter()")
	public void antesInsertarCliente() {
		
		
		System.out.println("El usuario está logueado");
		
		System.out.println("El perfil para insertar clientes es correcto");
				
	}
	
//	@Before("paraClientes()")
	public void requisitosCliente() {
		
		System.out.println("El cliente cumple los requisitos para ser insertado en la BBDD");
		
	}
	
//	@Before("paraClientes()")
	public void requisitosTabla() {
		
		System.out.println("Hay menos de 3000 registros en la tabla. Puedes insertar el nuevo cliente");
		
	}

}
