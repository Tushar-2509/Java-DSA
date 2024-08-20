public class rat {
    static int next_row[]={0,1,0,-1};
    static int next_col[]={1,0,-1,0};
    static char move[]={'R','B','L','T'};

    static boolean validate(int n,int row,int col,int maze[][]){
        return (row>=0 && row<n) && (col>=0 && col<n) && (maze[row][col]==1);
    }

    static void findpath(int n,int row,int col,int maze[][],String res){
        if(row==n-1 && col==n-1){
            System.out.print(res);
        }
        maze[row][col]=0;
        for(int i=0;i<n;i++){
            int n_row=row+next_row[i];
            int n_col=col+next_col[i];

            if(validate(n,n_row,n_col,maze)){
                findpath(n, n_row, n_col, maze,res+move[i]);
            }
        }
        maze[row][col]=1;
    }

    public static void main(String[] args) {
        int maze[][]={{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
        int n=maze.length;
        if(maze[0][0]!=0 && maze[n-1][n-1]!=0){
            findpath(n,0,0,maze,"");
        }
        else{
            System.out.println("No path");
        }
        }
    }
