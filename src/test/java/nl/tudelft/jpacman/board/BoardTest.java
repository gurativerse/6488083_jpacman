package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BoardTest {

    private Board valid_board;


    @BeforeEach
    void setUp() {
        // valid board
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        valid_board = new Board(grid);
    }

    @Test
    void testValidBoard() {
        assertThat(valid_board.squareAt(0,0)).isNotNull();
    }
    @Test
    void testInvalidSquareAt() {
        Square[][] nullgrid = new Square[1][1];
        nullgrid[0][0] = null;
        try {
            new Board(nullgrid);
        } catch (AssertionError e) {
            assertThat(e).hasMessageContaining("Initial grid cannot contain null squares");
        }
    }
}
