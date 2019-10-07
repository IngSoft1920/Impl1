package ingsoft1920.impl1.model;

import ingsoft1920.impl1.interfaces.ClienteAC;

public class UsuarioModel extends ClienteAC {
	private String nombreUsuario;
	private String hashPassword;
	private String saltString;
	
	public UsuarioModel(int idUsuario) {
		super(idUsuario);
	}
}
