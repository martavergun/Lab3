package org.example.droid;

import java.util.Random;

public class Droid {
    protected String name;
    protected int health;
    protected int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void attack(Droid opponent) {
        int actualDamage = new Random().nextInt(damage);
        System.out.println(name + " атакує " + opponent.getName() + " з нанесенням " + actualDamage + " урону.");
        opponent.takeDamage(actualDamage);
    }


    public String toString() {
        return "Дроїд{" +
                "ім'я='" + name + '\'' +
                ", здоров'я=" + health +
                ", сила=" + damage +
                '}';
    }
}