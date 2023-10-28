public class HealthPotion implements Potion {
    private int price, weight, value;

    public HealthPotion(int price, int weight, int value) {
        this.price = price;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public void use(Entity entity) {
        entity.regenerateHealth(value);
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
        return new String("Health potion:\n" +
                "\t-> price: " + price + "\n" +
                "\t-> weight: " + weight + "\n" +
                "\t-> value: " + value + "\n");
    }
}
