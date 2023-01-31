package JavaCode;

public class constructor {
    static String str;
    public void constructor(){
        System.out.println("A");
        str = "hello world";
    }

    public static void main(String[] args) {
        constructor a = new constructor();
        System.out.println(str);
    }
}
