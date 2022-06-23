public class Game {
	
	private int[] knockedPins = new int[21];
	private int rollCount = 0;
	
	public void roll(int knockedPins) {
		// case in which all pins are knocked
		if (knockedPins == 10) {
			// increment roll
			rollCount++;
		}
		// increment roll (again)
		this.knockedPins[rollCount++] = knockedPins;
	}
	public int score() {
		// initialize the total score value
		int total = 0;
		// iterate though the knockedPins to determine the score
		for (int i = 0; i < knockedPins.length; ++i) {
			// case in which all pins are knocked (strike) ; apply bonus
			if (knockedPins[i] == 10) {
				total += knockedPins[i+1] + knockedPins[i+2];
			} else if (i > 0 && i % 2 == 1) {
				// case in which less than 10 pins are knocked
				int frameScore = knockedPins[i] + knockedPins[i-1];
				if (frameScore == 10) {
					total += knockedPins[i+1];
				}
			}
			// collect total knocked pins for total score
			total += knockedPins[i];
		}
		return total;
	}
}