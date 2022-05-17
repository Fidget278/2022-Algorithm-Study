/*
백준에서 컴파일 에러뜸! 22-05-17
 * 11004 K번째 수
 * */
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    //2
    public static void quicksort(int A[], int startIndex, int endIndex) { // p : startIndex , r : endIndex
        //(,0,4)
        //시작 index와 종료 index가 같지 않은 경우
        if (startIndex < endIndex) {
            //(0 < 4)
            //(,0,4)
            //여기서 p에 담길 껀 피봇값의 최종 인덱스 -> 초기 array를 만져주는 부분임
            int q = partition(A, startIndex, endIndex);
            //자기가 자기를 부르는 제귀함수 호출
            // int q = 2   (,0,1)
            quicksort(A, startIndex, q - 1); // 0 ~ 1
            quicksort(A, q + 1, endIndex); //3 ~ 4
        }
    }

    //3
    private static int partition(int A[], int startIndex, int endIndex) {
        System.out.println(startIndex + "*`~~");
        //(,0,4)
        //(,0,1)
        //끝 index의 숫자
        //x = a[4] = 3
        //x = a[1] = 1
        int pivot = A[endIndex];
        //시작하는 거 바로 전(처음에 0인데 -1임)
        // i = -1
        // i = -1
        int leftIndex = startIndex - 1;
        //j=0; j<4; j++ /   r = 4
        for (int rightIndex = startIndex; rightIndex < endIndex; rightIndex++) {
            //j = p = 0 ; a[0] = 4 <= 3
            //j = 1 ; a[1] = 2 <= 3 실행  [4,2,1,5,3]
            //j = 2 ; a[2] = 1 <= 3 실행  [2,4,1,5,3]
            //j = 3 ; a[3] = 5 <= 3 [2,1,4,5,3]
            //--
            //j = p = 0 ; a[0] = 2 <= 1 [2, 1, 3, 5, 4]
            //j = 1 ; a[1] = 1 <= 1 실행 [2, 1, 3, 5, 4]
            //해당하는 숫자가 맨 첫번째 숫자(x)보다 작으면 -> 피봇보다 작니?
            if (A[rightIndex] <= pivot) {
                leftIndex++;
                //(, 0, 1) [1, 2, 3, 5, 4]
                swap(A, leftIndex, rightIndex);
            }
        }
        //i=1 / r-1= 3
        //i = 0 / 0
        if (leftIndex != endIndex - 1) { //-> 끝까지 다 검사한게 아니라 중간에 중단된거면 그 다음에 피벗값을 넣어야해 (최초 실행, 피벗의 위치를 잡아주기 위함)
            swap(A, leftIndex + 1, endIndex);
//            //temp = a[2] = 4 [2,1,4,5,3]
//            int temp = A[];
//            //a[2] = a[4] = 3 [2,1,3,5,3]
//            A[i+1] = A[r];
//            // a[4] = 4  [2,1,3,5,4]
//            A[r] = temp;
            System.out.println(leftIndex + "! :" + Arrays.toString(A));
        }
        //2
        return leftIndex + 1;
    }

    public static void swap(int[] A, int leftIndex, int rightIndex) {
        // i = 0; temp = a[0] = 4
        // i = 1; temp = a[1] = 4
        int temp = A[leftIndex]; //(-1이 0이 됨)
        //a[0] = a[1] = 4
        //a[1] = a[2] = 1
        A[leftIndex] = A[rightIndex];
        //a[1] = 4  [2,4,1,5,3]
        //a[2] = 4  [2,1,4,5,3]
        A[rightIndex] = temp;
        System.out.println(leftIndex + ":" + Arrays.toString(A));
    }
    //1
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        //배열의 갯수
        int N = sc1.nextInt();
        //x번째 숫자를 출력
        int K = sc1.nextInt();

        System.out.println(N+":"+K);

        //배열의 갯수만큼 작성한 숫자를 배열에 추가함
        int A[] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc2.nextInt();
            System.out.println(A[i]);
        }

        //처음 index 0
        int p = 0;
        //끝 index 4
        int r = N-1;

        quicksort(A, p, r);
        System.out.println(A[K-1]);
    }
}
