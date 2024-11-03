import java.util.Scanner;
import java.util.ArrayList;

/*
 * Curl_Yahtzee_Game
 * 
 * This game will play yatzee with 1-6 players
 */
public class Curl_Yahtzee_Game{

    private static int minPlayer = 1;
    private static int maxPlayer = 6;
    
    /*
     * Main method
     * 
     * Runs the starting code
     * This will be the yatzee game as a whole
     */
    public static void main(String[] args) {
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        int players = 0;
        

        // have a looping mechanism that confirms they have choosen a correct ammount
        
        while(!check){
            try{
            System.out.println("How many players are there? (1-6)");
            players = scan.nextInt();
            if (players >= minPlayer && players <= maxPlayer){
            check = true;
        }
        else{
            System.out.println("Please pick a number within the range");
        }
            }catch(Exception e){
                System.out.println("Please pick a integer");
                scan.nextLine();
            }
    }
        System.out.println("There are " + players + " Player(s)!");
        scan.nextLine();


        // CHECK FOR HOW MANY DICE
        int amountOfDice;
        boolean check2 = false;
        while(!check2){
            try{
            System.out.println("How many dice do you want to play with? (5 or 6)");
            amountOfDice = scan.nextInt();
            if (amountOfDice == 5 || amountOfDice == 6){
            check2 = true;
        }
        else{
            System.out.println("Please pick a number within the range");
        }
            }catch(Exception e){
                System.out.println("Please pick a integer");
                scan.nextLine();
            }
    }



        ArrayList<Player> playerArray = new ArrayList<Player>();

        // Test constructor and beginningRoll()
        // Player p1 = new Player("Billy Bob");
        // p1.beginningRoll();



        //crated a system for creating multiple players
        // arrayLists of players
        // = new Players("name")

        //Starting rolls and naming each player
        for(int i = 0; i < players; ++i){
            System.out.println("What is the name for player " + (i+1) + "?");
            String x = scan.nextLine();
            // change this for another input?
            Player p = new Player(x);
            playerArray.add(p);
            playerArray.get(i).beginningRoll();
        }

        //Set up roll order
        for(int i = 0; i < players; ++i){
            for(int j = 0; j < i; ++j){
                if(playerArray.get(j).getBeginning() < playerArray.get(i).getBeginning()){
                    Player sw = playerArray.get(i);
                    Player sl = playerArray.get(j);
                    playerArray.remove(i);
                    playerArray.add(i,sl);
                    playerArray.remove(j);
                    playerArray.add(j,sw);
                }
            }
        }

        System.out.println("The order of play is:");
        for(int i = 0; i < playerArray.size(); ++i){
            System.out.print(playerArray.get(i).getName() + ", ");
        }
        System.out.println();

        //Start the game

        for(int i = 0; i < 13; ++i){
            for(int j = 0; j < players; ++j){
                boolean endTurn = false;
                boolean endFirstRoll = false;
                boolean endSecondRoll = false;


                // roll once
                // rollAllDice()

                // turn 1
                System.out.println("It is " + playerArray.get(j).getName() + "\'s turn, Round " + (i+1));
                System.out.print("Your roll is = ");
                playerArray.get(j).rollAllDice();
                playerArray.get(j).printDice();
                System.out.println("Would you like to keep,roll again, or insert into a category? \n(r for roll, k for keep, and i for inserting into category)");
                while(!endFirstRoll){
                    String in = scan.next();
                    if(in.equals("r")){
                        // move to second round
                        endFirstRoll = true;
                    }
                    else if(in.equals("k")){
                        //choose dice to keep/unkeep
                        playerArray.get(j).printDiceKeep();
                        System.out.println("Which dice would you like to keep? (1-5)");
                        try{
                        int y = scan.nextInt();
                        y = y - 1;
                            if(playerArray.get(j).getDiceSpot(y).showKeep() ){
                                playerArray.get(j).getDiceSpot(y).unkeepDice();
                            }
                            else{
                                playerArray.get(j).getDiceSpot(y).keepDice();
                            }
                        }catch(Exception e){
                            System.out.println("Please pick a integer from (1-5)");
                            scan.nextLine();
                        }
                        System.out.println("Would you like to keep,roll again, or insert into a category? \n(r for roll, k for keep, and i for inserting into category)");
                    }
                    else if(in.equals("i")){
                        // print categories
                        // ask for which to fill
                        System.out.println("What category would you like to put it in?");
                        System.out.print("[1] Aces: ");
                        if(playerArray.get(j).getc1()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[2] Doubles: ");
                        if(playerArray.get(j).getc2()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[3] Tripples: ");
                        if(playerArray.get(j).getc3()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[4] Quads: ");
                        if(playerArray.get(j).getc4()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[5] Fives: ");
                        if(playerArray.get(j).getc5()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[6] Sixes: ");
                        if(playerArray.get(j).getc6()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[7] Three of a kind: ");
                        if(playerArray.get(j).getc7()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[8] Four of a kind: ");
                        if(playerArray.get(j).getc8()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[9] Full House: ");
                        if(playerArray.get(j).getc9()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[10] Small Straight: ");
                        if(playerArray.get(j).getc10()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[11] Large Straight: ");
                        if(playerArray.get(j).getc11()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[12] YAHTZEE: ");
                        if(playerArray.get(j).getc12()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }
                        System.out.print("[13] Chance: ");
                        if(playerArray.get(j).getc13()){
                            System.out.println("[*]");
                        }
                        else{
                            System.out.println("[]");
                        }

                        boolean czech = false;
                        int exp;
                        while(!czech){
                            try{
                                System.out.println("What category would you like to insert your roll into?");
                                exp = scan.nextInt();
                                if(playerArray.get(j).insert(exp)){
                                czech = true;
                                }
                            }catch(Exception e){
                                System.out.println("Please choose a number (1-13)");
                                scan.nextLine();
                            }
                        }
                        endTurn = true;
                        endFirstRoll = true;
                    }
                    else{
                        System.out.println("Please try again \nr for roll, k for keep, and i for inserting into category");
                    }
                }

                // check if want another roll
                // if so roll twice

                // turn 2
                if(!endTurn){
                    

                    //rollSomeDice
                    System.out.print("Your second roll is = ");
                    playerArray.get(j).rollSomeDice();
                    playerArray.get(j).printDice();
                    System.out.println("Would you like to keep,roll again, or insert into a category? \n(r for roll, k for keep, and i for inserting into category)");
                    
                    while(!endSecondRoll){
                        String in = scan.next();
                        if(in.equals("r")){
                            // check for keep
                            // move to second round
                            endSecondRoll = true;
                        }
                        else if(in.equals("k")){
                            //choose dice to keep/unkeep
                            playerArray.get(j).printDiceKeep();
                            System.out.println("Which dice would you like to keep? (1-5)");
                            try{
                            int y = scan.nextInt();
                            y = y - 1;
                                if(playerArray.get(j).getDiceSpot(y).showKeep() ){
                                    playerArray.get(j).getDiceSpot(y).unkeepDice();
                                }
                                else{
                                    playerArray.get(j).getDiceSpot(y).keepDice();
                                }
                            }catch(Exception e){
                                System.out.println("Please pick a integer from (1-5)");
                                scan.nextLine();
                            }
                            System.out.println("Would you like to keep,roll again, or insert into a category? \n(r for roll, k for keep, and i for inserting into category)");
                        }
                        else if(in.equals("i")){
                            // print categories
                            // ask for which to fill
                            System.out.println("What category would you like to put it in?");
                            System.out.print("[1] Aces: ");
                            if(playerArray.get(j).getc1()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[2] Doubles: ");
                            if(playerArray.get(j).getc2()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[3] Tripples: ");
                            if(playerArray.get(j).getc3()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[4] Quads: ");
                            if(playerArray.get(j).getc4()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[5] Fives: ");
                            if(playerArray.get(j).getc5()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[6] Sixes: ");
                            if(playerArray.get(j).getc6()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[7] Three of a kind: ");
                            if(playerArray.get(j).getc7()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[8] Four of a kind: ");
                            if(playerArray.get(j).getc8()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[9] Full House: ");
                            if(playerArray.get(j).getc9()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[10] Small Straight: ");
                            if(playerArray.get(j).getc10()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[11] Large Straight: ");
                            if(playerArray.get(j).getc11()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[12] YAHTZEE: ");
                            if(playerArray.get(j).getc12()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }
                            System.out.print("[13] Chance: ");
                            if(playerArray.get(j).getc13()){
                                System.out.println("[*]");
                            }
                            else{
                                System.out.println("[]");
                            }

                            boolean czech = false;
                            int exp;
                            while(!czech){
                                try{
                                    System.out.println("What category would you like to insert your roll into?");
                                    exp = scan.nextInt();
                                    if(playerArray.get(j).insert(exp)){
                                    czech = true;
                                    }
                                }catch(Exception e){
                                    System.out.println("Please choose a number (1-13)");
                                    scan.nextLine();
                                }
                            }
                            endTurn = true;
                            endSecondRoll = true;
                        }
                        else{
                            System.out.println("Please try again \ny for keep/roll, i for inserting into category");
                        }
                    }
                }

                // another check if want another roll
                // if so roll three times

                // turn 3
                if(!endTurn){
                    //rollSomeDice
                    System.out.print("Your third roll is = ");
                    playerArray.get(j).rollSomeDice();
                    playerArray.get(j).printDice();
                    System.out.println("What category would you like to put it in?");
                    System.out.print("[1] Aces: ");
                    if(playerArray.get(j).getc1()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[2] Doubles: ");
                    if(playerArray.get(j).getc2()){
                        System.out.println("[*]");
                    }
                     else{
                        System.out.println("[]");
                    }
                    System.out.print("[3] Tripples: ");
                    if(playerArray.get(j).getc3()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[4] Quads: ");
                    if(playerArray.get(j).getc4()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[5] Fives: ");
                    if(playerArray.get(j).getc5()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[6] Sixes: ");
                    if(playerArray.get(j).getc6()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[7] Three of a kind: ");
                    if(playerArray.get(j).getc7()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[8] Four of a kind: ");
                    if(playerArray.get(j).getc8()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[9] Full House: ");
                    if(playerArray.get(j).getc9()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[10] Small Straight: ");
                    if(playerArray.get(j).getc10()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[11] Large Straight: ");
                    if(playerArray.get(j).getc11()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[12] YAHTZEE: ");
                    if(playerArray.get(j).getc12()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }
                    System.out.print("[13] Chance: ");
                    if(playerArray.get(j).getc13()){
                        System.out.println("[*]");
                    }
                    else{
                        System.out.println("[]");
                    }

                    boolean czech = false;
                    int exp;
                    while(!czech){
                        try{
                            System.out.println("What category would you like to insert your roll into?");
                            exp = scan.nextInt();
                            if(playerArray.get(j).insert(exp)){
                            czech = true;
                            }
                        }catch(Exception e){
                            System.out.println("Please choose a number (1-13)");
                            scan.nextLine();
                        }
                    }
                }

                // once done, put into catigory
                // repeat
            }
        }


        //print points from end of game

        System.out.println("End of Game!");
        for(int i = 0; i < playerArray.size(); ++i){
            System.out.println(playerArray.get(i).getName() + " had " + playerArray.get(i).allPoints() + " points!");
        }

        //Testing Dice class
        // Dice d1 = new Dice();
        // System.out.println(d1.showKeep());
        // System.out.println(d1.diceNumber());
        // d1.rollDice();
        // System.out.println(d1.diceNumber());

        scan.close();
        
    }


    // create player class and intake stuff
}