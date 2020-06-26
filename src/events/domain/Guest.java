package events.domain;
import java.lang.String;
public class Guest {

	private String name;
	private String contact;
	private String status;
	
	public Guest(String name, String contact, String status)
	{
		this.name=name;
		this.contact=contact;
		this.status=status;
	}
	
	
	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
