package org.example.battle;

import org.example.droid.Droid;
import java.util.List;

public class TeamBattle {
    private List<Droid> team1;
    private List<Droid> team2;

    public TeamBattle(List<Droid> team1, List<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public String start() {
        StringBuilder log = new StringBuilder();
        log.append("Командний бій почався!\n");

        while (!team1.isEmpty() && !team2.isEmpty()) {
            // Вибираємо перших дроїдів з кожної команди
            Droid droid1 = team1.get(0);
            Droid droid2 = team2.get(0);

            // Бій один на один
            String battleLog = new Battle(droid1, droid2).start(); // Метод, який повертає лог бою
            log.append(battleLog);

            // Видаляємо мертвих дроїдів
            if (!droid1.isAlive()) {
                team1.remove(droid1);
            }
            if (!droid2.isAlive()) {
                team2.remove(droid2);
            }
        }

        // Визначаємо переможця
        if (!team1.isEmpty()) {
            log.append("Перемогла команда 1!\n");
        } else {
            log.append("Перемогла команда 2!\n");
        }

        return log.toString();
    }
}
