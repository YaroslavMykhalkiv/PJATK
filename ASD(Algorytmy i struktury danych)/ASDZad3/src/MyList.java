//
//
//public class MyList {
//
//    Elem head;
//    Elem tail;
//
//    public void add(int o) {
//        if (head == null) {
//            head = new Elem(o, null, null);
//        }else {
//            if (head.next == null) {
//                tail = new Elem(o, null, head);
//                head.next = tail;
//            }
//            else {
//                Elem el = new Elem(o, null, tail);
//                tail.next = el;
//                tail = tail.next;
//            }
//
//        }
//
//    }
//
//    public int remove(int p) {
//        Elem deleted = get(head, 0, p);
//        int val = deleted.val ;
//        if (head.next == null)
//            head = null;
//        else {
//            Elem e;
//            if (p == 0) {
//                head = head.next;
//                Main.p--;
//            }
//            else if (deleted == tail) {
//                tail = tail.prev;
//                get(head, 0, p-1).next = null;
////                System.out.println("delete " + p);
//            }else {
////                System.out.println("delete " + p);
//                e = deleted.prev;
//                get(head, 0, p-1).next = deleted.next;
//            }
//
//        }
//        return val;
//    }
//
//    public void showList(Elem host){
//        System.out.print( host.val + " ");
//        if (host.next != null)
//            showList(host.next);
//        else
//            System.out.println();
//    }
//
//    public int size(Elem host, int count){
//        if (host == null)
//            return 0;
//        if (host.next != null)
//            count = size(host.next,++count);
//        else
//            count++;
//        return count;
//    }
//
//    public Elem get(Elem host, int count, int index){
//        Elem get = host;
//        if (count != index){
//            get = get(host.next,++count,index);
//        }
//        return get;
//    }
//
//    public Object set(int index, int val){
//        return get(head,0,index).val = val;
//    }
//
//    public void ADD(int p){
//        int x = get(head,0,p).val;
//        add(get(head,0,size(head,0)-1).val);
//        for (int i = size(head,0) - 2; i > p + 1; i--) {
//           set(i , get(head,0,i-1).val);
//        }
//        set(p+1,x-1);
//    }
//
//    public int DELETE(int p){
//        int x = remove(Main.check(size(head,0),1,p));
//
//
////        System.out.println("x= " + x);
//        return  x;
//    }
//
//    public void showP(int p, int count){
//        if (size(head,0) != 0)
//        System.out.print(get(head,0,Main.check(size(head,0),0,p)).val + " ");
//        if (size(head,0) != 0 && count != size(head,0)-1)
//        showP(++p,++count);
//        else
//            System.out.println();
//    }
//
//}
