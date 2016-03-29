package tsypanov;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int input = getInput();

		Game game = new Game(input);
		game.go();
	}

	private static int getInput() {
		try (Scanner in = new Scanner(System.in)) {
			return readInput(in);
		}
	}

	private static int readInput(Scanner in) {
		int value;

		do {
			System.out.print("Please provide random integer number: ");
			String userInput = in.next();
			value = parserUsersInput(userInput);
		} while (value == -1);

		return value;
	}

	private static int parserUsersInput(String userInput) {
		int i = -1;
		try {
			i = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			System.err.println("Wrong input, please try again.");
		}
		return i;
	}
}
