import java.util.Random;
import java.util.ArrayList;

public class Player {
    
    Random rand = new Random();
    private boolean supercheck;
    private String name;
    private boolean c1;
    private int p1;
    private boolean c2;
    private int p2;
    private boolean c3;
    private int p3;
    private boolean c4;
    private int p4;
    private boolean c5;
    private int p5;
    private boolean c6;
    private int p6;
    private boolean c7;
    private int p7;
    private boolean c8;
    private int p8;
    private boolean c9;
    private int p9;
    private boolean c10;
    private int p10;
    private boolean c11;
    private int p11;
    private boolean c12;
    private int p12;
    private boolean c13;
    private int p13;
    private int[] startingRoll;
    private int beginRoll;
    private boolean cRealYatzee;
    private ArrayList<Dice> pDice = new ArrayList<Dice>();

    private int amountOfDice;



    // What a check and point count for each combo
    // 13 combos
    // starting roll, name?

    public Player(){
        name = "bill";
        // checks:
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;
        c9 = false;
        c10 = false;
        c11 = false;
        c12 = false;
        c13 = false;
        cRealYatzee = false;
        for(int i = 0; i < 5; ++i){
            Dice d = new Dice();
            pDice.add(d);
        }

        // assumes dice are 5
        amountOfDice = 5;
        startingRoll = new int[5];

        //attributes
    }

    public Player(String n){
        name = n;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;
        c9 = false;
        c10 = false;
        c11 = false;
        c12 = false;
        c13 = false;
        cRealYatzee = false;
        for(int i = 0; i < 5; ++i){
            Dice d = new Dice();
            pDice.add(d);
        }

        // assumes dice are 5
        amountOfDice = 5;
        startingRoll = new int[5];
    }

    // Player(Name, amountOfDice)
    public Player(String n, int dice){
        name = n;
        c1 = false;
        c2 = false;
        c3 = false;
        c4 = false;
        c5 = false;
        c6 = false;
        c7 = false;
        c8 = false;
        c9 = false;
        c10 = false;
        c11 = false;
        c12 = false;
        c13 = false;
        cRealYatzee = false;
        for(int i = 0; i < amountOfDice; ++i){
            Dice d = new Dice();
            pDice.add(d);
        }

        amountOfDice = dice;
        startingRoll = new int[dice];
    }

    public Player(Player p){
        name = p.getName();
        c1 = p.getc1();
        c2 = p.getc2();
        c3 = p.getc3();
        c4 = p.getc4();
        c5 = p.getc5();
        c6 = p.getc6();
        c7 = p.getc7();
        c8 = p.getc8();
        c9 = p.getc9();
        c10 = p.getc10();
        c11 = p.getc11();
        c12 = p.getc12();
        c13 = p.getc13();
        cRealYatzee = p.getcRealYatzee();
        beginRoll = p.getBeginning();
        for(int i = 0; i < 5; ++i){
            startingRoll[i] = p.startingRoll[i];
        }
        for(int i = 0; i < 5; ++i){
            Dice d = new Dice();
            pDice.add(d);
        }

        // assumes dice are 5
        amountOfDice = 5;
        startingRoll = new int[5];
    }


    public void rollAllDice(){
        for(int i = 0; i < pDice.size(); ++i){
            pDice.get(i).unkeepDice();
            pDice.get(i).rollDice();
        }
    }

    public void rollSomeDice(){
        for(int i = 0; i < pDice.size(); ++i){
            boolean x = pDice.get(i).showKeep();
            if(x == false){
                pDice.get(i).rollDice();
            }
        }
    }

