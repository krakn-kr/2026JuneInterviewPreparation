public class Main {
    public static void main(String[] args) {
        Integer i = 10;
        i = 20;
        System.out.println(i);
        Test t = new Test();
        System.out.println(t.hashCode());
        t = new Test();
        System.out.println(t.hashCode());


    }
}
class Test{

}
