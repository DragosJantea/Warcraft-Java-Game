import java.util.*;

public class Shop implements CellElement {
    private List<Potion> potions;

    public Shop() {
        List<Potion> potions = new ArrayList<>();
        int noOfPotions = 1 + new Random().nextInt(10);

        for (int i = 1; i <= noOfPotions; i++)
            potions.add(generateRandomPotion());

        potions.sort(Test.potionComparator);
        this.potions = potions;
    }

    public Potion generateRandomPotion() {
        int potionType = new Random().nextInt(10);
        int potionPrice = 10 + new Random().nextInt(90);
        int potionWeight = potionPrice + new Random().nextInt(10);
        int potionValue = potionWeight + new Random().nextInt(10);

        if (potionType % 2 == 0)
            return new HealthPotion(potionPrice, potionWeight, potionValue);

        return new ManaPotion(potionPrice, potionWeight, potionValue);
    }

    public Potion select(int index) {
        if (index >= 0 && index < potions.size())
            return potions.remove(index);

        return null;
    }

    public void testPotion(Entity entity) throws InvalidCommandException {
        Scanner scanner = new Scanner(System.in);
        int potionIndex;

        System.out.println(this);
        System.out.println();
        System.out.println(entity);
        System.out.print("Enter the potion index: ");
        potionIndex = scanner.nextInt();

        if (potionIndex < 0 || potionIndex >= potions.size())
            throw new InvalidCommandException();

        select(potionIndex).use(entity);
        System.out.println(entity);
    }

    public void testShop(Character character) throws InvalidCommandException {
        Scanner scanner = new Scanner(System.in);
        int potionIndex;

        System.out.println(this);
        System.out.println();
        System.out.println(character.getInventory());
        System.out.print("Enter the potion index: ");
        potionIndex = scanner.nextInt();

        if (potionIndex < 0 || potionIndex >= potions.size())
            throw new InvalidCommandException();

        Potion potion = potions.get(potionIndex);

        if (character.buyPotion(potion))
            potions.remove(potionIndex);

        System.out.println(this);
        System.out.println();
        System.out.println(character.getInventory());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Shop contains:\n");

        for (int i = 0; i < potions.size(); i++)
            stringBuilder.append(i + ". " + potions.get(i).toString());

        return stringBuilder.toString();
    }

    @Override
    public char toCharacter() {
        return 'S';
    }
}
