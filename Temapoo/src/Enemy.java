import java.util.Random;
import java.util.Scanner;

public class Enemy extends Entity implements CellElement {
    public Enemy(int health, int mana, int maximumHealth, int maximumMana) {
        super(health, mana, maximumHealth, maximumMana);
        setEarth(false);
        setFire(false);
        setIce(false);
    }

    @Override
    public void receiveDamage(int damage) {
        if (new Random().nextInt(10) % 2 == 0)
            setHealth(Math.max(0, getHealth() - damage));
    }

    @Override
    public int getDamage() {
        if (new Random().nextInt(10) % 2 == 0)
            return 10 + new Random().nextInt(10);

        return 2 * (10 + new Random().nextInt(10));
    }

    @Override
    public char toCharacter() {
        return 'E';
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void testPlayerEnemy(Character character) throws InvalidCommandException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (getHealth() > 0 && character.getHealth() > 0) {
            System.out.println(this);
            System.out.println();
            System.out.println(character);

            System.out.print("Press a for attack: ");
            command = scanner.next();

            if (command.contains("a")) {
                receiveDamage(character.getDamage());
                System.out.println("\nEnemy has " + getHealth() + " life left");
            } else
                throw new InvalidCommandException();

            if (getHealth() <= 0) {
                System.out.println("You won!\n");
                break;
            }

            character.receiveDamage(getDamage());
            System.out.println("Character has " + character.getHealth() + " life left\n");

            if (character.getHealth() <= 0) {
                System.out.println("You lost!\n");
                break;
            }

            Thread.sleep(1000);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Enemy has " +
                getHealth() + " health and " + getMana() + " mana\n");

        if (getSpells().isEmpty())
            stringBuilder.append("Enemy doesn't have any spell!\n");
        else
            stringBuilder.append("Enemy has the next spells:\n");

        for (int i = 0; i < getSpells().size(); i++)
            stringBuilder.append(i + ". " + getSpells().get(i).toString());

        return stringBuilder.toString();
    }
}
