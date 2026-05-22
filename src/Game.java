import java.util.Scanner;

public class Game {
    public Game() {
        System.out.println("            ----------Story Mode----------           ");
        System.out.println("oh no! , You are stuck in a Haunted house full of monsters!\n");
        System.out.println("You are (P) , your goal is to reach the end (E) before any monster (X) catches you!");
        System.out.println("Hint: use the walls (H) for your advantage, good luck!\n");
        System.out.println("Note: USE W,A,S,D to move");
        int n = 3;
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        for(int i = 1 ; i <= n ; i++) {
            Level level = new Level(i);
            if(level.getLogic().isLost()) {
                System.out.println("press any key to restart , or (Q) to quit");
                choice = scanner.nextLine().trim().toUpperCase().charAt(0);
                if (choice == 'Q') break;
                i--;
            }else if(i < n){
                System.out.println("Press (E) to proceed to the next room , (R) to restart this level ,or (Q) to quit");
                while(true){
                    choice = scanner.nextLine().trim().toUpperCase().charAt(0);
                    switch (choice) {
                        case 'E':
                            break;
                        case 'R':
                            i--;
                            break;
                        case 'Q':
                            System.out.println("thank you for playing!");
                            break;
                        default:
                            System.out.println("wrong input! , Press (E) to proceed , (R) to restart , or (Q) to quit");
                            continue;
                    }
                  break;
                }
            }else{
                System.out.println("Congratulations , You beat the Game!");
            }
            if(choice == 'Q') break;
        }

    }
}
