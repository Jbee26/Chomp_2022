import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];
        nineteen();

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

    public static List<int[]> valids(int rows, int cols) {
        ArrayList<int[]> valids = new ArrayList<>();


        for(int x = 1; x <=3; x++ ){
            for (int y = 0; y <= 3; y++){
                for(int z = 0; z <= 3; z++){
                    if(z < y && y < x) {
                        System.out.println(x + " " + y + " " + z);
                    }


                    // valids.add(new int[]{x, y, z});

                }


            }
        }
        return valids;












    }

    public void nineteen(){
        System.out.println(valids(3,3));



    }

    public void toColumns() {
        columns = new int[10];

        for (int x = 0; x < gameBoard.length; x++) {
            for (int y = 0; y < gameBoard[x].length; y++) {
                if(gameBoard[x][y].isAlive){
                    columns[y] = columns[y]+1;
                    System.out.println(Arrays.toString(columns));



                }


            }
        }

    }


}






