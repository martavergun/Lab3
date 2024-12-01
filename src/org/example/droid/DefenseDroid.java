package org.example.droid;

public class DefenseDroid  extends Droid {
    public DefenseDroid(String name) {
        super(name, 150, 20);
    }
    public String toString() {
        return "DefenseDroid{" +
                "ім'я='" + name + '\'' +
                ", здоров'я=" + health +
                ", сила=" + damage +
                '}';
    }
}