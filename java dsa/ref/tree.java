import java.util.*;
class tree{
    tree_node root=null;
    class tree_node{
        int data;
        tree_node left;
        tree_node right;
        tree_node(int x){
            data=x;
            left=null;
            right=null;
        }
    }
    void insert(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter root value");
        int val=sc.nextInt();
        if(val!=-1){
            tree_node new_node=new tree_node(val);
            root=new_node;
            insert(root);        
        }
    }
    void insert(tree_node curr){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter left value of "+curr.data+":");
        int left_val=sc.nextInt();
        if(left_val!=-1){
            tree_node new_node=new tree_node(left_val);
            curr.left=new_node;
            insert(curr.left);
            }
            System.out.println("enter right value of "+curr.data+":");
            int right_val=sc.nextInt();
            if(right_val!=-1){
                tree_node new_node=new tree_node(right_val);
                curr.right=new_node;
                insert(curr.right);}
    }
    void preorder(tree_node curr){
        if(curr==null){
            return;
        }
        System.out.print(curr.data+"=>");
        preorder(curr.left);
        preorder(curr.right);
    }
    void inorder(tree_node curr){
        if(curr==null){
            return;
        }
        preorder(curr.left);
        System.out.print(curr.data+"=>");
        preorder(curr.right);
    }
    void postorder(tree_node curr){
        if(curr==null){
            return;
        }
        preorder(curr.left);
        preorder(curr.right);
        System.out.print(curr.data+"=>");
    }
    int sum(){
        return sum(root);
    }
    int sum(tree_node curr){
        if(curr==null){
            return 0;
        }
        else{
            return curr.data+sum(curr.left)+sum(curr.right);
        }
    }
    int count(){
        return count(root);
    }
    int count(tree_node curr){
        if(curr==null){
            return 0;
        }
        else{
            return 1+count(curr.left)+count(curr.right);
        }
    }
    boolean search(int key){
        return search(root,key);
    }
    boolean search(tree_node curr,int key){
        if(curr==null){
            return false;
        }
        else if(curr.data==key){
            return true;
        }
        else{
            return search(curr.left,key)||search(curr.right,key);
        }
    }
    int leaf_count(){
        return leaf_count(root);
    }
    int leaf_count(tree_node curr){
        if(curr==null){
            return 0;
        }
        else if(curr.left==null && curr.right==null){
            return 1;//curr.data;
        }
        else{
            return leaf_count(curr.left)+leaf_count(curr.right);
        }
    }
    int min(){
        return min(root);
    }
    int min(tree_node curr){
        if(curr==null){
            return Integer.MAX_VALUE;
        }
        else{
            return Integer.min(curr.data,Integer.min(min(curr.left),min(curr.right)));
        }
    }
    int height(){
        return height(root);
    }
    int height(tree_node curr){
        if(curr==null){
            return 0;
        }
        else{
            return 1+Integer.max(height(curr.left),height(curr.right));
        }
    }

    public static void main(String[] args) {
        tree bt=new tree();
        bt.insert();
        System.out.println("preorder traversal");
        bt.preorder(bt.root);
        // System.out.println();
        // System.out.println("inorder traversal");
        // bt.inorder(bt.root);
        // System.out.println();
        // System.out.println("postorder traversal");
        // bt.postorder(bt.root);
        int sum=bt.sum();
        System.out.println();
        System.out.println("sum="+sum);
        int count=bt.count();
        System.out.println();
        System.out.println("count="+count);
        System.out.println();
        System.out.println(bt.search(50));
        System.out.println();
        int min=bt.min();
        System.out.println("min="+min);
    }
} 