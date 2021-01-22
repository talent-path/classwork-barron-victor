package com.tp.rpg.armors;

public class TankTop implements Armor{
    @Override
    public int reduceDamage(int startingDamage) {
        return startingDamage - 5;
    }
}
