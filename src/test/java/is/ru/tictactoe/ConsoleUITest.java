package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConsoleUITest {

	@Test
    public void TestDraw() {
        Board board = new Board();
        Player player1 = new Player("Ragnar", 'X');
        Player player2 = new Player("Benedikt", 'O');

        Move move1 = new Move(0, 0, player1);
        Move move2 = new Move(0, 1, player2);
        Move move3 = new Move(0, 2, player1);
        Move move4 = new Move(1, 0, player2);

        board.addMove(move1);
        ConsoleUI.draw(board);
        board.addMove(move2);
        ConsoleUI.draw(board);
        board.addMove(move3);
        ConsoleUI.draw(board);
        board.addMove(move4);
        ConsoleUI.draw(board);
    }
}

