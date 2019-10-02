package ingsoft1920.impl1.model;

public class HotelInfoModel {
	private int hotelInfoId=-1;
	private int numHabs;
	private String nombreHotel;
	
	public HotelInfoModel() {}
	
	public HotelInfoModel(int numHabs, String nombreHotel) {
		this.numHabs=numHabs;
		this.nombreHotel=nombreHotel;
	}
	
	public int getHotelInfoId() {
		return this.hotelInfoId;
	}
	
	public void setHotelInfoId(int hotelInfoId) {
		this.hotelInfoId=hotelInfoId;
	}

	public int getNumHabs() {
		return numHabs;
	}

	public void setNumHabs(int numHabs) {
		this.numHabs = numHabs;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

}
