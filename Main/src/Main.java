import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static int[] mm;
    private static int count;
    private static LinkedList<Node> part;//空闲分区表
    private static LinkedList<Node> reqd;//已分配的内存
    private static int maxMem;

    private static class Node {
        int start;
        int end;
        int size;
        int idx;

        public Node() {
        }

        public Node(int start, int end, int size, int idx) {
            this.end = end;
            this.size = size;
            this.start = start;
            this.idx = idx;
        }

        public Node clon() {
            return new Node(this.start, this.end, this.size, this.idx);
        }
    }
//请求指定大小内存，返回一个句柄
    private static int mm_require(int size) {
        if (size <= 0)
            return -1;
        for (Node p : part) {
            if (p.size >= size) {
                p.size -= size;
                Node r = new Node();
                r.start = p.start;
                r.end = p.start + size - 1;
                r.size = size;
                r.idx = ++count;
                reqd.add(r);
                if (p.size == 0) {
                    part.remove(p);
                } else {
                    p.start += size;
                }
                return r.idx;
            }
        }
        return -1;
    }
//从某一位置开始分配请求大小的内存
    private static int mm_require(int start, int size) {
        int id = 0;
        if (start < 0 || size <= 0)
            return -1;
        for (Node p : part) {
            if (p.start <= start && start + size - 1 <= p.end) {
                Node r = new Node();
                r.start = start;
                r.end = start + size - 1;
                r.size = size;
                r.idx = ++count;
                reqd.add(r);
                if (p.start == start) {
                    p.size -= size;
                    if (p.size == 0) {
                        part.remove(p);
                    } else {
                        p.start += size;
                    }
                } else {
                    int tend = p.end;
                    p.end = start - 1;
                    p.size = p.end - p.start + 1;
                    if (start + size - 1 != p.end) {
                        Node temp = new Node();
                        temp.start = start + size;
                        temp.end = tend;
                        temp.size = temp.end - temp.start + 1;
                        part.add(id + 1, temp);
                    }
                }
                return r.idx;
            }
            id++;
        }
        return -1;
    }
//释放句柄指向的内存空间
    private static boolean mm_release(int handle) {
        for (Node r : reqd) {
            if (r.idx == handle) {
                reqd.remove(r);
                for (int i = 0; i < part.size(); i++) {
                    Node p = part.get(i);
                    if (p.end + 1 == r.start) {
                        p.end = r.end;
                        p.size = p.end - p.start + 1;
                        initpart();
                        return true;
                    } else if (r.end + 1 == p.start) {
                        p.start = r.start;
                        // defrag();
                        return true;
                    }
                }
                Node temp = new Node();
                temp.start = r.start;
                temp.end = r.end;
                temp.size = r.size;
                for (int j = 0; j < part.size(); j++) {
                    if (temp.start < part.get(j).start) {
                        part.add(j, temp);
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }
//碎片整理
    private static void defrag() {
        Node temp = new Node();
        for (Node p : part) {
            temp.size += p.size;
        }
        temp.end = maxMem - 1;
        temp.start = maxMem - temp.size;
        part.clear();
        part.add(temp);
        LinkedList<Node> newreq = new LinkedList<Node>();
        for (int i = 1; i < reqd.size(); i++) {
            for (int j = i + 1; j <= reqd.size(); j++) {
                Node temp1 = reqd.get(i - 1);
                Node temp2 = reqd.get(j - 1);
                if (temp1.start > temp2.start) {
                    Node clon = temp1.clon();
                    temp1.idx = temp2.idx;
                    temp1.end = temp2.end;
                    temp1.size = temp2.size;
                    temp1.start = temp2.start;
                    temp2.idx = clon.idx;
                    temp2.end = clon.end;
                    temp2.size = clon.size;
                    temp2.start = clon.start;
                }
            }
        }
        Node firstr = new Node();
        firstr.start = 0;
        for (Node p : reqd) {
            Node t = new Node();
            t.start = firstr.start;
            t.end = firstr.start + p.size - 1;
            t.size = p.size;
            t.idx = p.idx;
            newreq.add(t);
            firstr.start += p.size;
        }
        reqd = newreq;
    }

    private static void initpart() {
        for (int j = 0; j < part.size() - 1; j++) {
            Node temp1 = part.get(j);
            Node temp2 = part.get(j + 1);
            if (temp1.end + 1 == temp2.start) {
                part.remove(temp2);
                temp1.end = temp2.end;
            }
        }
    }

    private static void init() {
        part = new LinkedList<Node>();
        reqd = new LinkedList<Node>();
        Node first = new Node();
        first.start = 0;
        first.end = maxMem - 1;
        first.size = maxMem;
        first.idx = 0;
        part.add(first);
        count = 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        maxMem = in.nextInt();
        mm = new int[maxMem];
        init();
        while (t > 0) {
            String instruct = in.nextLine();
            if (!instruct.equals("")) {
                int n1 = instruct.indexOf(" ");
                if (n1 != -1) {
                    String op = instruct.substring(0, n1);
                    if ("new".equals(op)) {
                        int n2 = instruct.indexOf(" ", n1 + 1);
                        if (n2 != -1) {
                            int start = Integer.valueOf(instruct.substring(
                                    n1 + 1, n2));
                            int size = Integer.valueOf(instruct
                                    .substring(n2 + 1));
                            int handle = mm_require(start, size);
                            if (handle != -1)
                                System.out.println(handle);
                            else
                                System.out.println("NULL");
                        } else {
                            int size = Integer.valueOf(instruct
                                    .substring(n1 + 1));
                            int handle = mm_require(size);
                            if (handle != -1)
                                System.out.println(handle);
                            else
                                System.out.println("NULL");
                        }
                    } else if ("delete".equals(op)) {
                        int handle = Integer
                                .valueOf(instruct.substring(n1 + 1));
                        if (!mm_release(handle)) {
                            System.out.println("ILLEGAL_OPERATION");
                        }
                    }
                } else {
                    defrag();
                }
                t--;
            }
        }
    }
}