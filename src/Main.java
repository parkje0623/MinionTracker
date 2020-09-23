import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class for Main Application.
 * Uses user input for the program to create, delete, or add an evil deeds to a minions
 * Also have options to list all the existing minions and debug minion details as well.
 */
public class Main {
    private static ArrayList<Minion> nameList = new ArrayList<>();
    private static ArrayList<Minion> heightList = new ArrayList<>();
    private static ArrayList<Minion> deedsList = new ArrayList<>();
    private static boolean runApplication = true;
    private static void minionList(){
        Text listTitle = new Text();
        listTitle.minionListTitle();
        for (int i = 0; i < nameList.size(); i++){
            Minion name = nameList.get(i);
            Minion height = heightList.get(i);
            Minion deeds = deedsList.get(i);
            System.out.print("\n" + (i + 1) + ". " + name.getName() + ", " + height.getHeight() + "m, " +
                               deeds.getNumEvilDeeds() + " evil deed(s)");
        }
        if (nameList.size() == 0){
            System.out.println("\nThere are no minion(s) on the list.");
        }
    }
    private static int chooseMinion(){
        Scanner scan = new Scanner(System.in);
        boolean correctNum = false;
        int chosen = scan.nextInt();
        if (chosen == 0){
            return -1;
        }
        while (correctNum == false) {
            if (chosen < 0 || chosen > nameList.size()) {
                System.out.print("Please choose a number from the list or 0 to cancel. \n> ");
                chosen = scan.nextInt();
            } else if (chosen == 0){
                return -1;
            } else {
                correctNum = true;
            }
        }
        return chosen - 1;
    }
    private static void addMinion() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter a name: ");
        String newMinion = scan.nextLine();
        while (newMinion == "" || newMinion == null || newMinion == "\n") {
            System.out.print("Name should not be empty, Please enter a valid name: ");
            newMinion = scan.nextLine();
        }
        nameList.add(new Minion(newMinion));

        System.out.print("Enter a height: ");
        double newHeight = scan.nextDouble();
        while (newHeight < 0.0) {
            System.out.print("Should be be equal to or less than 0.0, Please enter a valid height: ");
            newHeight = scan.nextDouble();
        }
        heightList.add(new Minion(newHeight));
        deedsList.add(new Minion(0));
    }
    private static void removeMinion() {
        minionList();
        System.out.print("\n(Enter 0 to cancel)\n> ");
        int chosenMinion = chooseMinion();
        if (chosenMinion == -1){
            return;
        }
        nameList.remove(chosenMinion);
        heightList.remove(chosenMinion);
        deedsList.remove(chosenMinion);
    }
    private static void addEvilDeed(){
        minionList();
        System.out.print("\n(Enter 0 to cancel)\n> ");
        int selectedMinion = chooseMinion();
        if (selectedMinion == -1){
            return;
        }
        deedsList.get(selectedMinion).incrementEvilDeed();
        Minion name = nameList.get(selectedMinion);
        Minion deeds = deedsList.get(selectedMinion);
        System.out.println(name.getName() + " has now down " + deeds.getNumEvilDeeds() + " evil deed(s)!");
    }
    private static void dump(){
        System.out.println("All minion objects:");
        if (nameList.size() == 0){
            System.out.println("There are no minions.");
        }
        for (int i = 0; i < nameList.size(); i++){
            System.out.println(i + 1 + ". " + nameList.get(i).toString());
        }
    }
    public static void main(String[] args){
        Text display = new Text();
        display.displayTitle();
        display.displayMenu();
        while (runApplication == true){
            int option = display.selectedOption();
            if (option == 1){
                minionList();
                display.displayMenu();
            } else if (option == 2){
                addMinion();
                display.displayMenu();
            } else if (option == 3){
                removeMinion();
                display.displayMenu();
            } else if (option == 4){
                addEvilDeed();
                display.displayMenu();
            } else if (option == 5){
                dump();
                display.displayMenu();
            } else if (option == 6){
                runApplication = false;
            }
        }
    }
}
