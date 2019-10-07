package ingsoft1920.impl1.interfaces;

public abstract class ClienteAC {
	int idUsuario;
	
	public ClienteAC(int idUsuario) {
		this.idUsuario=idUsuario;
	}
	
	public int getIdUsuario() {
		return this.idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario=idUsuario;
	}
}
