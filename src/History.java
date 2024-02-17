import java.util.Vector;

public class History {
    private Vector<String> hist;

    History() {
        hist = new Vector<String>();
    }

    public void clearHistory() {
            hist.clear();
    }

    public Vector<String> getHistory() {
        return hist;
    }
}
