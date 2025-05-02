import java.util.List;

public class Board {

    public int x;
    public int y;
    public int z;
    public boolean winLose;
    public int bMove;


    public Board(int x, int y, int z, boolean winLose, int bMove) {


        for (int x = 1; x <= 3; x++) {
            for (int y = 0; y <= 3; y++) {
                if (x >= y) {
                    for (int z = 0; z <= 3; z++) {
                        if (z <= y) {
                            System.out.println("new board");
                            System.out.println(x + " " + y + " " + z);
                            System.out.println("________________________");


                        }

                    }
                }

            }
        }
    }
}


