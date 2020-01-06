import java.util.ArrayList;
import java.util.stream.*;

public class Stos<T> {
    private ArrayList<T> stack;

    public Stos() {
        this.stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(0, item);
    }

    public void pop() {
        stack.remove(0);
    }

    @Override
    public String toString() {
        Stream s = this.stack.stream();
        return (String) s.reduce("", (acc, val) -> acc + "{" + val.toString() + "}" + " ");
    }
}
