package danylo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class KingTest {
    
    private King king;
    private Character target;
    
    @BeforeEach
    void setUp() {
        king = new King();
        target = new Hobbit();
    }
    
    @Test
    void testInitialStats_WithinRange() {
        assertTrue(king.getPower() >= 5 && king.getPower() <= 15);
        assertTrue(king.getHp() >= 5 && king.getHp() <= 15);
    }
    
    @RepeatedTest(10)
    void testInitialStats_Randomness() {
        King newKing = new King();
        assertTrue(newKing.getPower() >= 5 && newKing.getPower() <= 15);
        assertTrue(newKing.getHp() >= 5 && newKing.getHp() <= 15);
    }
    
    @Test
    void testKick_DamageWithinRange() {
        int initialHp = target.getHp();
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        king.kick(target);
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("King strikes") && output.contains("damage!"));
        
        int damage = initialHp - target.getHp();
        assertTrue(damage >= 1 && damage <= king.getPower());
    }
    
    @RepeatedTest(20)
    void testKick_DamageRandomness() {
        Character testTarget = new Hobbit();
        int initialHp = testTarget.getHp();
        
        king.kick(testTarget);
        
        int damage = initialHp - testTarget.getHp();
        assertTrue(damage >= 1 && damage <= king.getPower());
    }
    
    @Test
    void testKick_DoesNotExceedTargetHp() {
        target.setHp(1);
        int initialHp = target.getHp();
        
        king.kick(target);
        
        assertTrue(target.getHp() >= 0);
        assertTrue(target.getHp() <= initialHp);
    }
    
    @Test
    void testIsAlive_WithInitialHp_ReturnsTrue() {
        assertTrue(king.isAlive());
    }
    
    @Test
    void testIsAlive_WithZeroHp_ReturnsFalse() {
        king.setHp(0);
        assertFalse(king.isAlive());
    }
}
