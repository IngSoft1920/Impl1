package ingsoft1920.impl1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.impl1.model.ReservaModel;
import ingsoft1920.impl1.services.MySQLService;

public class ReservaDAO {

	public static ReservaModel save(ReservaModel reservaModel) {
		if(reservaModel.getIdReserva()==-1) {
			return insertNew(reservaModel);
		}else {
			return updateExisting(reservaModel);
		}
	}
	
	public static ReservaModel getByReservaId(int reservaId) {
		String query = "SELECT * FROM t_reservas WHERE idReserva=?;";
		
		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, reservaId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ReservaModel model=new ReservaModel();
				model.setIdReserva(rs.getInt("idReserva"));
				model.setIdUsuario(rs.getInt("idUsuario"));
				model.setIdHotel(rs.getInt("idHotel"));
				model.setIdTarifa(rs.getInt("idTarifa"));
				model.setNumHabs(rs.getInt("numHabs"));
				model.setDateReserva(new Date(rs.getTimestamp("dateReserva").getTime()));
				return model;
			}else {
				return null;
			}
		}catch(Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}
	
	public static List<ReservaModel> getAll(){
		List<ReservaModel> resultado=new ArrayList<ReservaModel>();
		
		String query="SELECT * FROM t_reservas";
		
		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ReservaModel model=new ReservaModel();
				model.setIdReserva(rs.getInt("idReserva"));
				model.setIdUsuario(rs.getInt("idUsuario"));
				model.setIdHotel(rs.getInt("idHotel"));
				model.setIdTarifa(rs.getInt("idTarifa"));
				model.setNumHabs(rs.getInt("numHabs"));
				model.setDateReserva(new Date(rs.getTimestamp("dateReserva").getTime()));
				resultado.add(model);
			}
			return resultado;
		}catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}
	
	private static ReservaModel insertNew(ReservaModel reservaModel) {
		String query = "INSERT INTO t_reservas (idUsuario, idHotel, idTarifa,"
				+ " numHabs, dateReserva) VALUES (?,?,?,?,?)";

		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, reservaModel.getIdUsuario());
			ps.setInt(2, reservaModel.getIdHotel());
			ps.setInt(3, reservaModel.getIdTarifa());
			ps.setInt(4, reservaModel.getNumHabs());
			ps.setTimestamp(5, new Timestamp(reservaModel.getDateReserva().getTime()));

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
				return getByReservaId(rs.getInt(1));
			}else{
				return null;
			}
		} catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}
	
	private static ReservaModel updateExisting(ReservaModel reservaModel) {
		String query = "UPDATE t_reservas"
				+ "SET idUsuario=?,"
				+ " idHotel=?,"
				+ " idTarifa=?,"
				+ " numHabs=?,"
				+ " dateReserva=? "
				+ "WHERE idReserva=?;";

		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, reservaModel.getIdUsuario());
			ps.setInt(2, reservaModel.getIdHotel());
			ps.setInt(3, reservaModel.getIdTarifa());
			ps.setInt(4, reservaModel.getNumHabs());
			ps.setTimestamp(5, new Timestamp(reservaModel.getDateReserva().getTime()));
			ps.setInt(6, reservaModel.getIdReserva());

			ps.executeUpdate();
			int affected = ps.getUpdateCount();
			if (affected>0){
				return getByReservaId(reservaModel.getIdReserva());
			}else{
				return null;
			}
		} catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}

	public static List<ReservaModel> getByIdHotel(int idHotel) {
		List<ReservaModel> resultado=new ArrayList<ReservaModel>();
		
		String query="SELECT * FROM t_reservas WHERE idHotel=?";
		
		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idHotel);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ReservaModel model=new ReservaModel();
				model.setIdReserva(rs.getInt("idReserva"));
				model.setIdUsuario(rs.getInt("idUsuario"));
				model.setIdHotel(rs.getInt("idHotel"));
				model.setIdTarifa(rs.getInt("idTarifa"));
				model.setNumHabs(rs.getInt("numHabs"));
				model.setDateReserva(new Date(rs.getTimestamp("dateReserva").getTime()));
				resultado.add(model);
			}
			return resultado;
		}catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}
}
