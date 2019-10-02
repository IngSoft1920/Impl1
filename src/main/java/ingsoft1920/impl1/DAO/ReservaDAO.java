package ingsoft1920.impl1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ingsoft1920.impl1.model.ReservaModel;
import ingsoft1920.impl1.services.MySQLService;

public class ReservaDAO {

	public static ReservaModel save(ReservaModel reservaModel) {
		String query = "INSERT INTO t_reservas (idUsuario, idHotel, idTarifa,"
				+ " numHabs) VALUES (?,?,?,?)";

		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, reservaModel.getIdUsuario());
			ps.setInt(2, reservaModel.getIdHotel());
			ps.setInt(3, reservaModel.getIdTarifa());
			ps.setInt(4, reservaModel.getNumHabs());

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return getByReservaId(rs.getInt("idReserva"));
			}else{
				return null;
			}
		} catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}
	
	
	public static ReservaModel getByReservaId(int reservaId) {
		String query = "SELECT * FROM t_reservas WHERE idReserva=?;";
		
		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, reservaId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ReservaModel res = new ReservaModel();
				res.setIdReserva(rs.getInt("idReserva"));
				res.setIdReserva(rs.getInt("idReserva"));
				res.setIdReserva(rs.getInt("idReserva"));
				res.setIdReserva(rs.getInt("idReserva"));
				res.setIdReserva(rs.getInt("idReserva"));
				return res;
			}else {
				return null;
			}
		}catch(Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}
}
