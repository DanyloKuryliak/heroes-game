package danylo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    
    // Concrete test implementation of Character
    private static class TestCharacter extends Character {
        public TestCharacter(int power, int hp) {
            super(power, hp);
        }
        
        @Override
        public void kick(Character c) {
            // Simple test implementation
            c.takeDamage(1);
        }
    }
    
    private TestCharacter character;
    
    @BeforeEach
    void setUp() {
        character = new TestCharacter(10, 20);
    }
    
    @Test
    void testIsAlive_WithPositiveHp_ReturnsTrue() {
        assertTrue(character.isAlive());
    }
    
    @Test
    void testIsAlive_WithZeroHp_ReturnsFalse() {
        character.setHp(0);
        assertFalse(character.isAlive());
    }
    
    @Test
    void testIsAlive_WithNegativeHp_ReturnsFalse() {
        character.setHp(-1);
        assertFalse(character.isAlive());
    }
    
    @Test
    void testTakeDamage_ReducesHpCorrectly() {
        character.takeDamage(5);
        assertEquals(15, character.getHp());
    }
    
    @Test
    void testTakeDamage_DoesNotGoBelowZero() {
        character.takeDamage(25);
        assertEquals(0, character.getHp());
    }
    
    @Test
    void testGettersAndSetters() {
        character.setPower(15);
        character.setHp(30);
        
        assertEquals(15, character.getPower());
        assertEquals(30, character.getHp());
    }
    
    @Test
    void testToString_ContainsClassNameAndStats() {
        String result = character.toString();
        assertTrue(result.contains("TestCharacter"));
        assertTrue(result.contains("power=10"));
        assertTrue(result.contains("hp=20"));
    }
}
