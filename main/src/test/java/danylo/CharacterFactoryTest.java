package danylo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterFactoryTest {
    
    @Test
    void testCreateCharacter_ReturnsNotNull() {
        Character character = CharacterFactory.createCharacter();
        assertNotNull(character);
    }
    
    @Test
    void testCreateCharacter_ReturnsValidCharacterType() {
        Character character = CharacterFactory.createCharacter();
        assertTrue(character instanceof Hobbit || 
                  character instanceof Elf || 
                  character instanceof King || 
                  character instanceof Knight);
    }
    
    @RepeatedTest(50)
    void testCreateCharacter_ReturnsAllCharacterTypes() {
        Character character = CharacterFactory.createCharacter();
        assertTrue(character instanceof Hobbit || 
                  character instanceof Elf || 
                  character instanceof King || 
                  character instanceof Knight);
    }
    
    @Test
    void testCreateCharacter_CanCreateHobbit() {
        boolean foundHobbit = false;
        for (int i = 0; i < 100; i++) {
            Character character = CharacterFactory.createCharacter();
            if (character instanceof Hobbit) {
                foundHobbit = true;
                break;
            }
        }
        assertTrue(foundHobbit, "Should be able to create Hobbit");
    }
    
    @Test
    void testCreateCharacter_CanCreateElf() {
        boolean foundElf = false;
        for (int i = 0; i < 100; i++) {
            Character character = CharacterFactory.createCharacter();
            if (character instanceof Elf) {
                foundElf = true;
                break;
            }
        }
        assertTrue(foundElf, "Should be able to create Elf");
    }
    
    @Test
    void testCreateCharacter_CanCreateKing() {
        boolean foundKing = false;
        for (int i = 0; i < 100; i++) {
            Character character = CharacterFactory.createCharacter();
            if (character instanceof King) {
                foundKing = true;
                break;
            }
        }
        assertTrue(foundKing, "Should be able to create King");
    }
    
    @Test
    void testCreateCharacter_CanCreateKnight() {
        boolean foundKnight = false;
        for (int i = 0; i < 100; i++) {
            Character character = CharacterFactory.createCharacter();
            if (character instanceof Knight) {
                foundKnight = true;
                break;
            }
        }
        assertTrue(foundKnight, "Should be able to create Knight");
    }
    
    @Test
    void testCreateCharacter_CharactersAreAlive() {
        Character character = CharacterFactory.createCharacter();
        assertTrue(character.isAlive());
    }
    
    @Test
    void testCreateCharacter_CharactersHaveValidStats() {
        Character character = CharacterFactory.createCharacter();
        assertTrue(character.getHp() > 0);
        assertTrue(character.getPower() >= 0);
    }
}
