import java.util.Random;

public class Warrior extends Character {
    public Warrior(Inventory inventory, int health, int mana, int maximumHealth, int maximumMana, int x, int y, int level, int experience) {
        super(inventory, health, mana, maximumHealth, maximumMana, x, y, level, experience);
        getInventory().setMaximumWeight(getInventory().getMaximumWeight() + 50);
        setStrength(2 * getStrength());
        setFire(true);
    }

    @Override
    public void receiveDamage(int damage) {
        if (new Random().nextInt(100) > getDexterity() + getCharisma())
            setHealth(Math.max(0, getHealth() - damage / 2));
        else
            setHealth(Math.max(0, getHealth() - damage));
    }

    @Override
    public int getDamage() {
        int damage = 10 + new Random().nextInt(25);

        if (new Random().nextInt(100) > getStrength())
            return 2 * damage;

        return damage;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
