
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class S21339 {
    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        Scanner scanner;
        MyList list = new MyList();
        int count = 0;
        try {
            scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                list.insert(new Node(scanner.next(),Integer.parseInt(scanner.next())));
            }
        }catch(Exception e){

        }
        list.loopReady();
        list.loopCode(list.head.node,"");


    }
}
class MyList {

    Elem head;
    Elem tail;
    int size;

    public void add(Node o) {
        if (head == null) {
            head = new Elem(o, null, null);
        }else {
            if (head.next == null) {
                tail = new Elem(o, null, head);
                head.next = tail;
            }
            else {
                Elem el = new Elem(o, null, tail);
                tail.next = el;
                tail = tail.next;
            }

        }
        size++;
    }

    public String remove(int p) {
        Elem deleted = get(head, 0, p);
        String val = deleted.node.getLetter();
        if (head.next == null)
            head = null;
        else {
            Elem e;
            if (p == 0) {
                head = head.next;
            }
            else if (deleted == tail) {
                tail = tail.prev;
                get(head, 0, p-1).next = null;
            }else {
                e = deleted.prev;
                get(head, 0, p-1).next = deleted.next;
            }

        }
        size--;
        return val;
    }

    public void showList(Elem host){
        if (host.next != null)
            showList(host.next);
        else
            System.out.println();
    }

    public Elem get(Elem host, int count, int index){
        Elem get = host;
        if (count != index && host.next != null){
            get = get(host.next,++count,index);
        }
        return get;
    }

    public Object set(int index, Node node){
        return get(head,0,index).node = node;
    }

    public void loopSortFreq(int i,Node newTree){
        boolean cont = true;
        if (get(head,0,i).node.getFrequence() > newTree.getFrequence()) {//если частота вставляемого дерева меньше
            add(get(head,0,size-1).node);
            loopFor((size - 2),i+1);
            set(i,newTree);
            cont = false;
        }
        if (i == size - 1 && cont == true) {
            add(newTree);
            cont = false;
        }
        if (i < size && cont == true) {
            loopSortFreq(++i, newTree);
        }
    }

    public void loopFor(int i, int end){
        set(i , get(head,0,i-1).node);
        if (i > end)
            loopFor(--i,end);
    }

    public void loopReady(){
        if (size > 1){
            Node connect = new Node(head.node.getLetter() + head.next.node.getLetter(),
                                 head.node.getFrequence()+head.next.node.getFrequence());
            connect.addChild(head.node);
            connect.addChild(head.next.node);
            remove(0);
            remove(0);
            insert(connect);
            loopReady();
        }
    }

    public void loopCode(Node head, String code){
        if (head.isLeaf()){
            System.out.println(head.getLetter() + " " + code);
        }else {
            loopCode(head.getLeftChild(),code + "0");
            loopCode(head.getRightChild(),code + "1");
        }
    }

    public void insert(Node node) {
        if (size == 0)
            add(node);
        else {
            loopSortFreq(0,node);
        }
    }

}

class Elem {
    Node node;
    Elem next;
    Elem prev;

    public Elem(Node node, Elem next, Elem prev) {
        this.node = node;
        this.next = next;
        this.prev = prev;
    }

}

class Node {
    private int frequence;
    private String letter;
    private Node leftChild;
    private Node rightChild;

    public Node(String letter, int frequence) {
        this.letter = letter;
        this.frequence = frequence;
    }

    public void addChild(Node newNode) {
        if (leftChild == null)
            leftChild = newNode;
        else {
            if (leftChild.getFrequence() <= newNode.getFrequence())
                rightChild = newNode;
            else {
                rightChild = leftChild;
                leftChild = newNode;
            }
        }


    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getFrequence() {
        return frequence;
    }

    public String getLetter() {
        return letter;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
}

