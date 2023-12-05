import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestColourTable {

    private ColourTable colourTable;

    @BeforeEach
    public void setUp() {
        colourTable = new ColourTable(4);
    }

    @Test
    @DisplayName("Ensure the palette size is correct")
    public void testArray() {
        int expectedSize = 4;
        assertEquals(expectedSize, colourTable.getPaletteSize());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 1025})
    @DisplayName("Ensure an exception is thrown when noColours has an invalid value")
    public void invalidNoColoursValue(int noColours) {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(noColours));
    }

    @Test
    @DisplayName("Ensure that colour is added to the palette")
    public void testAddColour() throws Exception {
        int colourToAdd = 0xFFFFFF;
        colourTable.add(colourToAdd);
        assertEquals(colourToAdd, colourTable.getPalette(0));
    }

    @Test
    @DisplayName("Ensure that exception is thrown when colour is attempted to be added to the full palette")
    public void addColourToFullPalette() throws Exception {
        // fill palette with colours
        colourTable.add(0x000000);
        colourTable.add(0x000001);
        colourTable.add(0x000002);
        colourTable.add(0x000003);
        // add colour to full palette
        assertThrows(Exception.class, () -> colourTable.add(0x000004));
    }

    @Test
    @DisplayName("Ensure the exception is thrown when invalid RGB value is attempted to be added to palette")
    public void addInvalidRGBValue() {
        int invalidRGB = 0xFFFFFFF;
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(invalidRGB));
    }
}
