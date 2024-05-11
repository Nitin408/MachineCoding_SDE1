package Model;

public class Ladder {
    public Ladder(int startPosition, int endPosition) {
        this.endPosition = endPosition;
        this.startPosition = startPosition;
    }

    private int startPosition;
    private int endPosition;

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }
}
