import java.util.Scanner;
/**
 * Class for text interface.
 * Creates texts and helps main application to display needed for the Title, Main menu title, and Menu for options.
 * Also creates stars and error message for input errors.
 */
public class Text {
    private static final String TITLE = "Welcome to the Evil Minion Tracker (tm)";
    private static int starLength = TITLE.length();
    private static final String MAIN_MENU = "* Main Menu *";
    private static final String[] MENU = {"List Minions", "Add New Minions", "Remove Minions",
                                          "Attribute an Evil Deed to a Minion",
                                          "Debug Dump of Minion Details", "Exit"};
    public static void printStars(){
        for (int i = 0; i < starLength; i++){
            System.out.print("*");
        }
    }
    public static void displayTitle(){
        printStars();
        System.out.println("\n" + TITLE + "\nby Jieung Park");
        printStars();
    }
    public static void minionListTitle(){
        System.out.println("Minion List:");
        String menuTitle = "Minion List:";
        starLength = menuTitle.length();
        printStars();
    }
    public static void displayMenu(){
        starLength = MAIN_MENU.length();
        System.out.println("\n");
        printStars();
        System.out.println("\n" + MAIN_MENU);
        printStars();
        System.out.print("\n");
        for (int i = 0; i < 6; i++){
            System.out.println(i + 1 + ". "+ MENU[i]);
        }
        System.out.print("> ");
    }
    public static int selectedOption(){
        Scanner scan = new Scanner(System.in);
        int selectedNum = scan.nextInt();
        if (selectedNum < 1 || selectedNum > 6){
            System.out.println("Please choose a number between 0 and 6: ");
            selectedNum = scan.nextInt();
        }
        return selectedNum;
    }
}