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

    public void add(int rgb) throws Exception {
        if (!isRGBValid(rgb)) {
            throw new IllegalArgumentException("Invalid RGB value");
        }

        if (isPaletteFull()) {
            throw new Exception("Palette of the colour table is full");
        }

        if (!inPalette(rgb)) {
            this.palette[this.nextIndex] = rgb;
            this.nextIndex++;
        }
    }

    public int getPalette(int index) {
        return this.palette[index];
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

    private boolean isRGBValid(int rgb) {
        return rgb >= 0 && rgb <= 16777216;
    }

    private boolean isPaletteFull() {
        return this.nextIndex >= this.palette.length;
    }

    private boolean inPalette(int rgb) {
        for (int colour : this.palette) {
            if (rgb == colour) {
                return true;
            }
        }

        return false;
    }
}