package ingsoft1920.impl1.model;

import java.util.Calendar;
import java.util.Date;

import ingsoft1920.impl1.beans.NewReservaBean;
import ingsoft1920.impl1.interfaces.ReservaAC;

public class ReservaModel extends ReservaAC {

	private int idReserva=-1;
	private int idUsuario;
	private Date dateReserva;
	private int idHotel;
	private int numHabs;
	private int idTarifa;
	
	public ReservaModel() {}
	
	public ReservaModel(NewReservaBean newReserva) {
		this.idHotel=newReserva.getIdHotel();
		this.idUsuario=newReserva.getIdUsuario();
		String[] parts = newReserva.getsdateReserva().split("-");
		if(parts.length==3) {
			Calendar c=Calendar.getInstance();
			c.set(Integer.parseInt(parts[2]),
					Integer.parseInt(parts[1]),Integer.parseInt(parts[0]));
			this.dateReserva=c.getTime();
		}
		this.numHabs=newReserva.getNumHabs();
		this.idTarifa=newReserva.getIdTarifa();		
	}
	
	public ReservaModel(int idUsuario, Date dateReserva, int idHotel, int numHabs, int idTarifa) {
		this.idHotel=idHotel;
		this.idUsuario=idUsuario;
		this.dateReserva=dateReserva;
		this.numHabs=numHabs;
		this.idTarifa=idTarifa;
	}

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

	public int getIdTarifa() {
		return idTarifa;
	}

	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}

	public boolean checkValidData() {
		//TODO
		return true;		
	}

	@Override
	public UsuarioModel getDatosCliente() {
		UsuarioModel m = new UsuarioModel(0);
		m.getIdUsuario();
		return m;
	}
}
