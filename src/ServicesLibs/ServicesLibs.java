package ServicesLibs;

public class ServicesLibs {
	int roomNumber, quantity, bookingId, serviceId;
	String date, customerName, checkInDate, serviceType, services;
	double price;

	public ServicesLibs() {
		this.roomNumber = 0;
		this.quantity = 0;
		this.bookingId = 0;
		this.serviceId = 0;
		this.date = "";
		this.customerName = "";
		this.checkInDate = "";
		this.serviceType = "";
		this.services = "";
		this.price = 0.0;
	}

	public ServicesLibs(int roomNumber, int quantity, int bookingId, int serviceId, String date, String customerName,
			String checkInDate, String serviceType, String services, double price) {
		this.roomNumber = roomNumber;
		this.quantity = quantity;
		this.bookingId = bookingId;
		this.serviceId = serviceId;
		this.date = date;
		this.customerName = customerName;
		this.checkInDate = checkInDate;
		this.serviceType = serviceType;
		this.services = services;
		this.price = price;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ServicesLibs [roomNumber=" + roomNumber + ", quantity=" + quantity + ", bookingId=" + bookingId
				+ ", serviceId=" + serviceId + ", date=" + date + ", customerName=" + customerName + ", checkInDate="
				+ checkInDate + ", serviceType=" + serviceType + ", services=" + services + ", price=" + price + "]";
	}

}
