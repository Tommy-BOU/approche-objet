package fr.diginamic.combat;

import javax.management.InstanceAlreadyExistsException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
    static Random random = new Random();

    static Player currentCharacter;

    public static void startGame() {
        displayMenu();
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MENU PRINCIPAL");
        System.out.println("----------------");
        if (currentCharacter != null) {
            System.out.println("Personnage :");
            System.out.println("Points de vies : " + currentCharacter.getHitPoints());
            System.out.println("Force : " + currentCharacter.getStrength());
            System.out.println("----------------");
        }
        System.out.println("Choisissez une option :");
        System.out.println("1 - Créer un personnage.");
        if (currentCharacter != null) {
            System.out.println("2 - Combattre une créature");
            System.out.println("3 - Prendre une potion");
            System.out.println("4 - Afficher le score");
        }
        System.out.println("5 - Sortir");

        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                createCharacter();
                break;
            case 2:
                startFight(randomEnemy());
                break;
            case 3:
                potionMenu();
                break;
            case 4:
                displayScore();
                break;
            default:
                displayMenu();
        }
    }

    public static void createCharacter() {
        if (currentCharacter == null || currentCharacter.getHitPoints() <= 0) {
            int hitPoints = random.nextInt(31) + 20;
            int strength = random.nextInt(7) + 12;
            currentCharacter = new Player(hitPoints, strength);
        } else {
            System.out.println("Vous avez déjà crée un personnage !");
        }
        displayMenu();
    }

    public static void startFight(Enemy enemy) {
        boolean fightIsOn = true;

        if (currentCharacter.getHitPoints() <= 0) {
            System.out.println("Votre personnage est décédé. Il a obtenu le score de " + currentCharacter.getScore() + " points. Veuillez créer un nouveau personnage");
        } else {
            System.out.println(enemy.combatIntro());
            while (fightIsOn) {
                int playerStrength = currentCharacter.getStrength() + random.nextInt(10) + 1;
                int enemyStrenght = enemy.getStrength() + random.nextInt(10) + 1;

                System.out.println("Jet de force du joueur : " + playerStrength);
                System.out.println("Jet de force du " + enemy + " : " + enemyStrenght);
                if (playerStrength > enemyStrenght) {
                    int damage = playerStrength - enemyStrenght;
                    enemy.takeDamage(damage);
                    System.out.println("Le joueur remporte le tour et inflige " + damage + " points de dégats au " + enemy);
                } else if (enemyStrenght > playerStrength) {
                    int damage = enemyStrenght - playerStrength;
                    currentCharacter.takeDamage(damage);
                    System.out.println("L'ennemi remporte le tour et inflige " + damage + " points de dégats au joueur");
                } else {
                    System.out.println("Aucun combattant n'inflige de dégats ce tour ci.");
                }

                System.out.println("Points de vie restant au " + enemy + " : " + enemy.getHitPoints());
                System.out.println("Points de vie restant au joueur : " + currentCharacter.getHitPoints());

                if (currentCharacter.getHitPoints() <= 0) {
                    fightIsOn = false;
                    System.out.println("Vous avez péri au combat");
                } else if (enemy.getHitPoints() <= 0) {
                    fightIsOn = false;
                    System.out.println("Vous avez gagner et remportez " + enemy.getScoreValue() + " points !");

                    int rewardValue = random.nextInt(101);

                    if (rewardValue % 2 == 0) {
                        System.out.println("La chance vous sourit et vous gagnez une récompense !");
                        System.out.println(getRandomReward());
                    }

                    currentCharacter.addScore(enemy.getScoreValue());
                }
            }
        }
        currentCharacter.turnsBoost--;
        if (currentCharacter.turnsBoost <= 0){
            currentCharacter.resetStrength();
        }
        displayMenu();
    }

    public static String getRandomReward() {
        int rewardNum = random.nextInt(4);

        return switch (rewardNum) {
            case 0 -> {
                currentCharacter.numOfHealthPotions++;
                yield "Vous recevez une potion de soin !";
            }
            case 1 -> {
                currentCharacter.numOfMinorAttackPotion++;
                yield "Vous recevez une potion d'attaque mineure !";
            }
            case 2 -> {
                currentCharacter.numOfMajorAttackPotion++;
                yield "Vous recevez une potion d'attaque majeure !";
            }
            default -> {
                currentCharacter.addScore(5);
                yield "Vous gagnez 5 points de score !";
            }
        };
    }

    public static Enemy randomEnemy() {
        int randomChar = random.nextInt(3);
        return switch (randomChar) {
            case 0 -> new Wolf(random.nextInt(6) + 5, random.nextInt(6) + 3);
            case 1 -> new Goblin(random.nextInt(6) + 10, random.nextInt(6) + 5);
            default -> new Troll(random.nextInt(11) + 20, random.nextInt(6) + 10);
        };
    }

    public static void potionMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("POTIONS");
        System.out.println("Choisissez une potion :");
        System.out.println("1 - Potion de soin (" + currentCharacter.numOfHealthPotions + ")");
        System.out.println("2 - Potion d'attaque mineure (" + currentCharacter.numOfMinorAttackPotion + ")");
        System.out.println("3 - Potion d'attaque majeure (" + currentCharacter.numOfMajorAttackPotion + ")");
        System.out.println("4 - retour");

        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                if (currentCharacter.numOfHealthPotions > 0) {
                    currentCharacter.heal(random.nextInt(6) + 5);
                    currentCharacter.numOfHealthPotions--;
                } else {
                    System.out.println("Vous ne possédez pas cette potion !");
                }
                displayMenu();
                break;
            case 2:
                if (currentCharacter.numOfMinorAttackPotion > 0) {
                    currentCharacter.boostStrength(3 , 1);
                    currentCharacter.numOfMinorAttackPotion--;
                } else {
                    System.out.println("Vous ne possédez pas cette potion !");
                }
                displayMenu();
                break;
            case 3:
                if (currentCharacter.numOfMajorAttackPotion > 0) {
                    currentCharacter.boostStrength(5, 2);
                    currentCharacter.numOfMajorAttackPotion--;
                } else {
                    System.out.println("Vous ne possédez pas cette potion !");
                }
                displayMenu();
                break;
            default:
                displayMenu();
                break;
        }
    }

    public static void displayScore() {
        System.out.println("Votre score actuel est de : " + currentCharacter.getScore());
        displayMenu();
    }
}
