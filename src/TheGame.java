import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TheGame {
	
	
	static ArrayList<Character> row1 = new ArrayList<Character>();
	static ArrayList<Character> row2 = new ArrayList<Character>();
	static ArrayList<Character> row3 = new ArrayList<Character>();
	static boolean gameOn = true;
	static int counter = 0;
	

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		
		Collections.addAll(row1, ' ' , '|' , ' ', '|' , ' ');
		Collections.addAll(row2, ' ' , '|' , ' ', '|' , ' ');
		Collections.addAll(row3, ' ' , '|' , ' ', '|' , ' ');
		
		int player =(int) Math.floor(Math.random()*(2-1+1)+1);
		
		
		System.out.println("Welcome to Tic Tac Toe! PLAYER 1 = X   PLAYER 2 = O   Placement is assigned by number. ");
		System.out.println("Player " + player + " begins.");
		
		
		
		
		while(gameOn) {
			
			System.out.println("");
			System.out.println("player " + player + " enter placement: ");
			int pos = input.nextInt();
			
			
			addToBoard(player,pos);
			
			checkResults();
			
			
			if(player == 1) {
				player = 2;
			}
			else if(player == 2) {
				player = 1;
			}
			
			if(gameOn == false) {
				
				
				
				System.out.println("Would you like to restart the game? (YES/NO)");
				
				String word = scan.nextLine();
				
				if(word.equals("YES")) {
					gameOn = true;
					
					resetData();
					
				}else {System.out.println("Goodbye!");}
				
				
			}
			
		}
		
		
		
		
	}

	private static void resetData() {
		// TODO Auto-generated method stub
		
		row1.clear();
		row2.clear();
		row3.clear();
		
		Collections.addAll(row1, ' ' , '|' , ' ', '|' , ' ');
		Collections.addAll(row2, ' ' , '|' , ' ', '|' , ' ');
		Collections.addAll(row3, ' ' , '|' , ' ', '|' , ' ');
		
		counter = 0;
		
		
		System.out.println("Welcome to Tic Tac Toe! PLAYER 1 = X   PLAYER 2 = O   Placement is assigned by number. ");
		
		
		
	}

	private static void checkResults() {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Character>> outer = new ArrayList<ArrayList<Character>>();
		
		ArrayList<Character> topRow = new ArrayList<Character>();
		ArrayList<Character> midRow = new ArrayList<Character>();
		ArrayList<Character> botRow = new ArrayList<Character>();
		
		ArrayList<Character> leftCol = new ArrayList<Character>();
		ArrayList<Character> midCol = new ArrayList<Character>();
		ArrayList<Character> rightCol = new ArrayList<Character>();
		
		ArrayList<Character> cross1 = new ArrayList<Character>();
		ArrayList<Character> cross2 = new ArrayList<Character>();
		
		topRow.clear();
		midRow.clear();
		botRow.clear();
		leftCol.clear();
		midCol.clear();
		rightCol.clear();
		cross1.clear();
		cross2.clear();
		
		Collections.addAll(topRow, row1.get(0),row1.get(2),row1.get(4));
		Collections.addAll(midRow, row2.get(0),row2.get(2),row2.get(4));
		Collections.addAll(botRow, row3.get(0),row3.get(2),row3.get(4));
		Collections.addAll(leftCol, row1.get(0),row2.get(0),row3.get(0));
		Collections.addAll(midCol, row1.get(2),row2.get(2),row3.get(2));
		Collections.addAll(rightCol, row1.get(4),row2.get(4),row3.get(4));
		Collections.addAll(cross1, row1.get(0),row2.get(2),row3.get(4));
		Collections.addAll(cross2, row1.get(4),row2.get(2),row3.get(0));
		
		
	    outer.add(topRow);
	    outer.add(midRow);
	    outer.add(botRow);
	    outer.add(leftCol);
	    outer.add(midCol);
	    outer.add(rightCol);
	    outer.add(cross1);
	    outer.add(cross2);
	    
	    ArrayList<Character> checkWins = new ArrayList<Character>();
	    ArrayList<Character> player1 = new ArrayList<Character>();
	    ArrayList<Character> player2 = new ArrayList<Character>();
	    
	    Collections.addAll(player1, 'X','X','X');
	    Collections.addAll(player2, 'O','O','O');
	    
	    
	    
	    for(int i = 0; i<8; i++) {
	    	
	    	for(int x = 0; x<3; x++) {
	    		
	    		
	    		checkWins.add(outer.get(i).get(x));
	    		
	    	}
	    	
	    	if(checkWins.equals(player1)) {
	    		System.out.println("");
	    		System.out.println("PLAYER 1 WINS!!!!!!!!!!!!!!!!!!!");
	    		
	    		gameOn = false;
	    		break;
	    		
	    	}else if(checkWins.equals(player2)) {
	    		System.out.println("");
	    		System.out.println("PLAYER 2 WINS!!!!!!!!!!!!!!!!!!!");
	    		
	    		gameOn = false;
	    		break;
	    	}
	    	else if(counter==8) {
	    		System.out.println("");
	    		System.out.println("ITS A TIE !!!!!!!!!!!!!!!!!!!");
	    		gameOn = false;
	    		break;
	    	}
	    	
	    	checkWins.clear();	
	    	
	    }
	    
	    counter++;

	}

	private static void addToBoard(int player, int pos) {
		// TODO Auto-generated method stub
		
		switch(pos) {
		
			case 1:
				if(player == 1) {
					row1.set(0, 'X');
				}else {
					row1.set(0, 'O');
				}
				break;
				
			case 2:
				if(player == 1) {
					row1.set(2, 'X');
				}else {
					row1.set(2, 'O');
				}
				break;
				
			case 3:
				if(player == 1) {
					row1.set(4, 'X');
				}else {
					row1.set(4, 'O');
				}
				break;
				
			case 4:
				if(player == 1) {
					row2.set(0, 'X');
				}else {
					row2.set(0, 'O');
				}
				break;
				
			case 5:
				if(player == 1) {
					row2.set(2, 'X');
				}else {
					row2.set(2, 'O');
				}
				break;
			
			case 6:
				if(player == 1) {
					row2.set(4, 'X');
				}else {
					row2.set(4, 'O');
				}
				break;
				
			case 7:
				if(player == 1) {
					row3.set(0, 'X');
				}else {
					row3.set(0, 'O');
				}
				break;
				
			case 8:
				if(player == 1) {
					row3.set(2, 'X');
				}else {
					row3.set(2, 'O');
				}
				break;
			
			case 9:	
				if(player == 1) {
					row3.set(4, 'X');
				}else {
					row3.set(4, 'O');
				}
				break;
		
		}
		
		
		
		
		
		
		printBoard();
	}

	private static void printBoard() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i< row1.size(); i++) {
			
			char a = row1.get(i);
			System.out.print(a);
		}
		System.out.println("");
		System.out.print("-+-+-");
		System.out.println("");
		for(int i = 0; i< row2.size(); i++) {
			
			char a = row2.get(i);
			System.out.print(a);
		}
		System.out.println("");
		System.out.print("-+-+-");
		System.out.println("");
		
		for(int i = 0; i< row3.size(); i++) {
			
			char a = row3.get(i);
			System.out.print(a);
		}
		
	}
	
	

}
