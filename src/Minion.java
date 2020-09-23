/**
 * Class for holding Minion Information.
 * Creates and hold minion information of name, height, and number of evil deed(s) completed
 * Also can increment an number of evil deed, and toString() method for main application to run debug dump process
 */
public class Minion {
    private String name = null;
    private double height = 0.0;
    private int numEvilDeeds = 0;
    Minion (String name){
        this.name = name;
    }
    Minion (double height){
            this.height = height;
    }
    Minion (int numEvilDeeds){
        this.numEvilDeeds = numEvilDeeds;
    }

    public String getName() {
        return this.name = name;
    }
    public double getHeight(){
        return this.height = height;
    }
    public int getNumEvilDeeds(){
        return this.numEvilDeeds = numEvilDeeds;
    }
    public int incrementEvilDeed(){
        return this.numEvilDeeds++;
    }
    @Override
    public String toString(){
        return getClass().getName() + "Minion[Name: " + name + ", Evil Deeds: " + numEvilDeeds
                + ", Height: " + height + "]";
    }
}
