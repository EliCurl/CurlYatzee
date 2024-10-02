import java.util.Random;

public class Dice {
    
    int number;
    boolean keep;
    Random rand = new Random();

    public Dice(){
        number = -1;
        keep = false;
    }

    public void rollDice(){
        if(!keep){
            number = roll();
        }
    }

    public void keepDice(){
        keep = true;
    }

    public void unkeepDice(){
        keep = false;
    }

    public boolean showKeep(){
        return keep;
    }

    public int diceNumber(){
        return number;
    }

    public String print(){
        return "" + number;
    }

    /*
     * Roll()
     * Returns an int
     * This code rolls from 1-6 with a random number
     */
    private int roll(){
        int number = 0;
        number = rand.nextInt(6) + 1;
        return number;
        }
}
