import java.util.Scanner;

public class Gugudan2 {
    public static void main(String[] args) {
        // 4단 Using Variable
        System.out.println("----------4단----------");
        int result = 4 * 1;
        System.out.println(result);
        result = 4 * 2;
        System.out.println(result);
        result = 4 * 3;
        System.out.println(result);
        result = 4 * 4;
        System.out.println(result);
        result = 4 * 5;
        System.out.println(result);
        result = 4 * 6;
        System.out.println(result);
        result = 4 * 7;
        System.out.println(result);
        result = 4 * 8;
        System.out.println(result);
        result = 4 * 9;
        System.out.println(result);

        // 5단, User Input 받기
        System.out.println("구구단 중 출력할 단은? : ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("=================");
        System.out.println(number * 1);
        System.out.println(number * 2);
        System.out.println(number * 3);
        System.out.println(number * 4);
        System.out.println(number * 5);
        System.out.println(number * 6);
        System.out.println(number * 7);
        System.out.println(number * 8);
        System.out.println(number * 9);

    }
}