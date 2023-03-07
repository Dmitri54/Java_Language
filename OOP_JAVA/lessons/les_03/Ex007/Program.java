package OOP_JAVA.lessons.les_03.Ex007;

// три вода
public class Program {
    public static void main(String[] args) {
        Coffee latte = new Coffee();
        latte.addComponent(new Water("вода"));
        latte.addComponent(new Water("вода"));
        latte.addComponent(new Water("вода"));
        for (var ingredient : latte) {
            System.err.println(ingredient); // вода
// Покажет только одно вхождение.
        }
    }
}