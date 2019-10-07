package ingsoft1920.impl1.PMS1.model;

import ingsoft1920.impl1.interfaces.ReservaAC;

public class ReservaPMSModel extends ReservaAC{

	@Override
	public ClienteModel getDatosCliente() {
		return new ClienteModel(0);
	}

}
