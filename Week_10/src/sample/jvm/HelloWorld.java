package sample.jvm;

/**
 * Test JVM
 *
 * @author YangQi
 */
public class HelloWorld {

    public void hello() {
        System.out.println("Hello JVM!");
    }

    public static void main(String[] args) {
        HelloWorld demo = new HelloWorld();
        demo.hello();
    }
}
