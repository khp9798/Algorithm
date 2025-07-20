import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            long[] height = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                height[i] = Long.parseLong(st.nextToken());
            }

            int answer = 0;

            for (int i = 0; i < n; i++) {
                int x1 = i + 1;
                long y1 = height[i];

                int buildingCount = 0;
                double leftBefore = Long.MIN_VALUE;
                double rightBefore = Long.MIN_VALUE;

                // 왼쪽 구간
                for (int j = i; j >= 0; j--) {
                    if(i==j) continue;
                    int x2 = j + 1;
                    long y2 = height[j];

                    double currValue = calIncline(y2, y1, x1, x2);

                    // System.out.print("[left : "+currValue+"] ");
                    // System.out.printf("x1 : %d, y1 : %d, x2 : %d, y2 : %d\n",x1,y1,x2,y2);

                    if (currValue > leftBefore) {
                        leftBefore = currValue;
                        buildingCount++;
                    }
                }

                // 오른쪽 구간
                for (int j = i; j < n; j++) {
                    if(i==j) continue;
                    int x2 = j + 1;
                    long y2 = height[j];

                    double currValue = calIncline(y2, y1, x2, x1);

                    // System.out.print("[right : "+currValue+"] ");
                    // System.out.printf("x1 : %d, y1 : %d, x2 : %d, y2 : %d\n",x1,y1,x2,y2);

                    if (currValue > rightBefore) {
                        rightBefore = currValue;
                        buildingCount++;
                    }
                }

                // System.out.println(buildingCount);
                answer = Math.max(answer, buildingCount);
            }

            System.out.println(answer);
        }
    }

    // 기울기 계산
    public static double calIncline(long y2, long y1, int x2, int x1) {
        return (y2 - y1) / (double) (x2 - x1);
    }
}