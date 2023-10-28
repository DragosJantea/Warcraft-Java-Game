import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Entity implements Element {
    private int health, mana;
    private int maximumHealth, maximumMana;
    private boolean earth, ice, fire;
    private List<Spell> spells;

    public Entity(int health, int mana, int maximumHealth, int maximumMana) {
        this.health = health;
        this.mana = mana;

        this.maximumHealth = maximumHealth;
        this.maximumMana = maximumMana;

        List<Spell> spells = new ArrayList<>();
        int noOfSpells = 1 + new Random().nextInt(4);

        for (int i = 1; i <= noOfSpells; i++)
            spells.add(generateRandomSpell());

        spells.sort(Test.spellComparator);
        this.spells = spells;
    }
    public Spell generateRandomSpell() {
        int potionType = new Random().nextInt(30);
        int spellDamage = 10 + new Random().nextInt(90);
        int spellMana = spellDamage + new Random().nextInt(10);

        if (potionType % 3 == 0)
            return new Fire(spellDamage, spellMana);

        if (potionType % 3 == 1)
            return new Ice(spellDamage, spellMana);

        return new Earth(spellDamage, spellMana);
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public int getMaximumMana() {
        return maximumMana;
    }

    public boolean getEarth() {
        return earth;
    }

    public boolean getIce() {
        return ice;
    }

    public boolean getFire() {
        return fire;
    }

    public void setHealth(int health) {
        this.health = Math.min(health, maximumHealth);
    }

    public void setEarth(boolean earth) {
        this.earth = earth;
    }

    public void setIce(boolean ice) {
        this.ice = ice;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setMana(int mana) {
        mana = Math.min(mana, maximumMana);
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public void regenerateHealth(int value) {
        health = Math.min(maximumHealth, health + value);
    }

    public void regenerateMana(int value) {
        mana = Math.min(maximumMana, mana + value);
    }

    public void useSpell(Spell spell, Entity entity) {
        if (spell.getMana() <= mana) {
            entity.accept(spell);
            mana -= spell.getMana();
            spells.remove(spell);
        }
    }

    public abstract void receiveDamage(int damage);

    public abstract int getDamage();
}
