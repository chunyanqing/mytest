package day08;

import java.io.Serializable;

public class User implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;
	
	private String pwd;
	
	private Integer age;
	
	private String hobby;
	
	private String info;
	
	private String sex;
	
	
	public String getSomeProp()
	{
		return "aaaaa";
	}
	
	public void setHobby(String[] hbs)
	{
		StringBuffer buffer = new StringBuffer();
		for (String h : hbs) {
			buffer.append(h + ",");
		}
		buffer.deleteCharAt(buffer.length()-1);
		this.hobby = buffer.toString();
	}
	
	public User()
	{
	}

	public User(Integer id, String name, String pwd, 
		Integer age, String hobby,
			String info, String sex)
	{
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.hobby = hobby;
		this.info = info;
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
