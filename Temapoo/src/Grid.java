import java.util.ArrayList;

public class Grid<E> extends ArrayList<E> {
    private int width, height;
    private Character character;
    private Grid<Grid<E>> cells;

    private Grid(Character character, int width, int height) {
        this.character = character;
        this.width = width;
        this.height = height;
    }

    public static Grid generate(Character character, int width, int height) {
        Grid<Cell> grid = new Grid<>(character, width, height);

        grid.cells = new Grid<>(character, width, height);

        for (int i = 0; i < height; i++) {
            Grid<Cell> lineCells = new Grid<>(character, width, height);

            for (int j = 0; j < width; j++)
                lineCells.add(new Cell(Cell.Type.EMPTY, i, j));

            grid.cells.add(lineCells);
        }

        grid.cells.get(0).set(width / 2, new Cell( Cell.Type.SHOP, new Shop(), 0, width / 2));
        grid.cells.get(height / 2).set(0, new Cell( Cell.Type.SHOP,
                new Enemy(100, 100, 100, 100), height / 2, 0));

        grid.cells.get(height - 1).set(width - 1, new Cell(Cell.Type.FINISH, height - 1, width - 1));
        return grid;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                if (((Cell)cells.get(i).get(j)).getCellElement() != null)
                    stringBuilder.append(" " + ((Cell)cells.get(i).get(j)).getCellElement().toCharacter() + " ");
                else if (i == character.getX() &&  j == character.getY())
                    stringBuilder.append(" P ");
                else if (((Cell)cells.get(i).get(j)).getType() == Cell.Type.EMPTY)
                    stringBuilder.append(" N ");
                else if (((Cell)cells.get(i).get(j)).getType() == Cell.Type.FINISH)
                    stringBuilder.append(" F ");

            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
