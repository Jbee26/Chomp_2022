import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList<Board> loseB = new ArrayList<>();
    ArrayList<Board> winB = new ArrayList<>();
    public int bCol;
    public int bRow;
    public int bX;
    public int bY;
    public int bZ;
    public int bT;
    double random;


    public MyPlayer() {
        columns = new int[10];
        loseB.add(new Board(1, 0, 0, 0));


        nineteen();


        // afterNineteen();

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        toColumns();


        int column = 0;
        int row = 0;


        row = 1;
        column = 1;


//Start here
        for (int g = 0; g < winB.size(); g++)
            if (winB.get(g).x == columns[0]) {
                if (winB.get(g).y == columns[1]) {
                    if (winB.get(g).z == columns[2]) {
                        if (winB.get(g).t == columns[3])
                            row = winB.get(g).rowBMove;
                        column = winB.get(g).colBMove;


                    }
                }

            }
        for (int u = 0; u < loseB.size(); u++) {
            if (loseB.get(u).x == columns[0]) {
                if (loseB.get(u).y == columns[1]) {
                    if (loseB.get(u).z == columns[2]) {
                        if (loseB.get(u).t == columns[3]) {
                            row = loseB.get(u).rowBMove;
                            column = loseB.get(u).colBMove;
                        }


                    }
                }

            }

        }

        Point myMove = new Point(row, column);

        return myMove;
    }

    public List<int[]> valids(int rows, int cols) {
        ArrayList<int[]> valids = new ArrayList<>();


        for (int x = 1; x <= 4; x++) {
            for (int y = 0; y <= 4; y++) {
                if (x >= y) {
                    for (int z = 0; z <= 4; z++) {
                        if (z <= y) {
                            for (int t = 0; t <= 4; t++) {
                                if (z >= t) {
                                    System.out.println("________________________");
                                    System.out.println("new board");
                                    System.out.println(x + " " + y + " " + z + " " + t);
                                    System.out.println("________________________");
                                    aValids(x, y, z, t);


//
//

                                }
                            }
                        }
                    }


                }


            }
        }


        return valids;


    }


    public List<int[]> aValids(int x, int y, int z, int t) {
        ArrayList<int[]> aValids = new ArrayList<>();


        int Z1 = z;
        int Y1 = y;
        int X1 = x;
        int T1 = t;
        boolean isYay = false;


        for (int T = t - 1; T >= 0; T--) {
            System.out.println(x + " " + y + " " + z + " " + T1);
            for (int m = 0; m < loseB.size(); m++) {
                if (x == loseB.get(m).x && y == loseB.get(m).y && z == loseB.get(m).z && t == loseB.get(m).t) {
                    System.out.println("yay");
                    isYay = true;
                    bX = x - loseB.get(m).x;
                    bY = y - loseB.get(m).y;
                    bZ = z - loseB.get(m).z;
                    bT = t - loseB.get(m).t;
                    if (bX > 0) {
                        bRow = loseB.get(m).x;
                        bCol = 0;

                    }
                    if (bY > 0) {
                        bRow = loseB.get(m).y;
                        bCol = 1;


                    } else if (bZ > 0) {
                        bRow = loseB.get(m).z;
                        bCol = 2;

                    } else if (bX == 0 && bY == 0 && bZ == 0) {
                        bRow = loseB.get(m).t;
                        bCol = 3;
                    }


                }

            }


        }


        for (int Z = z - 1; Z >= 0; Z--) {
            if (Z >= T1) {
                System.out.println(x + " " + y + " " + z + " " + T1);
                for (int m = 0; m < loseB.size(); m++) {
                    if (x == loseB.get(m).x && y == loseB.get(m).y && z == loseB.get(m).z && t == loseB.get(m).t) {
                        System.out.println("yay");
                        isYay = true;
                        bX = x - loseB.get(m).x;
                        bY = y - loseB.get(m).y;
                        bZ = z - loseB.get(m).z;
                        bT = t - loseB.get(m).t;
                        if (bX > 0) {
                            bRow = loseB.get(m).x;
                            bCol = 0;

                        }
                        if (bY > 0) {
                            bRow = loseB.get(m).y;
                            bCol = 1;


                        }
                        if (bZ > 0) {
                            bRow = loseB.get(m).z;
                            bCol = 2;

                        } else if (bX == 0 && bY == 0 && bZ == 0) {
                            bRow = loseB.get(m).t;
                            bCol = 3;
                        }


                    }

                }


            } else {
                if (Z1 < T1) {
                    T1 = T1 - 1;
                }

            }
            if (T1 <= Z1) {
                System.out.println(x + " " + y + " " + z + " " + T1);
                for (int m = 0; m < loseB.size(); m++) {
                    if (x == loseB.get(m).x && Y1 == loseB.get(m).y && Z1 == loseB.get(m).z && T1 == loseB.get(m).t) {
                        System.out.println("yay");
                        isYay = true;

                        bX = x - loseB.get(m).x;
                        bY = y - loseB.get(m).y;
                        bZ = z - loseB.get(m).z;
                        bT = t - loseB.get(m).t;
                        if (bX > 0) {
                            bRow = loseB.get(m).x;
                            bCol = 0;

                        }
                        if (bY > 0) {
                            bRow = loseB.get(m).y;
                            bCol = 1;


                        } else if (bZ > 0) {
                            bRow = loseB.get(m).z;
                            bCol = 2;

                        } else if (bX == 0 && bY == 0 && bZ == 0) {
                            bRow = loseB.get(m).t;
                            bCol = 3;
                        }
                    }
                }
            }
        }




        for (int Y = y - 1; Y >= 0; Y--) {
            if (Y < T1 && Y <= Z1) {
                System.out.println(x + " " + Y + " " + z + " " + T1);
                for (int m = 0; m < loseB.size(); m++) {
                    if (x == loseB.get(m).x && y == loseB.get(m).y && z == loseB.get(m).z && t == loseB.get(m).t) {
                        System.out.println("yay");
                        isYay = true;


                        bX = x - loseB.get(m).x;
                        bY = y - loseB.get(m).y;
                        bZ = z - loseB.get(m).z;
                        bT = t - loseB.get(m).t;
                        if (bX > 0) {
                            bRow = loseB.get(m).x;
                            bCol = 0;

                        }
                        if (bY > 0) {
                            bRow = loseB.get(m).y;
                            bCol = 1;


                        } else if (bZ > 0) {
                            bRow = loseB.get(m).z;
                            bCol = 2;

                        } else if (bX == 0 && bY == 0 && bZ == 0) {
                            bRow = loseB.get(m).t;
                            bCol = 3;
                        }


                    }

                }


            }
            else{
                if (Y1 < Z1) {
                    Z1 = Z1 - 1;
                }
                if (T1 > Y1) {
                    T1 = T1 - 1;
                }
        }




                if (Z1 <= Y1) {
                    System.out.println(x + " " + y + " " + z + " " + T1);
                    for (int m = 0; m < loseB.size(); m++) {
                        if (x == loseB.get(m).x && Y1 == loseB.get(m).y && Z1 == loseB.get(m).z && T1 == loseB.get(m).t) {
                            System.out.println("yay");
                            isYay = true;

                            bX = x - loseB.get(m).x;
                            bY = y - loseB.get(m).y;
                            bZ = z - loseB.get(m).z;
                            bT = t - loseB.get(m).t;
                            if (bX > 0) {
                                bRow = loseB.get(m).x;
                                bCol = 0;

                            }
                            if (bY > 0) {
                                bRow = loseB.get(m).y;
                                bCol = 1;


                            } else if (bZ > 0) {
                                bRow = loseB.get(m).z;
                                bCol = 2;

                            } else if (bX == 0 && bY == 0 && bZ == 0) {
                                bRow = loseB.get(m).t;
                                bCol = 3;
                            }
                        }
                    }
                }
            }

            Z1 = z;


            for (int X = x - 1; X >= 1; X--) {
                if (X >= Y1 && X > Z1 && X > T1) {

                    System.out.println(X + " " + Y1 + " " + Z1 + " " + T1);
                    for (int m = 0; m < loseB.size(); m++) {
                        if (X == loseB.get(m).x && Y1 == loseB.get(m).y && Z1 == loseB.get(m).z && T1 == loseB.get(m).t) {
                            System.out.println("yay");
                            isYay = true;

                            bX = x - loseB.get(m).x;
                            bY = y - loseB.get(m).y;
                            bZ = z - loseB.get(m).z;
                            bT = t - loseB.get(m).t;
                            if (bX > 0) {
                                bRow = loseB.get(m).x;
                                bCol = 0;

                            }
                            if (bY > 0) {
                                bRow = loseB.get(m).y;
                                bCol = 1;


                            } else if (bZ > 0) {
                                bRow = loseB.get(m).z;
                                bCol = 2;

                            } else if (bX == 0 && bY == 0 && bZ == 0) {
                                bRow = loseB.get(m).t;
                                bCol = 3;
                            }


                        }
                    }
                } else {
                    if (X < Z1) {
                        Z1 = Z1 - 1;
                    }
                    if (X < Y1) {
                        Y1 = Y1 - 1;
                    }
                    if (X < T1) {
                        T1 = T1 - 1;
                    }

                    if (Y1 <= X1) {
                        System.out.println(X + " " + Y1 + " " + Z1 + " " + T1);

                        for (int m = 0; m < loseB.size(); m++) {
                            if (X == loseB.get(m).x && Y1 == loseB.get(m).y && Z1 == loseB.get(m).z && T1 == loseB.get(m).t) {
                                System.out.println("yay");
                                isYay = true;
                                bX = x - loseB.get(m).x;
                                bY = y - loseB.get(m).y;
                                bZ = z - loseB.get(m).z;
                                bT = t - loseB.get(m).t;
                                if (bX > 0) {
                                    bRow = loseB.get(m).x;
                                    bCol = 0;

                                }
                                if (bY > 0) {
                                    bRow = loseB.get(m).y;
                                    bCol = 1;


                                } else if (bZ > 0) {
                                    bRow = loseB.get(m).z;
                                    bCol = 2;

                                } else if (bX == 0 && bY == 0 && bZ == 0) {
                                    bRow = loseB.get(m).t;
                                    bCol = 3;
                                }


                            }
                        }
                    }
                }
            }


            Y1 = y;
            Z1 = z;
            random = (int) (Math.random() * 4);
            if (isYay) {
                Board w = new Board(x, y, z, t);
                w.colBMove = bCol;
                w.rowBMove = bRow;
                w.winLose = true;
                winB.add(w);
                System.out.println("added to win boards");
                System.out.println("best move:" + bRow + "," + bCol);

            }
            if (!isYay) {
                Board l = new Board(x, y, z, t);
                l.winLose = false;

                if (x > 0) {
                    l.rowBMove = x - 1;
                    l.colBMove = 0;
                } else if (y > 0) {
                    l.rowBMove = y - 1;
                    l.colBMove = 1;
                } else if (z > 0) {
                    l.rowBMove = z - 1;
                    l.colBMove = 2;
                } else if (t > 0) {
                    l.rowBMove = t - 1;
                    l.colBMove = 3;
                }

                loseB.add(l);
                System.out.println("move col: " + l.colBMove + " row: " + l.rowBMove);
                System.out.println("Added to lose boards|No best moves|Hope for the best!");

            }

            return aValids;
        }


        public void nineteen () {
            System.out.println(valids(4, 4));


        }

        public void afterNineteen () {
            System.out.println(aValids(4, 4, 4, 4));


        }

        public void toColumns () {
            columns = new int[10];

            for (int x = 0; x < gameBoard.length; x++) {
                for (int y = 0; y < gameBoard[x].length; y++) {
                    if (gameBoard[x][y].isAlive) {
                        columns[y] = columns[y] + 1;


                    }


                }
            }

            System.out.println(Arrays.toString(columns));

        }


    }






