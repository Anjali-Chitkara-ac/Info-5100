package Assignment6;

public class Tester {
    public static void main(String[] args) {
        Cat a = new Cat("Ginger","Stacy","white","Short");
        a.setBoardStart(12,10,2019);
        a.setBoardEnd(1,24,2020);
        System.out.println(a.toString());

        boolean b = a.boarding(1,1,2020);
        System.out.println(b);

        boolean b1 = a.boarding(12,29,2019);
        System.out.println(b1);

        Dog d = new Dog("Tuffy","Joe","Golden","Medium");
        d.setBoardStart(2,3,2020);
        d.setBoardEnd(5,6,2020);
        System.out.println(d.toString());

        boolean b2 = d.boarding(3,5,2020);
        System.out.println(b2);
    }

}
