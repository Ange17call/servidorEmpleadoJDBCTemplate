package com.distribuida;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.distribuida.dao.ServicioEmpleadoJDBC;


@Configuration
@ComponentScan("com")
public class AppConfig {
	
	@Bean("/servicioEmpleado")
	public HttpInvokerServiceExporter HttpOperaciones(ServicioEmpleadoJDBC servicioEmpleadoJDBC) {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(servicioEmpleadoJDBC);
		exporter.setServiceInterface(ServicioEmpleadoJDBC.class);
		return exporter;
	}
	
}