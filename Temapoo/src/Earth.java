public class Earth extends Spell {
    public Earth(int damage, int mana) {
        super(damage, mana);
    }

    @Override
    public void visit(Entity entity) {
        if (!entity.getEarth())
            entity.receiveDamage(getDamage());
    }

    public String toString() {
        return new String("Earth: damage(" + getDamage() + "), mana(" + getMana() + ")\n");
    }
}
