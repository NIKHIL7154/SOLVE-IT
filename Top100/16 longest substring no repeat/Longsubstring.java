
import java.util.HashSet;


public class Longsubstring {
    public static void main(String[] args) {
        String s= "abcabcdegab";
        int m=1;
        int i=0;
        HashSet<Character> set=new HashSet<>();
        for (int j = 0; j < s.length(); j++) {
            char key=s.charAt(j);
            while(set.contains(key)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(key);
            m=Math.max(m,j-i+1);

            
        }
        System.out.println(m);
    }
}
