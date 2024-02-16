import java.util.Vector;

public class History {
    private Vector<String> hist;

    History() {
        hist = new Vector<String>();
    }

    public void addHistory(String h) {
        hist.add(h);
    }
    public Vector<String> getHistory() {
        return hist;
    }
}
