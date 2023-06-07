public class Piece {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_ORANGE_BACKGROUND = "\033[48;2;255;165;0m";

    private char clr;

    public Piece(char clr) throws IllegalArgumentException{
        if (clr!='w'&& clr!='y'&&clr!='g'&&clr!='b'&&clr!='r'&&clr!='o')
            throw new IllegalArgumentException("Invalid colour.\n Valid Colours: White, Yellow, Green, Blue, Red, and Orange. ");
        this.clr = clr;
    }
    public Piece(Piece p) {
        this.clr = p.getClr();
    }

    public char getClr() {
        return clr;
    }


    public void setClr(char clr) throws IllegalArgumentException{
        if (clr!='w'&& clr!='y'&&clr!='g'&&clr!='b'&&clr!='r'&&clr!='o')
            throw new IllegalArgumentException("Invalid colour.\n Valid Colours: White, Yellow, Green, Blue, Red, and Orange. ");
        this.clr = clr;
    }

    public boolean equals(Piece p) {
        return ((this.clr == p.getClr()));
    }

    public String toString() {
        switch(this.clr) {
            case 'w' : return (ANSI_WHITE_BACKGROUND + "  " + ANSI_RESET);
            case 'y' : return (ANSI_YELLOW_BACKGROUND + "  " + ANSI_RESET);
            case 'g' : return (ANSI_GREEN_BACKGROUND + "  " + ANSI_RESET);
            case 'b' : return (ANSI_BLUE_BACKGROUND + "  " + ANSI_RESET);
            case 'r' : return (ANSI_RED_BACKGROUND + "  " + ANSI_RESET);
            case 'o' : return (ANSI_ORANGE_BACKGROUND+ "  "+ ANSI_RESET);
            default: return "";
        }
    }
}
