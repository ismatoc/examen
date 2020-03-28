package com.viking.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.viking.dao.VehiculoDao;
import com.viking.model.Vehiculo;
import com.viking.model.Bitacora;

@Repository
public class VehiculoDaoImpl extends JdbcDaoSupport implements VehiculoDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertVehiculo(Vehiculo veh) {
		String sql = "INSERT INTO vehiculos " +
				"(marca, modelo) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				veh.getMarca(), veh.getModelo()
		});
	}
	
	@Override
	public void insertBitacora(Bitacora bit) {
		String sql = "INSERT INTO bitacora " +
				"(marca, modelo) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				bit.getMarca(), bit.getModelo()
		});
	}
	
	
	@Override
	public void insertVehiculos(final List<Vehiculo> vehiculos) {
		String sql = "INSERT INTO vehiculos " + "(marca, modelo) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Vehiculo vehiculo = vehiculos.get(i);
				ps.setString(1, vehiculo.getMarca());
				ps.setString(2, vehiculo.getModelo());
			}
			
			public int getBatchSize() {
				return vehiculos.size();
			}
		});

	}
	
	
	
	
	
	
	
	
	@Override
	public List<Vehiculo> getAllVehiculos(){
		String sql = "SELECT * FROM vehiculos";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Vehiculo> result = new ArrayList<Vehiculo>();
		for(Map<String, Object> row:rows){
			Vehiculo veh = new Vehiculo();
			veh.setMarca((String)row.get("marca"));
			veh.setModelo((String)row.get("modelo"));
			result.add(veh);
		}
		
		return result;
	}

	@Override
	public Vehiculo getVehiculoById(String marca) {
		String sql = "SELECT * FROM vehiculos WHERE marca = ?";
		return (Vehiculo)getJdbcTemplate().queryForObject(sql, new Object[]{marca}, new RowMapper<Vehiculo>(){
			@Override
			public Vehiculo mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Vehiculo veh = new Vehiculo();
				veh.setMarca(rs.getString("marca"));
				veh.setModelo(rs.getString("modelo"));
				return veh;
			}
		});
	}
}