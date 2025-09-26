package danylo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameManagerTest {
    
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    
    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    void testFight_WithDeadCharacter_EndsImmediately() {
        Character alive = new Elf();
        Character dead = new Hobbit();
        dead.setHp(0);
        
        GameManager.fight(alive, dead);
        
        String output = outputStream.toString();
        assertTrue(output.contains("BATTLE BEGINS"));
        assertTrue(output.contains("BATTLE ENDS"));
        assertTrue(output.contains("Winner: Fighter 1 - Elf"));
    }
    
    @Test
    void testFight_WithBothDeadCharacters_EndsImmediately() {
        Character dead1 = new Hobbit();
        Character dead2 = new Hobbit();
        dead1.setHp(0);
        dead2.setHp(0);
        
        GameManager.fight(dead1, dead2);
        
        String output = outputStream.toString();
        assertTrue(output.contains("BATTLE BEGINS"));
        assertTrue(output.contains("BATTLE ENDS"));
        assertTrue(output.contains("Both fighters have been defeated!"));
    }
    
    @Test
    void testFight_WithAliveCharacters_ContinuesBattle() {
        Character fighter1 = new Elf();
        Character fighter2 = new Elf(); // Use two Elves so they don't kill each other immediately
        
        GameManager.fight(fighter1, fighter2);
        
        String output = outputStream.toString();
        assertTrue(output.contains("BATTLE BEGINS"));
        assertTrue(output.contains("Round 1"));
        assertTrue(output.contains("Fighter 1 attacks:"));
        assertTrue(output.contains("Fighter 2 attacks:"));
        assertTrue(output.contains("BATTLE ENDS"));
    }
    
    @Test
    void testFight_PrintsCharacterStats() {
        Character fighter1 = new Elf();
        Character fighter2 = new Hobbit();
        
        GameManager.fight(fighter1, fighter2);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Fighter 1: Elf{power=10, hp=10}"));
        assertTrue(output.contains("Fighter 2: Hobbit{power=0, hp=3}"));
    }
    
    @Test
    void testFight_WithHobbitVsHobbit_EndsInDraw() {
        Character hobbit1 = new Hobbit();
        Character hobbit2 = new Hobbit();
        
        GameManager.fight(hobbit1, hobbit2);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Battle ended in a draw after 100 rounds!"));
        assertTrue(output.contains("Winner: Fighter 1 - Hobbit"));
    }
    
    @Test
    void testFight_ElfVsHobbit_ElfWins() {
        Character elf = new Elf();
        Character hobbit = new Hobbit();
        
        GameManager.fight(elf, hobbit);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Elf kills Hobbit with a powerful strike!"));
        assertTrue(output.contains("Winner: Fighter 1 - Elf"));
    }
    
    @Test
    void testFight_PrintsRoundNumbers() {
        Character fighter1 = new Elf();
        Character fighter2 = new Hobbit();
        
        GameManager.fight(fighter1, fighter2);
        
        String output = outputStream.toString();
        assertTrue(output.contains("--- Round 1 ---"));
    }
    
    @Test
    void testFight_PrintsStatusAfterEachAttack() {
        Character fighter1 = new Elf();
        Character fighter2 = new Elf();
        
        GameManager.fight(fighter1, fighter2);
        
        String output = outputStream.toString();
        assertTrue(output.contains("Fighter 2 status:"));
        assertTrue(output.contains("Fighter 1 status:"));
    }
}
