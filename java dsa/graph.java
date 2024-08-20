import java.util.*;
public class graph {
    
    void display(int graph[][],int vertex){
        for(int i=0;i<vertex;i++){
            System.out.print(i+"=> ");
            for(int j=0;j<vertex;j++){
                if(graph[i][j]==1){
                    System.out.print(j+" ");
                }
                
            }
            System.out.println();
        }
    }
    void create(Scanner sc,int graph[][],int vertex){
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                if(i==j) continue;
                System.out.println("Do you want to make an edge between"+i+"->"+j+"(Y/N)");
                char flag=sc.next().charAt(0);
                flag=(flag=='Y'||flag=='y')?'Y':'N';
                if(flag=='Y'){
                    graph[i][j]=1;
                }
            }
        }
    }
    void bfs(int graph[][],int v,int s){
        if(s<0 || s>=v) return;
        boolean visited[]=new boolean[v];
        visited[s]=true;
        Queue<Integer> que=new LinkedList<>();
        que.add(s);

        for(int i=0;i<v;i++){
            s=que.remove();
            System.out.println(s+" ");
            for(int j=0;j<v;j++){
                if(!visited[j] && graph[s][j]==1){
                    que.add(j);
                    visited[j]=true;
                }
            }
        }
    }
    void dfs(int graph[][],boolean visited[],int vertex,int st){
        if(st<0||st>=vertex||visited[st]){
            return;
        }
        else{
            System.out.println(st+" ");
            visited[st]=true;
            for(int i=0;i<vertex;i++){
                if(graph[st][i]==1 && !visited[i]){
                    dfs(graph,visited,vertex,i);
                }
            }
        }
    }
    void add_edge(int graph[][],int x,int y){
        graph[x][y]=1;
        graph[y][x]=1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        graph g=new graph();
        int vertex=5;
        int graph[][]=new int[vertex][vertex];
        
        g.add_edge(graph,0,1);
        g.add_edge(graph,0,4);
        g.add_edge(graph,1,0);
        g.add_edge(graph,1,2);
        g.add_edge(graph,1,3);
        g.add_edge(graph,2,0);
        // g.create(sc, graph, vertex);
        g.display(graph,vertex);
        g.bfs(graph, vertex, 2);
        boolean visited[]=new boolean[vertex];
        g.dfs(graph, visited, vertex, 0);
    }    
}
