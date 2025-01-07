# cs1027b-project2
# What This Project Does
This project is a Java-based Scrabble Word Finder, which simulates a Scrabble game environment. It allows users to:

Generate random sets of Scrabble tiles.
Identify valid words that can be formed using those tiles.
Calculate the Scrabble score for each of the words.
Features of the Project
Tile Class:

Represents a single Scrabble tile with:
A randomly generated letter (or a specific letter if provided).
Methods to retrieve the tile's letter.
Scrabble Class:

Handles the main game logic.
Features:
Random Tile Generation: Initializes a rack of 7 random Scrabble tiles.
Word Formation: Finds all words that can be formed using the tiles, by comparing them against a dictionary file (CollinsScrabbleWords2019.txt).
Word Scoring: Calculates the Scrabble score for each word based on standard tile point values.
Equality Check: Compares two Scrabble racks to see if they have the same set of tiles.
Helper Methods:
Calculates the value of a specific letter based on Scrabble rules.
Handles string manipulation to verify if a word can be formed.
How to Run It
Environment Setup:

Install Java Development Kit (JDK) if not already installed.
Prepare a text file named CollinsScrabbleWords2019.txt containing valid Scrabble words (one word per line). Place it in the same directory as the project files.

Expected Output:

The program will display the random tiles, words that can be formed, and their corresponding scores.
Technologies/Libraries Used
Language: Java
Core Libraries:
java.util: Used for ArrayList, Arrays, and Random.
java.io: For file reading using BufferedReader and FileReader.
This project demonstrates skills in:

Object-oriented programming (OOP) with classes and objects.
String manipulation and algorithmic thinking.
File I/O operations to integrate external data (dictionary file).
