public class Cell {
    private int x , y;
    private GameObjects object;

    public Cell(int x , int y) {
        this.x = x;
        this.y = y;
        object = null;
    }
    public void setGameObject(GameObjects object){
        this.object = object;
    }
    public GameObjects getGameObject(){
        return object;
    }
    @Override
    public String toString(){
        if(object instanceof Player)
            return " " + object.getIcon() + " ";
        else if(object instanceof Monster)
            return " " + object.getIcon() + " ";
        else if(object instanceof Obstacle)
            return " "+ object.getIcon() + " ";
        else if(x == Board.getSize() - 1 && y == 0)
            return " E ";
        else return " . ";
    }
}
