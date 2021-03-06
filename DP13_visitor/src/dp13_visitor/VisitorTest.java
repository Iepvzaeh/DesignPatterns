package dp13_visitor;

/**
 * A class containing the main method.
 *
 * This project is an experiment on the combination of state and visitor design
 * patterns.
 *
 * It models characters who own diamonds and that have different behaviours
 * `move`, `breathe` and `grow`. The behaviours depend on the state of the
 * context (`Character` implementing objects), which are encapsulated in the
 * state objects i.e. implementations of the `CharacterState` interface. The
 * `grow` method switches the state of the context object, whereas the others
 * just print stuff to the console.
 *
 * The characters get diamonds from a diamond dealer upon request. This
 * behaviour is achieved by the visitor design pattern. The
 * `BonusVisitorDiamondDealer` is the visitor and the `Frog` and `Dragon` are
 * the elements to be visited.
 *
 * When the context method `accept` is called with a `BonusVisitor` object as a
 * parameter, it delegates the call to it's state object which calls the visitor
 * object's `visit` method, which in turn gives diamonds to the context object.
 * The amount of diamonds is unique to each state object.
 *
 * @author Antti Nieminen
 */
public class VisitorTest {

    public static void main(String[] args) {
        BonusVisitor diamondDealer = new BonusVisitorDiamondDealer();
        Character dragon = new Dragon(new DragonYoung());
        for (int i = 0; i < 3; i++) {
            dragon.breathe();
            dragon.move();
            dragon.accept(diamondDealer);
            System.out.println("It has " + dragon.getDiamonds() + " diamonds.");
            dragon.grow();
        }

        Character frog = new Frog(new FrogYoung());
        for (int i = 0; i < 3; i++) {
            frog.breathe();
            frog.move();
            frog.accept(diamondDealer);
            System.out.println("It has " + frog.getDiamonds() + " diamonds.");
            frog.grow();
        }

    }

}
