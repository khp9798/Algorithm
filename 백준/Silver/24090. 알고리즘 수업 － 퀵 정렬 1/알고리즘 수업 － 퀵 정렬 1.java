import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    static int K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //배열의 크기
        K = Integer.parseInt(st.nextToken()); //교환 횟수

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N-1);

        if (cnt < K) {
            System.out.print("-1");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1); //왼쪽 분리 집합 정렬
            quickSort(arr, pivot+1, end); //오른쪽 분리 집합 정렬
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int idx = start-1; //pivot보다 작은 데이터들의 끝지점

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                idx++;
                swap(arr, idx, i);
            }
        }

        if (idx+1 != end) {
            swap(arr, idx+1, end);
        }

        return idx+1;
    }

    public static void swap(int[] arr, int a, int b) {
        int num = arr[a];
        arr[a] = arr[b];
        arr[b] = num;

        cnt++;
        if (cnt == K) {
            System.out.print(arr[a] + " " + arr[b]);
        }
    }
}