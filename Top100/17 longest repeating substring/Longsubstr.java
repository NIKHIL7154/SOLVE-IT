
import java.util.HashMap;



/*
 You are given a string s and an integer k. You can choose any
character of the string and change it to any other uppercase
English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same
letter you can get after performing the above operations.
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
 
 */



public class Longsubstr {

    static void mylogic(){
        String s="BABABBBCBBD";
        int k=2;
        int ans=1;
        for (int i = 0; i < s.length(); i++) {
            char key=s.charAt(i);
            int left=i,right=i;
            int cost=0;
            //checking left
            while(left>0 && cost<=k){
                if(s.charAt(left-1)==key){
                    left--;
                }else if(cost<k){
                    cost++;
                    left--;
                }else{
                    cost++;
                }
            }
            System.out.println(left+" "+right);
            ans=Math.max(ans,right-left+1);
            cost=0;
            left=i;
            while(right<s.length()-1 && cost<=k){
                if(s.charAt(right+1)==key){
                    right++;
                }else if(cost<k){
                    cost++;
                    right++;
                }else{
                    cost++;
                }
            }
            System.out.println(left+" "+right);
            right=i;
            ans=Math.max(ans,right-left+1);
            cost=0;
            while(cost<=k && (left>0 || right <s.length()-1)){
                
                if(left>0){
                    if(s.charAt(left-1)==key){
                        left--;

                    }else if(cost<k){
                        cost++;
                        left--;
                    }else{
                        cost++;
                    }
                }
                if(right<s.length()-1){
                    if(s.charAt(right+1)==key){
                        right++;
                    }else if(cost<k){
                        cost++;
                        right++;
                    }else{
                        cost++;
                    }
                }
            }
            System.out.println(left+" "+right);
            ans=Math.max(ans,right-left+1);
            
        }
        System.out.println(ans);
    }
    //this approach is o(n) why cause we are only checking the max frequency when we are encountering changes to be done more then k
    public static void main(String[] args) {
        String s="BABRRABBAQXEBCBBD";
        int maxLength=1;
        int maxCount=0;
        int k =2;
        HashMap<Character,Integer> counter=new HashMap<>();
        int left=0;
        for (int right = 0; right < s.length(); right++) {
            char curChar=s.charAt(right);

            counter.put(curChar, counter.getOrDefault(curChar, 0)+1);
            maxCount=Math.max(maxCount, counter.get(curChar));

            if((right -left +1 -maxCount) >k){
                char leftChar=s.charAt(left);
                counter.put(leftChar, counter.get(leftChar)-1);
                left++;
            }

            maxLength=Math.max(maxLength,right-left+1);
            
        }

        System.out.println(maxLength);
    }
}
