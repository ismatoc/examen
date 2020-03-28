package com.viking.dao;

import java.util.List;

import com.viking.model.Vehiculo;
import com.viking.model.Bitacora;

public interface VehiculoDao {
	void insertVehiculo(Vehiculo veh);
	void insertVehiculos(List<Vehiculo> vehiculos);
	List<Vehiculo> getAllVehiculos();
	Vehiculo getVehiculoById(String marca);
	
	void insertBitacora(Bitacora bit);
}