public class linkedlist {
    node head=null;
    
    class node{
        int data;
        node next;
        node (int val){
            data=val;
            next=null;
        }
    }

    void add(int val){
        node new_node=new node(val);
        if(head==null){
            head=new_node;
        }
        else{
            node temp=head;
            while(temp.next!=null){
                temp=temp.next;
                }
                temp.next=new_node;
                }
    }
    void add_at_first(int val){
        if(head==null){
            head=new node(val);
        }
        else{
        node new_node=new node(val);
        new_node.next=head;
        head=new_node;}
    }
    // void add_at_last(int val){
    //     node new_node=new node(val);
    //     node temp=head;
    //     while(temp)
    // }
    void insert(int val,int pos){
        if (pos<0){
            System.out.println("invalid position");
        }
        else if(pos==0){
            add_at_first(val);}
            else{
                node new_node=new node(val);
                node temp=head;
                for(int i=0;i<pos-1;i++){
                    temp=temp.next;
                    }
                    new_node.next=temp.next;
                    temp.next=new_node;
                    }
    }
    void del_first(){
        if(head!=null){
            head=head.next;}
    }
    void del_last(){
        if(head!=null){
        if(head.next==null){
            del_first();;
        }
        else{
            node temp=head;
            while(temp.next!=null && temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;}
        }
    }
    void del_index(int index){
        if(head!=null && index>=0){
            if(index==0){
                del_first();
            }
            else{
                node temp=head;
                while(index > 1 && temp.next!=null){
                    index--;
                    temp=temp.next;
                }
                temp.next=temp.next.next;
            }
        }
    }
    void del_alt(){
        node temp=head;
        while(temp!=null && temp.next!=null){
            temp.next=temp.next.next;
            temp=temp.next;
        }
    }
    void size(){
        //return length of LL which is the number of nodes
        int len=0;
        if(head!=null){
            node temp=head;
            while(temp!=null){
                len++;
                temp=temp.next;
            }
            System.out.println("length is "+len);
        }

    }
    void mid(int x){
        node new_node=new node(x);
        if (head==null){
            head=new_node;
        }
        else{
            node fast=head;
            node slow=head;
            while(fast.next!=null && fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            new_node.next=slow.next;
            slow.next=new_node;
        }
    }
    void seg_012(){
        node i=head;
        node j=head;
        while(j!=null){
            if(j.data==0){
                int temp=i.data;
                i.data=j.data;
                j.data=temp;
                i=i.next;
                j=j.next;
            }
            else{
                j=j.next;
            }
        }
        j=i;
        while(j!=null){
            if(j.data==1){
                int temp=i.data;
                i.data=j.data;
                j.data=temp;
                i=i.next;
                j=j.next;
            }
            else{
                j=j.next;
            }
            
        }
    }
    void sort_dup(){
        node temp=head;
        while(temp.next!=null){
            if(temp.data==temp.next.data){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;
            }
        }
    }
   
    public void removeDuplicates() {
        node current = head;

        while (current != null) {
            node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
    void display(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;}
            System.out.print("Null");
            System.out.println();
    }


    public static void main(String[] args){
        linkedlist list=new linkedlist();
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(30);
        list.add(30);
        list.add(15);
        list.add(20);
        list.removeDuplicates();
        list.display();
    }
}
