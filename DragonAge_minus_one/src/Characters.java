import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract public class Characters implements CharStats {
    private String Name;
    private int Maxhp;
    private int HP;
    Armory Carmor;
    Weapon cWeapon;
    private int MaxDamage;
    private int Strenght;
    private int Vitality;
    private int Intelligence;

    public Characters(String Name, Armory Carmor, Weapon cWeapon) {
        this.Name = Name;
        this.Carmor = Carmor;
        this.cWeapon = cWeapon;
        this.HP = Maxhp;;

    }

    public Characters(String name) {
        Name = name;
        setcWeapon(Weapon.randomweapon());
    }

    public int calculateHeal(){
        return getIntelligence()*2 + cWeapon.getHealP() ;

    }
    public boolean isAlive(){
        return getHP() > 0;
    }
    public int calcHP(){
        return (10*getVitality() + 4*getStrenght() + getIntelligence());
    }
    public int getRandomint(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void stun(ArrayList<Enemy> enemies){
        int dice;
        if(enemies.size() <= getVitality()){
            for (int x = 0; x<enemies.size();x++){
                dice = getRandomint(1,30);
                dice = dice + getVitality();
                if(dice >= 23 && enemies.get(x).isAlive()){
                    enemies.get(x).setStunned(true);
                    System.out.println(enemies.get(x).getName() + " stunned!");
                }else if(enemies.get(x).isAlive()) {
                    System.out.println(enemies.get(x).getName() + " dodged your move!");
                }
            }
        }else if (enemies.size() > getVitality())
        for (int x = 0; x<getVitality();x++){
            dice = getRandomint(1,30);
            dice = dice + getVitality();
            if(dice >= 23 && enemies.get(x).isAlive()){
                enemies.get(x).setStunned(true);
            }else if(enemies.get(x).isAlive()) {
                System.out.println(enemies.get(x).getName() + " dodged your move!");
            }
        }
    }


    public void printInfo(){
        System.out.println("Name:" + getName() +
                "\nMax HP: " + getMaxhp() + "    HP: " + getHP() +
                        "\nStrength, Vitality and Intelligence: " + getStrenght() + ", " + getVitality() + ", " + getIntelligence()+
                "\nWeapon ");
        getcWeapon().printinfo();
        System.out.println("Armor");
        getCarmor().printinfo();

    }

    public void Attack(Characters c) {
        int damge;
        if(!c.isAlive()){
            System.out.println("Target is already dead");
        }if(c instanceof Enemy) {
            damge = (int) calcDamage();
            if(damge <= 0){
                System.out.println(getName() + " is so weak, he couldn't even touch " + c.getName() + "!");
            }else {
                c.setHP((int) (c.getHP() - damge));
                System.out.println(getName() + " attacks to " + c.getName());
                System.out.println(damge + " Damage!");
                System.out.println(c.getName() + "  HP:" + c.getHP());
                if(c.getHP() <= 0){
                    System.out.println(c.getName() + " is dead");
                }
            }

        }else {
            damge = (int) calcDamage()- c.getCarmor().getArmor()/(3/2)-c.cWeapon.getDamagereduce();
            if(damge <= 0){
                System.out.println(getName() + " is so weak, he couldn't even touch " + c.getName() + "!");
            }else {
                c.setHP((int) (c.getHP() - damge));
                System.out.println(getName() + " attacks to " + c.getName());
                System.out.println(damge + " Damage!");
                if(c.getHP() <= 0) {
                    System.out.println(c.getName() + " is dead");
                }
            }
        }
    }

    public void Heal(Characters character){
        if((character.getHP() + calculateHeal()) >= character.getMaxhp()){
            character.setHP(character.getMaxhp());
            System.out.println(getName() + " heals " + character.getName() + "'s wounds");
            System.out.println(character.getName() + "'s new HP: " + character.getHP());
            System.out.println(character.getName() + " is full HP now");
        }else {
            character.setHP(character.getHP()+calculateHeal());
            System.out.println(getName() + " heals " + character.getName() + "'s wounds");
            System.out.println(character.getName() + "'s new HP: " + character.getHP());
        }
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getMaxhp() {
        return Maxhp;
    }
    public void setMaxhp(int maxhp) {
        Maxhp = maxhp;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public Armory getCarmor() {
        return Carmor;
    }
    public void setCarmor(Armory carmor) {
        Carmor = carmor;
    }
    public Weapon getcWeapon() {
        return cWeapon;
    }
    public void setcWeapon(Weapon cWeapon) {
        this.cWeapon = cWeapon;
    }
    public double getMaxDamage() {
        return MaxDamage;
    }
    public void setMaxDamage(int maxDamage) {
        MaxDamage = maxDamage;
    }
    public int getStrenght() {
        return Strenght;
    }
    public void setStrenght(int strenght) {
        Strenght = strenght;
    }
    public int getVitality() {
        return Vitality;
    }
    public void setVitality(int vitality) {
        Vitality = vitality;
    }
    public int getIntelligence() {
        return Intelligence;
    }
    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }

} class Warrior extends Characters{


    public Warrior(String Name, Armory Carmor, Weapon cWeapon) {
        super(Name, Carmor, cWeapon);
        setStrenght(getRandomint(6,10));
        setVitality(getRandomint(3,7));
        setIntelligence(getRandomint(1,5));
        setMaxhp(calcHP());
        setHP(getMaxhp());
    }

    @Override
    public double calcDamage() {
        int damage = 0;
        int chance = getRandomint(0,100);
        if(chance > 100-cWeapon.getCrit()+getStrenght()*1.5){
            System.out.println("Critical hit!");
            damage = (cWeapon.getDamage()*2) + getStrenght()*2;
        }else {
            damage = cWeapon.getDamage()+ getStrenght()*3;
        }
        return damage;
    }
}

class Tank extends Characters{
    Shileds cShield;

    public Tank(String Name, Armory Carmor, Shileds cShield) {
        super(Name, Carmor, cShield);
        this.cShield = cShield;
        setStrenght(getRandomint(3,7));
        setVitality(getRandomint(6,10));
        setIntelligence(getRandomint(1,5));
        setMaxhp(calcHP());
        setHP(getMaxhp());

    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("The number of enemies  " + getName() + " can stun: " + getVitality());
    }

    @Override
    public double calcDamage() {
        int damage = 0;
        int chance = getRandomint(0,100);
        if(chance > 100-cWeapon.getCrit()){
            System.out.println("Critical hit!");
            damage = cWeapon.getDamage()*2+ getVitality()*2;
        }else {
            damage = cWeapon.getDamage()+ getVitality()*2;
        }
        return damage;
    }


}


class Healer extends Characters{

    public Healer(String Name, Armory Carmor,Weapon cWeapon) {
        super(Name, Carmor, cWeapon);
        setStrenght(getRandomint(3,7));
        setVitality(getRandomint(1,5));
        setIntelligence(getRandomint(6,10));
        setMaxhp(calcHP());
        setHP(getMaxhp());
    }

    @Override
    public double calcDamage() {
        int damage = 0;
        int chance = getRandomint(0,100);
        if(chance > 100-cWeapon.getCrit()){
            System.out.println("Critical hit!");
            damage = cWeapon.getDamage()*2+ getIntelligence()*2;
        }else {
            damage = cWeapon.getDamage()+ getIntelligence()*2;
        }
        return damage;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Healing power: " + calculateHeal());
    }



}

