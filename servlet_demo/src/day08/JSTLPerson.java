package day08;

/**
 * JSTL核心库演示
 */
public class JSTLPerson {

	private String userName;
	
	private Integer age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return"JSTLPerson [userName=" + userName + ", age=" + age + "]";
	}
}