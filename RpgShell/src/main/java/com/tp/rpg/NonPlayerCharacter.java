package com.tp.rpg;

import java.util.Random;

public class NonPlayerCharacter extends Character {


    @Override
    public String makeChoice() {
        Random rn = new Random();
        int npcChoice = rn.nextInt(3 - 1) + 1;
        switch (npcChoice){
            case 1:
                return "Attack";
            case 2:
                return "Disarm";
            case 3:
                return "Use Potion";
        }
        return "Attack";
    }
}
