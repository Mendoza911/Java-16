import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void whenPlayer1Win() {
        Player firstPlayer = new Player(1, "firstPlayer", 11);
        Player secondPlayer = new Player(2, "secondPlayer", 9);

        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);

        Assertions.assertEquals(game.round("firstPlayer", "secondPlayer"), 1);
    }

    @Test
    public void whenPlayer2Win() {
        Player firstPlayer = new Player(1, "firstPlayer", 10);
        Player secondPlayer = new Player(2, "secondPlayer", 13);

        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);

        Assertions.assertEquals(game.round("firstPlayer", "secondPlayer"), 2);
    }

    @Test
    public void whenDraw() {
        Player firstPlayer = new Player(1, "firstPlayer", 14);
        Player secondPlayer = new Player(2, "secondPlayer", 14);

        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);

        Assertions.assertEquals(game.round("firstPlayer", "secondPlayer"), 0);

    }

    @Test
    public void whenPlayer1NonRegistered() {
        Player firstPlayer = new Player(1, "firstPlayer", 14);
        Player secondPlayer = new Player(2, "secondPlayer", 14);

        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("firstPlayer1", "secondPlayer");
        }
        );
    }

    @Test
    public void whenPlayer2NonRegistered() {
        Player firstPlayer = new Player(1, "firstPlayer", 14);
        Player secondPlayer = new Player(2, "secondPlayer", 14);

        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
                    game.round("firstPlayer", "secondPlayer1");
                }
        );
    }
}
