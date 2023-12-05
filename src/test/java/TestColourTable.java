import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestColourTable {

    private ColourTable colourTable;

    @BeforeEach
    public void setUp() throws Exception {
        colourTable = new ColourTable(8);
    }

    @Test
    public void testArray() throws Exception {
        int expectedSize = 8;
        assertEquals(expectedSize, colourTable.getPaletteSize());
    }

    @Test
    public void invalidNoColours() throws Exception {
        int noColours = 1025;
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(noColours));
    }

    @Test
    public void invalidNoColoursNonPowerOfTwo() throws Exception {
        int noColours = 7;
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(noColours));
    }
}
