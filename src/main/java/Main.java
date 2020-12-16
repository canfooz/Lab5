/**
 * @autor Chekmarev Andrey
 * 3rd year, 7th group
 * @version 1.0
 *  Main class
 */

public class Main {

    public static void main(String[] args) throws Exception {
        InjectTest injectTest = new Injector().inject(new InjectTest());
        injectTest.doSmth();
    }
}