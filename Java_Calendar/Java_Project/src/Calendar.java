
public class Calendar {
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
    private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
    
    public int getMaxDaysOfMonths(int year, int month){
        if (isLeapYear(year)){
            return LEAP_MAX_DAYS[month];
        }
        return MAX_DAYS[month];

    }
    public boolean isLeapYear(int year){
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 ==0 )){
            return true;
        }
        else
            return false;
    }
    
    public void printCalendar(int year, int month){
        System.out.printf("   <<%d월 %d년>>\n",year,month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");
        //get weekday automatically
        int weekday = getWeekDay(year, month, 1);



        // print blank space according to weekdays to sync the starting date
        for (int i = 0; i < weekday; i++){
            System.out.print("   ");
        }
        
        int maxDay = getMaxDaysOfMonths(year, month);  
        int count = 7 - weekday;
        int delim = (count < 7) ? count : 0;
        // print first line
        for (int i = 1; i <= count; i++){
            System.out.printf("%3d", i);
        }
        System.out.println(); // line change

        //print from second line
        count++;
        
        for (int i = count; i <= maxDay; i++){
            System.out.printf("%3d", i);
            if (i % 7 == delim){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();

    }
    
    private int getWeekDay(int year, int month, int day) {
        int syear = 1970;

        final int STANDARD_WEEKDAY = 4; //Thursday (1970/1/1) 
        
        int count = 0;
        for (int i = syear; i < year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }
        //System.out.println(count);
        for (int i = 1; i < month; i++){
            int delta = getMaxDaysOfMonths(year, i);
            count += delta;
        }

        count += day - 1;
        //System.out.println(count);
        int weekday = (count + STANDARD_WEEKDAY) % 7;
        
        return weekday;
    }

    //Test here
    public static void main(String[] args) throws Exception {   
        Calendar c = new Calendar();
        System.out.println(c.getWeekDay(1970, 1, 1) == 3);
        System.out.println(c.getWeekDay(1971, 1, 1) == 4);
        System.out.println(c.getWeekDay(1972, 1, 1) == 5);
        System.out.println(c.getWeekDay(1973, 1, 1) == 0);
        System.out.println(c.getWeekDay(1974, 1, 1) == 1);




    }
}