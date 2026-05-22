public abstract class Entity extends GameObjects { //abstract class

    public Entity(String icon, int x, int y) {
        super(icon, x, y);
    }
    public abstract void move(Board board); //polymorphic method
}
