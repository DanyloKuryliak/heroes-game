package danylo;

public class Elf extends Character {
    
    public Elf() {
        super(10, 10);
    }
    
    @Override
    public void kick(Character c) {
        if (c.getPower() < this.power) {
            System.out.println("Elf kills " + c.getClass().getSimpleName() + " with a powerful strike!");
            c.setHp(0);
        } else {
            System.out.println("Elf weakens " + c.getClass().getSimpleName() + "! Power decreased by 1.");
            c.setPower(c.getPower() - 1);
        }
    }
}
