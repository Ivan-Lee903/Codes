//Using Method
public class Gugudan8 {

    public static int[] calculate(int times) {
        int[] result = new int[9];
        for (int i = 0; i < result.length; i++) {
            result[i] = times * (i + 1);
        }
        return result;
    }

    public static void print_calculate(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            int[] result = calculate(i);
            print_calculate(result);
        }
    }
    // 자바 파일 하나의 코드 크기가 너무 커지게 되기 때문에 (만약 한 자바 파일 안에서 모든걸 짠다면), 역할을 분리하여 클래스들을 만든다.
}
