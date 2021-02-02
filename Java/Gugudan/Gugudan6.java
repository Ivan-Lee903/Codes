import java.util.Scanner;

//using array, keep results in array then print using for loop
public class Gugudan6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("2~9 를 입력해주세요");
        int input = sc.nextInt();

        int[] resultArray = new int[9];

        for (int i = 0; i < 9; i++) {
            resultArray[i] = input * (i + 1);
        }
        for (int i = 1; i < 10; i++) {
            int j = 0;
            System.out.println(input + " * " + i + " = " + resultArray[j]);
            j++;
        }
    }
}
