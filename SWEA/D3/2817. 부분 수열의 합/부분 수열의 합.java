import java.util.Scanner;
 
public class Solution {
 
    static int N;
    static int K;
    static int [] nums;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int t=1; t<=T; t++) {
            N = sc.nextInt();
             
            K = sc.nextInt();
             
             
            nums = new int [N];
            for(int i=0; i<N; i++) {
                nums[i] = sc.nextInt();
            }
             
             
             
            for(int i=1; i<=N; i++) {
                cnt=i;
                for (int j=0; j<N; j++) {
                    visited = new boolean[N];
                    dfs(j,0,1);
                }
            }
             
            System.out.println("#"+t+" "+res);
            res=0;
        }
 
    }
     
     
    static int cnt = 0;
    static int res = 0;
    static void dfs(int idx, int sum, int cntt) {
        visited[idx] = true;
         
        sum+=nums[idx];
         
        if(cnt == cntt) {
            if(sum==K) {
                res++;
            }
            return;
        }
         
         
        for(int i=idx; i<N; i++) {
            if(!visited[i]) {
                dfs(i,sum,cntt+1);
                visited[i] = false;
            }
        }
    }
 
}