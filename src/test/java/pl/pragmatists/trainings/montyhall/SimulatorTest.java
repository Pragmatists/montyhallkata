package pl.pragmatists.trainings.montyhall;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimulatorTest {

    private final Player mockPlayer = mock(Player.class);

    @Test
    public void player_wins_all_games() {
        Game game = new Game(PrizeOrNot.ZONK, PrizeOrNot.PRIZE, PrizeOrNot.ZONK);
        Simulator simulator = new Simulator(mockPlayer, game);
        when(mockPlayer.chooseSlot()).thenReturn(2);

        simulator.simulateStaying(10);

        assertThat(simulator.numberOfGamesWon()).isEqualTo(10);
    }

    @Test
    public void player_looses_all_games() {
        Game game = new Game(PrizeOrNot.ZONK, PrizeOrNot.PRIZE, PrizeOrNot.ZONK);
        Simulator simulator = new Simulator(mockPlayer, game);
        when(mockPlayer.chooseSlot()).thenReturn(2);

        simulator.simulateChanging(10);

        assertThat(simulator.numberOfGamesWon()).isEqualTo(0);
    }

    @Test
    public void test_1000_stays() {
        Simulator simulator = new Simulator(new Player(), new Game());
        simulator.simulateStaying(1000);
        Assertions.assertThat(simulator.numberOfGamesWon()).isBetween(0,500);
    }

    @Test
    public void test_1000_changes() {
        Simulator simulator = new Simulator(new Player(), new Game());
        simulator.simulateChanging(1000);
        Assertions.assertThat(simulator.numberOfGamesWon()).isBetween(600,1000);
    }
}
