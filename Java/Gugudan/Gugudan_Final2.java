import java.util.Scanner;

public class Gugudan_Final2 {
    public static void main(String[] args) {
        System.out.println("몇 * 몇 단을 출력하시겠습니까?");
        System.out.println("(ex) 3,7");
        Scanner sc = new Scanner(System.in);
        String stringInput = sc.nextLine();
        String[] splitedValue = stringInput.split(",");
        int first = Integer.parseInt(splitedValue[0]);
        int second = Integer.parseInt(splitedValue[1]);
        for (int i = 2; i <= first; i++) {
            for (int j = 1; j <= second; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println("============");
        }
    }
}