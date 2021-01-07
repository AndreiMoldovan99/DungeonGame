package Main;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //game variables
        String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
        int maxEnemyHealth = 100;
        int enemyAttacDamage = 25;

        //player variables
        int health = 200;
        int attackDamage = 35;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 40; //Percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon");

        GAME:                      //label
        while(running){
            System.out.println("-------------------------------------------------"); //used as a separator

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while(enemyHealth > 0){
                System.out.println("\t Your HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\t What would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run");

                String input = in.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttacDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken + " damage back!");

                    if(health < 1){
                        System.out.println("\t? You took too much damage, you died!");
                        break;
                    }
                }
                else if(input.equals("2")){
                    if(numHealthPotions > 0){
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + " . "
                                + "\n\t> You now have " + health + "HP."
                                + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                    }
                    else{
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!");
                    }
                }
                else if(input.equals("3")){
                    System.out.print("\t> You ran away from " + enemy + "! ");
                    continue GAME; //I use the label "GAME" cuz I need the whole thing to continue from the main while, not de second one
                    //it goes again with another enemy cuz you ran away from the first one.
                }
                else{
                    System.out.println("\t Invalid command!");
                }
            }

            if(health < 1){
                System.out.println(" You died :( " + " Maybe try again. ");
                break;
            }

            System.out.println("-------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + "HP left # ");

            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
            }
            System.out.println("-------------------------------------------------");
            System.out.println(" What would you like to do? ");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit the dungeon");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid command!");
                input = in.nextLine();
            }

            if(input.equals("1")){
                System.out.println("You continue your adventure. Good luck!");
            }
            else if(input.equals("2")){
                System.out.println("You exit the dungeon alive! Congrats!");
                break;
            }
        }

        System.out.println("# # # # # # # # # # # # # # # # # # # # # #");
        System.out.println("# # # # # # THANKS FOR PLAYING! # # # # # #");
        System.out.println("# # # # # # # # # # # # # # # # # # # # # #");
    }
}
