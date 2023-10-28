public class Cell {
    public enum Type {
        EMPTY,
        ENEMY,
        SHOP,
        FINISH
    }

    private Type type;
    private int x, y;
    private CellElement cellElement;
    boolean visited;

    public Type getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCellElement(CellElement cellElement) {
        this.cellElement = cellElement;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public CellElement getCellElement() {
        return cellElement;
    }

    public boolean isVisited() {
        return visited;
    }

    public Cell(Type type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public Cell(Type type, CellElement cellElement, int x, int y) {
        this.type = type;
        this.cellElement = cellElement;
        this.x = x;
        this.y = y;
    }

    public static Type convertStringToType(String type) {
        if (type.equalsIgnoreCase("EMPTY"))
            return Type.EMPTY;

        if (type.equalsIgnoreCase("FINISH"))
            return Type.FINISH;

        if (type.equalsIgnoreCase("SHOP"))
            return Type.SHOP;

        return Type.ENEMY;
    }
}
