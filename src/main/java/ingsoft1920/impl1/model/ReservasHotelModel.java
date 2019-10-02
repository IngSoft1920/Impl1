package ingsoft1920.impl1.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservasHotelModel {
	private HotelInfoModel hotelInfo;
	private Map<Date, Integer> habsDisponibles;
	private Map<Date, List<ReservaModel>> reservas;
	
	public ReservasHotelModel() {}
	
	public ReservasHotelModel(HotelInfoModel hotelInfoModel) {
		this.hotelInfo = hotelInfoModel;
		this.habsDisponibles=new HashMap<Date, Integer>();
	}
	
	public HotelInfoModel getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfoModel hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public Map<Date, Integer> getHabsDisponibles() {
		return habsDisponibles;
	}

	public void setHabsDisponibles(Map<Date, Integer> habsDisponibles) {
		this.habsDisponibles = habsDisponibles;
	}

	public Map<Date, List<ReservaModel>> getReservas() {
		return reservas;
	}

	public void setReservas(Map<Date, List<ReservaModel>> reservas) {
		this.reservas = reservas;
	}

	public int getHabsDisponibles(Date dia) {
		if(!habsDisponibles.containsKey(dia)){
			this.habsDisponibles.put(dia, this.hotelInfo.getNumHabs());			
		}
		return this.habsDisponibles.get(dia);
	}
	
	public boolean reservaHabitacion(ReservaModel reserva) {
		int num=reserva.getNumHabs();
		Date dia=reserva.getDateReserva();
		if(getHabsDisponibles(dia)>=num) {
			this.habsDisponibles.put(dia, this.habsDisponibles.get(dia)-num);
			this.reservas.get(dia).add(reserva);
			
			return true;
		}else {
			return false;
		}
	}
}
