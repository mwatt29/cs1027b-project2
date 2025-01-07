import java.util.Random;

public class Tile {
    private char letter;

                                            // our default constructor which initializes letter to a random letter
    public Tile() {
        this.letter = generateLetter();
    }

                                            // constructor with a given letter
    public Tile(char c) {
        this.letter = c;
    }

                                            // method to generate a random letter between 'A' and 'Z'
    private char generateLetter() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'A');
    }

                                            // getter for the letter
    public char getLetter() {
        return this.letter;
    }
}
