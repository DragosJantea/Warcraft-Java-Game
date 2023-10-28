import java.util.Scanner;

public abstract class Character extends Entity {
    private Inventory inventory;
    private String name;
    private int x, y;
    private int level, experience;
    private int strength, charisma, dexterity;

    public Character(Inventory inventory,
                     int health, int mana, int maximumHealth, int maximumMana,
                     int x, int y, int level, int experience) {
        super(health, mana, maximumHealth, maximumMana);
        this.experience = experience;
        this.inventory = inventory;
        this.level = level;
        this.x = x;
        this.y = y;

        strength = level;
        charisma = level;
        dexterity = level;
    }

    public static Character getCharacter(String characterType,
                                  Inventory inventory,
                                  int health, int mana, int maximumHealth, int maximumMana,
                                  int x, int y, int level, int experience) {
        if (characterType.equalsIgnoreCase("warrior"))
            return new Warrior(inventory, health, mana, maximumHealth, maximumMana, x, y, level, experience);

        if (characterType.equalsIgnoreCase("rogue"))
            return new Rogue(inventory, health, mana, maximumHealth, maximumMana, x, y, level, experience);

        return new Mage(inventory, health, mana, maximumHealth, maximumMana, x, y, level, experience);
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getStrength() {
        return strength;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getDexterity() {
        return dexterity;
    }

    public Inventory getInventory() {
        return inventory;
    }


    public boolean buyPotion(Potion potion) {
        if (inventory.getCoins() < potion.getPrice())
            return false;

        if (inventory.getRemainingWeight() < potion.getWeight())
            return false;

        inventory.addPotion(potion);
        inventory.setCoins(inventory.getCoins() - potion.getPrice());
        return true;
    }

    public void testSpell(Entity entity) throws InvalidCommandException {
        Scanner scanner = new Scanner(System.in);
        int spellIndex;

        System.out.println(this);
        System.out.println();
        System.out.println(entity);
        System.out.print("Enter the spell index: ");
        spellIndex = scanner.nextInt();

        if (spellIndex < 0 || spellIndex >= getSpells().size())
            throw new InvalidCommandException();

        useSpell(getSpells().get(spellIndex), entity);
        System.out.println(this);
        System.out.println();
        System.out.println(entity);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Character has " +
                getHealth() + " health and " + getMana() + " mana\n");

        if (getSpells().isEmpty())
            stringBuilder.append("Character doesn't have any spell!\n");
        else
            stringBuilder.append("Character has the next spells:\n");

        for (int i = 0; i < getSpells().size(); i++)
            stringBuilder.append(i + ". " + getSpells().get(i).toString());

        stringBuilder.append(inventory.toString());

        return stringBuilder.toString();
    }
}
