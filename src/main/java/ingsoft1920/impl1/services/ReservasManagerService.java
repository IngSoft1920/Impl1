package ingsoft1920.impl1.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import ingsoft1920.impl1.model.ReservaModel;
import ingsoft1920.impl1.model.ReservasHotel;

@Component
public class ReservasManagerService {
	private Map<Integer,ReservasHotel> reservasHotel;
	
	
	public ReservasManagerService() {
		this.reservasHotel=new HashMap<Integer, ReservasHotel>();
		
		populateData();
	}
	
	public void hacerReserva(ReservaModel reservaModel) {
		
		
		return;
	}
	
	private void populateData() {
		this.reservasHotel.put(0, new ReservasHotel());
		//Placeholder data
		
		//Traer de bbdd todos datos guardados
	}
}
