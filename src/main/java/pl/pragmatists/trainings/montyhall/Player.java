package pl.pragmatists.trainings.montyhall;

import java.util.Random;

public class Player {
    public int chooseSlot() {
        return new Random().nextInt(3) + 1;
    }
}
