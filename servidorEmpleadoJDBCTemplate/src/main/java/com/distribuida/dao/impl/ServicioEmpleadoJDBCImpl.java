package com.distribuida.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.distribuida.Empleado;
import com.distribuida.dao.ServicioEmpleadoJDBC;

@Component("servicioEmpleados")
public class ServicioEmpleadoJDBCImpl implements ServicioEmpleadoJDBC{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insertar(Empleado empleado){
 
		String sql = "INSERT INTO EMPLEADO " +
			"(ID, NOMBRE, EDAD) VALUES (?, ?, ?)";
 
		jdbcTemplate = new JdbcTemplate(dataSource);
 
		jdbcTemplate.update(sql, new Object[] { empleado.getId(),
				empleado.getNombre(), empleado.getEdad()  
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Empleado buscarPorId(int id){
		 
		String sql = "SELECT * FROM EMPLEADO WHERE ID = ?";

		jdbcTemplate = new JdbcTemplate(dataSource);
		Empleado empleado = (Empleado) jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new BeanPropertyRowMapper(Empleado.class));
	 
		return empleado;
	}

	@SuppressWarnings("rawtypes")
	public List<Empleado> listar(){
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM EMPLEADO";
	 
		List<Empleado> empleados = new ArrayList<Empleado>();
	 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Empleado empleado = new Empleado();
			empleado.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			empleado.setNombre((String)row.get("NOMBRE"));
			empleado.setEdad(Integer.parseInt(String.valueOf(row.get("EDAD"))));
			empleados.add(empleado);
		}
	 
		return empleados;
	}
	
	public String buscarNombrePorId(int id){

		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT NOMBRE FROM EMPLEADO WHERE ID = ?";
	 
		String nombre = (String)jdbcTemplate.queryForObject(
				sql, new Object[] { id }, String.class);
	 
		return nombre;
	}

	public void insertBatchSQL(final String sql){
		 
		jdbcTemplate.batchUpdate(new String[]{sql});
	 
	}
	
	public void insertarBatch1(final List<Empleado> empleados){

		jdbcTemplate = new JdbcTemplate(dataSource);
		  String sql = "INSERT INTO EMPLEADO " +
			"(ID, NOMBRE, EDAD) VALUES (?, ?, ?)";
		 
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
		 
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Empleado empleado = empleados.get(i);
				ps.setLong(1, empleado.getId());
				ps.setString(2, empleado.getNombre());
				ps.setInt(3, empleado.getEdad() );
			}
		 
			public int getBatchSize() {
				return empleados.size();
			}
		  });
		}
	
	public void insertarBatch2(final String sql){
		jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.batchUpdate(new String[]{sql});
	 
	}
	
}
