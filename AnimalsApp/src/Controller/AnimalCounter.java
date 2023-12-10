package Controller;

public class AnimalCounter {
    private Integer counter;
    public AnimalCounter() {
        this.counter = 0;
    }
    public void add() {
        this.counter++;
    }
    public void remove () {
        this.counter--;
    }
    public int get () {
        return this.counter;
    }
}
