
import java.util.ArrayList;
import java.util.HashMap;

public class numkeypad {
    public void craftAnswer(ArrayList<String> res,StringBuilder sb,String num,int n,HashMap<Character, String> map,int i){
        if(i>=n){
            res.add(sb.toString());
            return;
        }
        
        String cur=map.get(num.charAt(i));
        for(int j=0;j<cur.length();j++){
            sb.append(cur.charAt(j));
            
            craftAnswer(res, sb, num, n, map, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        String num = "6454450842587";
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', " ");
        map.put('1', ".");
        ArrayList<String> res=new ArrayList<>();
        numkeypad nm=new numkeypad();
        StringBuilder sb=new StringBuilder("");
        nm.craftAnswer(res,sb,num,num.length(),map,0);
        System.out.println(res);


        
}

}