package pl.pragmatists.trainings.montyhall;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.pragmatists.trainings.montyhall.PrizeOrNot.PRIZE;
import static pl.pragmatists.trainings.montyhall.PrizeOrNot.ZONK;

public class GameTest {


    private Game game;

    @Test
    public void game_is_won_when_user_picks_right_slot() {
        game = new Game(PRIZE, ZONK, ZONK);

        game.choose(1);

        assertGameWon();
    }

    @Test
    public void game_is_lost_when_user_picks_wrong_slot() {
        game = new Game(PRIZE, ZONK, ZONK);

        game.choose(2);

        assertGameLost();
    }

    @Test
    public void game_is_lost_when_change_is_to_zonk() {
        game = new Game(PRIZE, ZONK, ZONK);

        game.choose(1);
        game.reveal();
        game.change();

        assertGameLost();
    }

    @Test
    public void game_is_won_when_change_is_to_prize() {
        game = new Game(PRIZE, ZONK, ZONK);

        game.choose(2);
        game.reveal();
        game.change();

        assertGameWon();
    }

    private void assertGameWon() {
        boolean result = this.game.check();
        assertThat(result).isTrue();
    }

    private void assertGameLost() {
        boolean result = this.game.check();
        assertThat(result).isFalse();
    }

}