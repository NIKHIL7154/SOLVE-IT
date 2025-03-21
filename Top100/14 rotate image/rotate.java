import java.util.Arrays;

public class rotate {

    static int[][] bruteforce(int[][] arr){
        int[][] res=new int[4][4];
        int n= arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            for(int j=0;j<arr[0].length;j++){
                res[j][n-i]=arr[i][j];
            }
        }
        return res;
    }

    static void inplaceTranspose(int[][] arr){
        int i=0,j=0;
        int n=arr.length;
        while(i<n && j<n){
            for(int k=i+1;k<n;k++){
                
                int temp=arr[i][k];
                arr[i][k]=arr[k][j];
                arr[k][j]=temp;
            }
            i++;
            j++;
        }
       //above was my logic but it says it might fail in some cases
       /* for (int i = 0; i < arr.length; i++) {
           for (int j = i+1; j < arr.length; j++) {
            int temp=arr[i][j];
            arr[i][j]=arr[j][i];
            arr[j][i]=temp;
               
           }
           
       } */
        
    }

    static void reverseEachRow(int[][] arr){
        for(int[] row:arr){
            int i=0;
            int j=row.length-1;
            while(i<j){
                int temp=row[i];
                row[i]=row[j];
                row[j]=temp;
                i++;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        /* int[][] arr={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        }; */
        int[][] arr={
            {1,2,3},
            {4,5,6},
            {7,8,9}
            
        };

       

        inplaceTranspose(arr);//transpose of a matrix inplace
        reverseEachRow(arr); //reverse each row of matrix to get the roatated image
        for(int[] k:arr){

            System.out.println(Arrays.toString(k));
        }
    }
}
