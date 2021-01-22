package com.tp.rpg;

import com.tp.rpg.armors.*;
import com.tp.rpg.weapons.*;

import java.util.Random;

public class Application {
    public static void main(String[] args) {

        PlayerCharacter pc = setUpPlayer();

        while( pc.isAlive() ){
            NonPlayerCharacter enemy = setUpEnemy();
            displayStats();
            battle( pc, enemy );


        }

        gameOverScreen();

    }

    private static void displayStats() {
    }

    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {
        PlayerCharacter player = new PlayerCharacter();
        System.out.println("Choose your armor:");
        System.out.println("1. Naked");
        System.out.println("2. Tank Top");
        System.out.println("3. Shirt");
        System.out.println("4. ChainLink Shirt");
        switch (Console.readInt("5. Knight Armor")) {
            case 1:
                player.setArmorUsed(new Naked());
                System.out.println("You selected to be Naked");
                break;
            case 2:
                player.setArmorUsed(new TankTop());
                System.out.println("You selected a Tank Top");
                break;
            case 3:
                player.setArmorUsed(new Shirt());
                System.out.println("You selected a Shirt");
                break;
            case 4:
                player.setArmorUsed(new ChainLink());
                System.out.println("You selected a ChainLink");
                break;
            case 5:
                player.setArmorUsed(new KnightArmor());
                System.out.println("You selected Knight Armor");
                break;
        }
        System.out.println("Choose your weapon:");
        System.out.println("1. Fist");
        System.out.println("2. Stick");
        System.out.println("3. Large Stick");
        System.out.println("4. Sword");
        switch (Console.readInt("5. LightSaber")) {
            case 1:
                player.setWeaponUsed(new Fist());
                System.out.println("You selected to use your fists!");
                break;
            case 2:
                player.setWeaponUsed(new Stick());
                System.out.println("You selected to use a stick");
                break;
            case 3:
                player.setWeaponUsed(new LargeStick());
                System.out.println("You selected to use a Large Stick");
                break;
            case 4:
                player.setWeaponUsed(new Sword());
                System.out.println("You selected to use a sword");
                break;
            case 5:
                player.setWeaponUsed(new LightSaber());
                System.out.println("You selected to use a LightSaber!");
                break;
        }
        player.setHp(100);
        return player;
    }

    //create some NPC object (with armor & weapons?)
    private static NonPlayerCharacter setUpEnemy() {
        NonPlayerCharacter npc = new NonPlayerCharacter();
        Random rn = new Random();
        int npcChoice = rn.nextInt(5 - 1 + 1) + 1;
        switch (npcChoice) {
            case 1:
                npc.setArmorUsed(new Naked());
            case 2:
                npc.setArmorUsed(new TankTop());
            case 3:
                npc.setArmorUsed(new Shirt());
            case 4:
                npc.setArmorUsed(new ChainLink());
            case 5:
                npc.setArmorUsed(new KnightArmor());
        }
        npcChoice = rn.nextInt(5 - 1 + 1) + 1;
        switch (npcChoice) {
            case 1:
                npc.setWeaponUsed(new Fist());
            case 2:
                npc.setWeaponUsed(new Stick());
            case 3:
                npc.setWeaponUsed(new LargeStick());
            case 4:
                npc.setWeaponUsed(new Sword());
            case 5:
                npc.setWeaponUsed(new LightSaber());
        }
        return npc;
    }

    //a and b battle until one is dead
    private static void battle(Character a, Character b) {
        Character attacker = a;
        Character defender = b;

        while( a.isAlive() && b.isAlive() ){
            if( attacker.makeChoice().equals("Attack")) {
                attacker.attack(defender);
            } else if(attacker.makeChoice().equals("Use Potion")){
                attacker.usePotions();
            }
            else if(attacker.makeChoice().equals("Disarm")){
                attacker.disarm(defender);
            }
            Character temp = a;
            a = b;
            b = temp;
        }
    }

    //display some message
    private static void gameOverScreen() {
    }

    private static void displayOptions(){
        System.out.println("Attack");
        System.out.println("Use Potion");
        System.out.println("Disarm");
    }
}
