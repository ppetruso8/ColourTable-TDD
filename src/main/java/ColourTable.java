public class ColourTable {
    private int[] palette;
    private int nextIndex = 0;

    public ColourTable(int noColours) {
        if (!isPowerOfTwo(noColours) || noColours <= 1 || noColours >= 1025) {
            throw new IllegalArgumentException("Number of colours in the palette must be" +
                    " a power of two and greater than 1 and less than 1025.");
        }
        this.palette = new int[noColours];
    }

    public int getPaletteSize() {
        return this.palette.length;
    }

    private boolean isPowerOfTwo(int number) {

        if (number <= 0) {
            return false;
        }

        if (number % 2 != 0) {
            return false;
        }

        while (number % 2 == 0)  {
            number = number/2;
        }

        return number == 1;
    }

    public void add(int rgb) {
        this.palette[nextIndex] = rgb;
        nextIndex++;
    }

    public int getPalette(int index) {
        return this.palette[index];
    }
}
