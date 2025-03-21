




public class islands {
    static boolean isSafe(int[][] arr,int i,int j){
        return i>=0 && i<5 && j>=0 && j<5 && arr[i][j]==1;
    }

    static void startIslanding(int[][] arr,int i,int j){
        arr[i][j]=0;
        //check if can go right
        if(isSafe(arr, i, j+1)){
            startIslanding(arr, i, j+1);
        }

        //check if can go down
        if(isSafe(arr, i+1, j)){
            startIslanding(arr, i+1,j);
        }

        //check if can go left
        if(isSafe(arr, i,j-1)){
            startIslanding(arr, i, j-1);
        }

        //check if can go up
        if(isSafe(arr, i-1, j)){
            startIslanding(arr, i-1, j);
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1, 0, 0, 1, 1},
            {1, 0, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 0, 1}
        };
        int res=0;
        
        
        
        for(int i=0;i<5;i++){
            for (int j = 0; j < 5; j++) {
                if(arr[i][j]==1){
                    //make all connected 1s into 0 to make an island
                    startIslanding(arr, i, j);
                    res++;
                }
                
                
            }
        }
        System.out.println(res);
        

    }
}
