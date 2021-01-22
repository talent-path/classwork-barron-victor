package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.armors.Naked;
import com.tp.rpg.weapons.Weapon;

import java.util.Scanner;

//TODO:
//      add a concept of hitpoints
//      add a concept of armor (or maybe multiple pieces of armor)
//      add a concept of a weapon (or maybe multiple weapons)
//Stretch goals:
//      add a potion class/interface that the character can drink instead of attacking
//      let the character "disarm" the opponent instead of attacking
//          base this on the weapons used?
//      let the character choose to "block" or "defend"
//          could stun the opponent if they attack?
//          could give us TWO attacks on the next round?
public abstract class Character implements Chooser {
    private int Hp;
    private Weapon weaponUsed;
    private Armor armorUsed;

    public void setHp(int Hp){
        this.Hp = Hp;
    }
    public void setWeaponUsed(Weapon chosen){
        this.weaponUsed = chosen;
    }
    public void setArmorUsed(Armor chosen){
        this.armorUsed = chosen;
    }
    //TODO: add fields for armor(s) and weapon(s)

    public void attack( Character defender ){
        defender.takeDamage(weaponUsed.generateDamage());
    }
    public void usePotions(){
        setHp(this.Hp + 20);
    }

    public void disarm(Character defender){
        defender.setArmorUsed(new Naked());
    }
    public void takeDamage( int damage ){
        setHp(armorUsed.reduceDamage(damage));
    }

    public boolean isAlive(){
        if(this.Hp < 0){
            return false;
        }
        else return true;
    }

    @Override
    public String makeChoice() {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        String choice = null;
        while (!isValid) {
            Console.print("What would you like to do?");
            String userInput = scan.nextLine();
            try {
                choice = scan.nextLine();
                if(choice.equals("Attack") || choice.equals("Use potion") || choice.equals("Disarm")) {
                    isValid = true;
                }
            } catch (NumberFormatException ex) {
            }
        }
        return choice;
    }

    public void displayHp(){
        System.out.println();
    }
}
