package danylo;

import java.util.Random;

public class Knight extends Character {
    private static final Random random = new Random();
    
    public Knight() {
        super(generateRandomPower(), generateRandomHp());
    }
    
    private static int generateRandomPower() {
        return random.nextInt(11) + 2;
    }
    
    private static int generateRandomHp() {
        return random.nextInt(11) + 2;
    }
    
    @Override
    public void kick(Character c) {
        int damage = random.nextInt(this.power) + 1;
        System.out.println("Knight strikes " + c.getClass().getSimpleName() + " for " + damage + " damage!");
        c.takeDamage(damage);
    }
}
