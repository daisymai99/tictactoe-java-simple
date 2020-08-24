package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author 84919
 *
 */
public class TicTacToe {

	static ArrayList<Integer> PlayerPotion = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPostion = new ArrayList<Integer>();

	public static void main(String[] args) {

		char [][] gameboard = { {' ','|',' ' ,'|' ,' '}, 
				{'-','+','-' ,'+' ,'-'},
				{' ','|',' ' ,'|' ,' '},
				{'-','+','-' ,'+' ,'-'},
				{' ','|',' ' ,'|' ,' '}};
		
		printGameboard(gameboard);
		
		
		
		while (true) {
			Scanner sc = new Scanner (System.in);
			System.out.println(" Enter your placement (1-9) : ");
			int PlayerPos = sc.nextInt();
			while (PlayerPotion.contains(PlayerPos) || cpuPostion.contains(PlayerPos)) {
				System.out.println("Position taken ! Enter a new pos ");
				PlayerPos = sc.nextInt();
			}
		
			placePiece(gameboard, PlayerPos, "player");
			String result = checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			
		
			Random rand = new Random();
			int cpuPos = rand.nextInt(9)+1;
			while (PlayerPotion.contains(cpuPos) || cpuPostion.contains(cpuPos)) {
			
				 cpuPos = rand.nextInt(9)+1;
			}
		
		
			placePiece(gameboard, cpuPos, "cpu");
		
			printGameboard(gameboard);
		
			result = checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			

		}
		
	}
	
	// 
	public static void printGameboard (char [] [] gameboard) {
		for ( char [] row : gameboard ) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	
	public static void placePiece (char [][ ] gameboard ,int pos , String user) {
		
		char sym = ' ';
		
		if(user .equals("player")) {
			sym = 'X';
			PlayerPotion.add(pos);
		}
		else if(user.equals("cpu")) {
			sym ='0';
			cpuPostion.add(pos);
		}
		
		
		switch (pos ) {
			case 1:
				gameboard [0][0] =sym;
				break ;
			case 2:
				gameboard [0][2] =sym;
				break ;
			case 3:
				gameboard [0][4] =sym;
				break ;
			case 4:
				gameboard [2][0] =sym;
				break ;
			case 5:
				gameboard [2][2] =sym;
				break ;
			case 6:
				gameboard [2][4] =sym;
				break ;
			case 7:
				gameboard [4][0] =sym;
				break ;
			case 8:
				gameboard [4][2] =sym;
				break ;
			case 9:
				gameboard [4][4] =sym;
				break ;
			default :
				break;
			
		}
	}
	
	public static String checkWinner () {
		
		// 
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(botRow);
		winningConditions.add(leftCol);
		winningConditions.add(midCol);
		winningConditions.add(rightCol);
		winningConditions.add(cross1);
		winningConditions.add(cross2);
		
		
		for (List l : winningConditions) {
			if(PlayerPotion.containsAll(l)) {
				return " congratulations u won !";
			} else if(cpuPostion.containsAll(l)) {
				return "Cpu wins , sorry :( ";
				
			}else if(PlayerPotion.size()+cpuPostion.size()==9) {
				return"Cat!";
			}
		}
		return "";
				
	}
}

/*


public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        int turns = 0;
        while (true) {
            Scanner input1 = new Scanner(askForInput(in, board, 1));
            board[input1.nextInt() - 1][input1.nextInt() - 1] = "X"; // so hang de danh khac voi thu tu nen phai tru 1 
            input1.close();
            turns++;

            printBoard(board);

            if (turns == 9 && !checkForWinner(board)) {
                System.out.println("It's a Draw!");
                break;
            }
            if (checkForWinner(board)) {
                System.out.println("Player 1 won!");
                break;
            }

            Scanner input2 = new Scanner(askForInput(in, board, 2));
            board[input2.nextInt() - 1][input2.nextInt() - 1] = "O";
            input2.close();
            turns++;

            printBoard(board);

            if (checkForWinner(board)) {
                System.out.println("Player 2 won!");
                break;
            }

        }
        in.close();
    }

    public static void printBoard(String[][] board) {
        System.out.println();
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        drawSeperator();
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        drawSeperator();
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println();
    }

    public static void drawSeperator() {
        System.out.println("-+-+-");
    }

    public static boolean checkForWinner(String[][] board) {
        for (int n = 0; n < board.length; n++) {
            // hang ngang 
            if ((board[n][0] == "X" && board[n][1] == "X" && board[n][2] == "X")
                    || (board[n][0] == "O" && board[n][1] == "O" && board[n][2] == "O")) {
                return true;
            }
        }
        for (int n = 0; n < board.length; n++) {
            // hang doc
            if ((board[0][n] == "X" && board[1][n] == "X" && board[2][n] == "X")
                    || (board[0][n] == "O" && board[1][n] == "O" && board[2][n] == "O")) {
                return true;
            }
        }
        // hang cheo
        if ((board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X")
                || (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O")) {
            return true;
        }
        // hang cheo nguoc
        if ((board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X")
                || (board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O")) {
            return true;
        }
        return false;
    }

    public static String askForInput(Scanner in, String[][] board, int player) {
        boolean bool = true;
        int prow = 0, pcolumn = 0;
        while (bool) {
            System.out.print("P" + player + " input row and column seperated by spaces: ");
            prow = in.nextInt();
            while (true) {
                if (prow > 3 || prow < 1) {
                    System.out.println("INVALID, TRY AGAIN");
                    in.nextLine();
                    prow = in.nextInt();
                } else {
                    break;
                }
            }
            pcolumn = in.nextInt();
            while (true) {
                if (pcolumn > 3 || pcolumn < 1) {
                    System.out.println("INVALID, TRY AGAIN");
                    in.nextLine();
                    pcolumn = in.nextInt();
                } else {
                    break;
                }
            }
            if (board[prow - 1][pcolumn - 1] == " ") // nhap 1 den 3 , ko co 0 
            {
                bool = false;
            }
        }

        return prow + " " + pcolumn;
    }

}
*/







