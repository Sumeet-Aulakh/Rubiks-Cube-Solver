import java.time.LocalTime;

public class Solution {
    public static Rubiks r;

    public static void main(String[] args) throws InterruptedException {
        LocalTime t1 = LocalTime.now();
        r = new Rubiks();
        System.out.println(r);
        // r.performMove(" F R' U' F R' U F U U F F U'");
        r.performMove(" R R U U R' F R U' F F U U ");
        // r.performMove("U");
        System.out.println(r);

        // STEP 1: White Side
        while (checkWhite() == false) {
            int countWhite = 0;
            for (int i = 0; i < r.getSides()[5].getList().length; i++) {
                if (r.getSides()[5].getList()[i].equals(new Piece('w')))
                    countWhite++;
            }
            System.out.println(countWhite);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (!r.getSides()[5].getPiece(i, j).equals(new Piece('w'))) {
                        while (!r.getSides()[5].getPiece(i, j).equals(new Piece('w'))) {
                            if (i == 0 && j == 0) {
                                r.performMove("Y' ");
                                // r.yPrime();
                            } else if (i == 0 && j == 1) {

                            } else if (i == 1 && j == 0) {
                                r.performMove("Y' ");
                                r.performMove("Y' ");
                                // r.yPrime();
                                // r.yPrime();
                            } else {
                                r.performMove("Y");
                                // r.y();
                            }
                            if (r.getSides()[0].getPiece(1, 1).equals(new Piece('w'))) {
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                            } else if (r.getSides()[2].getPiece(0, 1).equals(new Piece('w'))) {
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                            } else if (r.getSides()[2].getPiece(1, 1).equals(new Piece('w'))) {
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                            } else if (r.getSides()[3].getPiece(0, 0).equals(new Piece('w'))) {
                                r.performMove("R U R' U'");
                            } else if (r.getSides()[3].getPiece(1, 0).equals(new Piece('w'))) {
                                r.performMove("R U R' U'");
                                r.performMove("R U R' U'");
                            } else {
                                r.performMove("U");
                                // r.u();
                            }
                        }
                    }
                }
            }
            System.out.println(r);
        }
        r.performMove("X");
        r.performMove("X");
        // r.x();
        // r.x();
        System.out.println(r);

        // Step 2: Edges with White side

        int oneDouble = 0;
        if (r.getSides()[1].getPiece(0, 0).equals(r.getSides()[1].getPiece(0, 1))) {
            // System.out.println(r.getSides()[1].getPiece(0, 0).toString());
            // System.out.println(r.getSides()[1].getPiece(0, 1).toString());
            r.performMove("U");
            oneDouble++;

        } else if (r.getSides()[2].getPiece(0, 0).equals(r.getSides()[2].getPiece(0, 1))) {
            // System.out.println(r.getSides()[2].getPiece(0, 0).toString());
            // System.out.println(r.getSides()[2].getPiece(0, 1).toString());
            r.performMove("U U ");
            oneDouble++;
        } else if (r.getSides()[3].getPiece(0, 0).equals(r.getSides()[3].getPiece(0, 1))) {
            // System.out.println(r.getSides()[3].getPiece(0, 0).toString());
            // System.out.println(r.getSides()[3].getPiece(0, 1).toString());
            r.performMove("U' ");
            oneDouble++;
        } else if (r.getSides()[4].getPiece(0, 0).equals(r.getSides()[4].getPiece(0, 1))) {
            oneDouble++;
        }
        System.out.println(r);

        if (r.getSides()[1].getPiece(0, 0).equals(r.getSides()[1].getPiece(0, 1)) && oneDouble == 1) {
            oneDouble++;
        }
        System.out.println(oneDouble);

        System.out.println(oneDouble);
        if (oneDouble == 1) {
            r.performMove("R' F R' B B R F' R' B B R R ");
        } else if (oneDouble == 0) {
            r.performMove("R' F R' B B R F' R' B B R R ");
            r.performMove("U");
            r.performMove("R' F R' B B R F' R' B B R R ");
        } else {
            // DO NOTHING
        }
        System.out.println(r);
        r.performMove("X");
        r.performMove("X");
        // r.x();
        // r.x();
        System.out.println(r);

        // Step 3: Yellow Square
        int yellow = countYellow();
        switch (yellow) {
            case 0:
                while (!r.getSides()[1].getPiece(0, 0).equals(new Piece('y'))
                        || !r.getSides()[1].getPiece(0, 1).equals(new Piece('y'))) {
                    r.performMove("U");
                }
                if (r.getSides()[3].getPiece(0, 0).equals(new Piece('y'))
                        && r.getSides()[3].getPiece(0, 1).equals(new Piece('y'))) {
                    r.performMove("U");
                    r.performMove("R R U U R U U R R ");
                } else if (r.getSides()[2].getPiece(0, 1).equals(new Piece('y'))
                        && r.getSides()[4].getPiece(0, 0).equals(new Piece('y'))) {
                    r.performMove("R U U R R U' R R U' R R U U R ");
                }
                break;
            case 1:
                while (!r.getSides()[0].getPiece(1, 1).equals(new Piece('y')))
                    r.performMove("U");
                r.performMove("L' U R U' L U R' U' ");
                if (!r.getSides()[0].getPiece(0, 0).equals(new Piece('y')))
                    r.performMove("L' U R U' L U R' U' ");
                break;
            case 2:
                while (!r.getSides()[0].getPiece(1, 1).equals(new Piece('y')))
                    r.performMove("U");
                if (r.getSides()[0].getPiece(1, 0).equals(new Piece('y'))) {
                    r.performMove("U' ");
                }
                if (r.getSides()[0].getPiece(0, 1).equals(new Piece('y'))) {
                    if (r.getSides()[2].getPiece(0, 0).equals(new Piece('y'))) {
                        r.performMove("U U ");
                        r.performMove("R' F' L' F R F' L F ");
                        r.performMove("R' F' L' F R F' L F ");
                    } else {
                        r.performMove("U U ");

                        r.performMove("R R D R' U U R D' R' U U R' ");
                    }
                }
                if (r.getSides()[0].getPiece(0, 0).equals(new Piece('y'))) {
                    if (!r.getSides()[1].getPiece(0, 1).equals(new Piece('y'))) {
                        r.performMove("U U ");
                    }
                    r.performMove("R' F' L' F R F' L F ");
                }
                break;

            default:
                System.out.println("Something is not right");
                break;
        }
        System.out.println(r);

        // Step 4: Edges with yellow side

        // r.performMove("U' ");
        // r.performMove("R' F R' B B R F' R' B B R R ");
        // r.performMove("R' F R' B B R F' R' B B R R ");
        // r.u();
        // r.performMove("R' F R' B B R F' R' B B R R ");
        // r.u();r.u();
        System.out.println(r);
        int index = 0;
        if (r.getSides()[1].getPiece(0, 0).equals(r.getSides()[1].getPiece(0, 1)))
            index = 1;
        if (r.getSides()[2].getPiece(0, 0).equals(r.getSides()[2].getPiece(0, 1))) {
            if (index != 0)
                index = 5;
            else
                index = 2;
        }
        if (r.getSides()[2].getPiece(0, 0).equals(r.getSides()[2].getPiece(0, 1))) {
            if (index != 0)
                index = 5;
            else
                index = 3;
        }
        if (r.getSides()[2].getPiece(0, 0).equals(r.getSides()[2].getPiece(0, 1))) {
            if (index != 0)
                index = 5;
            else
                index = 4;
        }

        switch (index) {
            case 0:
                r.performMove("");
                break;
            case 1:
                r.performMove("U R' F R' B B R F' R' B B R R ");
                break;
            case 2:
                r.performMove("U U R' F R' B B R F' R' B B R R ");
                break;
            case 3:
                r.performMove("U' R' F R' B B R F' R' B B R R ");
                break;
            case 4:
                r.performMove("R' F R' B B R F' R' B B R R ");
                break;
            case 5:
                break;
            default:
                break;
        }
        System.out.println(r);

        while (!r.getSides()[1].getPiece(0, 0).equals(r.getSides()[1].getPiece(1, 0)))
            r.performMove("U");
        System.out.println(r);
        System.out.println(r.getSolution());
        LocalTime t2 = LocalTime.now();
        System.out.println("Start Time:\t" + t1);
        System.out.println("End Time:\t" + t2);
        int t2Sec = t2.getSecond();
        int t1Sec = t1.getSecond();
        if (t2Sec > t1Sec) {
            System.out.println("Time taken:\t" + (10e10 + t2.getNano() - t1.getNano()) + " seconds");
        } else {
            System.out.println("Time taken:\t0." + (t2.getNano() - t1.getNano()) + " seconds");
        }
    }

    public static boolean checkWhite() {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (r.getSides()[5].getPiece(i, j).equals(new Piece('w')))
                    count++;
            }
        }
        return count == 4;
    }

    public static int countYellow() {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (r.getSides()[0].getPiece(i, j).equals(new Piece('y')))
                    count++;
            }
        }
        return count;
    }

    public static boolean checkTop() {
        if (r.getSides()[1].getPiece(0, 0).equals(r.getSides()[1].getPiece(0, 1))
                && r.getSides()[2].getPiece(0, 0).equals(r.getSides()[2].getPiece(0, 1)))
            return true;
        return false;
    }
}
