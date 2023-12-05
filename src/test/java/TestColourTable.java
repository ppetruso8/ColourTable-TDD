import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestColourTable {

    private ColourTable colourTable;

    @BeforeEach
    public void setUp() throws Exception {
        colourTable = new ColourTable(4);
    }

    @Test
    public void testArray() throws Exception {
        int expectedSize = 8;
        assertEquals(expectedSize, colourTable.getPaletteSize());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 1025})
    public void invalidNoColoursValue(int noColours) throws Exception {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(noColours));
    }

    @Test
    public void testAddColour() throws Exception {
        int colourToAdd = 0xFFFFFF;
        colourTable.add(colourToAdd);
        assertEquals(colourToAdd, colourTable.getPalette(0));
    }

    @Test
    public void addColourToFullPalette() throws Exception {
        // fill palette with colours
        colourTable.add(0x000000);
        colourTable.add(0x000001);
        colourTable.add(0x000002);
        colourTable.add(0x000003);
        // add colour to full palette
        assertThrows(Exception.class, () -> colourTable.add(0x000004));
    }
}
