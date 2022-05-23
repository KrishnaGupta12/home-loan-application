public class Member {
	
	private String Locality, House_condition, Salary, Months;

	
	public Member() {
		super();
	}

	public Member(String Locality , String House_condition, String Salary , String Months) {
		super();
		this. Locality = Locality;
		this.House_condition=House_condition ;
		this.Salary=Salary ;
		this.Months=Months;
	}

	public String getLocality() {
		return Locality;
	}

	public void setLocality(String Locality) {
		this.Locality = Locality;
	}

	public String getHouse_condition() {
		return House_condition;
	}

	public void setHouse_condition(String House_condition) {
		this.House_condition = House_condition;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String Salary) {
		this.Salary = Salary;
	}

	public String getMonths() {
		return Months;
	}

	public void setMonths(String Months) {
		this.Months = Months;
	}
	
	

}

