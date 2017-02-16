package level03;

public class Task33 {
	
    public static void main(String[] args) {
        System.out.println(getCountSecondsPassedInCurrentHour(12345));
    }

    public static int getCountSecondsPassedInCurrentHour(int seconds) {
        
      int a = seconds/3600;
      int b = 3600 * a;
      int c = seconds -b;
      return c; 
       
        
       
    }
}