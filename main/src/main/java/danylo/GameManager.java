package danylo;

public class GameManager {
    
    public static void fight(Character c1, Character c2) {
        System.out.println("=== BATTLE BEGINS ===");
        System.out.println("Fighter 1: " + c1);
        System.out.println("Fighter 2: " + c2);
        System.out.println();
        
        int round = 1;
        
        while (c1.isAlive() && c2.isAlive()) {
            System.out.println("--- Round " + round + " ---");
            
            System.out.print("Fighter 1 attacks: ");
            c1.kick(c2);
            System.out.println("Fighter 2 status: " + c2);
            
            if (!c2.isAlive()) {
                System.out.println("Fighter 2 has been defeated!");
                break;
            }
            
            System.out.print("Fighter 2 attacks: ");
            c2.kick(c1);
            System.out.println("Fighter 1 status: " + c1);
            
            if (!c1.isAlive()) {
                System.out.println("Fighter 1 has been defeated!");
                break;
            }



            
            
            System.out.println();
            round++;
            
            if (round > 100) {
                System.out.println("Battle ended in a draw after 100 rounds!");
                break;
            }
        }
        
        System.out.println("=== BATTLE ENDS ===");
        if (c1.isAlive()) {
            System.out.println("Winner: Fighter 1 - " + c1.getClass().getSimpleName());
        } else if (c2.isAlive()) {
            System.out.println("Winner: Fighter 2 - " + c2.getClass().getSimpleName());
        } else {
            System.out.println("Both fighters have been defeated!");
        }
        System.out.println();
    }
}
