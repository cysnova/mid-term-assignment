import java.util.*;

public class CardGame {

    private static double balance;

    private static double bet;
    private static LinkedList<Card> deck;

    public static void main(String[] args) {

        initializeDeck();
        displayInstruction();
        Scanner scanner = new Scanner(System.in);
        ante(scanner);
        boolean exitTheGame = false;
        while (!exitTheGame) {

            enterBet(scanner);
            Card first = deck.pop();
            Card second = deck.pop();
            displayInstruction2(first, second);
            String decision = null;
            boolean valid = false;

            while (!valid) {

                decision = scanner.nextLine();
                if (decision.equals("B") || decision.equals("F") || decision.equals("E")) {
                    valid = true;
                } else {
                    System.out.print("You have to enter [B], [F], [E]: ");

                }
            }

            switch (decision) {


                case "B":
                    drawThirdCard(first, second);
                    break;

                case "F":
                    foldCard();
                    break;

                case "E":
                    exitTheGame = true;
                    quit();
                    break;


            }
            if (deck.size() < 3) {
                System.out.println("There are no more cards for the next round.");
                exitTheGame = true;
            }
            if (balance <= 0) {
                System.out.println("You have insufficient fund to continue the game!");
                exitTheGame = true;
            }

            System.out.println(" ");
        }
        scanner.close();
    }

    private static void initializeDeck() {
        deck = new LinkedList<>();
        for (int rank : Card.RANKS) {
            for (String suit : Card.SUITS) {
                Card newCard = new Card(rank, suit);
                deck.add(newCard);
            }
        }
        Collections.shuffle(deck);
    }

    private static void displayInstruction2(Card first, Card second) {

        System.out.println(" ");
        System.out.println("You have received two cards: " + first.toString() + ", " + second.toString());
        System.out.println("You can choose [B]et, [F]old or [E]nd the game");
        System.out.print("Please enter [B], [F] OR [E]: ");

    }


    private static void displayInstruction() {
        System.out.println("""
                Welcome to Nova's Casino 
                ╔══╗
                ╚╗╔╝
                ╔╝(¯`v´¯)
                ╚══`.¸.*Money$$$*
                """);
        System.out.println(" ");
        System.out.println("You are playing a card game called \"Betweenies\"\uD83C\uDF78\uD83C\uDF1F\uD83C\uDF7A٩(˘◡˘ )");
        System.out.println(" ");
        System.out.println("In the game of Betweenies,you are dealt two cards out of a deck and bets on the probability");
        System.out.println("that the third card to be dealt will have a numerical value in between the values of the first two cards.");
        System.out.println("Ace will be used as a low card, with the value of 1 in this game.");
        System.out.println(" ");
        System.out.println("You can choose either fold, place a bet or exit the game in each round.");
        System.out.println("If you fold, you will lose half of your bet.");
        System.out.println("Your amount of ante should be less than or equal to your bet. ");
        System.out.println(" ");
    }

    private static void ante(Scanner scanner) {
        boolean valid = false;
        while (!valid) {
            System.out.print("Now, please put in the ante : ");
            try {
                balance = Double.parseDouble(scanner.nextLine());
                if (balance > 0) {
                    valid = true;
                } else {
                    System.out.println("Please enter a valid amount!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }

        System.out.println(" ");
    }

    private static void drawThirdCard(Card firstCard, Card secondCard) {
        Card thirdCard = deck.pop();
        System.out.println("Your third card is :" + thirdCard);


        if (secondCard.getRank() > thirdCard.getRank() && firstCard.getRank() < thirdCard.getRank()) {
            balance = balance + bet;
            System.out.println(" ");
            System.out.println("* . °•★|•°∵ ∵°•|☆•° . * You win the game, your balance is " + balance + " * . °•★|•°∵ ∵°•|☆•° . *");

        } else if (firstCard.getRank() > thirdCard.getRank() && secondCard.getRank() < thirdCard.getRank()) {
            balance = balance + bet;
            System.out.println(" ");
            System.out.println("* . °•★|•°∵ ∵°•|☆•° . * You win the game, your balance is " + balance + " * . °•★|•°∵ ∵°•|☆•° . *");

        } else {
            balance = balance - bet;
            System.out.println(" ");
            System.out.println("☠ ☠ ☠ You lose the game, your balance is " + balance + " ☠ ☠ ☠");
        }
    }

    private static void foldCard() {

        balance = balance - bet / 2;

        System.out.println("You folded your card. Your balance is " + balance);


    }

    private static void quit() {

        System.out.println("You have quit the game, your balance is " + balance);
    }

    private static void enterBet(Scanner scanner) {

        boolean valid = false;
        while (!valid) {
            System.out.print("Now, please place a bet: ");
            try {

                bet = Double.parseDouble(scanner.nextLine());
                if (bet > 0 && bet <= balance) {
                    valid = true;

                } else {
                    System.out.println("This bet is not validated!");
                    System.out.println(" ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }

        }


    }


}











