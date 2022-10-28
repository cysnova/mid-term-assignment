public class Card {

    public static final int[] RANKS = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    public static final String[] SUITS = new String[]{"\u2663", "\u2666", "\u2665", "\u2660" };
    private int rank;
    private String suit;

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;


    }
//meaningful representation of the object
    public String toString() {
        return suit + " " + getRankString();
    }

    public String getRankString() {
        switch (rank) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(rank); //integer to string
        }
    }
}
