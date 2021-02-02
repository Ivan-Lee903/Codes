
//Using infinite Loop
import java.util.Scanner;

public class Gugudan5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 출력 안내 메세지
        System.out.println("구구단 \n2~9단중 몇단을 출력하시겠습니까?");
        int input = sc.nextInt();
        while (input < 2 || input > 9) {
            System.out.println("2~9 만 입력할 수 있습니다.\n다시입력해주십시오");
            input = sc.nextInt();
        }
        for (int i = 1; i < 10; i++) {
            System.out.println(input + " * " + i + " = " + (input * i));
        }
    }
}