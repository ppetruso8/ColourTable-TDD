/**
 * Representation of a palette of 24-bit RGB colours using Integer array
 * @author Petra Petrusova
 */
public class ColourTable {
    private Integer[] palette;
    // index of next empty place in palette
    private int nextIndex = 0;

    /**
     * Creates a ColourTable array with specified number of colours that must be
     * a power of two, and greater than 1 and less than 1025.
     *
     * @param   noColours number of colours to be in the palette
     * @throws  IllegalArgumentException when the number of colours is not valid
     */
    public ColourTable(int noColours) {
        if (!isSizeValid(noColours)) {
            throw new IllegalArgumentException("Number of colours in the palette must be" +
                    " a power of two and greater than 1 and less than 1025.");
        }
        this.palette = new Integer[noColours];
    }

    /**
     * Adds a 24-bit RGB colour to the palette if it is a valid value, if it is not
     * present in the palette already, and if there is still space in the palette.
     * @param   rgb RGB value of a colour to be added to the palette
     * @throws  PaletteFullException when the palette is full
     */
    public void add(int rgb) throws Exception {
        if (!isRGBValid(rgb)) {
            throw new IllegalArgumentException("Invalid RGB value");
        }

        if (isPaletteFull()) {
            throw new PaletteFullException();
        }

        if (!inPalette(rgb)) {
            this.palette[this.nextIndex] = rgb;
            this.nextIndex++;
        }
    }

    /**
     * Returns the colour from the palette at a specified index.
     * @param   index index of the colour to be returned from the palette
     * @return  an integer value of an RGB colour form a palette at specified index
     */
    public Integer getPalette(int index) {
        return this.palette[index];
    }

    /**
     * Returns the size of a palette
     * @return an integer representing the size of the palette
     */
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
        for (Integer colour : this.palette) {
            if (colour != null && rgb == colour) {
                return true;
            }
        }

        return false;
    }

    private boolean isSizeValid(int noColours) {
        return isPowerOfTwo(noColours) && noColours > 1 && noColours < 1025;
    }
}