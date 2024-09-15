package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        Square testsquare = new BasicSquare();
        unit.occupy(testsquare);
        assertThat(unit.getSquare()).isEqualTo(testsquare); // test occupy
        assertThat(testsquare.getOccupants()).contains(unit); //test contain
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        Square sq1 = new BasicSquare();
        unit.occupy(sq1);
        assertThat(unit.getSquare()).isEqualTo(sq1); // test occupy
        assertThat(sq1.getOccupants()).contains(unit); //test contain

        Square sq2 = new BasicSquare();
        unit.occupy(sq2);
        assertThat(unit.getSquare()).isEqualTo(sq2); // test new occupy
        assertThat(sq2.getOccupants()).contains(unit); //test contain

        // test old occupy and contain
        assertThat(unit.getSquare()).isNotEqualTo(sq1);
        assertThat(sq1.getOccupants()).doesNotContain(unit);
    }
}
