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






    public MyPlayer() {
        columns = new int[10];
        loseB.add( new Board(1,0,0));

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


        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }

    public List<int[]> valids(int rows, int cols) {
        ArrayList<int[]> valids = new ArrayList<>();




        for (int x = 1; x <= 3; x++) {
            for (int y = 0; y <= 3; y++) {
                if (x >= y) {
                    for (int z = 0; z <= 3; z++) {
                        if (z <= y) {
                            System.out.println("________________________");
                            System.out.println("new board");
                            System.out.println(x + " " + y + " " + z);
                            System.out.println("________________________");
                            aValids(x, y, z);


//
//


                        }
                    }



                }


            }
        }


        return valids;


    }


    public List<int[]> aValids(int x, int y, int z) {
        ArrayList<int[]> aValids = new ArrayList<>();


        int Z1 = z;
        int Y1 = y;
        int X1 = x;
        boolean isYay = false;


        for (int Z = z - 1; Z >= 0; Z--) {
            System.out.println(x + " " + y + " " + Z);
            for(int m = 0; m < loseB.size(); m++ ) {
                if (x == loseB.get(m).x && y == loseB.get(m).y && Z == loseB.get(m).z) {
                    System.out.println("yay");
                    isYay = true;


                }

            }

//            if(x == 2 && y == 1 && Z == 0){
//                isYay = true;
//
//            }
        }

        for (int Y = y - 1; Y >= 0; Y--) {
            if (Z1 <= Y) {
                System.out.println(x + " " + Y + " " + Z1);
                for(int m = 0; m < loseB.size(); m++ ) {
                    if (x== loseB.get(m).x && Y == loseB.get(m).y && Z1 == loseB.get(m).z) {
                        System.out.println("yay");
                        isYay = true;

                    }

                }


            }

//            if(x == 2 && Y == 1 && Z1 == 0){
//                isYay = false;
//
//            }
            if (Y < Z1) {
                Z1 = Z1 - 1;
                System.out.println(x + " " + Y + " " + Z1);
                for(int m = 0; m < loseB.size(); m++ ) {
                    if (x == loseB.get(m).x && Y == loseB.get(m).y && Z1 == loseB.get(m).z) {
                        System.out.println("yay");
                        isYay = true;

                    }

                }




            }


        }

        Z1 = z;

        for (int X = x - 1; X >= 1; X--) {
            if (X >= Y1 && X > Z1) {

                System.out.println(X + " " + Y1 + " " + Z1);
                for(int m = 0; m < loseB.size(); m++ ) {
                    if (X == loseB.get(m).x && Y1 == loseB.get(m).y && Z1 == loseB.get(m).z) {
                        System.out.println("yay");
                        isYay = true;

                    }
                }
            } else {
                if (X < Z1) {
                    Z1 = Z1 - 1;
                }
                if (X < Y1) {
                    Y1 = Y1 - 1;
                }
                System.out.println(X + " " + Y1 + " " + Z1);

                for(int m = 0; m < loseB.size(); m++ ) {
                    if (X == loseB.get(m).x && Y1 == loseB.get(m).y && Z1 == loseB.get(m).z) {
                        System.out.println("yay");
                        isYay = true;

                    }
                }
            }
        }


        Y1 = y;
        Z1 = z;
        if(isYay){
            Board w = new Board(x,y,z);
            w.winLose = true;
            winB.add(w);
            System.out.println("added to win boards");
            System.out.println("best move:" + bRow + "," + bCol);

        }
        if(!isYay){
            Board l = new Board(x,y,z);
            l.winLose = false;
            loseB.add(l);
            System.out.println("Added to lose boards|No best moves");

        }

        return aValids;
    }



    public void nineteen() {
        System.out.println(valids(3, 3));


    }

    public void afterNineteen() {
        System.out.println(aValids(3, 3, 3));


    }

    public void toColumns() {
        columns = new int[10];

        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[x].length; y++) {
                if (gameBoard[x][y].isAlive) {
                    columns[y] = columns[y] + 1;
                    System.out.println(Arrays.toString(columns));


                }


            }
        }

    }


}






