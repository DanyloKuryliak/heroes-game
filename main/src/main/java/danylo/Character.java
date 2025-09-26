package danylo;

public abstract class Character {
    protected int power;
    protected int hp;
    
    public Character(int power, int hp) {
        this.power = power;
        this.hp = hp;
    }
    
    public abstract void kick(Character c);
    
    public boolean isAlive() {
        return hp > 0;
    }
    
    public int getPower() {
        return power;
    }
    
    public int getHp() {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void setPower(int power) {
        this.power = power;
    }
    
    public void takeDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{power=" + power + ", hp=" + hp + "}";
    }
}
