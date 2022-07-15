import java.util.ArrayList;

public class Level {
    double levelnumber;
    ArrayList<Items> floor ;
    ArrayList<Enemy> Enemies;
    Team Heroes;


    public Level(int levelnumber,Team team){
        Heroes = team;
        this.levelnumber = levelnumber;
        floor = new ArrayList<>();
        Enemies = new ArrayList<>();
        spawnEnemies();

    }

    public void spawnEnemies(){
        double enemynumber = Math.pow(2,levelnumber);
        for(int x = 0; x < enemynumber; x++){
            String enemyname = "Enemy"+" " +(x+1);
            Enemies.add(new Enemy(enemyname));

        }
    }
    public void printEnemyteamInfo(){
        for(int x = 0; x < Enemies.size(); x++){
            if(Enemies.get(x).isAlive()){
                Enemies.get(x).printInfo();
                System.out.println("----------------------");

            }else if(!Enemies.get(x).isAlive()){
                System.out.println(Enemies.get(x).getName() + " is dead");
            }

        }
    }

    public void printfloorinfo(){
        if(floor.size() <=0 ){
            System.out.println("There is nothing on the floor");
        }else {
            for(int x = 0; x < floor.size(); x++){
                System.out.println("-------");
                System.out.println(" "+(x+1)+" ");
                floor.get(x).printinfo();
                System.out.println("-------");
            }
        }
    }


    public void dropFloor(Enemy enemy){
        floor.add(enemy.dropItem());
    }

    public void printbasicteamInfo(){
        System.out.println("   " + Heroes.getTeam()[0].getName());
        System.out.println("HP: " + Heroes.getTeam()[0].getHP() + "   Damage: " + Heroes.getTeam()[0].calcDamage());
        System.out.println("   " + Heroes.getTeam()[1].getName());
        System.out.println("HP: " + Heroes.getTeam()[1].getHP() + "   Damage: " + Heroes.getTeam()[1].calcDamage());
        System.out.println("   " + Heroes.getTeam()[2].getName());
        System.out.println("HP: " + Heroes.getTeam()[2].getHP() + "   Damage: " + Heroes.getTeam()[2].calcDamage());
    }

    public void printdetailedteamInfo(){
        System.out.println("--------------------");
        Heroes.getTeam()[0].printInfo();
        System.out.println("--------------------");
        Heroes.getTeam()[1].printInfo();
        System.out.println("--------------------");
        Heroes.getTeam()[2].printInfo();
        System.out.println("--------------------");

    }

}
