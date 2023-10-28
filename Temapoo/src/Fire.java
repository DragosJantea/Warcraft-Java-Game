public class Fire extends Spell {
    public Fire(int damage, int mana) {
        super(damage, mana);
    }

    @Override
    public void visit(Entity entity) {
        if (!entity.getFire())
            entity.receiveDamage(getDamage());
    }

    public String toString() {
        return new String("Fire: damage(" + getDamage() + "), mana(" + getMana() + ")\n");
    }
}
