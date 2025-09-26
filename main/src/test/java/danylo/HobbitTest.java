package danylo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HobbitTest {
    
    private Hobbit hobbit;
    private Character target;
    
    @BeforeEach
    void setUp() {
        hobbit = new Hobbit();
        target = new Elf(); // Use Elf as target for testing
    }
    
    @Test
    void testInitialStats() {
        assertEquals(0, hobbit.getPower());
        assertEquals(3, hobbit.getHp());
    }
    
    @Test
    void testKick_CallsToCry() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        hobbit.kick(target);
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("Hobbit cries: 'Wahhh! I don't want to fight!'"));
    }
    
    @Test
    void testKick_DoesNotDamageTarget() {
        int initialHp = target.getHp();
        int initialPower = target.getPower();
        
        hobbit.kick(target);
        
        assertEquals(initialHp, target.getHp());
        assertEquals(initialPower, target.getPower());
    }
    
    @Test
    void testIsAlive_WithInitialHp_ReturnsTrue() {
        assertTrue(hobbit.isAlive());
    }
    
    @Test
    void testIsAlive_WithZeroHp_ReturnsFalse() {
        hobbit.setHp(0);
        assertFalse(hobbit.isAlive());
    }
}
