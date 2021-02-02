import java.util.Scanner;

public class Gugudan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇단을 출력할까요? : ");
        int input = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
            System.out.println(i + " * " + i + " = " + (input * i));
        }

        int j = 1;
        while (j < 10) {
            System.out.println(j + " * " + j + " = " + (input * j));
            j++;
        }
    }
}