    //insert into a category
    public boolean insert(int ins){
        supercheck = false;
        if(ins == 1 && !c1){
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 1){
                    p1++;
                }
            }
            if(cRealYatzee){
                p1 = multiYatzee();
            }
            System.out.println("You got " + p1 + " Points!");
            c1 = true;
            supercheck = true;
        }
        if(ins == 2 && !c2){
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 2){
                    p2 = p2 + 2;
                }
            }
            if(cRealYatzee){
                p2 = multiYatzee();
            }
            System.out.println("You got " + p2 + " Points!");
            c2 = true;
            supercheck = true;
        }
        if(ins == 3 && !c3){
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 3){
                    p3 = p3 + 3;
                }
            }
            if(cRealYatzee){
                p3 = multiYatzee();
            }
            System.out.println("You got " + p3 + " Points!");
            c3 = true;
            supercheck = true;
        }
        if(ins == 4 && !c4){
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 4){
                    p4 = p4 + 4;
                }
            }
            if(cRealYatzee){
                p4 = multiYatzee();
            }
            System.out.println("You got " + p4 + " Points!");
            c4 = true;
            supercheck = true;
        }
        if(ins == 5 && !c5){
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 5){
                    p5 = p5 + 5;
                }
            }
            if(cRealYatzee){
                p5 = multiYatzee();
            }
            System.out.println("You got " + p5 + " Points!");
            c5 = true;
            supercheck = true;
        }
        if(ins == 6 && !c6){
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 6){
                    p6 = p6 + 6;
                }
            }
            if(cRealYatzee){
                p6 = multiYatzee();
            }
            System.out.println("You got " + p6 + " Points!");
            c6 = true;
            supercheck = true;
        }
        if(ins == 7 && !c7){
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            int a4 = 0;
            int a5 = 0;
            int a6 = 0;
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 1){
                    a1++;
                }
                if(pDice.get(i).diceNumber() == 2){
                    a2++;
                }
                if(pDice.get(i).diceNumber() == 3){
                    a3++;
                }
                if(pDice.get(i).diceNumber() == 4){
                    a4++;
                }
                if(pDice.get(i).diceNumber() == 5){
                    a5++;
                }
                if(pDice.get(i).diceNumber() == 6){
                    a6++;
                }
            }
            if(a1 >= 3 || a2 >= 3 || a3 >= 3 || a4 >= 3 || a5 >= 3 || a6 >= 3){
                for(int i = 0; i < pDice.size(); ++i){
                    p7 = p7 + pDice.get(i).diceNumber();
                }
            }
            if(cRealYatzee){
                p7 = multiYatzee();
            }
            System.out.println("You got " + p7 + " Points!");
            c7 = true;
            supercheck = true;
        }
        if(ins == 8 && !c8){
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            int a4 = 0;
            int a5 = 0;
            int a6 = 0;
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 1){
                    a1++;
                }
                if(pDice.get(i).diceNumber() == 2){
                    a2++;
                }
                if(pDice.get(i).diceNumber() == 3){
                    a3++;
                }
                if(pDice.get(i).diceNumber() == 4){
                    a4++;
                }
                if(pDice.get(i).diceNumber() == 5){
                    a5++;
                }
                if(pDice.get(i).diceNumber() == 6){
                    a6++;
                }
            }
            if(a1 >= 4 || a2 >= 4 || a3 >= 4 || a4 >= 4 || a5 >= 4 || a6 >= 4){
                for(int i = 0; i < pDice.size(); ++i){
                    p8 = p8 + pDice.get(i).diceNumber();
                }
            }
            if(cRealYatzee){
                p8 = multiYatzee();
            }
            System.out.println("You got " + p8 + " Points!");
            c8 = true;
            supercheck = true;
        }
        if(ins == 9 && !c9){
            // full house
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            int a4 = 0;
            int a5 = 0;
            int a6 = 0;
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 1){
                    a1++;
                }
                if(pDice.get(i).diceNumber() == 2){
                    a2++;
                }
                if(pDice.get(i).diceNumber() == 3){
                    a3++;
                }
                if(pDice.get(i).diceNumber() == 4){
                    a4++;
                }
                if(pDice.get(i).diceNumber() == 5){
                    a5++;
                }
                if(pDice.get(i).diceNumber() == 6){
                    a6++;
                }
            }
            if(a1 == 3 || a2 == 3 || a3 == 3 || a4 == 3 || a5 == 3 || a6 == 3){
                if(a1 == 2 || a2 == 2 || a3 == 2 || a4 == 2 || a5 == 2 || a6 == 2){
                    p9 = 25;
                }
            }
            if(cRealYatzee){
                p9 = multiYatzee();
            }
            System.out.println("You got " + p9 + " Points!");
            c9 = true;
            supercheck = true;
        }
        if(ins == 10 && !c10){
            // small straight
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            int a4 = 0;
            int a5 = 0;
            int a6 = 0;
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 1){
                    a1++;
                }
                if(pDice.get(i).diceNumber() == 2){
                    a2++;
                }
                if(pDice.get(i).diceNumber() == 3){
                    a3++;
                }
                if(pDice.get(i).diceNumber() == 4){
                    a4++;
                }
                if(pDice.get(i).diceNumber() == 5){
                    a5++;
                }
                if(pDice.get(i).diceNumber() == 6){
                    a6++;
                }
            }
            if(a1 >= 1 && a2 >= 1 && a3 >= 1 && a4 >= 1){
                p10 = 30;
            }
            else if(a2 >= 1 && a3 >= 1 && a4 >= 1 && a5 >= 1){
                p10 = 30;
            }
            else if(a3 >= 1 && a4 >= 1 && a5 >= 1 && a6 >= 1){
                p10 = 30;
            }
            if(cRealYatzee){
                p10 = multiYatzee();
            }
            System.out.println("You got " + p10 + " Points!");
            c10 = true;
            supercheck = true;
        }
        if(ins == 11 && !c11){
            // large straight
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            int a4 = 0;
            int a5 = 0;
            int a6 = 0;
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 1){
                    a1++;
                }
                if(pDice.get(i).diceNumber() == 2){
                    a2++;
                }
                if(pDice.get(i).diceNumber() == 3){
                    a3++;
                }
                if(pDice.get(i).diceNumber() == 4){
                    a4++;
                }
                if(pDice.get(i).diceNumber() == 5){
                    a5++;
                }
                if(pDice.get(i).diceNumber() == 6){
                    a6++;
                }
            }
            if(a1 >= 1 && a2 >= 1 && a3 >= 1 && a4 >= 1){
                p11 = 40;
            }
            else if(a2 >= 1 && a3 >= 1 && a4 >= 1 && a5 >= 1){
                p11 = 40;
            }
            else if(a3 >= 1 && a4 >= 1 && a5 >= 1 && a6 >= 1){
                p11 = 40;
            }
            if(cRealYatzee){
                p11 = multiYatzee();
            }
            System.out.println("You got " + p11 + " Points!");
            c11 = true;
            supercheck = true;
        }
        if(ins == 12 && !c12){
            // yatzee
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            int a4 = 0;
            int a5 = 0;
            int a6 = 0;
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 1){
                    a1++;
                }
                if(pDice.get(i).diceNumber() == 2){
                    a2++;
                }
                if(pDice.get(i).diceNumber() == 3){
                    a3++;
                }
                if(pDice.get(i).diceNumber() == 4){
                    a4++;
                }
                if(pDice.get(i).diceNumber() == 5){
                    a5++;
                }
                if(pDice.get(i).diceNumber() == 6){
                    a6++;
                }
            }
            if(a1 == 5){
                p12 = 50;
                cRealYatzee = true;
            }
            if(a2 == 5){
                p12 = 50;
                cRealYatzee = true;
            }
            if(a3 == 5){
                p12 = 50;
                cRealYatzee = true;
            }
            if(a4 == 5){
                p12 = 50;
                cRealYatzee = true;
            }
            if(a5 == 5){
                p12 = 50;
                cRealYatzee = true;
            }
            if(a6 == 5){
                p12 = 50;
                cRealYatzee = true;
            }
            System.out.println("You got " + p12 + " Points!");
            c12 = true;
            supercheck = true;
        }
        if(ins == 13 && !c13){
            // chance
            for(int i = 0; i < pDice.size(); ++i){
                p13 = p13 + pDice.get(i).diceNumber();
            }
            if(cRealYatzee){
                p13 = multiYatzee();
            }
            System.out.println("You got " + p13 + " Points!");
            c13 = true;
            supercheck = true;
        }
        return supercheck;
    }

    public int multiYatzee(){
            int points = 0;
            int b1 = 0;
            int b2 = 0;
            int b3 = 0;
            int b4 = 0;
            int b5 = 0;
            int b6 = 0;
            for(int i = 0; i < pDice.size(); ++i){
                if(pDice.get(i).diceNumber() == 1){
                    b1++;
                }
                if(pDice.get(i).diceNumber() == 2){
                    b2++;
                }
                if(pDice.get(i).diceNumber() == 3){
                    b3++;
                }
                if(pDice.get(i).diceNumber() == 4){
                    b4++;
                }
                if(pDice.get(i).diceNumber() == 5){
                    b5++;
                }
                if(pDice.get(i).diceNumber() == 6){
                    b6++;
                }
            }
            if(b1 == 5){
                points = 100;
            }
            if(b2 == 5){
                points = 100;
            }
            if(b3 == 5){
                points = 100;
            }
            if(b4 == 5){
                points = 100;
            }
            if(b5 == 5){
                points = 100;
            }
            if(b6 == 5){
                points = 100;
            }
            return points;
    }

    public int allPoints(){
        int allP = 0;
        allP = allP + p1;
        allP = allP + p2;
        allP = allP + p3;
        allP = allP + p4;
        allP = allP + p5;
        allP = allP + p6;
        allP = allP + p7;
        allP = allP + p8;
        allP = allP + p9;
        allP = allP + p10;
        allP = allP + p11;
        allP = allP + p12;
        allP = allP + p13;
        return allP;
    }

    // prints the dice
    public void printDice(){
        for(int i = 0; i < amountOfDice; ++i){
            System.out.print(pDice.get(i).print() + " ");
        }
        System.out.println();
    }

    // prints the dice but for the keep function
    public void printDiceKeep(){
        for(int i = 0; i < amountOfDice; ++i){
            if(pDice.get(i).showKeep()){
                System.out.print("(" + (i+1) + ") " + pDice.get(i).print() + "->[*], ");
            }
            else{
                System.out.print("(" + (i+1) + ") " + pDice.get(i).print() + "->[ ], ");
            }
        }
        System.out.println("* means it is being kept and no * means it will reroll");
    }



    /*
     * This is the starting roll of the game
     * 
     * This rolls and adds it into an array related to 
     */
    public int beginningRoll(){
        int y = 0;
        for(int i = 0; i < startingRoll.length; ++i){
            int x = roll();
            startingRoll[i] = x;
            y = y + x;
        }
        System.out.println(name + " rolls are:");
        for(int i = 0; i < startingRoll.length; ++i){
            System.out.print(startingRoll[i] + " ");
        }
        System.out.print(" = " + y);
        System.out.println();
        beginRoll = y;
        return y;
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



        public ArrayList<Dice> getDice(){
            return pDice;
        }

        public Dice getDiceSpot(int i){
            return pDice.get(i);
        }

        public int getP1(){
            return p1;
        }
    
        public int getP2(){
            return p2;
        }
    
        public int getP3(){
            return p3;
        }
    
        public int getP4(){
            return p4;
        }
    
        public int getP5(){
            return p5;
        }
    
        public int getP6(){
            return p6;
        }
    
        public int getP7(){
            return p7;
        }
    
        public int getP8(){
            return p8;
        }
    
        public int getP9(){
            return p9;
        }
    
        public int getP10(){
            return p10;
        }
    
        public int getP11(){
            return p11;
        }
    
        public int getP12(){
            return p12;
        }
    
        public int getP13(){
            return p13;
        }
    
        public String getName(){
            return name;
        }
    
        public void setName(String n){
            name = n;
        }
    
        public int getBeginning(){
            return beginRoll;
        }
    
        public boolean getcRealYatzee(){
            return cRealYatzee;
        }

        public boolean getc1(){
           return c1; 
        }

        public boolean getc2(){
            return c2; 
        }
         
        public boolean getc3(){
            return c3; 
        }

        public boolean getc4(){
            return c4; 
        }

        public boolean getc5(){
            return c5; 
        }

        public boolean getc6(){
            return c6; 
        }

        public boolean getc7(){
            return c7; 
        }

        public boolean getc8(){
            return c8; 
        }

        public boolean getc9(){
            return c9; 
        }

        public boolean getc10(){
            return c10; 
        }

        public boolean getc11(){
            return c11; 
        }

        public boolean getc12(){
            return c12; 
        }

        public boolean getc13(){
            return c13; 
        }

}
