import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class Scrabble {
    private Tile tiles[];

                                                                                // default constructor, initializes the tile array with random tiles
    public Scrabble() {
        this.tiles = new Tile[7];
        for (int i = 0; i < 7; i++) {
            this.tiles[i] = new Tile();
        }
    }

                                                                                // Constructor with a given array of tiles
    public Scrabble(Tile[] tiles) {
        if (tiles.length != 7) {
            throw new IllegalArgumentException("The array must have 7 tiles.");
        }
        this.tiles = tiles;
    }

                                                                                // returns a string of the letters of tiles
    public String getLetters() {
        StringBuilder letters = new StringBuilder();
        for (Tile tile : tiles) {
            letters.append(tile.getLetter());
        }
        return letters.toString();
    }

                                                                            // finds words that can be formed using the tiles
    public ArrayList<String> getWords() throws FileNotFoundException {
        ArrayList<String> spellableWords = new ArrayList<>();
        String myLetters = getLetters();
        
        try (BufferedReader br = new BufferedReader(new FileReader("CollinsScrabbleWords2019.txt"))) {
            String word;
            while ((word = br.readLine()) != null) {
                String tempLetters = myLetters;
                boolean canSpell = true;

                for (char letter : word.toCharArray()) {
                    if (tempLetters.indexOf(letter) >= 0) {
                        tempLetters = tempLetters.replaceFirst(String.valueOf(letter), "");
                    } else {
                        canSpell = false;
                        break;
                    }
                }

                if (canSpell) {
                    spellableWords.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return spellableWords;
    }

                                                                    // Calculates scores for the found words
    public int[] getScores() throws FileNotFoundException {
        ArrayList<String> spellableWords = this.getWords();
        int[] wordScores = new int[spellableWords.size()];

        for (int i = 0; i < spellableWords.size(); i++) {
            int score = 0;
            for (char letter : spellableWords.get(i).toCharArray()) {
                score += getLetterValue(letter);
            }
            wordScores[i] = score;
        }

        Arrays.sort(wordScores);
        return wordScores;
    }

                                                                                            // Returns the value of a letter
    private int getLetterValue(char letter) {
        if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'L' || letter == 'N' || letter == 'O' || letter == 'R' || letter == 'S' || letter == 'T' || letter == 'U') {
            return 1;
        } else if (letter == 'D' || letter == 'G') {
            return 2;
        } else if (letter == 'B' || letter == 'C' || letter == 'M' || letter == 'P') {
            return 3;
        } else if (letter == 'F' || letter == 'H' || letter == 'V' || letter == 'W' || letter == 'Y') {
            return 4;
        } else if (letter == 'K') {
            return 5;
        } else if (letter == 'J' || letter == 'X') {
            return 8;
        } else if (letter == 'Q' || letter == 'Z') {
            return 10;
        } else {
            throw new IllegalArgumentException("Invalid Scrabble letter: " + letter);
        }
    }

                                                                        // Compares two Scrabble objects to see if they have the same tiles
    public boolean equals(Scrabble s) {
        char[] thisCharArray = this.getLetters().toCharArray();
        char[] otherCharArray = s.getLetters().toCharArray();
        Arrays.sort(thisCharArray);
        Arrays.sort(otherCharArray);
        return Arrays.equals(thisCharArray, otherCharArray);
    }
}