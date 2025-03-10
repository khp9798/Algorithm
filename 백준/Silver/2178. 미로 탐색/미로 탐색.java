import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static int [][] map;

    static boolean [][] visited;

    static int result = 0;

    static class node{
        int r;
        int c;
        int count;


        node(int r, int c, int count){
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }


    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];

        visited = new boolean[N][M];


        for(int i=0; i<N; i++){
            String str = br.readLine();

            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }


        bfs(0,0);


    }


    public static void bfs(int r, int c){
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(r,c,1));
        visited[r][c] = true;

        while(!queue.isEmpty()){
            node node = queue.poll();

            int row = node.r;
            int cul = node.c;
            int count = node.count;

            if(row == N-1 && cul == M-1){
                result = node.count;
                System.out.println(result);
                break;
            }


            for(int d=0; d<4; d++){
                int nr = row+dr[d];
                int nc = cul+dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M)
                    continue;

                if(visited[nr][nc])
                    continue;

                if(map[nr][nc]!=1)
                    continue;

                queue.add(new node(nr,nc,count+1));
                visited[nr][nc] = true;
            }


        }

    }


    
}