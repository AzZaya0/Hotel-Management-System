package mylibs;

public class User {
	int uid;
	String fName, lName, creditCard, email, mobile, loginName, loginPassword, role;

	public User() {
		this.uid = 0;
		this.fName = "";
		this.lName = "";
		this.creditCard = "";
		this.email = "";
		this.mobile = "";
		this.loginName = "";
		this.loginPassword = "";
		this.role = "";
	}

	public User(int uid, String fName, String lName, String creditCard, String email, String mobile, String loginName,
			String loginPassword, String role) {
		this.uid = uid;
		this.fName = fName;
		this.lName = lName;
		this.creditCard = creditCard;
		this.email = email;
		this.mobile = mobile;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.role = role;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", fName=" + fName + ", lName=" + lName + ", creditCard=" + creditCard + ", email="
				+ email + ", mobile=" + mobile + ", loginName=" + loginName + ", loginPassword=" + loginPassword
				+ ", role=" + role + "]";
	}
}
