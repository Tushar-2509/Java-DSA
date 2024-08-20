public class double_linked {
    node head=null;
    node tail=null;
    class node{
        int data;
        node next;
        node prev;
        node(int d){
            data=d;
            next=null;
            prev=null;
        }
    }
    void add(int x){
        node new_node=new node(x);
        if(head==null){
            head=new_node;
            tail=new_node;
            }
            else{
                tail.next=new_node;
                new_node.prev=tail;
                tail=tail.next;
            }
        }
        void add_first(int x){
            node new_node=new node(x);
            if(head==null){
                head=new_node;
                tail=new_node;}
                else{
                    new_node.next=head;
                    head.prev=new_node;
                    head=new_node;
                }
        }
        void add_last(int x){
            node new_node=new node(x);
            tail.next=new_node;
            new_node.prev=tail;
            tail=new_node;
        }
        void del_first(){
            if(head!=null){
                node temp=head;
                head=head.next;
                temp.next=null;
                head.prev=null;


            }
        }
        void del_last(){
            if(head!=null){
                tail=tail.prev;
                tail.next=null;

            }

        }
        void del_index(int index){
            if(index==0){
                del_first();
            }
            else{
                if(head!=null){
                    node temp=head;
                    while(index>1 && temp.next!=null){
                        index--;
                        temp=temp.next;
                    }
                    if(temp.next!=null){
                        if(temp.next.next!=null){
                            temp.next.prev=null;
                            temp.next.next.prev=temp;
                            temp.next=temp.next.next;
                        }
                        else{
                            temp.next.prev=null;
                            temp.next=temp.next.next;
                            tail=temp;
                        }
                    }
                }
            }
        }
        void rev(){
            if(head!=null){
                node temp=tail;
                while(temp!=null){
                    System.out.print(temp.data+"<=>");
                    temp=temp.prev;}
                }
        }
        void display(){
            node temp=head;
            System.out.println();
            while(temp!=null){
                System.out.print(temp.data+"<=>");
                temp=temp.next;
            }
            System.out.print("null");
        }
        public static void main(String[] args) {
            double_linked dll=new double_linked();
            dll.add(10);
            dll.add(20);
            dll.add(30);
            dll.add_first(5);
            dll.add_last(40);
            dll.del_first();
            dll.del_index(2);
            dll.rev();
            dll.display();
        }
    }
