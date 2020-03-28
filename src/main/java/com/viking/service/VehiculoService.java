package com.viking.service;

import java.util.List;

import com.viking.model.Vehiculo;
import com.viking.model.Bitacora;

public interface VehiculoService {
	void insertVehiculo(Vehiculo veh);
	void insertVehiculos(List<Vehiculo> vehiculos);
	
	void getVehiculoById(String marca);
	
	void insertBitacora(Bitacora bit);
	
}