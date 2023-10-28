public class ManaPotion implements Potion {
    private int price, weight, value;

    public ManaPotion(int price, int weight, int value) {
        this.price = price;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public void use(Entity entity) {
        entity.regenerateMana(value);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String toString() {
        return new String("Mana potion:\n" +
                "\t-> price: " + price + "\n" +
                "\t-> weight: " + weight + "\n" +
                "\t-> value: " + value + "\n");
    }
}
