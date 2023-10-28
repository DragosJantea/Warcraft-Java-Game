import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Test {
    public static Map<Cell.Type, List<String>> stories;
    public static List<Account> accounts;

    public static Comparator<Potion> potionComparator = new Comparator<Potion>() {
        @Override
        public int compare(Potion potion1, Potion potion2) {
            if (potion1.getPrice() < potion2.getPrice())
                return -1;

            if (potion1.getPrice() > potion2.getPrice())
                return 1;

            if (potion1.getWeight() < potion2.getWeight())
                return -1;

            if (potion1.getWeight() > potion2.getWeight())
                return 1;

            if (potion1.getValue() > potion2.getValue())
                return -1;

            return 1;
        }
    };

    public static Comparator<Spell> spellComparator = new Comparator<Spell>() {
        @Override
        public int compare(Spell spell1, Spell spell2) {
            if (spell1.getMana() < spell2.getMana())
                return -1;

            if (spell1.getMana() > spell2.getMana())
                return 1;

            if (spell1.getDamage() > spell2.getDamage())
                return -1;

            return 1;
        }
    };

    public static void parseJsonFiles() throws IOException, InvalidCommandException {
        // Parse stories
        stories = new HashMap<>();

        String storiesJsonContent = Files.readString(Paths.get("stories.json"));
        JSONArray storiesJson = new JSONObject(storiesJsonContent).getJSONArray("stories");

        for (int i = 0; i < storiesJson.length(); i++) {
            String typeJson = storiesJson.getJSONObject(i).getString("type");
            String valueJson = storiesJson.getJSONObject(i).getString("value");

            if (!stories.containsKey(Cell.convertStringToType(typeJson)))
                stories.put(Cell.convertStringToType(typeJson), new ArrayList<>());

            stories.get(Cell.convertStringToType(typeJson)).add(valueJson);
        }

        // Parse accounts
        accounts = new ArrayList<>();

        String accountsJsonContent = Files.readString(Paths.get("accounts.json"));
        JSONArray accountsJson = new JSONObject(accountsJsonContent).getJSONArray("accounts");

        for (int i = 0; i < accountsJson.length(); i++) {
            String emailJson = accountsJson.getJSONObject(i).getJSONObject("credentials").getString("email");
            String passwordJson = accountsJson.getJSONObject(i).getJSONObject("credentials").getString("password");

            String accountNameJson = accountsJson.getJSONObject(i).getString("name");
            String countryJson = accountsJson.getJSONObject(i).getString("country");

            int noOfGamesJson = accountsJson.getJSONObject(i).getInt("maps_completed");
            List<String> games = new ArrayList<>();

            for (int j = 0; j < accountsJson.getJSONObject(i).getJSONArray("favorite_games").length(); j++)
                games.add(accountsJson.getJSONObject(i).getJSONArray("favorite_games").getString(j));

            List<Character> characters = new ArrayList<>();
            Inventory inventory = new Inventory(100, 100);

            for (int j = 0; j < accountsJson.getJSONObject(i).getJSONArray("characters").length(); j++) {
                String characterNameJson = accountsJson.getJSONObject(i).getJSONArray("characters").getJSONObject(j).getString("name");
                String professionJson = accountsJson.getJSONObject(i).getJSONArray("characters").getJSONObject(j).getString("profession");

                int levelJson = accountsJson.getJSONObject(i).getJSONArray("characters").getJSONObject(j).getInt("level");
                int experienceJson = accountsJson.getJSONObject(i).getJSONArray("characters").getJSONObject(j).getInt("experience");

                characters.add(Character.getCharacter(professionJson, inventory,
                        100, 100, 100, 100, 0, 0,
                        levelJson, experienceJson));
            }

            Credentials credentials = new Credentials(emailJson, passwordJson);
            Account.Information information = new Account.Information.Builder().
                    setName(accountNameJson).
                    setCountry(countryJson).
                    setCredentials(credentials).
                    setGames(games).
                    build();

            accounts.add(new Account(information, characters, noOfGamesJson));
        }
    }

    public static void testPotion() throws InvalidCommandException {
        // Test functionality of a potion
        Shop shop = new Shop();
        Enemy enemy = new Enemy(10, 10, 100, 100);

        shop.testPotion(enemy);
    }

    public static void testSpell() throws InvalidCommandException {
        // Test functionality of a spell
        Inventory inventory = new Inventory(50, 50);
        Character character = new Warrior(inventory,
                100, 100, 100, 100,
                0, 0, 1, 0);
        Enemy enemy = new Enemy(10, 10, 100, 100);

        character.testSpell(enemy);
    }

    public static void testShop() throws InvalidCommandException {
        // Test functionality of a shop
        Shop shop = new Shop();
        Inventory inventory = new Inventory(50, 50);
        Character character = new Warrior(inventory,
                100, 100, 100, 100,
                0, 0, 1, 0);
        shop.testShop(character);
    }

    public static void testPlayerEnemy() throws InvalidCommandException, InterruptedException {
        // Test functionality between a player and an enemy
        Inventory inventory = new Inventory(50, 50);
        Character character = new Warrior(inventory,
                100, 100, 100, 100,
                0, 0, 1, 0);

        Enemy enemy = new Enemy(100, 100, 100, 100);

        enemy.testPlayerEnemy(character);
    }

    public static void main(String[] args) throws InvalidCommandException, IOException, InterruptedException {
        Game.getInstance().run();
    }
}
