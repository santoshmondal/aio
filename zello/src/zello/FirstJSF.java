package zello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bean1")
@RequestScoped
public class FirstJSF {
	private String name;
	private String id;
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		if(this.message == null) {
			this.message = "HELLO BEAN!!";
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		
		
	}

}
