
    

public class searchword {
    private static int callstack=0;
    static void startSearchFromHere(char[][] arr,String word,boolean[][] visited,int i,int j,int s,boolean[] ans){
        callstack++;
        if(s>=word.length()){
            ans[0]=true;
            return;
        }
        if(i>=0 && i<arr.length && j>=0 && j<arr[0].length && !visited[i][j]  && arr[i][j]==word.charAt(s)){
            visited[i][j]=true;
            //checking right
            startSearchFromHere(arr, word, visited, i, j+1, s+1, ans);

            //checking down
            startSearchFromHere(arr, word, visited, i+1, j, s+1, ans);

            //checking left
            startSearchFromHere(arr, word, visited, i, j-1, s+1, ans);

            //checking up
            startSearchFromHere(arr, word, visited, i-1, j, s+1, ans);
            
        }
    }
    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "EEDASABFCCEB";
        //we can use dfs
        
        boolean[] ans={false};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited= new boolean[board.length][board[0].length];
                    startSearchFromHere(board,word,visited,i,j,0,ans);
                    if(ans[0]){
                        System.out.println("Found : Starts from "+i+", "+j);
                        break;
                        
                    }
                }
                

                
            }
            if(ans[0]){
                break;
            }
            
        }
        if(!ans[0]){
            System.out.println("Not Found");
        }
        System.out.println("Call stack "+callstack);
        
        
    }
}
