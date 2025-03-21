import java.util.Arrays;

public class matrix {
    public static void main(String[] args) {
        int[][] arr={
            {1,1,1,1,1},
            {1,1,1,0,1},
            {1,0,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
        };
        int rows=arr.length,cols=arr[0].length;
        boolean[] rowFlags=new boolean[rows];
        boolean[] colFlags=new boolean[cols];
        for(int i=0;i<rows;i++){
            for (int j = 0; j < cols; j++) {
                if(arr[i][j]==0){
                    rowFlags[i]=true;
                    colFlags[j]=true;
                }
                
            }
        }
        for (int i = 0; i < rowFlags.length; i++) {
            for (int j = 0; j < colFlags.length; j++) {
                if(rowFlags[i] || colFlags[j]){
                    arr[i][j]=0;
                }
                
            }
            
        }
        for(int[] l:arr){
            System.out.println(Arrays.toString(l));
        }
    }
}
