public class Person {
	String name;
	int age;
	int salary;
	
	//constructor
	public Person(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	public int getSalary() {
		return this.salary;
	}
	
	public String toString() {
		return (name + ", " + age + ", " + salary);
	}
}
