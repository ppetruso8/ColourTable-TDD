import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestColourTable {
    @Test
    public void createColourTable() throws Exception {
        int noColours = 8;
        ColourTable colourTable = new ColourTable(noColours);
        assertNotNull(colourTable);
    }

    @Test
    public void testArray() throws Exception {
        int noColours = 8;
        ColourTable colourTable = new ColourTable(noColours);
        assertEquals(noColours, colourTable.getPaletteSize());
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
