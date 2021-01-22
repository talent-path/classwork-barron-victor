package com.tp.rpg.armors;

public class KnightArmor implements Armor{
    @Override
    public int reduceDamage(int startingDamage) {
        return startingDamage - 25;
    }
}
