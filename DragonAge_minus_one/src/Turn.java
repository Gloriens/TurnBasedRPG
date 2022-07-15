import java.util.ArrayList;

public class Turn {
    ArrayList<Enemy> Enemies;
    Team Heroes;

    public Turn(ArrayList<Enemy> enemies, Team team) {
        Enemies = enemies;
        this.Heroes = team;
    }

    public boolean startturns(Level level){
        boolean isitover =true;
        System.out.println("ENEMY TEAM");
        System.out.println("***********************");
        level.printEnemyteamInfo();
        System.out.println("YOUR TEAM");
        System.out.println("***********************");
        level.printbasicteamInfo();
        boolean ggez = true;
        boolean Idontfeelsogood = true;
        while (ggez && Idontfeelsogood){
            System.out.println("     NEW TURN");
            System.out.println("PREPARE FOR BATTLE!");
            aturn(level);
            ggez = isanyonealive(Enemies);
            Idontfeelsogood = isanyonealive(Heroes);
            System.out.println("----------------");
            System.out.println("END OF THE TURN");
            System.out.println("----------------");
            if(!Idontfeelsogood){
                System.out.println("┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n" +
                        "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n" +
                        "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n" +
                        "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n" +
                        "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n" +
                        "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                        "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n" +
                        "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                        "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n" +
                        "██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                        "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄");
                System.out.println("┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼" +
                        "\n\n");
                isitover=false;
            }else if(!ggez){
                System.out.println("You have won the battle!");
                isitover=true;
                System.out.println("Now you can collect the items and heal your Heroes for 1 turn");
                Action.Actions(Heroes.getTeam()[0],Enemies,level,Heroes);
                Action.Actions(Heroes.getTeam()[1],Enemies,level,Heroes);
                Action.Actions(Heroes.getTeam()[2],Enemies,level,Heroes);


            }

        }return isitover;

    }

    public boolean isanyonealive(Team army){
        boolean control = false;
        for (int x = 0; x<army.getTeam().length;x++){
            if (army.getTeam()[x].isAlive()){
                control = true;
                break;
            }
        }
        return control;

    }

    public boolean isanyonealive(ArrayList<Enemy> army){
        boolean control = false;
        for (int x = 0; x<army.size();x++){
            if (army.get(x).isAlive()){
                control = true;
                break;
            }
        }
        return control;
    }

    public void aturn(Level level){
        for(int x = 0; x<Heroes.getTeam().length; x++){
            Action.Actions(Heroes.getTeam()[x],Enemies,level,Heroes);
            try {
                System.out.println( nextdumy(x).getName() + " trying to attack!");
                nextdumy(x).attackTeam(Heroes);

            }catch (Exception e){
                try {
                    if(Enemies.size() == 2){
                        System.out.println( nextdumy(1).getName() + " trying to attack!");
                        nextdumy(1).attackTeam(Heroes);

                    }else {
                        System.out.println( nextdumy(0).getName() + " trying to attack!");
                        nextdumy(0).attackTeam(Heroes);
                    }

                }catch (Exception a){

                }


            }
            level.printbasicteamInfo();
        }
        for (int x =2; x<Enemies.size();x++){
            System.out.println("Enemy " + nextdumy(x).getName() + " trying to attack!");
            nextdumy(x).attackTeam(Heroes);
            level.printbasicteamInfo();
        }
        cleanStun();

    }
    public Enemy nextdumy(int y) {
        Enemy temp = null;
        for (int x = y; x < Enemies.size(); x++) {
            if (Enemies.get(x).isAlive()) {
                temp = Enemies.get(x);
                break;
            }
        }
        return temp;
    }


    public void cleanStun(){
        for (int x = 0; x<Enemies.size();x++){
            Enemies.get(x).setStunned(false);
        }

    }

}
