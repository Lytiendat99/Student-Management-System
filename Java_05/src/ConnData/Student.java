package ConnData;

public class Student {
	private int id;
	private String name;
	private int age, gender;
	private String adress;
	private float score;
	
	public Student() {
		
	}
	public Student(int id, String name, int age, int gender, String adress, float score) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.adress = adress;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	
	

}
