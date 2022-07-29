import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class S21339 {
    static int p = 0;
    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        Scanner scanner;
        MyList list = new MyList();
        int  x, k;
        try {
            scanner = new Scanner(path);
            k = Integer.parseInt(scanner.next());
            while (scanner.hasNext()){
                list.add(Integer.parseInt(scanner.next()));
            }
            for (int i = 1;i<=k;i++){
                x = list.get(list.head, 0,p).val;
                if (x % 2 == 1){
                    list.ADD(p);
                    p = check(list.size(list.head, 0), x,p);

                }else{
                    int val =  list.DELETE(p);
                    if (list.size(list.head, 0) == 0)
                        break;
                    else
                        p = check(list.size(list.head, 0),val,p );

                }
            }
            list.showP(p,0);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int check(int size, int x, int p){
        int sum = 0;
        if (size !=0)
        sum = (p + x) % size;
        return sum;
    }
}



class MyList {

    Elem head;
    Elem tail;

    public void add(int o) {
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

    }

    public int remove(int p) {
        Elem deleted = get(head, 0, p);
        int val = deleted.val ;
        if (head.next == null)
            head = null;
        else {
            Elem e;
            if (p == 0) {
                head = head.next;
                S21339.p--;
            }
            else if (deleted == tail) {
                tail = tail.prev;
                get(head, 0, p-1).next = null;
            }else {
                e = deleted.prev;
                get(head, 0, p-1).next = deleted.next;
            }

        }
        return val;
    }

    public void showList(Elem host){
        System.out.print( host.val + " ");
        if (host.next != null)
            showList(host.next);
        else
            System.out.println();
    }

    public int size(Elem host, int count){
        if (host == null)
            return 0;
        if (host.next != null)
            count = size(host.next,++count);
        else
            count++;
        return count;
    }

    public Elem get(Elem host, int count, int index){
        Elem get = host;
        if (count != index){
            get = get(host.next,++count,index);
        }
        return get;
    }

    public Object set(int index, int val){
        return get(head,0,index).val = val;
    }

    public void ADD(int p){
        int x = get(head,0,p).val;
        add(get(head,0,size(head,0)-1).val);
        loop(size(head,0) - 2,p+1);
        set(p+1,x-1);
    }

    public int DELETE(int p){
        int x = remove(S21339.check(size(head,0),1,p));


        return  x;
    }

    public void showP(int p, int count){
        if (size(head,0) != 0)
            System.out.print(get(head,0,S21339.check(size(head,0),0,p)).val + " ");
        if (size(head,0) != 0 && count != size(head,0)-1)
            showP(++p,++count);
        else
            System.out.println();
    }

    public void loop(int i, int end){
        if (i > end){
            set(i , get(head,0,i-1).val);
            loop(--i,end);
        }
    }

}

class Elem {
    int val;
    Elem next;
    Elem prev;

    public Elem(int val, Elem next, Elem prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public Elem(Elem e){
        val = e.val;
        next = e.next;
        prev = e.prev;
    }

}

