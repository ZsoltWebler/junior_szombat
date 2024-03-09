package java_collections;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameShop {

    private final List<Game> games;

    public GameShop(List<Game> games) {
        this.games = games;
    }

    public List<Developer> listOfDistinctDevelopers() {

        return games.stream().map(Game::getDeveloper).toList();

    }

    public Developer developerWithMostGame() {
        return games.stream()
                .collect(Collectors.groupingBy(Game::getDeveloper))
                .entrySet().stream()
                .max(Comparator.comparingInt(o -> o.getValue().hashCode()))
                .orElseThrow()
                .getKey();
    }

    public Map<Developer, List<Game>> gamesByDeveloper() {
        //Todo
        throw new UnsupportedOperationException();
    }

    public double medianPriceOfGames() {
        //Todo
        throw new UnsupportedOperationException();
    }

    public Game minPriceGame() {
        //Todo
        throw new UnsupportedOperationException();
    }


}
