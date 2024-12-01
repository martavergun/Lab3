package org.example.droid;

public class BattleDroid  extends Droid{
    public BattleDroid(String name) {
        super(name, 100, 30);
    }

    public String toString() {
        return "BattleDroid{" +
                "ім'я='" + name + '\'' +
                ", здоров'я=" + health +
                ", сила=" + damage +
                '}';
    }
}