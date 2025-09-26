package danylo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ElfTest {
    
    private Elf elf;
    private Character weakerTarget;
    private Character strongerTarget;
    
    @BeforeEach
    void setUp() {
        elf = new Elf();
        weakerTarget = new Hobbit(); // power = 0, weaker than elf
        strongerTarget = new King(); // power = 5-15, might be stronger
    }
    
    @Test
    void testInitialStats() {
        assertEquals(10, elf.getPower());
        assertEquals(10, elf.getHp());
    }
    
    @Test
    void testKick_AgainstWeakerEnemy_KillsEnemy() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        elf.kick(weakerTarget);
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("Elf kills Hobbit with a powerful strike!"));
        assertEquals(0, weakerTarget.getHp());
    }
    
    @Test
    void testKick_AgainstStrongerEnemy_DecreasesPower() {
        // Ensure target is stronger
        strongerTarget.setPower(15);
        int initialPower = strongerTarget.getPower();
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        elf.kick(strongerTarget);
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("Elf weakens") && output.contains("Power decreased by 1"));
        assertEquals(initialPower - 1, strongerTarget.getPower());
    }
    
    @Test
    void testKick_AgainstEqualPowerEnemy_DecreasesPower() {
        Character equalTarget = new Elf();
        int initialPower = equalTarget.getPower();
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        elf.kick(equalTarget);
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("Elf weakens") && output.contains("Power decreased by 1"));
        assertEquals(initialPower - 1, equalTarget.getPower());
    }
    
    @Test
    void testIsAlive_WithInitialHp_ReturnsTrue() {
        assertTrue(elf.isAlive());
    }
    
    @Test
    void testIsAlive_WithZeroHp_ReturnsFalse() {
        elf.setHp(0);
        assertFalse(elf.isAlive());
    }
}
