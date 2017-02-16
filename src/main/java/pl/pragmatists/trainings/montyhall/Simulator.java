package pl.pragmatists.trainings.montyhall;

public class Simulator {
    private final Player player;
    private final Game game;
    private int numberOfGamesWon = 0;

    public Simulator(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    public void simulateStaying(int times) {
        for (int i = 0; i < times; i++) {
            simulateGame(game::stay);
        }
    }

    public int numberOfGamesWon() {
        return numberOfGamesWon;
    }

    public void simulateChanging(int times) {
        for (int i = 0; i < times; i++) {
            simulateGame(game::change);
        }
    }

    private void simulateGame(Runnable decision) {
        game.choose(player.chooseSlot());
        game.reveal();
        decision.run();
        numberOfGamesWon += game.check() ? 1 : 0;
    }
}
