import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static int M;

    static int [][] relation;
    static boolean [] visited;

    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());

        relation = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            relation[start][end] = relation[end][start] = 1;
        }


        dfs(1);


        System.out.println(result);
    }

    public static void dfs(int start){

        visited[start] = true;
        
        for(int i=1; i<=N; i++){
            if(relation[start][i] == 1 && !visited[i]){
                result++;
                dfs(i);
            }
        }

    }
}