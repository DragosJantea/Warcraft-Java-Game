public interface Visitor<T extends Entity> {
    abstract void visit(T entity);
}
