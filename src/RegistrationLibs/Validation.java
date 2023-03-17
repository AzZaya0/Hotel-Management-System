package RegistrationLibs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public boolean fName(String st) {
		boolean result = false;

		String regex = "^[A-Z][a-z]{2,10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	public boolean lName(String st) {
		boolean result = false;

		String regex = "^[A-Z][a-z]{2,10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	public boolean Postal(String st) {
		boolean result = false;

		String regex = "[0-9]{5}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	public boolean Gender(String st) {
		boolean result = false;
		
		if (st.equals("Male")||st.equals("Female")||st.equals("Others")) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}
	
	public boolean Phone(String st) {
		boolean result = false;
		
		String regex = "^[9]{1}[678]{1}[0-9]{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	public boolean CreditCard(String st) {
		boolean result = false;
		
		String regex = "[0-9]{4}[-]{1}[0-9]{4}[-]{1}[0-9]{4}[-]{1}[0-9]{4}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	public boolean CvcNumber(String st) {
		boolean result = false;
		
		String regex = "[0-9]{3}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}

	public boolean Email(String st) {
		boolean result = false;
		
		String regex = "^[a-z]{1}[a-z0-9_.]{5,20}[@]{1}[a-z]{5,6}[.]{1}[com]{2,3}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	public boolean UserName(String st) {
		boolean result = false;
		
		String regex = "^[a-z]{1}[a-z0-9\\_\\.]{10,20}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	
	public boolean Password(String st) {
		boolean result = false;
		
		String regex = "^[A-Z]{1}[a-z]{6,10}[0-9]{1,10}[!@#$%^*._-]{1,5}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	public boolean ConfirmPassword(String st) {
		boolean result = false;
		
		String regex = "^[A-Z]{1}[A-Za-z0-9]{6,10}[!@#$%^*._-]{1,5}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();
		
		return result;
	}
	
}