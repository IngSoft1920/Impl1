package ingsoft1920.impl1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.impl1.model.HotelInfoModel;
import ingsoft1920.impl1.services.MySQLService;

public class HotelInfoDAO {
	public static HotelInfoModel save(HotelInfoModel hotelInfoModel) {
		String query = "INSERT INTO t_hotelInfo (numHabs, nombreHotel) "+
				"VALUES (?,?)";

		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, hotelInfoModel.getNumHabs());
			ps.setString(2, hotelInfoModel.getNombreHotel());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()){
				return getByHotelInfoId(rs.getInt(1));
			}else{
				return null;
			}
		} catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}
	
	public static HotelInfoModel getByHotelInfoId(int idHotelInfo) {
		String query= "SELECT * FROM t_hotelInfo WHERE hotelInfoId=?";
		
		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idHotelInfo);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				HotelInfoModel model = new HotelInfoModel();
				model.setHotelInfoId(rs.getInt("hotelInfoId"));
				model.setNumHabs(rs.getInt("numHabs"));
				model.setNombreHotel(rs.getString("nombreHotel"));
				return model;
			}else {
				return null;
			}		
		}catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}

	public static List<Integer> getAllIds() {
		List<Integer> result = new ArrayList<Integer>();
		
		String query = "SELECT hotelInfoId FROM t_hotelInfo";
		try (Connection con = (new MySQLService()).getConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.add(rs.getInt("hotelInfoId"));
			}
			return result;
		}catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			return null;
		}
	}

}
