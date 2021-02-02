import java.util.Scanner;

public class Gugudan_Final {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇단까지 출력할까요? (8 = 2*1 ~ 8 * 8)");
        int input = sc.nextInt();
        // 구구단 input 만큼 돌리기

        // increment 구구단

        for (int i = 2; i <= input; i++) {
            for (int j = 1; j <= input; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }
}