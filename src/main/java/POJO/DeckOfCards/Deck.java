package POJO.DeckOfCards;

public class Deck {
    private boolean success;
    private String deck_id;
    private boolean shuffled;
    private int remaining;

    // Getter and Setter for success
    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    // Getter and Setter for deck_id
    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    // Getter and Setter for shuffled
    public boolean getShuffled() {
        return shuffled;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }

    // Getter and Setter for remaining
    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
