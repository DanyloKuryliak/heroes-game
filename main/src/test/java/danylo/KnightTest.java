package danylo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class KnightTest {
    
    private Knight knight;
    private Character target;
    
    @BeforeEach
    void setUp() {
        knight = new Knight();
        target = new Hobbit();
    }
    
    @Test
    void testInitialStats_WithinRange() {
        assertTrue(knight.getPower() >= 2 && knight.getPower() <= 12);
        assertTrue(knight.getHp() >= 2 && knight.getHp() <= 12);
    }
    
    @RepeatedTest(10)
    void testInitialStats_Randomness() {
        Knight newKnight = new Knight();
        assertTrue(newKnight.getPower() >= 2 && newKnight.getPower() <= 12);
        assertTrue(newKnight.getHp() >= 2 && newKnight.getHp() <= 12);
    }
    
    @Test
    void testKick_DamageWithinRange() {
        int initialHp = target.getHp();
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        knight.kick(target);
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("Knight strikes") && output.contains("damage!"));
        
        int damage = initialHp - target.getHp();
        assertTrue(damage >= 1 && damage <= knight.getPower());
    }
    
    @RepeatedTest(20)
    void testKick_DamageRandomness() {
        Character testTarget = new Hobbit();
        int initialHp = testTarget.getHp();
        
        knight.kick(testTarget);
        
        int damage = initialHp - testTarget.getHp();
        assertTrue(damage >= 1 && damage <= knight.getPower());
    }
    
    @Test
    void testKick_DoesNotExceedTargetHp() {
        target.setHp(1);
        int initialHp = target.getHp();
        
        knight.kick(target);
        
        assertTrue(target.getHp() >= 0);
        assertTrue(target.getHp() <= initialHp);
    }
    
    @Test
    void testIsAlive_WithInitialHp_ReturnsTrue() {
        assertTrue(knight.isAlive());
    }
    
    @Test
    void testIsAlive_WithZeroHp_ReturnsFalse() {
        knight.setHp(0);
        assertFalse(knight.isAlive());
    }
}
