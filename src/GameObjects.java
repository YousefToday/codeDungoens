public class GameObjects {
    protected int x , y;
    protected String icon;

    public GameObjects(String icon , int x , int y){
        this.icon = icon;
        this.x = x;
        this.y = y;
    }
    public String getIcon() {
        return icon;
    }
}
