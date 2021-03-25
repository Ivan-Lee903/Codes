import java.util.Scanner;

public class Prompt {

    public void printMenu() {
        System.out.println("+----------------------+");
        System.out.println("| 1. 일정등록       ");
        System.out.println("| 2. 일정검색       ");
        System.out.println("| 3. 달력보기       ");
        System.out.println("| h. 도움말 q. 종료  ");
        System.out.println("+----------------------+");
        
        // 일정등록
        // 일정 검색    
        // 달력 보기
        // h 도움말 , q. 종료 
    }
    /**
     * 
     * @param week 
     * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
     */
    public int parseDay(String week){
        if (week.equals("su")) return 0;
        else if (week.equals("mo")) return 1;
        else if (week.equals("tu")) return 2;
        else if (week.equals("we")) return 3;
        else if (week.equals("th")) return 4;
        else if (week.equals("fr")) return 5;
        else if (week.equals("sa")) return 6;
       
        else return 0;
    }

   
    public void runPrompt() {
        printMenu();
        Calendar cal = new Calendar();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("명령 (1, 2, 3, h, q)");
            String cmd = sc.next();
            if (cmd.equals("1")) cmdRegister();
            else if (cmd.equals("2")) cmdSearch();
            else if (cmd.equals("3")) cmdCal(sc, cal);
            else if (cmd.equals("h")) printMenu();
            else if (cmd.equals("q")) break;
        
        }
        System.out.println("Thank you! Good Bye~!");
        //cal.printSampleCalendar();
        sc.close();
    }

    private void cmdCal(Scanner sc, Calendar c) {
            int month = 1;
            int year = 2017;
            System.out.println("년도를 입력하세요.");
            System.out.print("YEAR> ");
            year = sc.nextInt();
            System.out.println();
            System.out.println("일수를 출력하고 싶은 달의 숫자를 입력해주세요. (input 0 = exit)");
            System.out.print("MONTH> ");
            month = sc.nextInt();
            System.out.println();
            System.out.println();

            if ((month < 1 && month != 0)  || month > 12){
                System.out.println("--------ERROR : 1월부터 12월만 입력가능합니다.--------");
                return;
            }
            
            c.printCalendar(year, month);

    }

    private void cmdSearch() {
    }

    private void cmdRegister() {
    }

    public static void main(String[] args) {
    //셀 실행
    Prompt p = new Prompt();
    p.runPrompt();        
    }
}   