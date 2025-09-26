package danylo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HEROES GAME ===");
        System.out.println("Welcome to the text-based heroes battle game!");
        System.out.println();
        
        Character fighter1 = CharacterFactory.createCharacter();
        Character fighter2 = CharacterFactory.createCharacter();
        
        GameManager.fight(fighter1, fighter2);
        
        System.out.println("Game finished. Thanks for playing!");
    }
}