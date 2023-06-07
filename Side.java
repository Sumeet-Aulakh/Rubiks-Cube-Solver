public class Side {
    private char name;
    private Piece[][] pieces;
    private Piece[] list;

    public Side(char name, char c1, char c2, char c3, char c4) throws IllegalArgumentException {
        if (name !='u' && name !='d' && name !='l' && name !='r' && name !='f' && name !='b')
            throw new IllegalArgumentException("Invalid name");
        this.name = name;
        pieces = new Piece[2][2];
        pieces[0][0] = new Piece(c1);
        pieces[0][1] = new Piece(c2);
        pieces[1][0] = new Piece(c3);
        pieces[1][1] = new Piece(c4);
        list = new Piece[4];
        list[0]=pieces[0][0];
        list[1]=pieces[0][1];
        list[2]=pieces[1][0];
        list[3]=pieces[1][1];
    }

    public Side(Side s) {
        pieces = new Piece[2][2];
        pieces[0][0] = s.getPiece(0, 0);
        pieces[0][1] = s.getPiece(0, 1);
        pieces[1][0] = s.getPiece(1, 0);
        pieces[1][1] = s.getPiece(1, 1);
        list = new Piece[4];
        list[0]=pieces[0][0];
        list[1]=pieces[0][1];
        list[2]=pieces[1][0];
        list[3]=pieces[1][1];
    }

    public Piece[] getList() {
        return list;
    }

    public int[] contains(char clr) {
        int[] result = {0,0,0,0};
        if (pieces[0][0].equals(new Piece(clr))) result[0]=1;
        if (pieces[0][1].equals(new Piece(clr))) result[1]=1;
        if (pieces[1][0].equals(new Piece(clr))) result[2]=1;
        if (pieces[1][1].equals(new Piece(clr))) result[3]=1;
        return result;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(int i, int j) throws IllegalArgumentException {
        if (i < 0 || i > 1 || j < 0 || j > 1)
            throw new IllegalArgumentException("Invalid position");
        return pieces[i][j];
    }

    public Piece setPiece(int i, int j, char c) throws IllegalArgumentException {
        if (i < 0 || i > 1 || j < 0 || j > 1)
            throw new IllegalArgumentException("Invalid position");
        Piece result = pieces[i][j];
        pieces[i][j] = new Piece(c);
        return result;
    }

    public Piece[] getRow(int i) throws IllegalArgumentException {
        if(i < 0 || i > 1) 
            throw new IllegalArgumentException("Invalid Row");
        Piece[] result = new Piece[2];
        result[0] = pieces[i][0];
        result[1] = pieces[i][1];

        return result;
    }

    public Piece[] setRow(int i, char c1, char c2) throws IllegalArgumentException {
        if(i < 0 || i > 1) 
            throw new IllegalArgumentException("Invalid Row");
        Piece[] result = new Piece[2];
        result[0] = pieces[i][0];
        result[1] = pieces[i][1];

        pieces[i][0] = new Piece(c1);
        pieces[i][1] = new Piece(c2);

        return result;
    }
    public Piece[] setRow(int i, Piece[] row) throws IllegalArgumentException{
        if(i < 0 || i > 1) 
            throw new IllegalArgumentException("Invalid Row");
        Piece[] result = new Piece[2];
        result[0] = pieces[i][0];
        result[1] = pieces[i][1];
        
        pieces[i][0] = row[0];
        pieces[i][1] = row[1];

        return result;
    }

    public Piece[] setRow(int i, Piece p1, Piece p2) throws IllegalArgumentException{
        if(i < 0 || i > 1) 
            throw new IllegalArgumentException("Invalid Row");
        Piece[] result = new Piece[2];
        result[0] = pieces[i][0];
        result[1] = pieces[i][1];
        
        pieces[i][0] = new Piece(p1);
        pieces[i][1] = new Piece(p2);

        return result;
    }

    public Piece[] getCol(int i) throws IllegalArgumentException {
        if(i < 0 || i > 1) 
            throw new IllegalArgumentException("Invalid Column");
        Piece[] result = new Piece[2];
        result[0] = new Piece(pieces[0][i]);
        result[1] = new Piece(pieces[1][i]);

        return result;
    }

    public Piece[] setCol(int i, char c1, char c2) throws IllegalArgumentException {
        if(i < 0 || i > 1) 
            throw new IllegalArgumentException("Invalid Column");
        Piece[] result = new Piece[2];
        result[0] = pieces[0][i];
        result[1] = pieces[1][i];

        pieces[0][i] = new Piece(c1);
        pieces[1][i] = new Piece(c2);

        return result;
    }

    public Piece[] setCol(int i, Piece p1, Piece p2) throws IllegalArgumentException {
        if(i < 0 || i > 1) 
            throw new IllegalArgumentException("Invalid Column");
        Piece[] result = new Piece[2];
        result[0] = pieces[0][i];
        result[1] = pieces[1][i];

        pieces[0][i] = new Piece(p1);
        pieces[1][i] = new Piece(p2);

        return result;
    }

    public Piece[] setCol(int i, Piece[] col) throws IllegalArgumentException{
        if(i < 0 || i > 1) 
            throw new IllegalArgumentException("Invalid Column");
        Piece[] result = new Piece[2];
        result[0] = pieces[0][i];
        result[1] = pieces[1][i];
        
        pieces[0][i] = new Piece(col[0]);
        pieces[1][i] = new Piece(col[1]);

        return result;
    }

    public void clockwiseTurn() {
        Piece temp = pieces[0][0];
        pieces[0][0] = pieces[1][0];
        pieces[1][0] = pieces[1][1];
        pieces[1][1] = pieces[0][1];
        pieces[0][1] = temp;
    }

    public void antiClockwiseTurn() {
        Piece temp = pieces[0][0];
        pieces[0][0] = pieces[0][1];
        pieces[0][1] = pieces[1][1];
        pieces[1][1] = pieces[1][0];
        pieces[1][0] = temp;
    }

    public boolean equals(Side s) {
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] != s.getPieces()[i])
                return false;
        }
        return true;
    }

    public String toString() {
        String result = "";
        result+=(pieces[0][0].toString()+""+pieces[0][1].toString()+"\n"+pieces[1][0].toString()+""+pieces[1][1].toString());
        return result;
    }
}
