import java.util.*;

public class Main{

    static char [][] board;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        board = new char[n][n];

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                board[r][c] = ' ';
            }
        }

        star(n,0,0);

        for(int r=0; r<n; r++){
            System.out.println(String.valueOf(board[r]));
        }

        sc.close();
    }

    public static void star(int n, int r, int c){
        if(n==1){
            board[r][c] = '*';
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1){
                    continue;
                } 
                star(n/3, r+n/3*i, c+n/3*j);
            }
        }
    }
}