import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inventory {
    private List<Potion> potions;
    private int maximumWeight;
    private int coins;

    public Inventory(int maximumWeight, int coins) {
        this.maximumWeight = maximumWeight;
        this.coins = coins;

        potions = new ArrayList<>();
    }

    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public int getMaximumWeight() {
        return maximumWeight;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void addPotion(Potion potion) {
        potions.add(potion);
        potions.sort(Test.potionComparator);
    }

    public void removePotion(Potion potion) {
        potions.remove(potion);
    }

    public int getRemainingWeight() {
        int remainingWeight = maximumWeight;

        for (int i = 0; i < potions.size(); i++)
            remainingWeight -= potions.get(i).getWeight();

        return remainingWeight;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (potions.isEmpty())
            stringBuilder.append("Inventory doesn't contain any potion!");
        else
            stringBuilder.append("Inventory contains:\n");

        for (int i = 0; i < potions.size(); i++)
            stringBuilder.append(i + ". " + potions.get(i).toString());

        stringBuilder.append("\nRemaining coins: " + coins +
                "\nRemaining weight: " + getRemainingWeight() + "\n");

        return stringBuilder.toString();
    }
}
