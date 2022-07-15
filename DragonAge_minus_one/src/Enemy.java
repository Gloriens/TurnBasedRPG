public class Enemy extends Characters {
    private boolean stunned;

    public Enemy(String name) {
        super(name);
        setStrenght(getRandomint(1,5));
        setVitality(getRandomint(1,5));
        setIntelligence(getRandomint(1,5));
        setMaxhp(calcHP());
        setHP(getMaxhp());
    }

    @Override
    public double calcDamage() {
        setMaxDamage((int) (getMaxhp()*0.3 + cWeapon.getDamage()));
        return getMaxDamage();
    }

    @Override
    public void printInfo() {
        System.out.println("Name:" + getName() +
                "\nHP: " + getHP() + "    Weapon: " + cWeapon.getName() +"    Damage: " + calcDamage() +
                "\nStrength, Vitality and Intelligence: " + getStrenght() + ", " + getVitality() + ", " + getIntelligence());
    }

    public Items dropItem(){
        int dice = getRandomint(1,6);
        Items rand = null;
        if(dice<=2){
            rand = Items.randomitem();
        }else if(dice == 3){
            rand = Weapon.randomweapon();
        }else if(dice == 4) {
            rand = Armory.randomarmor();
        }else if(dice ==5){
            rand = Staffs.randomstaff();
        }else if(dice == 6){
            rand = Shileds.randomshield();
        }

        return rand;
    }

    public void attackTeam(Team team){
        if(isStunned() == false && isAlive() == true){
            if(team.getTeam()[0].isAlive()){
                Attack(team.getTeam()[0]);
            }else if(team.getTeam()[1].isAlive()){
                Attack(team.getTeam()[1]);
            }else if(team.getTeam()[2].isAlive()){
                Attack(team.getTeam()[2]);
            }else {
                System.out.println("Enemy " + getName() + " spits your body");
            }

        }else if(isStunned() == true) {
            System.out.println(getName() + " is stunned! Enemy cant attack!");
            System.out.println("*******");
        }


    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }
}

