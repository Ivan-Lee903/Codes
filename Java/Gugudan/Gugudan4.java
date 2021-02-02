import java.util.Scanner;

public class Gugudan4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 출력 안내 메세지
        System.out.println("구구단 \n2~9단중 몇단을 출력하시겠습니까?");
        int input = sc.nextInt();
        if (input >= 2 && input <= 9) {
            for (int i = 1; i < 10; i++) {
                System.out.println(input + " * " + i + " = " + (input * i));
            }
        } else
            System.out.println("2~9 만 입력할 수 있습니다.");
    }
}