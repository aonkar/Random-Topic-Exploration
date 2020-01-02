package designpatterns.creational.prototype;

import java.io.Serializable;

public class SerializableClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String emailId;
	private String company;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	protected Object readResolve() {
		return this;
	}

	@Override
	public String toString() {
		return "SerializableClass [name=" + name + ", emailId=" + emailId + ", company=" + company + "]";
	}

}
