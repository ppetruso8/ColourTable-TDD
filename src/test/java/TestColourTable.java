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
    public void testArray() throws Exception{
        int noColours = 8;
        ColourTable colourTable = new ColourTable(noColours);
        assertEquals(noColours, colourTable.getPaletteSize());
    }
}
