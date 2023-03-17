package ReceptionistLibs;

public class CheckInLibs {
	int bookingID,customerID,roomNumber, tmpRoomNumber;
	String fName,lName,email,address,arrivalDate,departureDate,roomType,status,cardDetails;
	
	public CheckInLibs() {
		this.bookingID = 0;
		this.customerID = 0;
		this.roomNumber = 0;
		this.fName = "";
		this.lName = "";
		this.email = "";
		this.address = "";
		this.arrivalDate = "";
		this.departureDate = "";
		this.roomType = "";
		this.status = "";
		this.cardDetails = "";
		this.tmpRoomNumber = 0;
	}
	
	public CheckInLibs(int bookingID, int customerID, int roomNumber, String fName, String lName, String email,
			String address, String arrivalDate, String departureDate, String roomType, String status,
			String cardDetails) {
		this.bookingID = bookingID;
		this.customerID = customerID;
		this.roomNumber = roomNumber;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.address = address;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.roomType = roomType;
		this.status = status;
		this.cardDetails = cardDetails;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}

	public int getTmpRoomNumber() {
		return tmpRoomNumber;
	}

	public void setTmpRoomNumber(int tmpRoomNumber) {
		this.tmpRoomNumber = tmpRoomNumber;
	}

	@Override
	public String toString() {
		return "CheckInLibs [bookingID=" + bookingID + ", customerID=" + customerID + ", roomNumber=" + roomNumber
				+ ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", address=" + address
				+ ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", roomType=" + roomType
				+ ", status=" + status + ", cardDetails=" + cardDetails + "]";
	}
	
	
}
