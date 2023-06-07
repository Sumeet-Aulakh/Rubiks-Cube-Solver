public class Rubiks {
    private Side[] sides;
    private Piece[] pieces; 
    private String solution;
    public Rubiks() {
        solution = "";
        sides = new Side[6];
        pieces = new Piece[24];
        sides[0] = new Side('u', 'y', 'y', 'y', 'y');
        sides[5] = new Side('d', 'w', 'w', 'w', 'w');
        sides[2] = new Side('f', 'g', 'g', 'g', 'g');
        sides[1] = new Side('l', 'r', 'r', 'r', 'r');
        sides[3] = new Side('r', 'o', 'o', 'o', 'o');
        sides[4] = new Side('b', 'b', 'b', 'b', 'b');

        int count = 0;
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    pieces[count++] = sides[0].getPiece(j, k);
                }
            }
        }
    }

    public Rubiks(Side[] sides) {
        solution = "";
        this.sides = new Side[6];
        pieces = new Piece[24];
        for (int i = 0; i < 6; i++) {
            this.sides[i] = sides[i];
        }

        int count = 0;
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    pieces[count++] = sides[0].getPiece(j, k);
                }
            }
        }
    }

    public String getSolution() {
        return solution;
    }

    public Piece[] getPieces() {
        return pieces;
    }
    public Side[] getSides() {
        return sides;
    }

    public void x() {
        Side temp = new Side(sides[0]);
        sides[0] = new Side(sides[2]);
        sides[2] = new Side(sides[5]);
        sides[5].setPiece(0, 0, sides[4].getPiece(1, 1).getClr());
        sides[5].setPiece(0, 1, sides[4].getPiece(1, 0).getClr());
        sides[5].setPiece(1, 0, sides[4].getPiece(0, 1).getClr());
        sides[5].setPiece(1, 1, sides[4].getPiece(0, 0).getClr());
        sides[4].setPiece(0, 0, temp.getPiece(1, 1).getClr());
        sides[4].setPiece(0, 1, temp.getPiece(1, 0).getClr());
        sides[4].setPiece(1, 0, temp.getPiece(0, 1).getClr());
        sides[4].setPiece(1, 1, temp.getPiece(0, 0).getClr());
        sides[1].antiClockwiseTurn();
        sides[3].clockwiseTurn();
    }

    public void xPrime() {
        this.x();
        this.x();
        this.x();
    }

    public void y() {
        sides[0].clockwiseTurn();
        sides[5].antiClockwiseTurn();
        Side temp = new Side(sides[1]);
        sides[1] = new Side(sides[2]);
        sides[2] = new Side(sides[3]);
        sides[3] = new Side(sides[4]);
        sides[4] = temp;

    }

    public void yPrime() {
        this.y();
        this.y();
        this.y();
    }

    public void z() {
        sides[2].clockwiseTurn();
        sides[4].antiClockwiseTurn();
        Side temp = new Side(sides[0]);
        sides[0].setPiece(0, 0, sides[1].getPiece(1, 0).getClr());
        sides[0].setPiece(0, 1, sides[1].getPiece(0, 0).getClr());
        sides[0].setPiece(1, 0, sides[1].getPiece(1, 1).getClr());
        sides[0].setPiece(1, 1, sides[1].getPiece(0, 1).getClr());

        sides[1].setPiece(0, 0, sides[5].getPiece(1, 0).getClr());
        sides[1].setPiece(0, 1, sides[5].getPiece(0, 0).getClr());
        sides[1].setPiece(1, 0, sides[5].getPiece(1, 1).getClr());
        sides[1].setPiece(1, 1, sides[5].getPiece(0, 1).getClr());

        sides[5].setPiece(0, 0, sides[3].getPiece(1, 0).getClr());
        sides[5].setPiece(0, 1, sides[3].getPiece(0, 0).getClr());
        sides[5].setPiece(1, 0, sides[3].getPiece(1, 1).getClr());
        sides[5].setPiece(1, 1, sides[3].getPiece(0, 1).getClr());

        sides[3].setPiece(0, 0, temp.getPiece(1, 0).getClr());
        sides[3].setPiece(0, 1, temp.getPiece(0, 0).getClr());
        sides[3].setPiece(1, 0, temp.getPiece(1, 1).getClr());
        sides[3].setPiece(1, 1, temp.getPiece(0, 1).getClr());
    }

    public void zPrime() {
        this.z();
        this.z();
        this.z();
    }

    public void r() {
        Piece[] temp = new Piece[2];
        sides[3].clockwiseTurn();
        temp[0] = sides[0].getPiece(0, 1);
        temp[1] = sides[0].getPiece(1, 1);
        sides[0].setCol(1, sides[2].getCol(1));
        sides[2].setCol(1, sides[5].getCol(1));
        sides[5].setCol(1, sides[4].getPiece(1, 0), sides[4].getPiece(0, 0));
        sides[4].setCol(0, temp[1], temp[0]);
    }

    public void rPrime() {
        this.r();
        this.r();
        this.r();
    }

    public void l() {
        Piece[] temp = new Piece[2];
        sides[1].clockwiseTurn();
        temp[0] = sides[4].getPiece(0, 1);
        temp[1] = sides[4].getPiece(1, 1);
        sides[4].setCol(1, sides[5].getPiece(1, 0), sides[5].getPiece(0, 0));
        sides[5].setCol(0, sides[2].getCol(0));
        sides[2].setCol(0, sides[0].getCol(0));
        sides[0].setCol(0, temp[1], temp[0]);
    }

    public void lPrime() {
        this.l();
        this.l();
        this.l();
    }

    public void u() {
        sides[0].clockwiseTurn();
        Piece[] temp = new Piece[2];
        temp[0] = sides[1].getPiece(0, 0);
        temp[1] = sides[1].getPiece(0, 1);
        sides[1].setRow(0, sides[2].getRow(0));
        sides[2].setRow(0, sides[3].getRow(0));
        sides[3].setRow(0, sides[4].getRow(0));
        sides[4].setRow(0, temp[0], temp[1]);
    }

    public void uPrime() {
        this.u();
        this.u();
        this.u();
    }

    public void d() {
        sides[5].clockwiseTurn();
        Piece[] temp = new Piece[2];
        temp[0] = sides[1].getPiece(1, 0);
        temp[1] = sides[1].getPiece(1, 1);
        sides[1].setRow(1, sides[4].getRow(1));
        sides[4].setRow(1, sides[3].getRow(1));
        sides[3].setRow(1, sides[2].getRow(1));
        sides[2].setRow(1, temp[0], temp[1]);
    }

    public void dPrime() {
        this.d();
        this.d();
        this.d();
    }

    public void f() {
        sides[2].clockwiseTurn();
        Piece[] temp = new Piece[2];
        temp[0] = sides[0].getPiece(1, 0);
        temp[1] = sides[0].getPiece(1, 1);
        sides[0].setRow(1, sides[1].getPiece(1, 1), sides[1].getPiece(0, 1));
        sides[1].setCol(1, sides[5].getRow(0));
        sides[5].setRow(0, sides[3].getPiece(1, 0), sides[3].getPiece(0, 0));
        sides[3].setCol(0, temp[0], temp[1]);
    }

    public void fPrime() {
        this.f();
        this.f();
        this.f();
    }

    public void b() {
        sides[4].clockwiseTurn();
        Piece[] temp = new Piece[2];
        temp[0] = sides[0].getPiece(0, 0);
        temp[1] = sides[0].getPiece(0, 1);
        sides[0].setRow(0, sides[3].getCol(1));
        sides[3].setCol(1, sides[5].getPiece(1, 1), sides[5].getPiece(1, 0));
        sides[5].setRow(1, sides[1].getCol(0));
        sides[1].setCol(0, temp[1], temp[0]);
    }

    public void bPrime() {
        this.b();
        this.b();
        this.b();
    }

    public void performMove(String str) throws InterruptedException {
        String[] arr = str.split("");
        int len = arr.length;
        int i = 0;
        if (len == 1) {
            char c1 = arr[i].toLowerCase().charAt(0);
            switch(c1) {
                case 'x': this.x();System.out.println("X");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                case 'y': this.y();System.out.println("Y");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                case 'z': this.z();System.out.println("Z");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                case 'r': this.r();System.out.println("R");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                case 'l': this.l();System.out.println("L");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                case 'u': this.u();System.out.println("U");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                case 'd': this.d();System.out.println("D");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                case 'f': this.f();System.out.println("F");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                case 'b': this.b();System.out.println("B");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                case ' ': break;
                default: System.out.println("Unknown move "+arr[i].toLowerCase().charAt(0)); break;
            }
        }
        while (i < len-1) {
            char c1 = arr[i].toLowerCase().charAt(0);
            char c2 = arr[i+1].toLowerCase().charAt(0);
            if (c2 == '\'') {
                switch(c1) {
                    case 'x': this.xPrime();System.out.println("X'");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+"' ");break;
                    case 'y': this.yPrime();System.out.println("Y'");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+"' ");break;
                    case 'z': this.zPrime();System.out.println("Z'");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+"' ");break;
                    case 'r': this.rPrime();System.out.println("R'");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+"' ");break;
                    case 'l': this.lPrime();System.out.println("L'");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+"' ");break;
                    case 'u': this.uPrime();System.out.println("U'");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+"' ");break;
                    case 'd': this.dPrime();System.out.println("D'");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+"' ");break;
                    case 'f': this.fPrime();System.out.println("F'");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+"' ");break;
                    case 'b': this.bPrime();System.out.println("B'");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+"' ");break;
                    case ' ': break;
                    default: System.out.println("Unknown move "+c1); break;
                }
                i+=2;
            } else {
                switch(c1) {
                    case 'x': this.x();System.out.println("X");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                    case 'y': this.y();System.out.println("Y");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                    case 'z': this.z();System.out.println("Z");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                    case 'r': this.r();System.out.println("R");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                    case 'l': this.l();System.out.println("L");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                    case 'u': this.u();System.out.println("U");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                    case 'd': this.d();System.out.println("D");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                    case 'f': this.f();System.out.println("F");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                    case 'b': this.b();System.out.println("B");System.out.println(this.toString());Thread.sleep(0);solution+=(Character.toString(c1).toUpperCase()+" ");break;
                    case ' ': break;
                    default: System.out.println("Unknown move "+c1);break;
                }
                i++;
            }
        }
    }

    public String toString() {
        String result = "";
        result+="    "+sides[0].getPiece(0, 0).toString()+sides[0].getPiece(0, 1).toString()+"\n    "+sides[0].getPiece(1, 0).toString()+sides[0].getPiece(1, 1).toString()+"\n"; 
        result+=sides[1].getPiece(0, 0).toString()+sides[1].getPiece(0, 1).toString()+sides[2].getPiece(0, 0).toString()+sides[2].getPiece(0, 1).toString()+sides[3].getPiece(0, 0).toString()+sides[3].getPiece(0, 1).toString()+sides[4].getPiece(0, 0).toString()+sides[4].getPiece(0, 1).toString()+"\n"+sides[1].getPiece(1, 0).toString()+sides[1].getPiece(1, 1).toString()+sides[2].getPiece(1, 0).toString()+sides[2].getPiece(1, 1).toString()+sides[3].getPiece(1, 0).toString()+sides[3].getPiece(1, 1).toString()+sides[4].getPiece(1, 0).toString()+sides[4].getPiece(1, 1).toString()+"\n";
        result+="    "+sides[5].getPiece(0, 0).toString()+sides[5].getPiece(0, 1).toString()+"\n    "+sides[5].getPiece(1, 0).toString()+sides[5].getPiece(1, 1).toString()+"\n\n";
        return result;
    }
}
