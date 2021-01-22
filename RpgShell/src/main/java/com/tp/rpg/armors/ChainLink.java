package com.tp.rpg.armors;

public class ChainLink implements Armor{
    @Override
    public int reduceDamage(int startingDamage) {
        return startingDamage - 20;
    }
}
