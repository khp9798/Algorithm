import java.io.*;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int r = 0; r < n; r++) {
            String str = br.readLine();
            for (int c = 0; c < n; c++) {
                arr[r][c] = str.charAt(c) - '0';
            }
        }

        divide(0, 0, n);

    }

    static void divide(int r, int c, int n) {
        if (check(r, c, n, arr[r][c])) {

            System.out.print(arr[r][c]);
            return;
        }
        System.out.print("(");
        int size = n / 2;
        divide(r, c, size);
        divide(r, c + size, size);
        divide(r + size, c, size);
        divide(r + size, c + size, size);

        System.out.print(")");

    }

    static boolean check(int r, int c, int n, int num) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] != num)
                    return false;
            }
        }

        return true;
    }
}
