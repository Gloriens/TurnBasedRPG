import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    private Characters[] team;
    private ArrayList<Items> teaminventory = new ArrayList<>();
    private int inventoryMaxWeight;

    public Team(Characters[] team){
        this.team = team;
        setInventoryMaxWeight(calcMaxInvWeight());
    }

    public int calcMaxInvWeight(){
        int maxWeight = 0;
        for (int x= 0; x<team.length;x++){
            maxWeight += team[x].getVitality()*3;
        }
        return maxWeight;
    }

    public int calcInvWeight(){
        int w=0;
        try {
            for (int x = 0; x<teaminventory.size();x++){
                w += teaminventory.get(x).getWeight();
            }

        }catch (Exception e){

        }return w;

    }

    public void printInventory(){
        System.out.println("The maximum weight that your team can carry: " + calcMaxInvWeight());
        System.out.println("Weight of your inventory: " + calcInvWeight());
        try {
            for (int x = 0; x<teaminventory.size();x++){
                System.out.println("---------------------------");
                System.out.println(" " + (x+1) + "-");
                teaminventory.get(x).printinfo();
                System.out.println("---------------------------");
            }


        }catch (Exception e){
            System.out.println("Your inventory is empty");

        }
    }

    public void additem(Characters player,ArrayList<Enemy> enemies,Level level,Team team){
        try {
            System.out.println("Pick the item that you want to take");
            System.out.println("If the floor is empty, please press a random key to go back");
            System.out.println("Also, if you enter an invalid value, you will be directed inventory actions menu");
            System.out.println("Floor:");
            level.printfloorinfo();
            int choice = Action.takechoice();
            choice = choice -1;
            if(calcMaxInvWeight() <= level.floor.get(choice).getWeight()+ calcInvWeight()){
                System.out.println("Your Inventory is full");
                System.out.println("Do you want to remove something?");
                System.out.println("1-Yes            2-No");
                int leavechoice = Action.takechoice();
                switch (leavechoice){
                    case 1:
                        removeInventory(player,enemies,level,team);
                        break;
                    case 2:
                        Action.inventoryActions(player,enemies,level,team);
                        break;
                    default:
                        System.out.println("Please enter valid number");
                }
            }else if(calcMaxInvWeight() >= level.floor.get(choice).getWeight()+ calcInvWeight()){
                teaminventory.add(level.floor.get(choice));
                level.floor.remove(choice);
            }
        }catch (Exception e){
            Action.inventoryActions(player,enemies,level,team);

        }



    }


    public void removeInventory(Characters player,ArrayList<Enemy> enemies,Level level,Team team){
        try {
            System.out.println("Pick the item that you want to remove");
            System.out.println("If the floor is empty, press a random key for cancel");
            System.out.println("Also, if you enter an invalid value, you will be directed inventory actions menu");
            System.out.println("Inventory:");
            printInventory();
            int choice = Action.takechoice();
            choice = choice-1;
            level.floor.add(teaminventory.remove(choice));
            teaminventory.remove(choice);

        }catch (Exception e){
            Action.inventoryActions(player,enemies,level,team);
        }


    }

    public void equipfromInventory(Characters çar,ArrayList<Enemy> enemies,Level level,Team team){
        try {
            System.out.println("************************************");
            System.out.println("Pick the item that you want to equip");
            System.out.println("Also, if you enter an invalid value, you will be directed inventory actions menu");
            System.out.println("0-Cancel");
            System.out.println("************************************");
            System.out.println("Inventory:");
            printInventory();
            int choice = Action.takechoice();
            choice = choice-1;
            if(choice <= teaminventory.size()){
                if(teaminventory.get(choice) instanceof Weapon){
                    getTeaminventory().add(çar.getcWeapon());
                    çar.setcWeapon((Weapon) teaminventory.get(choice));
                    teaminventory.remove(choice);
                    System.out.println("Your old item will be added to your inventory");
                }else if(teaminventory.get(choice) instanceof Armory){
                    getTeaminventory().add(çar.getCarmor());
                    System.out.println("Your old item will be added to your inventory");
                    çar.setCarmor((Armory) teaminventory.get(choice));
                    teaminventory.remove(choice);
                }else if (choice == -1){
                    Action.inventoryActions(çar,enemies,level,team);
                }else {
                    System.out.println("You cant equip that item");
                    Action.inventoryActions(çar,enemies,level,team);
                }
            }else {
                System.out.println("The number you have entered is null, please try again");
                equipfromInventory(çar,enemies,level,team);
            }
        }catch (Exception e){
            Action.inventoryActions(çar,enemies,level,team);
        }
    }

    public void equipfromfloor(Characters çar,ArrayList<Enemy> enemies,Level level,Team team){
        try {

            System.out.println("************************************");
            System.out.println("Pick the item that you want to equip");
            System.out.println("Also, if you enter an invalid value, you will be directed inventory actions menu");
            System.out.println("0-Cancel");
            System.out.println("************************************");
            System.out.println("Floor: ");
            level.printfloorinfo();
            int choice = Action.takechoice();
            choice = choice-1;
            if(choice <= level.floor.size()){
                if(level.floor.get(choice) instanceof Weapon){
                    getTeaminventory().add(çar.getcWeapon());
                    çar.setcWeapon((Weapon) level.floor.get(choice));
                    level.floor.remove(choice);
                    System.out.println("Your old item will be added to your inventory");
                }else if(level.floor.get(choice) instanceof Armory){
                    getTeaminventory().add(çar.getCarmor());
                    System.out.println("Your old item will be added to your inventory");
                    çar.setCarmor((Armory) level.floor.get(choice));
                    level.floor.remove(choice);
                }else if (choice == -1){
                    Action.inventoryActions(çar,enemies,level,team);
                }else {
                    System.out.println("You cant equip that item");
                }
            }else {
                System.out.println("The number you have entered is null, please try again");
                equipfromfloor(çar,enemies,level,team);
            }
        }catch (Exception e){
            Action.inventoryActions(çar,enemies,level,team);
        }
    }




    public Characters[] getTeam() {
        return team;
    }

    public void setTeam(Characters[] team) {
        this.team = team;
    }

    public ArrayList<Items> getTeaminventory() {
        return teaminventory;
    }

    public void setTeaminventory(ArrayList<Items> teaminventory) {
        this.teaminventory = teaminventory;
    }

    public int getInventoryMaxWeight() {
        return inventoryMaxWeight;
    }

    public void setInventoryMaxWeight(int inventoryMaxWeight) {
        this.inventoryMaxWeight = inventoryMaxWeight;
    }
}
