package main;

class Pair{
    int i;
    int j;
    Pair(int i , int j){
        this.i = i;
        this.j = j;
    }
}
class PairWrapper{
    Pair pair ;
    PairWrapper(Pair p){
        this.pair = p;
    }

    @Override
    public String toString() {
        return "PairWrapper{" +
                "pair= i " + pair.i +
                " j : "+ pair.j+
                '}';
    }
}
public class SwapingTest {
    public static void main(String[] args) {
        int i = 10 ;
        int j = 20 ;
        swap(10, 20);
        Pair p1 = new Pair(10, 20);
        Pair p2 = new Pair(30, 40);
        swap(p1);
        System.out.println(i+ " "+ j);
        System.out.println(p1.i + " "+ p1.j);
        PairWrapper pw1 = new PairWrapper(p1);
        PairWrapper pw2 = new PairWrapper(p2);
        swap(pw1, pw2);
        System.out.println(pw1.toString());
        System.out.println(pw2.toString());
    }

    private static void swap(PairWrapper pw1, PairWrapper pw2) {
        Pair temp = pw1.pair;
        pw1.pair = pw2.pair;
        pw2.pair = temp;
    }

    private static void swap(Pair p1) {
        int temp = p1.i;
        p1.i = p1.j;
        p1.j = temp;
    }

    private static void swap(int i, int j) {
        int temp = i;
        i = j ;
        j = temp;
    }
}
