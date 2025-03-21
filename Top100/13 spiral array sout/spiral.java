
public class spiral {
    public static void main(String[] args) {
        int[][] arr = {
            {1},
            {4},
            {7},
            {10 },
            {13 }
        };
        
        int srow=0,erow=arr.length-1,scol=0,ecol=arr[0].length-1;
        System.out.println(srow+" , "+erow+" , "+scol+" , "+ecol);
        while(erow>=srow && scol<=ecol){
            //top boundary
            
            for (int i = scol; i <= ecol; i++) {
                System.out.print(arr[srow][i]+" ");
                
            }
            srow++;
            //right boundary
            
            for (int i = srow; i <= erow; i++) {
                
                System.out.print(arr[i][ecol]+" ");
                
            }
            ecol--;
            //bottom boundary
            if(!(srow<=erow)){
                break;
            }
            for (int i = ecol; i >= scol; i--) {
                
                System.out.print(arr[erow][i]+" ");
                
            }
            erow--;
            //left boundary
            if(!(scol<=ecol)){
                break;
            }
            for (int i = erow; i >= srow; i--) {
                System.out.print(arr[i][scol]+" ");
                
            }
            scol++;
            
            
        }

    }
}
