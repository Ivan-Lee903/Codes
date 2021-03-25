import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        //입력: 키보드로 두수의 입력을 받는다. 
        //출력: 화면의 두 수의 합을 출력한다. 
        Scanner sc = new Scanner(System.in); // System.in = 키보드 입력 
        System.out.println("두 수를 입력해주세요");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("두수의 합은 : " + (a+b) + " 입니다");
        System.out.printf("두수 %d와 %d의 합은 %d입니다.",a,b,a+b);
        sc.close();
    }    
}
