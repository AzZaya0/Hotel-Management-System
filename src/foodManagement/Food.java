package foodManagement;

public class Food {
	int id;
	String name;
	double rate;
	
	public Food() {
		this.id = 0;
		this.name = "";
		this.rate = 0;
	}
	
	public Food(int id, String name, double rate) {
		this.id = id;
		this.name = name;
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", rate=" + rate + "]";
	}
	
	
}
