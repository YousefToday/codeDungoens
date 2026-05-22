//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("""
                            ___  ___  _____   _   _   _____   _____   _____  ______   _____ \s
                            |  \\/  | |  _  | | \\ | | /  ___| |_   _| |  ___| | ___ \\ /  ___|\s
                            | .  . | | | | | |  \\| | \\ `--.    | |   | |__   | |_/ / \\ `--. \s
                            | |\\/| | | | | | | . ` |  `--. \\   | |   |  __|  |    /   `--. \\\s
                            | |  | | \\ \\_/ / | |\\  | /\\__/ /   | |   | |___  | |\\ \\  /\\__/ /\s
                            \\_|  |_/  \\___/  \\_| \\_/ \\____/    \\_/   \\____/  \\_| \\_| \\____/ \s
                                                                                            \s
                                                                                            \s
                                             ___  ___   ___    ______  _____                \s
                                             |  \\/  |  / _ \\  |___  / |  ___|               \s
                                             | .  . | / /_\\ \\    / /  | |__                 \s
                                             | |\\/| | |  _  |   / /   |  __|                \s
                                             | |  | | | | | | ./ /___ | |___                \s
                                             \\_|  |_/ \\_| |_/ \\_____/ \\____/                \s
                                                                                            \s
                                                                                            \s
                    """);
                        System.out.println("                press any Key to start the game or (Q) to quit the game");
            Scanner scanner = new Scanner(System.in);
            if(scanner.nextLine().trim().toUpperCase().charAt(0) == 'Q') System.exit(0);
            while(true) {
                System.out.println("        ------Main Menu------");
                System.out.println(" 1: Story Mode\n" +
                        " 2: Select Levels\n" +
                        " 3: Controls\n" +
                        " 4: credits\n" +
                        " 5: Exit");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        Game game = new Game();
                        continue;
                    case 2:
                        while(true) {
                            System.out.println("choose the level");
                            System.out.println("1: level one (EASY)\n" +
                                    "2: level two (MEDIUM)\n" +
                                    "3: level three (HARD)\n" +
                                    "4: Exit");
                            while (true) {
                                choice = scanner.nextInt();
                                switch (choice) {
                                    case 1, 2, 3:
                                        while (true) {
                                            new Level(choice);
                                            System.out.println("Press any key to reset or (Q) to quit");
                                            if (scanner.next().trim().toUpperCase().charAt(0) == 'Q') break;
                                        }
                                        break;
                                    case 4:
                                        break;
                                    default:
                                        System.out.println("choose 1,2,3,or 4");
                                        continue;
                                }
                                break;
                            }
                            break;
                        }
                        continue;
                    case 3:
                        System.out.println("Use W,A,S,D for Movement");
                        System.out.println("W -> Up\n" +
                                "A -> Left\n" +
                                "S -> Down\n" +
                                "D -> Right\n");
                        System.out.println("press any button to get back to the Main Menu");
                        scanner.next();
                        continue;
                    case 4:
                        System.out.println("    ------Credits------");
                        System.out.println("       Yousef Almajid\n" +
                                "       Sultan Aleidan\n" +
                                "       Faisal Alzamil\n");
                        System.out.println("press any button to get back to the Main Menu");
                        scanner.next();
                        continue;
                    case 5:
                        break;
                    default:
                        System.out.println("choose 1,2,3,4,or 5");
                        continue;
                }
                break;
            }
        }
    }
}