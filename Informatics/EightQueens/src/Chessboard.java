package src;

import java.util.Scanner;

public class Chessboard {

	private static int[][] chessboard;
	private static int size;
	private static int counter;
	Scanner scan = new Scanner(System.in);

	public Chessboard() {
		
		System.out.println("Please type in the size of the chessboard: ");
		
		size = scan.nextInt();
		chessboard = new int[size][size];

	}

	public static void fillChessboard() {
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				chessboard[i][j] = 0;
			}
		}
	}

	public int getCounter() {
		
		return counter;
	}

	public static void printOutChessboard() {
		
		for (int i = 0; i < size; i++) {
			System.out.println();
			
			for (int j = 0; j < size; j++) {
				System.out.print(chessboard[i][j] + " ");
			}
		}
		System.out.println();
		counter++;
	}

	static boolean toPlaceOrNotToPlace(int row, int col) {
		
		int i, j;
		
		for (i = 0; i < col; i++) {
			if (chessboard[row][i] == 1)
				return false;
		}
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (chessboard[i][j] == 1)
				return false;
		}
		for (i = row, j = col; j >= 0 && i < size; i++, j--) {
			if (chessboard[i][j] == 1)
				return false;
		}
		return true;
	}

	public void solve(int col) {
		
		if (col == size)
			printOutChessboard();
		else {
			for (int i = 0; i < size; i++) {
				if (toPlaceOrNotToPlace(i, col)) {
					chessboard[i][col] = 1;
					solve(col + 1);
				}
				chessboard[i][col] = 0;
			}
		}
	}

	public static void main(String[] args) {

		Chessboard nQueens = new Chessboard();
		
		nQueens.solve(0);
		System.out.println();
		System.out.println("Number of possible solutions: "
				+ nQueens.getCounter());
	}
}
