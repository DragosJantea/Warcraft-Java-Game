public class Ice extends Spell {
    public Ice(int damage, int mana) {
        super(damage, mana);
    }

    @Override
    public void visit(Entity entity) {
        if (!entity.getIce())
            entity.receiveDamage(getDamage());
    }

    public String toString() {
        return new String("Ice: damage(" + getDamage() + "), mana(" + getMana() + ")\n");
    }
}
