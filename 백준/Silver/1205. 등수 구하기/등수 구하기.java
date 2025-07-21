import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            long newScore = Long.parseLong(st.nextToken());

            int p = Integer.parseInt(st.nextToken());

            int[] scores = new int[p];
            Arrays.fill(scores, -1);

            if(n>0){
                st = new StringTokenizer(br.readLine());
            }
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            int answer = -1;


            for (int i = p - 1; i >= 0; i--) {
                
                if(scores[i]==-1) continue;
                if (newScore == scores[i]) {
                    if (i + 1 >= p) {
                        break;
                    }
                    answer = i + 1;
                } else if (newScore < scores[i]) {
                    if (i + 2 > p) {
                        break;
                    } else {
                        answer = i + 2;
                        break;
                    }
                } else{
                    if(i == 0) answer = 1;
                }
            }

            System.out.println(n==0 ? 1 : answer);
        }
    }
}