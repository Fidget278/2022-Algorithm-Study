import java.util.*;
import java.io.*;

class Heap {
    int numOfData;
    int heapArr[];

    public Heap(int length) {
        heapArr = new int[length+1];
    }
    public boolean dataPriorityCompare(int num1, int num2){
        return num1 > num2;
    }

    public boolean isEmpty() {
        return numOfData == 0;
    }

    public int getParentIdx(int idx) {
        return idx/2;
    }

    public int getLChildIdx(int idx) {
        return idx*2;
    }

    public int getRChildIdx(int idx) {
        return getLChildIdx(idx) + 1;
    }

    public int getHiPriChildIdx(int idx) {
        if( getLChildIdx(idx) > numOfData ) {
            return 0;
        } else if(getLChildIdx(idx) == numOfData) {
            return getLChildIdx(idx);
        } else {
            if(dataPriorityCompare(heapArr[getLChildIdx(idx)], heapArr[getRChildIdx(idx)]))
                return getLChildIdx(idx);
            else
                return getRChildIdx(idx);
        }
    }

    public void insert(int data) {
        int idx = numOfData + 1;

        while(idx != 1) {
            if(dataPriorityCompare(data, heapArr[getParentIdx(idx)])) {
                heapArr[idx] = heapArr[getParentIdx(idx)];
                idx = getParentIdx(idx);
            } else
                break;
        }

        heapArr[idx] = data;
        numOfData +=1 ;
    }

    public int delete() {
        int retData = heapArr[1];
        int lastElem = heapArr[numOfData];

        int parentIdx = 1;
        int childIdx;

        while((childIdx = getHiPriChildIdx(parentIdx)) > 0) {
            if(dataPriorityCompare(lastElem, heapArr[childIdx]))
                break;

            heapArr[parentIdx] = heapArr[childIdx];
            parentIdx = childIdx;
        }

        heapArr[parentIdx] = lastElem;
        numOfData -= 1;

        return retData;
    }

    public void print() {
        for(int elem : heapArr)
            if(elem != 0)
                System.out.println(elem + " ");
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        Heap heap = new Heap(N);
        
        int num = N;
        for(int i = 2; i <= N; ++i)
            heap.insert(i);
        
        
        heap.insert(1);
        
        heap.print();
    }
}