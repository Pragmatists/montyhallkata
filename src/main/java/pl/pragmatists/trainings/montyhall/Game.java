package pl.pragmatists.trainings.montyhall;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Game {
    private final PrizeOrNot[] slots;
    private int chosenIndex;
    private int revealed;

    public Game(PrizeOrNot first, PrizeOrNot second, PrizeOrNot third) {
        slots = new PrizeOrNot[] {first, second, third};
    }

    public Game() {
        this(PrizeOrNot.ZONK, PrizeOrNot.PRIZE, PrizeOrNot.ZONK);
    }

    public void choose(int slot) {
        chosenIndex = slot - 1;
    }

    private PrizeOrNot chosenSlot() {
        return slots[chosenIndex];
    }

    public void reveal() {
        revealed = firstWithoutPrizeAndNotChosen();
    }

    private int firstWithoutPrizeAndNotChosen() {
        return findIndexThatIsNotChosenAnd((index) -> slots[index] != PrizeOrNot.PRIZE);
    }

    public void stay() {
    }

    public boolean check() {
        return chosenSlot() == PrizeOrNot.PRIZE;
    }

    public void change() {
        choose(findIndexThatIsNotChosenAnd((index) -> index != revealed) + 1);
    }

    public int findIndexThatIsNotChosenAnd(Predicate<Integer> p) {
        return IntStream.range(0, slots.length)
                .filter(index -> (index != chosenIndex) && p.test(index))
                .findFirst()
                .getAsInt();
    }
}
