package classWork;

public class Main {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		Animal animal1 = new Animal("Lion", "Cat", 10);
		Animal animal2 = new Animal("Tiger", "Cat", 8);
		Animal animal3 = new Animal("Snake", "Reptile", 5);
		
		zoo.addAnimal(animal1);
		zoo.addAnimal(animal2);
		zoo.addAnimal(animal3);
		
		zoo.getAnimalByAge().toString();
		zoo.getAnimalBySpecies("Cat").forEach(a -> System.out.println(a));
		zoo.removeAnimal("Lion");
		
		
	}

}
