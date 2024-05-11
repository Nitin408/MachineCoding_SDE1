package Model;

public class Player {
    public Player(String playerName) {
        this.currentPosition = 0;
        this.playerName = playerName;
    }

    private int currentPosition;
    private String playerName;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
