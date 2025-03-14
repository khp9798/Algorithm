import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static int M;

    static int [] result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        

        //1~N까지의 수
        N = Integer.parseInt(st.nextToken());

        //중복 없이 M개 고름
        M = Integer.parseInt(st.nextToken());

        
        //중복되는 수열을 여러번 출력 x, 각 수열은 공백으로 구분해서 출력
        //수열은 사전 순으로 증가하는 순서로 출력


        result = new int[M];

        dfs(1,0);

        System.out.println(sb.toString());

    }

    public static void dfs(int num, int depth){

        if(depth == M){
            for (int res : result){
                sb.append(res+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=num; i<=N; i++){
                result[depth] = i;
                dfs(num,depth+1);
        }

    }
}