package classWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zoo {
	
	List<Animal> list = new ArrayList<>();
	
	public void addAnimal(Animal animal) {
		list.add(animal);
	}
	
	public void removeAnimal(String name) {
		Animal animal = (Animal) list.stream().filter(a -> a.getName().equals(name));
		list.remove(animal);
	}
	
	public List<Animal> getAnimalBySpecies(String species){
		return list.stream().filter(a -> a.getSpecies().equals(species)).toList();
	}
	
	public HashMap<Integer, List<Animal>> getAnimalByAge(){
		HashMap<Integer, List<Animal>> map = new HashMap<>();
		
		for(Animal animal : list) {
			if(map.containsKey((animal).getAge())) {
				map.get(animal.getAge()).add(animal);
			}
			else {
				List<Animal> mapList = new ArrayList<>();
				mapList.add(animal);
				map.put(animal.getAge(), mapList);
			}
		}
		
		
		return map;
	}

}
