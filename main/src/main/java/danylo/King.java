package danylo;

import java.util.Random;

public class King extends Character {
    private static final Random random = new Random();
    
    public King() {
        super(generateRandomPower(), generateRandomHp());
    }
    
    private static int generateRandomPower() {
        return random.nextInt(11) + 5;
    }
    
    private static int generateRandomHp() {
        return random.nextInt(11) + 5;
    }
    
    @Override
    public void kick(Character c) {
        int damage = random.nextInt(this.power) + 1;
        System.out.println("King strikes " + c.getClass().getSimpleName() + " for " + damage + " damage!");
        c.takeDamage(damage);
    }
}
