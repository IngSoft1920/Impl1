package ingsoft1920.impl1.beans;

import java.util.Date;

public class NewReservaBean {
	private int idUsuario;
	private String sdateReserva;
	private int idHotel;
	private int numHabs;
	private int idTarifa;
	
	public NewReservaBean() {}
	
	public NewReservaBean(int idUsuario, Date dateReserva, int idHotel, int numHabs, int idTarifa) {
		this.idHotel=idHotel;
		this.idUsuario=idUsuario;
		this.numHabs=numHabs;
		this.idTarifa=idTarifa;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getNumHabs() {
		return numHabs;
	}

	public void setNumHabs(int numHabs) {
		this.numHabs = numHabs;
	}

	public int getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}
	
	public String getsdateReserva() {
		return sdateReserva;
	}

	public void setsdateReserva(String sdateReserva) {
		this.sdateReserva = sdateReserva;
	}
}
