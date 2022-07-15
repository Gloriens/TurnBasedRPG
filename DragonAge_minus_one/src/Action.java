import java.util.ArrayList;
import java.util.Scanner;

public class Action {
    static Scanner input = new Scanner(System.in);


    public static void Actions(Characters player, ArrayList<Enemy> enemies, Level level, Team team){
        System.out.println("************************************************************");
        if(player.isAlive()){
            System.out.println("Now you will play with " + player.getName() + "!");
            System.out.println("Choose your next move!");
            System.out.println("1-Attack");
            System.out.println("2-Special Action");
            System.out.println("3-Examine floor");
            System.out.println("4-Examine Enemy");
            System.out.println("5-Inventory Actions");
            System.out.println("6-Examine your team");
            System.out.println("7-Skip your turn");
            int choice = takechoice();
            switch (choice){
                case 1:
                    try {
                        System.out.println("Choose your target");
                        level.printEnemyteamInfo();
                        int achoice = takechoice();
                        if(enemies.get(achoice-1).isAlive()){
                            player.Attack(enemies.get(achoice-1));
                            if(!enemies.get(achoice-1).isAlive()){
                                level.floor.add(enemies.get(achoice-1).dropItem());
                            }
                        }
                        else{
                            System.out.println("Enemy is already dead");
                            System.out.println("Returning Action menu");
                            Action.Actions(player,enemies,level,team);
                        }

                    }catch (Exception e){
                        System.out.println("Please enter a valid number");
                        Action.Actions(player,enemies,level,team);
                    }

                    break;

                case 2:
                    Action.specialAction(player,enemies,level,team);
                    break;

                case 3:
                    level.printfloorinfo();
                    Action.Actions(player,enemies,level,team);
                    break;
                case 4:
                    level.printEnemyteamInfo();
                    Action.Actions(player,enemies,level,team);
                    break;
                case 5:
                    inventoryActions(player,enemies,level,team);
                    break;
                case 6:
                    level.printdetailedteamInfo();
                    Action.Actions(player,enemies,level,team);
                    break;

                case 7:
                    break;

                default:
                    System.out.println("Please enter a valid number");
                    Action.Actions(player,enemies,level,team);
                    break;

            }

        }else {
            System.out.println(player.getName() + " is dead");
        }

    }





    public static void specialAction(Characters c,ArrayList<Enemy> enemies, Level level,Team team){
        if(c.cWeapon instanceof Shileds){
            System.out.println("Your special action is Stun");
            System.out.println("Will you use it?");
            System.out.println("1-Yes                  2-No");
            int choice = takechoice();
            if(choice == 1){
                c.stun(enemies);
            }else if(choice == 2){
                Action.Actions(c,enemies,level,team);
            }

        }
        else if(c.cWeapon instanceof Staffs){
            System.out.println("Your special action is Healing");
            System.out.println("Choose your target");
            System.out.println("1- " + GameMap.Heroes.getTeam()[0].getName() + "   HP: " + GameMap.Heroes.getTeam()[0].getHP());
            System.out.println("2- " + GameMap.Heroes.getTeam()[1].getName() + "   HP: " + GameMap.Heroes.getTeam()[1].getHP());
            System.out.println("3- " + GameMap.Heroes.getTeam()[2].getName() + "   HP: " + GameMap.Heroes.getTeam()[2].getHP());
            System.out.println("4- Back");
            int choice = takechoice();
            switch (choice){
                case 1:
                    if(GameMap.Heroes.getTeam()[0].getHP() == GameMap.Heroes.getTeam()[0].getMaxhp()){
                        System.out.println("Your ally is healthy");
                        System.out.println("Please choose different target");
                        specialAction(c,enemies,level,team);
                    }else {
                        c.Heal(GameMap.Heroes.getTeam()[0]);
                        break;
                    }break;
                case 2:
                    if(GameMap.Heroes.getTeam()[1].getHP() == GameMap.Heroes.getTeam()[1].getMaxhp()){
                        System.out.println("Your allie is healthy");
                        System.out.println("Please choose different target");
                        specialAction(c,enemies,level,team);
                    }else {
                        c.Heal(GameMap.Heroes.getTeam()[1]);
                        break;
                    }break;
                case 3:
                    if(GameMap.Heroes.getTeam()[2].getHP() == GameMap.Heroes.getTeam()[2].getMaxhp()){
                        System.out.println("Your allie is healthy");
                        System.out.println("Please choose different target");
                        specialAction(c,enemies,level,team);
                    }else {
                        c.Heal(GameMap.Heroes.getTeam()[2]);
                        break;
                    }
                    break;
                case 4:
                    Action.Actions(c,enemies,level,team);
                    break;

                default:
                    System.out.println("Please enter a valid number");
                    specialAction(c,enemies,level,team);
                    break;
            }
        }else {
            System.out.println("Your special action is critic damage, this is your weapon's passive skill, your character has not" +
                    "\n an active skill");
            Action.Actions(c,enemies,level,team);
        }

    }

    public void versus(Characters player, ArrayList<Enemy> enemies, Level level){

    }

    public static void inventoryActions(Characters player,ArrayList<Enemy> enemies,Level level,Team team){
        System.out.println("1-Take an item from the floor    " +
                "\n2-Remove an item from your inventory    " +
                "\n3-Browse your Inventory    \n" +
                "4-Equip an item from your inventory    \n5-Wield from floor  \n6-Cancel");
        int choice = takechoice();
        switch (choice){
            case 1:
                team.additem(player,enemies,level,team);
                break;

            case 2:
                team.removeInventory(player,enemies,level,team);
                break;

            case 3:
                team.printInventory();
                inventoryActions(player,enemies,level,team);
                break;
            case 4:
                team.equipfromInventory(player,enemies,level,team);
                break;
            case 6:
                Action.Actions(player,enemies,level,team);
                break;
            case 5:
                team.equipfromfloor(player,enemies,level,team);
                break;
            default:
                System.out.println("Please enter a valid number");
                inventoryActions(player,enemies,level,team);
                break;
        }

    }




    public static int takechoice(){
        String astrchoice = input.nextLine();
        int achoice;
        try {
            achoice = Integer.parseInt(astrchoice);
        }
        catch (NumberFormatException e) {
            achoice = 0;
        }
        return achoice;
    }

}
