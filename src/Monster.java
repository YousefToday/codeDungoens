public class Monster extends Entity{
    private Player player;
    public Monster(int x, int y , Player player) {
        super("X" , x , y);
        this.player = player;
    }
    public void move(Board board) {
        int absX = Math.abs(x - player.x);
        int absY = Math.abs(y - player.y);
        boolean hasMoved = false;


        // step 1 : if the player has different x and y
        // check if direct diagonal move toward the player is possible
        if((player.x > x && player.y > y) && moveRestriction("bottomRight" , board)){
            x++;y++;
            hasMoved = true;
        }else if((player.x < x && player.y > y) && moveRestriction("bottomLeft" , board)){
            x--;y++;
            hasMoved = true;
        }else if((player.x > x && player.y < y)&& moveRestriction("topRight" , board)){
            x++;y--;
            hasMoved = true;
        }else if((player.x < x && player.y < y) && moveRestriction("topLeft" , board)) {
            x--;
            y--;
            hasMoved = true;
        }

        //step 2: if step 1 is blocked choose which way to go around the obstacle
        if(player.x > x && absX > absY && moveRestriction("right" , board ) && !hasMoved){
            x++;hasMoved = true;
        }else if(player.x < x && absX > absY && moveRestriction("left" , board) && !hasMoved){
            x--;hasMoved = true;
        }else if(player.y > y && absX < absY && moveRestriction("down" , board) && !hasMoved){
            y++;hasMoved = true;
        }else if(player.y < y && absX < absY && moveRestriction("up" , board) && !hasMoved){
            y--;hasMoved = true;
        }

        //step 3: if step 1 , 2 are blocked , check if you can go around the obstacle
        if(player.x > x && absY == 1 && !hasMoved) {
            if (moveRestriction("topRight", board)) {x++;y--; hasMoved = true;}
            else if (moveRestriction("bottomRight", board)) {x++;y++;hasMoved = true;}
        }else if(player.x < x && absY == 1&& !hasMoved){
            if(moveRestriction("topLeft", board)){x--;y--; hasMoved = true;}
            else if(moveRestriction("bottomLeft" , board)){x--;y++;hasMoved = true;}
        }else if(absX == 1 && player.y > y && !hasMoved) {
            if(moveRestriction("bottomRight" , board)){x++;y++;hasMoved = true;}
            else if(moveRestriction("bottomLeft" , board)){x--;y++;hasMoved = true;}
        }else if(absX == 1 && player.y < y && !hasMoved){
            if(moveRestriction("topRight" , board)){x++;y--;hasMoved = true;}
            else if(moveRestriction("topLeft" , board)){x--;y--;hasMoved = true;}

        }

        //step 4: check if you can go change only x or y to be closer
        if(player.x > x && moveRestriction("right" , board ) && !hasMoved){
            x++;hasMoved = true;
        }else if(player.x < x && moveRestriction("left" , board) && !hasMoved){
            x--;hasMoved = true;
        }else if(player.y > y && moveRestriction("down" , board) && !hasMoved){
            y++;hasMoved = true;
        }else if(player.y < y && moveRestriction("up" , board) && !hasMoved){
            y--;hasMoved = true;
        }

        //at this point y or x should be equal to the x or y for the player or the way is blocked
        //step 5: check if you can go around the direct obstacle(since x or y are equal)
        if(player.x > x && !hasMoved){
            if(moveRestriction("topRight" , board)){x++;y--;}
            else if(moveRestriction("bottomRight" , board)){x++;y++;}
        }else if(player.x < x && !hasMoved){
            if(moveRestriction("topLeft" , board)){x--;y--;}
            else if(moveRestriction("bottomLeft", board)){x--;y++;}
        }else if(player.y > y && !hasMoved){
            if(moveRestriction("bottomRight", board)){x++;y++;}
            else if(moveRestriction("bottomLeft" , board)){x--;y++;}
        }else if(player.y < y && !hasMoved){
            if(moveRestriction("topRight" , board)){x++;y--;}
            else if(moveRestriction("topLeft" , board)){x--;y--;}
        }
    }


    public boolean moveRestriction(String direction , Board board){
        switch(direction) {
            case "up":
                return y > 0 && (board.isEmptyCell(x , y-1) || board.getCells(Board.getSize() * (y-1) + (x)).getGameObject() instanceof Player);
            case "down":
                return y < Board.getSize()-1 && (board.isEmptyCell(x , y+1) || board.getCells(Board.getSize() * (y+1) + (x)).getGameObject() instanceof Player);
            case "right":
                return x < Board.getSize()-1 && (board.isEmptyCell(x+1 , y) || board.getCells(Board.getSize() * (y) + (x+1)).getGameObject() instanceof Player);
            case "left":
                return x > 0 && (board.isEmptyCell(x-1 , y) || board.getCells(Board.getSize() * (y) + (x-1)).getGameObject() instanceof Player);
            case "topRight":
                return x < Board.getSize()-1 && y > 0 && (board.isEmptyCell(x+1 , y-1) || board.getCells(Board.getSize() * (y-1) + (x+1)).getGameObject() instanceof Player);
            case "topLeft":
                return x > 0 && y > 0 && (board.isEmptyCell(x-1 , y-1) || board.getCells(Board.getSize() * (y-1) + (x-1)).getGameObject() instanceof Player);
            case "bottomRight":
                return x < Board.getSize()-1 && y <Board.getSize()-1 && (board.isEmptyCell(x+1 , y+1) || board.getCells(Board.getSize() * (y+1) + (x+1)).getGameObject() instanceof Player);
            case "bottomLeft":
                return x > 0 && y < Board.getSize()-1 && (board.isEmptyCell(x-1 , y+1) || board.getCells(Board.getSize() * (y+1) + (x-1)).getGameObject() instanceof Player);
        }
        return false;
    }
}