import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        //테스트 케이스 갯수
        int T = sc.nextInt();
 
         
        //2차원 퍼즐 배열 선언
        int[][] arr = new int[9][9];
         
         
         
         
        for(int t=1; t<=T; t++) {
             
            //정답 출력
            int answer = 1;
             
            //퍼즐에 값 입력하기
            for(int r=0; r<arr.length; r++) {
                for(int c=0; c<arr.length; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }
             
             
             
            //행 검사
            out : for(int r=0; r<arr.length; r++) {
                //갯수를 셀 count 배열 선언
                int[] count = new int[10];
                for(int c=0; c<arr.length; c++) {
                    count[arr[r][c]]++;
                }
                 
                for(int i=1; i<count.length; i++) {
                    if(count[i]!=1) {
                        answer = 0;
                        break out;
                    }
                }
            }
             
             
            //열 검사
            out : for(int c=0; c<arr.length; c++) {
                //갯수를 셀 count 배열 선언
                int[] count = new int[10];
                for(int r=0; r<arr.length; r++) {
                    count[arr[r][c]]++;
                }
                 
                for(int i=1; i<count.length; i++) {
                    if(count[i]!=1) {
                        answer = 0;
                        break out;
                    }
                }
            }
             
             
            //3*3 검사
            out : for(int r=0; r<arr.length; r+=3) {
                for(int c=0; c<arr.length; c+=3) {
                    int[] count = new int[10];
                    for(int i=r; i<r+3; i++) {
                        for(int j=c; j<c+3; j++) {
                            count[arr[i][j]]++;
                        }
                    }
                     
                    for(int i=1; i<count.length; i++) {
                        if(count[i]!=1) {
                            answer = 0;
                            break out;
                        }
                    }
                }
            }
             
            System.out.println("#"+t+" "+answer);
             
             
        }
         
         
    }
 
}