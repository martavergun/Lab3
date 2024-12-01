package org.example.battle;

import org.example.droid.Droid;

public class Battle {
    private Droid droid1;
    private Droid droid2;

    public Battle(Droid droid1, Droid droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
    }

    public String start() {
        StringBuilder log = new StringBuilder();
        log.append("Бій між ").append(droid1.getName()).append(" та ").append(droid2.getName()).append(" почався!\n");

        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.attack(droid2);
            if (!droid2.isAlive()) {
                log.append(droid2.getName()).append(" зазнав поразки!\n");
                break;
            }

            droid2.attack(droid1);
            if (!droid1.isAlive()) {
                log.append(droid1.getName()).append(" зазнав поразки!\n");
                break;
            }
        }

        if (droid1.isAlive()) {
            log.append("Переможець: ").append(droid1.getName()).append("\n");
        } else {
            log.append("Переможець: ").append(droid2.getName()).append("\n");
        }

        return log.toString();
    }
}