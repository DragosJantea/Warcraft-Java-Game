public abstract class Spell implements Visitor {
    private int damage, mana;

    public Spell(int damage, int mana) {
        this.damage = damage;
        this.mana = mana;
    }

    public int getDamage() {
        return damage;
    }

    public int getMana() {
        return mana;
    }
}
