package com.distribuida;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PruebaEmpleadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaEmpleadoApplication.class, args);
	/*	ApplicationContext ctx=SpringApplication.run(PruebaEmpleadoApplication.class, args);
		ServicioEmpleadoJDBC jdbcEmployeeDAO = (ServicioEmpleadoJDBC) ctx.getBean("servicioEmpleados");
		Empleado emplNew1 = new Empleado(23, "John", 23);
		Empleado emplNew2 = new Empleado(223, "Mark", 43);
		List<Empleado> employeesN = new ArrayList<Empleado>();
		employeesN.add(emplNew1);
        employeesN.add(emplNew2);
        jdbcEmployeeDAO.insertarBatch1(employeesN);
        System.out.println(" INSERTANDO FILAS:  " + employeesN);
        System.out.println(" LISTAR TODOS : " + jdbcEmployeeDAO.listar());
        jdbcEmployeeDAO.insertarBatch2("UPDATE EMPLEADO SET NOMBRE ='Mary'");
        
        List<Empleado> empleados = jdbcEmployeeDAO.listar();
        System.out.println("Nombre de columna actualizado de la tabla: " + empleados);	
        
        System.out.println(" LISTAR TODOS : " + jdbcEmployeeDAO.listar());*/
        
	}
}
