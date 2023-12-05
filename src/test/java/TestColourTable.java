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
    @DisplayName("Ensure the palette size is initialized correctly")
    public void testArray() {
        int expectedSize = 4;
        assertEquals(expectedSize, colourTable.getPaletteSize());
    }

    @ParameterizedTest
    @DisplayName("Ensure that exception is thrown when noColours has an invalid value")
    @ValueSource(ints = {1, 7, 1025})
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

    @Test
    @DisplayName("Ensure the duplicate colour is ignored when attempted to be added to palette")
    public void ignoreDuplicateColour() throws Exception {
        int duplicateColour = 0xFFFFFF;

        // add value to the palette
        colourTable.add(duplicateColour);
        // try to add the same value again
        assertThrows(Exception.class, () -> colourTable.add(duplicateColour));
    }
}
