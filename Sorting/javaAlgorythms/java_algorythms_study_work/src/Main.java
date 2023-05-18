import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//Getting min, max and avg using method Math.random()

        int n = 100;
        double[] array = new double[n];
        for(int i = 0; i < array.length; i++){
            array[i] = Math.random();
        }

        double min = array[0];
        double max = array[0];
        double avg = 0;
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }else if(min > array[i]) {
                min = array[i];
            }
            avg += array[i] / array.length;
        }

        System.out.println(min);
        System.out.println(max);
        System.out.println(avg);

        System.out.println();

//Bubble sort

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println();

//Getting prime numbers ==== Поиск простых чисел

        for(int i = 2; i < 100; i++){
            boolean isPrime = true;
            for(int j = 2; j < i; j++){
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(i);
            }
        }
        System.out.println();

//also using marks (out_for) ==== или, используя циклы с метками (out_for)

        out_for:
        for (int i = 2; i < 100; i++) {
            for (int j = 2; j < i; j++) {
                if(i%j==0){
                    continue out_for;
                }
            }
            System.out.println(i);
        }
    }
}