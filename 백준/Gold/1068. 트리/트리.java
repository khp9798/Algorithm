import java.io.*;
import java.util.*;

class Main {

    static int n;

    static int[][] graph;

    static boolean[] visited;

    static int count;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            //노드의 개수
            n = Integer.parseInt(br.readLine());

            //각 노드의 부모 정보
            graph = new int[n][n];

            //루트 노드
            int startNum = -1;

            //인덱스가 노드 번호, 값이 부모 번호
            //부모가 없다면 -1
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                int nodeNum = i;
                int parentNum = Integer.parseInt(st.nextToken());

                if(parentNum == -1) startNum = nodeNum;
                else{
                    graph[nodeNum][parentNum] = 1;
                    graph[parentNum][nodeNum] = 1;
                }
            }

            //지울 노드 번호
            int deleteNum = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++){
                graph[deleteNum][i] = graph[i][deleteNum] = 0;
            }

            //방문 체크 배열
            visited = new boolean[n];

            if(deleteNum != startNum){
                dfs(startNum);
            }

            System.out.println(count);
        }
    }

    public static void dfs(int num){
        visited[num] = true;
        
        boolean check = false;

        for(int i=0; i<n; i++){
            if(graph[num][i] == 1 && !visited[i]){
                check = true;
                dfs(i);
            }
        }

        if(!check){
            count++;
        }
    }
}