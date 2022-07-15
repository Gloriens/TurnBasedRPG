public class Items {
    private String name;
    private int weight;
    private int value;

    public Items(String name, int weight, int value) {
        this.value = value;
        this.name = name;
        this.weight = weight;
    }

    public Items() {
    }

    public static Items HarryPotter(){ return new Items ("Book of Harry Potter",1,0);}
    public static Items Pstone(){return new Items("Philosopher's Stone",2,150);}
    public static Items RoLC(){return new Items("Lich King's Helm",5,200);}
    public static Items EnderPerl(){ return new Items ("Ender Perl",1,100);}
    public static Items Dragonballsz() {return new Items("Dragon Ball",5,120);}
    public static Items Narsil(){ return new Items ("Shards of Narsil",3,200);}
    public static Items LoTR(){ return new Items ("The One Ring",1,700);}

    public static Items randomitem() {
        Items rand = new Items();
        int x = (int) (Math.random() * 100);
        if (x <= 50) {
            rand = HarryPotter();
        } else if (x <= 60) {
            rand = RoLC();
        } else if (x <= 75) {
            rand = EnderPerl();
        } else if (x <= 87) {
            rand = Dragonballsz();
        } else if (x <= 95){
            rand = Pstone();
        }else if (x <= 99){
            rand = Narsil();
        }else if(x <= 100){
            rand = LoTR();

        }
        return rand;
    }

    public void printinfo(){
        System.out.println("Name: " + name + "    Weight: " + weight + "    Value: " + value);
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}



class Weapon extends Items{
    private int damage;
    private int crit;
    private int HealP;
    private int damagereduce;

    public Weapon(){

    }

    public Weapon(String name, int weight, int damage, int crit, int value, int healP, int damagereduce) {
        super(name, weight, value);
        this.damage = damage;
        this.crit = crit;
        HealP = healP;
        this.damagereduce = damagereduce;
    }

    public static Weapon randomweapon() {
        Weapon rand = new Weapon();
        int x = (int) (Math.random() * 100);
        if (x < 40) {
            rand = lumberjackaxe();
        } else if (x <= 55) {
            rand = LongSword();
        } else if (x <= 70) {
            rand = SteelSword();
        } else if (x <= 83) {
            rand = Gorehowl();
        } else if (x <= 91){
            rand = Murasama();
        }else if (x <= 97){
            rand = GlorienB();
        }else if(x <= 100){
            rand = FroustMourne();

        }
        return rand;
    }

    public static Weapon  lumberjackaxe (){
        return new Weapon("lumberjack Axe ",6,4,8,5,0,0);
    }
    public static Weapon LongSword(){
        return new Weapon("Long Sword",6,6,15,10,0,0);
    }
    public static Weapon SteelSword(){
        return new Weapon("Steel Sword ",6,9,17,13,0,0);
    }
    public static Weapon Gorehowl(){
        return new Weapon("Gorehowl", 6,18,15,18,0,0);
    }
    public static Weapon Murasama(){
        return new Weapon("Murasama",5,15,40,30,0,0);
    }
    public static Weapon GlorienB(){
        return new Weapon("Blade of Glorien",7,20,20,50,0,0);
    }
    public static Weapon FroustMourne(){
        return new Weapon("Froustmourne",7,24,25,70,0,0);
    }


    @Override
    public void printinfo() {
        super.printinfo();
        System.out.println("Damage: " + getDamage() + "    Crit Chance: " + getCrit());
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getCrit() {
        return crit;
    }
    public void setCrit(int crit) {
        this.crit = crit;
    }
    public int getHealP() {
        return HealP;
    }
    public void setHealP(int healP) {
        HealP = healP;
    }
    public int getDamagereduce() {
        return damagereduce;
    }
    public void setDamagereduce(int damagereduce) {
        this.damagereduce = damagereduce;
    }
}



class Staffs extends Weapon{

    public Staffs(String name, int weight, int damage, int crit, int value, int healP, int damagereduce) {
        super(name, weight, damage, crit, value, healP, damagereduce);
    }

    public static Staffs NoviceStaff(){
        return new Staffs("Novice Staff",      5,3,3,5,3,0);
    }
    public static Staffs  StaffofLight(){
        return new Staffs("Staff of Light",  5,5,8,10,5,0);
    }
    public static Staffs  OblivionStaff(){
        return new Staffs("Oblivion staff", 8,8,10,20,8,0);
    }
    public static Staffs  MorningStar(){
        return new Staffs("Morning Star",     8,14,15,30,10,0);
    }
    public static Staffs  StaffofAnduin(){
        return new Staffs("Staff of Anduin",8,10,5,30,15,0);
    }

    public static Staffs randomstaff() {
        Staffs rand = null;
        int x = (int) (Math.random() * 100);
        if (x <= 40) {
            rand = NoviceStaff();
        } else if (x <= 70) {
            rand = StaffofLight();
        }else if(x <= 85){
            rand = MorningStar();
        }else if (x <= 95) {
            rand = OblivionStaff();
        }else if (x <= 100) {
            rand = StaffofAnduin();
        }
        return rand;
    }


    @Override
    public void printinfo() {
        System.out.println("Name: " + getName() + "    Weight: " + getWeight() + "    Value: " + getValue()
        +"\nDamage: " + getDamage() + " Heal Power " + getHealP());
    }


}



class Shileds extends Weapon{

    public Shileds(String name, int weight, int damage, int crit, int value, int healP, int damagereduce) {
        super(name, weight, damage, crit, value, healP, damagereduce);
    }

    public static Shileds randomshield() {
        Shileds rand = null;
        int x = (int) (Math.random() * 100);
        if (x <= 25) {
            rand = WoodenS();
        } else if (x <= 50) {
            rand = IronS();
        } else if (x <= 65) {
            rand = SteelPlateS();
        } else if (x <= 79) {
            rand = ElvenS();
        } else if (x <= 90) {
            rand = DemonicS();
        }else if (x <= 98){
            rand = HighKingS();
        }
        return rand;
    }

    @Override
    public void printinfo() {
        System.out.println("Name: " + getName() + "    Weight: " + getWeight() + "    Value: " + getValue()
                +"\nDamage: " + getDamage() + " Damage Reduce " + getDamagereduce());
    }

    public static Shileds WoodenS(){return new Shileds("Wooden Shield",2,3,0,10,0,3);}
    public static Shileds IronS(){return new Shileds("Iron Shield",5,5,0,25,0,6);}
    public static Shileds SteelPlateS(){return new Shileds("Steel Plate Shield",4,7,40,70,0,9);}
    public static Shileds ElvenS(){return new Shileds("Elven Shield",3,7,0,60,0,11);}
    public static Shileds DemonicS(){return new Shileds("Demonic Shield",5,11,0, 75,0,13);}
    public static Shileds HighKingS(){return new Shileds("High King's Shield",4,11,0,80,0,14);}


}

class Armory extends Items{
    private int armor;

    public Armory(String name, int weight, int armor,int value) {
        super(name, weight, value);
        this.armor = armor;
    }

    public Armory() {

    }

    public static Armory randomarmor() {
        Armory rand = new Armory();
        int x = (int) (Math.random() * 100);
        if (x <= 25) {
            rand = Leather();
        } else if (x <= 50) {
            rand = Ranger();
        } else if (x <= 65) {
            rand = IronArmor();
        } else if (x <= 79) {
            rand = HelfArmor();
        } else if (x <= 90) {
            rand = SteelPArmor();
        }else if (x <= 98){
            rand = Mythril();
        }else if (x <= 100){
            rand =HighKingArmor();
        }
        return rand;
    }


    public static Armory Leather(){ return new Armory("Leather Armor",4,10,10); }
    public static Armory Ranger(){
        return new Armory("Ranger Armor",3,12,15);
    }
    public static Armory HelfArmor(){
        return new Armory("Hıgh Elf Armor",5,20,70);
    }
    public static Armory IronArmor(){
        return new Armory("Iron Armor",10,15,20);
    }
    public static Armory SteelPArmor(){
        return new Armory("Steel Plate Armor",7,20,50);
    }
    public static Armory Mythril(){
        return new Armory("Mythril Armor",7,35,100);
    }
    public static Armory HighKingArmor(){
        return new Armory("High King's Armor",5,60,150);
    }



    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }





}