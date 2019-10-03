package ingsoft1920.impl1.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import ingsoft1920.impl1.DAO.ReservasHotelDAO;
import ingsoft1920.impl1.model.ReservaModel;
import ingsoft1920.impl1.model.ReservasHotelModel;

@Component
public class ReservasManagerService {
	private Map<Integer,ReservasHotelModel> reservasHotel;
	
	
	public ReservasManagerService() {
		this.reservasHotel=new HashMap<Integer, ReservasHotelModel>();
		
		List<ReservasHotelModel> lista = ReservasHotelDAO.getAll();
		for(ReservasHotelModel model : lista) {
			reservasHotel.put(model.getHotelInfo().getHotelInfoId(), model);
		}
	}
	
	public void hacerReserva(ReservaModel reservaModel) throws Exception{
		if(this.reservasHotel.containsKey(reservaModel.getIdHotel())) {
			this.reservasHotel.get(reservaModel.getIdHotel()).reservaHabitacion(reservaModel);
		}else {
			throw new Exception("HotelId no existe");
		}
	}
	
	private void populateData() {
		this.reservasHotel.put(0, new ReservasHotelModel());
		//Placeholder data
		
		//Traer de bbdd todos datos guardados
	}
}
