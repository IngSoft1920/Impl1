package ingsoft1920.impl1.interfaces;

import java.util.Date;

public abstract class ReservaAC {
	private int idReserva=-1;
	private int idUsuario;
	private Date dateReserva;
	private int idHotel;
	private int numHabs;
	
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Date getDateReserva() {
		return dateReserva;
	}
	public void setDateReserva(Date dateReserva) {
		this.dateReserva = dateReserva;
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
	
	public abstract ClienteAC getDatosCliente();
}
