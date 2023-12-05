public class ColourTable {
    private int[] palette;

    public ColourTable(int noColours) {
        palette = new int[noColours];
    }

    public int getPaletteSize() {
        return palette.length;
    }

}
