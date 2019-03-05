import java.io.*;
import java.util.*;

public class Main {
    public static Family[] f;
    public static House[] h;
    public static int[][] assignment;

    public static void main(String[] args) throws FileNotFoundException {
        //TODO: Implement me!
        Scanner familyUnits = new Scanner(new FileInputStream(new File("familyUnits.txt")));
        Scanner housingUnits= new Scanner(new FileInputStream(new File("housingUnits.txt")));
        createFamily(familyUnits);
        createHomes(housingUnits);
        assignFamilyToHome();
        System.out.println(displayAssignment()); //Do not modify this line!
    }
    // while loop to read in file to family
    public static void createFamily(Scanner s) {
        int index = 0;
        f = new Family[s.nextInt()]; //Do not modify this line!
        int familyIndex = 0;
        while (s.hasNextLine() && familyIndex < f.length){
            s.nextLine();
            f[index] = new Family(s.nextInt(), s.nextInt());
            s.nextLine();
            for (int i=0;i<f[index].numberOfPeople();i++){
                f[index].addMember(convertStringToPersonObj(s.nextLine()));
                // converts line to obj then adds member
            }

            for (int i=0;i<f[index].numberOfPets();i++){
                f[index].addPet(convertStringToPetObj(s.nextLine()));
                // converts line to obj then adds member
            }
            index++; // increments position
            familyIndex++;
        }
    }
    // converts String line into an object
    public static Person convertStringToPersonObj(String personInfo) {
        String[] splitInfo = personInfo.split(" ");
        return new Person(splitInfo[0], Integer.parseInt(splitInfo[1]), Integer.parseInt(splitInfo[2]));
    }
    // converts String line into an object
    public static Pet convertStringToPetObj(String petInfo) {
        String[] splitInfo = petInfo.split(" ");
        return new Pet(splitInfo[1],splitInfo[0], Integer.parseInt(splitInfo[2]));
    }

    // reads in text file to house array
    public static void createHomes(Scanner s) {
        h = new House[s.nextInt()]; //Do not modify this line!
        int index = 0 ;
        while (s.hasNextLine() && index<h.length){
            s.nextLine();
            h[index] = new House(s.nextInt(),s.nextInt(),s.nextBoolean());
            index++;
        }
    }
    // assigns
    public static void assignFamilyToHome() {
        assignment = new int[2][f.length]; //Do not modify this line!
       for (int i=0;i<f.length;i++){
           assignment[1][i] = findPostion(f[i]);
           assignment[0][i] = i;
       }
    }
    // finds the index of house where it meets family requirements
    public static int findPostion(Family familyIndex){
        for (int i=0; i < h.length ;i++){
            if (h[i].isHasBeenAssigned()){
                if (h[i].getPrice() <= familyIndex.getBudget()){
                    if (h[i].getRooms()>=familyIndex.numberOfPeople()){
                        if (familyIndex.getPets().length ==0 ){
                            h[i].setHasBeenAssigned(false);
                            return i;
                        } else if (familyIndex.getPets().length>0&&h[i].petsAllowed()){
                            h[i].setHasBeenAssigned(false);
                            return i;
                        }
                    }
                }

            }

        }
        return h.length;
    }


    public static String displayAssignment() {
        String toReturn = "";
		int unassigned = 0;
		for (int i:assignment[1]) {
			if (i==h.length) {
				unassigned++;
			}
		}
		toReturn += f.length-unassigned + " families assigned" + "\n" + unassigned + " families unassigned\n\n";
		for (int i = 0 ; i<assignment[0].length; i++) {
			if (assignment[1][i]>=h.length) {
				toReturn += "Family:\n"+f[assignment[0][i]].toString() + "NOT ASSIGNED TO HOME\n\n";
			}else {
				toReturn += "Family:\n"+f[assignment[0][i]].toString() + "Home:\n"+h[assignment[1][i]].toString()+"\n";
			}
		}
		return toReturn;
    }
}

