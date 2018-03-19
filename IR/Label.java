package IR;

public class Label {
    int num;
    public Label(int n) {
        num = n;
    }
    public String toString() {
        return "L" + num;
    }
}
