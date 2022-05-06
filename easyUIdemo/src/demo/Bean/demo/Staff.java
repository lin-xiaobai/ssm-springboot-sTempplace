package demo.Bean.demo;
/**公司职员类*/
public class Staff {
	String name;
	int age;double salary;
	public String toString() {
		return "<"+name+"-"+age+"-"+salary+">";
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
