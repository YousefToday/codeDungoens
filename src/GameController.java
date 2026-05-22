import java.util.Scanner;

public class GameController {
    private Player player;
    private Monster[] monsters; // array of objects(2)
    private int nOm;
    private Board board;

    public GameController(Player player, Monster[] monsters , Board board) {
        this.player = player;
        this.board = board;
        this.monsters = monsters;
        for(int i = 0 ; i < monsters.length ; i++){
            board.addInCell(monsters[i]);
            nOm++;
        }
    }
    public boolean isLost(){
       for(int i = 0 ; i < nOm ; i++)
           if(monsters[i].y == player.y && monsters[i].x == player.x)
               return true;
       return false;
    }

    public void updateBoard() {
        board.removeFromCell(player.x, player.y);
        for (int i = 0; i < nOm; i++)
            board.removeFromCell(monsters[i].x, monsters[i].y);
        player.move(board);
        board.addInCell(player);
        for (int i = 0; i < nOm; i++){
            monsters[i].move(board);
            board.addInCell(monsters[i]);
        }
        board.printBoard();
    }
    static Scanner scanner  = new Scanner(System.in);

    public static boolean isValidMoveInput(String input){
        char c = input.trim().toUpperCase().charAt(0);
        return c == 'W' || c == 'A' || c == 'S' || c == 'D';
    }
    public static char takaMoveInput(){
        String input;
        do{
            input = scanner.nextLine();
            if(!isValidMoveInput(input)) System.out.println("Use W,A,S,or D to move!");
        }while(!isValidMoveInput(input));
        return input.trim().toUpperCase().charAt(0);
    }
    public static boolean isValidMenuInput(String input){
        char c = input.trim().toUpperCase().charAt(0);
        return c == 'E' || c == 'R' || c == 'Q';
    }

    public static char takeMenuInput(){
        String input;
        do{
            input = scanner.nextLine();
            if(!isValidMenuInput(input)) System.out.println("Please enter (E) to Proceed , (R) to restart , or (Q) to quit the game");
        }while(!isValidMenuInput(input));
        return input.trim().toUpperCase().charAt(0);
    }
}
