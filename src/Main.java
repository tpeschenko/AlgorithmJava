//Сортировки(Пузырьком, Выбором, Вставками)




public class Main {
    public static void main(String[] args) {
        int[] myArray = new int[]{2, 3, 5, 5, 1};
        insertSort(myArray);

        for(int i: myArray){
            System.out.print(i + " ");
        }


    }





    public static void bubbleSort(int[] numbers){
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    finish = false;
                    }
            }
        }while (!finish);

    }



    public static void selectionSort(int[] numbers){
        for (int i = 0; i < numbers.length - 1; i++){
            int minNumbers = i;
            for (int j = i+1; j < numbers.length; j++){
                if (numbers[j] < numbers[minNumbers]) {
                    minNumbers = j;
                }
            }
            if(i != minNumbers);
            int temp = numbers[i];
            numbers[i] = numbers[minNumbers];
            numbers[minNumbers] = temp;

        }

    }

    public static void insertSort(int[] numbers){
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

//    Бинарный поиск



}
