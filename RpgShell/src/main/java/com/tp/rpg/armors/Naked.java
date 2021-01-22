package com.tp.rpg.armors;

public class Naked implements Armor{

    @Override
    public int reduceDamage(int startingDamage) {
        return startingDamage;
    }
}
