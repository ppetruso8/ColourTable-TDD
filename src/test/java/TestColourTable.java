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
        assertEquals(expectedSize, colourTable.getPaletteSize(),
                "Palette array is not initialized with correct size");
    }

    @ParameterizedTest
    @DisplayName("Ensure that exception is thrown when noColours has an invalid value")
    @ValueSource(ints = {1, 7, 1025})
    public void invalidNoColoursValue(int noColours) {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(noColours),
                "Invalid value passed in while creating ColourTable is no handled correctly");
    }

    @Test
    @DisplayName("Ensure that colour is added to the palette")
    public void testAddColour() throws Exception {
        int colourToAdd = 0xFFFFFF;
        colourTable.add(colourToAdd);
        assertEquals(colourToAdd, colourTable.getPalette(0),
                "Colour is not added to the palette");
    }

    @Test
    @DisplayName("Ensure that exception is thrown when colour is attempted to be added to the full palette")
    public void addColourToFullPalette() throws Exception {
        // fill palette with colours
        colourTable.add(0x0000ff);
        colourTable.add(0x000001);
        colourTable.add(0x000002);
        colourTable.add(0x000003);
        // add colour to full palette
        assertThrows(PaletteFullException.class, () -> colourTable.add(0x000004),
                "Colour should not be added into a full palette");
    }

    @Test
    @DisplayName("Ensure the exception is thrown when invalid RGB value is attempted to be added to palette")
    public void addInvalidRGBValue() {
        int invalidRGB = 0xFFFFFFF;
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(invalidRGB),
                "Invalid RGB value is not checked correctly");
    }

    @Test
    @DisplayName("Ensure the duplicate colour is ignored when attempted to be added to palette")
    public void ignoreDuplicateColour() throws Exception {
        int duplicateColour = 0xFFFFFF;
        // add value to the palette
        colourTable.add(duplicateColour);
        // add the same value to the palette again
        colourTable.add(duplicateColour);
        assertNull(colourTable.getPalette(1),
                "Duplicated colour is not being ignored");
    }

    @Test
    @DisplayName("Ensure proper handling of 0 value being added to the palette")
    public void addZero() throws Exception {
        colourTable.add(0x000000);
        colourTable.add(0x000001);
        assertEquals(1, colourTable.getPalette(1),
                "Addition of RGB value of 0 to the palette is not correctly handled");
    }
}
