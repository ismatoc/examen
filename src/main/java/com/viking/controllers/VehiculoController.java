package com.viking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.viking.model.Vehiculo;
import com.viking.model.Bitacora;
import com.viking.service.VehiculoService;

@Controller
public class VehiculoController {

	@Autowired
	VehiculoService vehiculoService;

	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/addNewVehiculo", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addVehiculo", "veh", new Vehiculo());
	}

	@RequestMapping(value = "/addNewVehiculo", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("veh") Vehiculo veh) {

		vehiculoService.insertVehiculo(veh);
		List<Vehiculo> vehiculos = vehiculoService.getAllVehiculos();
		ModelAndView model = new ModelAndView("getVehiculos");
		model.addObject("vehiculos", vehiculos);
		return model;
	}
	
	@RequestMapping(value = "/addNewVehiculo", method = RequestMethod.POST)
	public ModelAndView processRequest2(@ModelAttribute("bit") Bitacora bit) {

		vehiculoService.insertBitacora(bit);
		List<Bitacora> bitacoras = vehiculoService.getAllVehiculos();
		ModelAndView model = new ModelAndView("getVehiculos");
		model.addObject("bitacoras", bitacoras);
		return model;
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Usuario y Contraseña Invalida.");

		if (logout != null)
			model.addAttribute("msg", "Usuario Correcto..!!");

		return "login";
	}
	
	@RequestMapping("/acercade")
	public ModelAndView acercade() {
		ModelAndView model = new ModelAndView("acercade");
		return model;
	}
	
	@RequestMapping("/getVehiculos")
	public ModelAndView getVehiculos() {
		List<Vehiculo> vehiculos = vehiculoService.getAllVehiculos();
		ModelAndView model = new ModelAndView("getVehiculos");
		model.addObject("vehiculos", vehiculos);
		return model;
	}
	
	

}
