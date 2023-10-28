import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {
    private static Game instance;
    private Grid<Cell> grid;

    private Map<Cell.Type, List<String>> stories;
    private List<Account> accounts;

    private Game() {
        Inventory inventory = new Inventory(50, 50);
        Character character = new Warrior(inventory,
                100, 100, 100, 100,
                0, 0, 1, 0);

        grid = Grid.generate(character, 8, 8);
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();

        return instance;
    }

    public void run() throws InvalidCommandException, IOException, InterruptedException {
        Test.parseJsonFiles();

        stories = Test.stories;
        accounts = Test.accounts;

         //Test.testPotion();
       //Test.testSpell();
        // Test.testShop();
       // Test.testPlayerEnemy();
    }

    public String getRandomStory(Cell.Type type) {
        return stories.get(type).get(new Random().nextInt(stories.get(type).size()));
    }
}
