
public class Animal {
	public static void main(String[] args) {
	}

}

abstract class Mammal extends Animal{
	abstract String bark();
	abstract String getFood();
}
abstract class Reptile extends Animal{
	abstract String getFood();
}

final class Cat extends Mammal{
	
	String name;
	float weight;
	String nameSlave;
	
	Cat(String a, float b, String c){
		this.name=a;
		this.weight=b;
		this.nameSlave=c;
	}
	
	String getName() {
		return this.name;
	}
	
	void setName(String a) {
		this.name=a;
	}
	
	float getWeight() {
		return this.weight;
	}
	
	void setWeight(float a) {
		this.weight=a;
	}
	
	String getNameSlave() {
		return this.nameSlave;
	}
	
	void setNameSlave(String a) {
		this.nameSlave=a;
	}
	
	String bark() {
		System.out.println("Meow");
		return "Meow";
	}	
	
	String getFood() {
		System.out.println("Fish");
		return "Fish";
	}
	
}

final class Dog extends Mammal{
	String name;
	float weight;
	String nameMaster;
	
	Dog(String a, float b, String c){
		this.name=a;
		this.weight=b;
		this.nameMaster=c;
	}
	
	String getName() {
		return this.name;
	}
	
	void setName(String a) {
		this.name=a;
	}
	
	float getWeight() {
		return this.weight;
	}
	
	void setWeight(float a) {
		this.weight=a;
	}
	
	String getNameMaster() {
		return this.nameMaster;
	}
	
	void setNameMaster(String a) {
		this.nameMaster=a;
	}
	String bark() {
		System.out.println("Bowbow");
		return "Bowbow";
	}
	
	String getFood() {
		System.out.println("Apple");
		return "Apple";
	}
}

final class Crocodile extends Reptile{
	String name;
	float weight;

	Crocodile(String a, float b){
		this.name=a;
		this.weight=b;
	}
	
	String getName() {
		return this.name;
	}
	
	void setName(String a) {
		this.name=a;
	}
	
	float getWeight() {
		return this.weight;
	}
	
	void setWeight(float a) {
		this.weight=a;
	}
	
	String getFood(){
		System.out.println("Meat");
		return "Meat";
	}
}

