import java.util.Arrays;
import java.util.Scanner;
/*
백준에서 컴파일 에러뜸! 22-05-17
 * 1377 버블쇼트
 * */

public class Main {
    //2
    public static void bubblesort(int[] a, int size) {
        boolean changed = false;

        // round는 배열 크기 - 1 만큼 진행됨 / i는 어디까지 검사를 할지를 정함
        for(int i = 1; i < size; i++) {
            changed = false;

            // 각 라운드별 비교횟수는 배열 크기의 현재 라운드를 뺀 만큼 비교함
            for(int j = 0; j < size - i; j++) {
                /*
                 *  현재 원소가 다음 원소보다 클 경우
                 *  서로 원소의 위치를 교환한다.
                 */
                if(a[j] > a [j + 1]) {
                    changed = true;
                    swap(a, j, j + 1);
                }
            }

            //바뀐게 없이 올바른 위치일 때
            if(changed == false){
                System.out.println((i-1));
                break;
            }
        }
    }

    public  static void swap(int[] A, int indexOne, int indexTwo) {
        // i = 0; temp = a[0] = 4
        // i = 1; temp = a[1] = 4
        int temp = A[indexOne]; //(-1이 0이 됨)
        //a[0] = a[1] = 4
        //a[1] = a[2] = 1
        A[indexOne] = A[indexTwo];
        //a[1] = 4  [2,4,1,5,3]
        //a[2] = 4  [2,1,4,5,3]
        A[indexTwo] = temp;
        System.out.println(indexOne + ":" + Arrays.toString(A));
    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        //배열의 갯수
        System.out.println("배열의 갯수를 적어주세요.");
        int N = sc1.nextInt();

        //배열의 갯수만큼 작성한 숫자를 배열에 추가함
        System.out.println(N + "자리의 배열을 적어주세요");
        int A[] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc2.nextInt();
            System.out.println(A[i]);
        }

        bubblesort(A, N);
    }
}
