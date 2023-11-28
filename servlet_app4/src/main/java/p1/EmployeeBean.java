package p1;
import java.io.*;
@SuppressWarnings("serial")
public class EmployeeBean implements Serializable
{
	private String id,name,desg;
	private int bsal;
	private float totsal;
	public EmployeeBean() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;	
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public int getBsal() {
		return bsal;
	}
	public void setBsal(int bsal) {
		this.bsal = bsal;
	}
	public float getTotsal() {
		return totsal;
	}
	public void setTotsal(float totsal) {
		this.totsal = totsal;
	}
	
}