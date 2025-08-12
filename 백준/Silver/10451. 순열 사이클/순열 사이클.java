import java.io.*;
import java.util.*;

class Main {

    static int[] graph;
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int T = Integer.parseInt(br.readLine());

            while(T-->0){

                //순열의 크기
                n = Integer.parseInt(br.readLine());

                graph = new int[n+1];
                visited = new boolean[n+1];

                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i=1; i<=n; i++){
                    graph[i] = Integer.parseInt(st.nextToken());
                }

                int count = 0;
                for(int i=1; i<=n; i++){
                    if(!visited[i]){
                        dfs(i);
                        count++;
                    }
                }

                System.out.println(count);
            }
        }
    }


    public static void dfs(int v){
        visited[v] = true;

        if(!visited[graph[v]]){
            dfs(graph[v]);
        }
    }
}