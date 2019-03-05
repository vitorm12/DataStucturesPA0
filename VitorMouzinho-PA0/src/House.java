public class House {
	private int rooms;
	private int price;
	private boolean petsAllowed;
	private boolean hasBeenAssigned = true; //allows to keep track and see if house
	//has been already assigned

	//constructor
	public House(int rooms, int price, boolean petsAllowed) {
		this.rooms = rooms;
		this.price = price;
		this.petsAllowed = petsAllowed;
	}

	public boolean isHasBeenAssigned() {return hasBeenAssigned;}

	public int getRooms() {
		return rooms;
	}
	
	public int getPrice() {
		return price;
	}
	
	public boolean petsAllowed() {
		return petsAllowed;
	}

	public void setHasBeenAssigned(boolean hasBeenAssigned) {this.hasBeenAssigned = hasBeenAssigned;}

	public String toString() {
		return (rooms + ", " + price + ", " + petsAllowed + "\n");
	}
}
