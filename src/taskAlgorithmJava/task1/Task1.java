package taskAlgorithmJava.task1;
//Сортировка кучей
public class Task1 {
    public static void main(String[] arg){
        int[] array1 = new int[30];

        for(int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 100);
            System.out.print(array1[i] + " ");
        }
        System.out.println();

        heapSort heapSort1 = new heapSort();
        heapSort1.sort(array1);

        for (int i = 0; i < array1.length; ++i){
            System.out.print(array1[i] + " ");
        }
        System.out.println();
    }

    public static class heapSort{
        public void sort(int array[]){
            int n = array.length;
            for (int i = n / 2 - 1; i >= 0; i--){
                heapify(array, n, i);
            }
            for (int i = n - 1; i >= 0; i--){
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                heapify(array, i, 0);
            }
        }
        void heapify(int array[], int n, int i){
            int largest = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < n && array[l] > array[largest]){
                largest = l;
            }
            if (r < n && array[r] > array[largest]){
                largest = r;
            }
            if (largest != i){
                int swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;
                heapify(array, n, largest);
            }
        }
    }
}

