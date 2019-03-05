public class Family {
	private Person[] familyMembers;
	private Pet[] familyPets;
	private int buget;
	private int indexFamily = 0;
	private int indexPet = 0;
	private int familySize = 0;
	private int petsSize=0;

	//initializes fields needed
	public Family(int humans, int pets) {
		this.familySize = humans;
		this.petsSize = pets;
		familyMembers = new Person[familySize];
		familyPets = new Pet[petsSize];
	}
	
	public Person[] getPeople() {
		//TODO: Implement me!
		return familyMembers;
	}
	
	public Pet[] getPets() {
		//TODO: Implement me!
		return familyPets;
	}
	
	public int getBudget() {
		//TODO: Implement me!
		return buget;
	}
	
	public int numberOfPeople() {
		//TODO: Implement me!
		return familySize;
	}
	
	public int numberOfPets() {
		//TODO: Implement me!
		return petsSize;
	}
	// increments adds family member and increments position
	public boolean addMember(Person p) {
		if (indexFamily<=familySize){
			familyMembers[indexFamily] = p;
			buget+=p.salary;
			indexFamily++;
			return true;
		}
		return false;
	}
	// adds pet and increments in array
	public boolean addPet(Pet p) {
		if (indexPet<=petsSize){
			familyPets[indexPet] = p;
			indexPet++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		String toReturn = "";
		for (Person p : familyMembers) {
			if (p!=null) {
				toReturn += p.toString()+"\n";
			}
		}
		for (Pet p : familyPets) {
			if (p!=null) {
				toReturn += p.toString() + "\n";
			}
		}
		return toReturn;
	}
}
