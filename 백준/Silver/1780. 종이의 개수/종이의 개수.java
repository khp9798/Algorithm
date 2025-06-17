
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] paper;
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(n, 0, 0);

        for (int c : count) {
            System.out.println(c);
        }

    }

    static void divide(int n, int r, int c) {
        if (n == 1 || check(n, r, c, paper[r][c])) {
            count[paper[r][c] + 1]++;
            return;
        }

        int size = n / 3;
        for (int dr = 0; dr < 3; dr++) {
            for (int dc = 0; dc < 3; dc++) {
                divide(size, r + dr * size, c + dc * size);
            }
        }
    }

    static boolean check(int n, int r, int c, int num) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (paper[i][j] != num) {
                    return false;
                }
            }
        }

        return true;
    }
}
