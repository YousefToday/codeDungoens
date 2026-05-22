public class Board {
    private static int size;
    private Cell[] cells; //aggregation relationship , array of objects

    public Board(int size ){
        Board.size = size;
        int i = 0;
        cells = new Cell[size * size];
        for(int y = 0; y < size; y++)
            for(int x = 0; x < size ; x++) {
                cells[i++] = new Cell(x, y);
            }
    }
    public void printBoard(){
        for(int y = 0 ; y < size ; y++) {
            for(int x = 0 ; x < size  ; x++)
                System.out.print(cells[size * y + x]);
            System.out.println();
        }
    }

    public void addInCell(GameObjects object) { // add method for cells array
        cells[size * object.y + object.x].setGameObject(object);
    }
    public void removeFromCell(int x , int y){ // remove method for cells array
        cells[size * y + x].setGameObject(null);
    }

    public void addWalls(boolean column ,int vector, int start ,int end ){
        if(column) {
            for (int i = start; i <= end; i++) {
                cells[size * i + vector].setGameObject(new Obstacle(vector, i * size));
            }
        }else{
                for(int i = start ; i<=end ; i++) {
                    cells[size * vector + i].setGameObject(new Obstacle(i * size, vector));
                }
            }
        }

    public Cell getCells(int index) {
        return cells[index];
    }

    public static int getSize() { //for the player movement
        return size;
    }
    public boolean isEmptyCell(int x , int y){ // search method for the x , y cell and check if it is null
        return cells[size * y + x].getGameObject() == null;
    }
}
