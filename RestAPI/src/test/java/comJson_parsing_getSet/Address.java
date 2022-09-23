package comJson_parsing_getSet;

public class Address {
	private  String state;
	private String country;
	private ABC abc;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public ABC getabc()
	{
		return abc;
	}
	public void setabc(ABC abc)
	{
		this.abc=abc;
	}
}
