package ReceptionistLibs;

public class ReceptionistLibs {
	int bookingID, customerID, roomNumber;
	String  firstName, lastName, email, address, creditCard, checkIn, checkOut, roomType, status;

	public ReceptionistLibs() {
		this.bookingID = 0;
		this.customerID = 0;
		this.roomNumber = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.address = "";
		this.creditCard = "";
		this.checkIn = "";
		this.checkOut = "";
		this.roomType = "";
		this.status = "";
	}

	public ReceptionistLibs(int bookingID, int customerID, int roomNumber, String firstName,
			String lastName, String email, String address, String creditCard, String checkIn, String checkOut,
			String roomType, String status) {
		this.bookingID = bookingID;
		this.customerID = customerID;
		this.roomNumber = roomNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.creditCard = creditCard;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomType = roomType;
		this.status = status;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
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

	@Override
	public String toString() {
		return "ReceptionistLibs [bookingID=" + bookingID + ", customerID=" + customerID + ", roomNumber=" + roomNumber
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + ", creditCard=" + creditCard + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + ", roomType=" + roomType + ", status=" + status + "]";
	}

}
