import org.junit.Test;
import org.junit.Assert;
import junit.framework.TestCase;
public class BowlingGameTest extends TestCase{
	
	@Test
	void all_zeros() {
		Game game = createNewGame();
		rollFor20(game, 0);
		Assert.assertThat(game.score()).isEqualTo(0);
	}
	
	@Test
	void should_calculate20_when_allRolls1() {
        Game game = createNewGame();
        rollFor20(game, 1);
        Assert.assertThat(game.score()).isEqualTo(20);
    }

    @Test
    void should_calculate80_when_allRolls4() {
        Game game = createNewGame();
        rollFor20(game, 4);
        Assert.assertThat(game.score()).isEqualTo(80);
    }

    @Test
    void should_calculateFinalScore_when_knocksDifferentPins() {
        Game game = createNewGame();
        game.roll(5);
        game.roll(5);
        game.roll(2);
        Assert.assertThat(game.score()).isEqualTo(14);
    }

    @Test
    void should_calculateFinalScore_when_knocksDifferentPins2() {
        Game game = createNewGame();
        game.roll(7);
        game.roll(2);
        game.roll(8);
        game.roll(1);
        Assert.assertThat(game.score()).isEqualTo(18);
    }

    @Test
    void should_calculateFinalScore_when_spareAfterSpare() {
        Game game = createNewGame();
        game.roll(8);
        game.roll(2);
        game.roll(7);
        game.roll(3);
        game.roll(5);
        Assert.assertThat(game.score()).isEqualTo(37);
    }

    @Test
    void should_calculateFinalScore_when_itsTimeForStrike() {
        Game game = createNewGame();
        game.roll(10);
        game.roll(2);
        game.roll(7);
        game.roll(3);
        game.roll(5);
        Assert.assertThat(game.score()).isEqualTo(36);
    }

    @Test
    void should_calculateFinalScore_when_itsTimeForStrike2() {
        Game game = createNewGame();
        game.roll(2);
        game.roll(7);
        game.roll(10);
        game.roll(3);
        game.roll(5);
        Assert.assertThat(game.score()).isEqualTo(35);
    }
	private Game createNewGame() {
		return new Game();
	}
	private void rollFor20(Game game, int e) {
		for (int i = 0; i < 20; ++i) {
			game.roll(e);
		}
	}
}
