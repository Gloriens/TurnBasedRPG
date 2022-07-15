import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warrior Kanzi = new Warrior("Kanzi",Armory.Leather(),Weapon.lumberjackaxe());
        Healer May = new Healer("May",Armory.Leather(),Staffs.NoviceStaff());
        Tank Mun = new Tank("Mun",Armory.Leather(),Shileds.WoodenS());
        Characters[] team = new Characters[3];
        team[0] = Mun;
        team[1] = Kanzi;
        team[2] = May;
        Team Heroes = new Team(team);
        GameMap.Heroes = Heroes;
        try {             Thread.sleep(3000);         }
        catch (Exception e) {
            System.out.println("");         }
        System.out.println("☆ （ • •）☆\n" +
                "╔uu══════════════════╗☆\n" +
                "❝   <━━━WELCOME━━━>  ❞\n" +
                "╚══════nn════════════╝");

        System.out.println("\nWelcome to the Dragon Age Minus1! ");
        System.out.println("In this game, you will command a group of Heroes");
        System.out.println("Please enter your name, mighty Commander!");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        startgame(Heroes,name);

    }

    public static void startgame(Team team, String Name){
        System.out.println("Do you want to play the game or read the introduction?");
        System.out.println("1-Play      /       2-Read");
        int choice = Action.takechoice();
        switch (choice){
            case 1:
                Text.enter();
                GameMap.map();
                break;
            case 2:
                Text.introduction();
                Text.enter();
                GameMap.map();
                Text.printscore(team,Name);
                break;
            default:
                System.out.println("Please enter a valid number");
                startgame(team,Name);
                break;
        }

    }
}
