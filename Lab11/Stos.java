public class Stos<T> {
    private StosElement<T> firstElement;
    public Stos() {
        firstElement = null;
    }

    public void push(T value) {
        StosElement<T> newElement = new StosElement<T>(value);

        if (firstElement != null) {
            StosElement<T> prevElement = newElement;
            StosElement<T> nextElement = firstElement;

            while (nextElement != null) {
                prevElement.setNextElement(nextElement);
                prevElement = nextElement;
                nextElement = nextElement.getNextElement();
            }

        }
        firstElement = newElement;
    }

    public void pop() {
        firstElement = firstElement.getNextElement();
    }

    @Override
    public String toString() {
        StringBuilder reduced = new StringBuilder();
        StosElement<T> lastElement = firstElement;
        while (lastElement.getNextElement() != null) {
            reduced.append(lastElement);
            lastElement = lastElement.getNextElement();
        }
        reduced.append(lastElement);
        return reduced.toString();
    }
}

class StosElement<T> {
    private T value;
    private StosElement<T> nextElement;

    public StosElement(T value) {
        this.value = value;
        this.nextElement = null;
    }

    public StosElement<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(StosElement<T> nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public String toString() {
        return "{" + value + "} ";
    }
}
