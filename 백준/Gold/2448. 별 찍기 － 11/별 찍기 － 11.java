import java.io.*;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());           
        int width = 2*n - 1;

        // 1) 공백으로 초기화
        arr = new char[n][width];
        for(int i=0;i<n;i++){
            for(int j=0;j<width;j++){
                arr[i][j] = ' ';
            }
        }

        // 2) 별 그리기
        draw(0, n-1, n);

        // 3) 출력
        for(int i=0;i<n;i++){
            bw.write(arr[i]);
            bw.newLine();
        }
        bw.flush();
    }

    // y: 시작 행, x: 가운데 열 인덱스, size: 삼각형 높이
    static void draw(int y, int x, int size) {
        if (size == 3) {
            arr[y][x] = '*';
            arr[y+1][x-1] = '*'; arr[y+1][x+1] = '*';
            for(int i=0;i<5;i++){
                arr[y+2][x-2+i] = '*';
            }
            return;
        }
        int half = size / 2;
        draw(y,        x,      half);  // 위쪽
        draw(y+half,   x-half, half);  // 왼쪽 아래
        draw(y+half,   x+half, half);  // 오른쪽 아래
    }
}
