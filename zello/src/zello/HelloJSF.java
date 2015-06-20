package zello;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bean2")
@RequestScoped
public class HelloJSF {
	private String name;
	private String id;
	private String message;
	private List<String> nameList;
	private List<Student> stuList;
	
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
			this.message = "HELLO JSF!!";
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		
		
	}
	
	
	
	
	public String simpleMethod() {
		System.out.println(name);
		if(name == null) {
			this.name = "JAVA";
			this.id= "1";
		}
		
		System.out.println("HELLO!");
		return "abcd";
	}

	public List<String> getNameList() {
		if(this.nameList == null) {
			nameList = new ArrayList<String>();
			nameList.add("JAVA");
			nameList.add("JSF");
		}
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public List<Student> getStuList() {
		if(stuList == null) {
			this.stuList = new ArrayList<Student>();
			stuList.add(new Student("JAVA", "JSF1"));
			stuList.add(new Student("JAVA", "JSF2"));
			stuList.add(new Student("JAVA", "JSF3"));
			stuList.add(new Student("JAVA", "JSF4"));
			stuList.add(new Student("JAVA", "JSF5"));
		}
		
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
}
