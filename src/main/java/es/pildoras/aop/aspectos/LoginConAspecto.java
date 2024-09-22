package es.pildoras.aop.aspectos;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import es.pildoras.aop.Cliente;

@Aspect
@Component
@Order(3)
public class LoginConAspecto {
	
	
	@Around("execution(* es.pildoras.aop.servicios.*.getServicio(..))")
	public Object ejecutarServicio(ProceedingJoinPoint elPoint) throws Throwable{
		
		System.out.println("-----Comienzo de acciones antes de llamada-----");
		
		long comienzo=System.currentTimeMillis();
		
		
		Object resultado=elPoint.proceed();	// elPoint apunta al método destino
		
		long fin = System.currentTimeMillis();
		
		long duracion=fin-comienzo;
		
		System.out.println("El método tardó " + duracion/1000 + " segundos");
		
		System.out.println("-----tareas después de llamada----");
		
		
		return resultado;
		
	}
	
	
	@AfterReturning(pointcut="execution(* es.pildoras.aop.dao.ClienteDAO.encuentraClientes(..))", returning="listaClientes")
	public void tareaTrasEncontrarClientes(List<Cliente>listaClientes) {
		
		for(Cliente cl:listaClientes) {
			
			if(cl.getTipo()=="VIP") { 

				procesadoDatosAfterReturning(listaClientes);
				
				System.out.println("Existen clientes VIP en el listado: " + cl.getNombre());
				
			}
		}
		
	}
	
	@AfterThrowing(pointcut="execution(* es.pildoras.aop.dao.ClienteDAO.encuentraClientes(..))", throwing="LaExcepcion")
	public void procesandoDatosAfterExceptionEncuentraClientes(Throwable LaExcepcion) {
		
		
		System.out.println("Aquí se estarían ejecutando de forma automática las tareas tras la excepción");
		
		
	}
	
	@After("execution(* es.pildoras.aop.dao.ClienteDAO.encuentraClientes(..))")
	public void ejecutandoTareasConySinExcepcion(JoinPoint elPoint) {
		
		System.out.println("Ejecutando Tareas SIEMPRE!!!");
		
		
	}
	
	private void procesadoDatosAfterReturning(List<Cliente> listaClientes) {
		// TODO Auto-generated method stub
		
		for(Cliente cl:listaClientes) {
			
				String datosProcesados="V.I.P. " + cl.getNombre().toUpperCase();
				
				cl.setNombre(datosProcesados);
			
		}
		
	}
	//@Pointcut("execution(public * insertaCliente*(..))")
	@Pointcut("execution(* es.pildoras.aop.dao.*.*(..))")
	public void paraClientes() {}	//Se declara Public para poder acceder desde otras clases
		
	@Before("paraClientes()")
	public void antesInsertarCliente(JoinPoint miJoin) {
		
		
		System.out.println("El usuario está logueado");
		
		System.out.println("El perfil para insertar clientes es correcto");
		
		Object[] argumentos = miJoin.getArgs();
		
		for(Object tmpObj:argumentos) {
		
			if(tmpObj instanceof Cliente) {
				
				Cliente elCliente=(Cliente)tmpObj;
				
				System.out.println("Nombre del cliente: " + elCliente.getNombre());
		
				System.out.println("Tipo del cliente: " + elCliente.getTipo());

			}
			
		}
				
	}

}
