package com.viking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viking.dao.VehiculoDao;
import com.viking.model.Vehiculo;
import com.viking.model.Bitacora;
import com.viking.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	VehiculoDao vehiculoDao;

	@Override
	public void insertVehiculo(Vehiculo vehiculo) {
		vehiculoDao.insertVehiculo(vehiculo);
	}
	
	@Override
	public void insertBitacora(Bitacora bitacora) {
		vehiculoDao.insertBitacora(bitacora);
	}

	@Override
	public void insertVehiculos(List<Vehiculo> vehiculos) {
		vehiculoDao.insertVehiculos(vehiculos);
	}
	
	

	public List<Vehiculo> getAllVehiculos() {
		return vehiculoDao.getAllVehiculos();
	}

	@Override
	public void getVehiculoById(String marca) {
		Vehiculo vehiculo = vehiculoDao.getVehiculoById(marca);
		System.out.println(vehiculo);
	}

}