import java.io.FileWriter;
import java.io.IOException;

public abstract class Text {

    public static void enter(){
        System.out.println("Your team enters the dungeon\n\n");
        System.out.println("  _________________________________________________________\n" +
                " /|     -_-                                             _-  |\\\n" +
                "/ |_-_- _                                         -_- _-   -| \\   \n" +
                "  |                            _-  _--                      | \n" +
                "  |                            ,                            |\n" +
                "  |      .-'````````'.        '(`        .-'```````'-.      |\n" +
                "  |    .` |           `.      `)'      .` |           `.    |          \n" +
                "  |   /   |   ()        \\      U      /   |    ()       \\   |\n" +
                "  |  |    |    ;         | o   T   o |    |    ;         |  |\n" +
                "  |  |    |     ;        |  .  |  .  |    |    ;         |  |\n" +
                "  |  |    |     ;        |   . | .   |    |    ;         |  |\n" +
                "  |  |    |     ;        |    .|.    |    |    ;         |  |\n" +
                "  |  |    |____;_________|     |     |    |____;_________|  |  \n" +
                "  |  |   /  __ ;   -     |     !     |   /     `'() _ -  |  |\n" +
                "  |  |  / __  ()        -|        -  |  /  __--      -   |  |\n" +
                "  |  | /        __-- _   |   _- _ -  | /        __--_    |  |\n" +
                "  |__|/__________________|___________|/__________________|__|\n" +
                " /                                             _ -        lc \\\n" +
                "/   -_- _ -             _- _---                       -_-  -_ \\\n" +
                " ");
    }



    public static void introduction(){
        try {             Thread.sleep(3500);         } catch (Exception e) { System.out.println("");         }
        System.out.println("In this game, you will play with a team of 3 heroes");

        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }

        System.out.println("Tank: Mun ");
        try {             Thread.sleep(1000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("Tanks are the iron door between the enemies and their allies! Name of the tank is in your tem is Mun!");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("Mun's damage depends on his Vitality");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("｡☆✼★━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━★✼☆｡");
        try {             Thread.sleep(500);         } catch (Exception e) { System.out.println("");         }
        System.out.println("Warrior: Kanzi");
        try {             Thread.sleep(1300);         } catch (Exception e) { System.out.println("");         }
        System.out.println("Warriors are the symbols of courage and leadership! They are the master of blades! ");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("You can find weapons for your warrior. Kanzi's damage depends on theirs blade and Strength!");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("Healer: May");
        try {             Thread.sleep(1300);         } catch (Exception e) { System.out.println("");         }
        System.out.println("Healer's are the medic and support in their group! ");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("May's damage depends on her intelligence!");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("In this game, your special actions depends on character's weapon");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("If the character wield a shield, can stun the enemies");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("The number of enemies the character can stun and the possibility of stunning depends on its vitality");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("If the character wield a sword, can do critical damage");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("The possibility of critical damage depends on weapon and character's strength");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("If the character wield a staff, can do heal allies");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
        System.out.println("Amount of healing depends on character's intelligence");
        try {             Thread.sleep(4000);         } catch (Exception e) { System.out.println("");         }
    }



    public static void printscore(Team team, String Name){
        int score=0;
        for (int x = 0 ; x< team.getTeaminventory().size(); x++){
            score = team.getTeaminventory().get(x).getValue() + x;
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter("score.txt",true);
            writer.write("\n****************************************************************");
            writer.write("\n"+Name +"'s inventory worth: " + score + " gold!");
            writer.write("\n"+ Name +"Your total score " + score*GameMap.levelnumber);
            writer.write("\n****************************************************************");

            writer.close();
        } catch (IOException e) {
            System.out.println("An error has occured!");
        }
        System.out.println("You have climbed Level " + GameMap.levelnumber + "!");
        System.out.println("Value of your Inventory: " + score + "!");
        System.out.println("Your total score " + score*GameMap.levelnumber);
    }
}
