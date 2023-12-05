import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 1025})
    public void invalidNoColoursValue() throws Exception {
        int noColours = 1025;
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(noColours));
    }
}
