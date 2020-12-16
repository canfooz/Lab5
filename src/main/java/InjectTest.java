/**
 * @autor Chekmarev Andrey
 * 3rd year, 7th group
 * @version 1.0
 *  Class where something can be injected
 */

public class InjectTest {

    /**
     * Marks that the field will be injected
     */
    @AutoInjectable

    /**
     * Any successor of SomeInterface
     */
    private SomeInterface child;

    public void doSmth (){

        child.doSmth();
    }
}