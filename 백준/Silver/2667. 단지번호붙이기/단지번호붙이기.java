import java.io.*;
import java.util.*;

public class Main{

    static int N;

    static int [][] map;

    static boolean [][] visited;

    static List<Integer> countarr = new ArrayList<>();

    static int count;

    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();

            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }


        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(map[r][c]==1 && !visited[r][c]){
                    count=0;
                    dfs(r,c);
                    countarr.add(count);
                }
            }
        }

        System.out.println(countarr.size());
        Collections.sort(countarr);
        for(int count : countarr){
            System.out.println(count);
        }
    }


    public static void dfs(int startR, int startC){
        visited[startR][startC] = true;

        count++;

        for(int d=0; d<4; d++){
            int nr = dr[d]+startR;
            int nc = dc[d]+startC;

            if(nr<0 || nr>=N || nc<0 || nc>=N)
                continue;

            if(map[nr][nc]==1 && !visited[nr][nc])
                dfs(nr,nc);
        }

    }
}