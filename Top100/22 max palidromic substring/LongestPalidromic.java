
public class LongestPalidromic {
    public static void main(String[] args) {

        String s="aasdaadsllolls";
        int maxlen=0;
        String ans="";
        for(int i=0;i<s.length();i++){
        
            for(int j=i;j<i+2 && j<s.length();j++){
                
                int l=i;
                int r=j;
                
                while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;
                }
                l++;
                r--;
                int len=r-l+1;
                if(len>maxlen){
                    maxlen=len;
                    ans=s.substring(l,r+1);
                }
               
            }
            
        }
        System.out.println(ans);
        
    
    }
}
