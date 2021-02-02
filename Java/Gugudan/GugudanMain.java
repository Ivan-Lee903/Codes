public class GugudanMain {
    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            int[] result = Gugudan8.calculate(i);
            Gugudan8.print_calculate(result);
        }
    }
}

// Convention, 클래스는 대문자, 메소드는 소문자