public class Board {

    public int x;
    public int y;
    public int z;
    public boolean winLose;
    public int rowBMove;
    public int colBMove;


    public Board(int x1, int y1, int z1, boolean winLose1, int bMove1, int colBMove1) {
        x = x1;
        y = y1;
        z = z1;
        winLose = winLose1;
        rowBMove = bMove1;
        colBMove = colBMove1;

        print();






    }

    public void print(){
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        if (winLose == true){
            System.out.println("Win");
        }
        else{
            System.out.println("Lose");
        }
        System.out.println(this.rowBMove);
        System.out.println(colBMove);

    }
}


