import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}