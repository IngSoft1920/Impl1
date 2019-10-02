package ingsoft1920.impl1.DAO;

import java.util.ArrayList;
import java.util.List;

import ingsoft1920.impl1.model.HotelInfoModel;
import ingsoft1920.impl1.model.ReservaModel;
import ingsoft1920.impl1.model.ReservasHotelModel;

public class ReservasHotelDAO {
	public static List<ReservasHotelModel> getAll(){
		return new ArrayList<ReservasHotelModel>();
	}
	
	public static ReservasHotelModel getByIdHotel(int idHotel) {
		ReservasHotelModel reservasHotelModel = new ReservasHotelModel();
		
		HotelInfoModel info = HotelInfoDAO.getByHotelInfoId(idHotel);
		reservasHotelModel.setHotelInfo(info);
		
		List<ReservaModel> reservas = ReservaDAO.getByIdHotel(idHotel);
		
		for(ReservaModel res : reservas) {
			reservasHotelModel.reservaHabitacion(res);
		}
		
		return reservasHotelModel;
	}
	
	
}
