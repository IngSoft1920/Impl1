package ingsoft1920.impl1.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReservasHotel {
	private Map<Date, Integer> habsDisponibles;
	private Map<Date, List<ReservaModel>> reservas;
	
	public ReservasHotel() {}
	
	public int getHabsDisponibles(Date dia) {
		if(habsDisponibles.containsKey(dia)) {
			return this.habsDisponibles.get(dia);
		}else{
			return -1;
		}
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
