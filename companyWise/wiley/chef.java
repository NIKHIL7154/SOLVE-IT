
import java.util.*;


public class chef {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        sc.nextLine();
        String[] data=new String[t];
        for (int i = 0; i < t; i++) {
            data[i]=sc.nextLine();
        }
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        int c=Integer.MAX_VALUE;

        for (String ele:data) {
            String[] parts=ele.split(" ");
            switch(parts[0]){
                case "A" -> a=Math.min(a,Integer.parseInt(parts[1]));
                case "B" -> {
                    b=Math.min(b,Integer.parseInt(parts[1]));
                    
                }
                default -> c=Math.min(c,Integer.parseInt(parts[1]));

            }
            
        }
        System.out.println(Math.min(a+b,c));
    }
}
