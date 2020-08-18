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







