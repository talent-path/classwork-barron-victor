package com.tp.rpg;

//goblins always attack?
public class Goblin extends NonPlayerCharacter {
    @Override
    public String makeChoice() {
        return "attack";
    }
}
