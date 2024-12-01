package org.example;


import org.example.droid.*;
import org.example. battle.*;
import org.example.util.FileUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Droid> droids = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Меню:");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Бій 1 на 1");
            System.out.println("4. Командний бій");
            System.out.println("5. Записати бій у файл");
            System.out.println("6. Відтворити бій із файлу");
            System.out.println("7. Вийти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createDroid();
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    fightOneOnOne();
                    break;
                case 4:
                    fightTeamBattle();
                    break;
                case 5:
                    saveBattleLog();
                    break;
                case 6:
                    loadBattleLog();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Неправильний вибір!");
            }
        }
    }

    private static void createDroid() {
        System.out.println("Виберіть тип дроїда: 1. Бойовий дроїд 2. Оборонний дроїд");
        int type = scanner.nextInt();
        System.out.println("Введіть ім'я дроїда:");
        String name = scanner.next();

        Droid droid = null;
        if (type == 1) {
            droid = new BattleDroid(name);
        } else if (type == 2) {
            droid = new DefenseDroid(name);
        }

        if (droid != null) {
            droids.add(droid);
            System.out.println("Дроїд створений: " + droid);
        }
    }

    private static void showDroids() {
        System.out.println("Список створених дроїдів:");
        for (Droid droid : droids) {
            System.out.println(droid);
        }
    }

    private static void fightOneOnOne() {
        if (droids.size() < 2) {
            System.out.println("Недостатньо дроїдів для бою!");
            return;
        }

        System.out.println("Виберіть два дроїди для бою (введіть їх індекси):");
        showDroids();
        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();

        Droid droid1 = droids.get(index1);
        Droid droid2 = droids.get(index2);

        Battle battle = new Battle(droid1, droid2);
        String log = battle.start();
        System.out.println(log);
    }

    private static void fightTeamBattle() {
        if (droids.size() < 4) {
            System.out.println("Недостатньо дроїдів для командного бою!");
            return;
        }

        System.out.println("Формуємо дві команди по два дроїди:");
        showDroids();

        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println("Виберіть дроїда для команди 1:");
            int index = scanner.nextInt();
            team1.add(droids.get(index));
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Виберіть дроїда для команди 2:");
            int index = scanner.nextInt();
            team2.add(droids.get(index));
        }TeamBattle teamBattle = new TeamBattle(team1, team2);
        String log = teamBattle.start();
        System.out.println(log);
    }
    private static void saveBattleLog() {
        System.out.println("Введіть ім'я файлу для збереження:");
        String filename = scanner.next();
        System.out.println("Введіть запис бою:");
        scanner.nextLine();
        String log = scanner.nextLine();

        FileUtils.saveBattleLog(log, filename);
        System.out.println("Бій збережено у файл " + filename);
    }

    private static void loadBattleLog() {
        System.out.println("Введіть ім'я файлу для відтворення:");
        String filename = scanner.next();
        String log = FileUtils.loadBattleLog(filename);
        System.out.println("Відтворення бою з файлу:");
        System.out.println(log);
    }
}