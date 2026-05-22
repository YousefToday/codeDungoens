public class Player extends Entity{
    public Player(int x , int y){
        super("P" , x , y);
    }
    @Override
    public void move(Board board){
        switch(GameController.takaMoveInput()){
                case 'W':
                    if(y > 0 && board.isEmptyCell(x , y - 1))
                        y--;
                    break;
                case 'A':
                    if(x > 0 && board.isEmptyCell(x - 1 , y))
                        x--;
                    break;
                case 'S':
                    if(y < Board.getSize() - 1 && board.isEmptyCell(x , y + 1))
                        y++;
                    break;
                case 'D':
                    if(x < Board.getSize() - 1 && board.isEmptyCell(x + 1 , y))
                        x++;
                    break;
        }
    }
}
