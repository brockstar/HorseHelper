package mechanics;

public class Dice {

	public enum Result {
		FAILURE, TIE, SUCCESS, IMPRESSIVE;
	}

	public static int roll(int score) {
		return (int) (Math.random() * score) + 1;
	}

	public static Result contest(int playerScore, int difficulty) {
		Result outcome;
		int playerRoll = roll(playerScore);
		int opponentRoll = roll(difficulty);
		if (playerRoll < opponentRoll) {
			outcome = Result.FAILURE;
		} else if (playerRoll == opponentRoll) {
			outcome = Result.TIE;
		} else if (playerRoll > opponentRoll) {
			outcome = Result.SUCCESS;
		} else {
			outcome = Result.IMPRESSIVE;
		}
		return outcome;
	}

}
