package Library;

public class Booking {
	int bookingId, regId, roomNumber;
	String arrivalDate, departureDate, roomtype, bookinStatus;

	public Booking() {
		this.bookingId = 0;
		this.regId = 0;
		this.roomNumber = 0;
		this.arrivalDate = "";
		this.departureDate = "";
		this.roomtype = "";
		this.bookinStatus = "";
	}

	public Booking(int bookingId, int regId, int roomNumber, String arrivalDate, String departureDate, String roomtype,
			String bookinStatus) {
		this.bookingId = bookingId;
		this.regId = regId;
		this.roomNumber = roomNumber;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.roomtype = roomtype;
		this.bookinStatus = bookinStatus;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getBookinStatus() {
		return bookinStatus;
	}

	public void setBookinStatus(String bookinStatus) {
		this.bookinStatus = bookinStatus;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", regId=" + regId + ", roomNumber=" + roomNumber + ", arrivalDate="
				+ arrivalDate + ", departureDate=" + departureDate + ", roomtype=" + roomtype + ", bookinStatus="
				+ bookinStatus + "]";
	}

}
