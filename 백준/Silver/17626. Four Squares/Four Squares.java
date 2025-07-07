import java.util.*;

class Main {
    public static void main(String[] args) {
        // 코드 작성
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int c1 = (int)Math.sqrt(n);
        if(c1*c1 == n){
            System.out.println(1);
            return;
        }


        for(int i=1; i<=(int)Math.sqrt(n); i++){
            int num = n-i*i;
            int c2 = (int) Math.sqrt(num);
            if(c2*c2 == num){
                System.out.println(2);
                return;
            }
        }

        int m= n;
        while(m%4 == 0){
            m/=4;
        }

        if(m%8 == 7) System.out.println(4);
        else System.out.println(3);
    }
}