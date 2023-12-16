package programming.injava.dp;

/**
 * Given a robot which can only move in four directions, UP(U), DOWN(D),
 * LEFT(L), RIGHT(R). Given a string consisting of instructions to move. Output
 * the coordinates of a robot after executing the instructions. Initial position
 * of robot is at origin(0, 0).
 * 
 */
public class FindfinalPositionOfRobot {

	public static void main(String[] args) {
		
		finalPosition("UDDLLRUUUDUURUDDUULLDRRRR");
		
	}

	// final x = rightMoves - leftMoves, y = upMoves - downMoves;
	public static void finalPosition(String moves) {
		int leftMoves = 0, rightMoves = 0, upMoves = 0, downMoves = 0;

		int totalMoves = moves.length();

		for (int i = 0; i < totalMoves; i++) {
			switch (moves.charAt(i)) {
			case 'U': 
				upMoves++;
				break;
			case 'D': 
				downMoves++;
				break;
			case 'R':
				rightMoves++;
				break;
			case 'L':
				leftMoves++;
				break;
			}
		}
		
		System.out.println("Final position of Robot: (" + (rightMoves - leftMoves) + ", " + (upMoves - downMoves) + ")");
		
	}
}
