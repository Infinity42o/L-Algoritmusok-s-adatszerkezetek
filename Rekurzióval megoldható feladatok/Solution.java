import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'crosswordPuzzle' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY crossword
     *  2. STRING words
     */

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
     // Felosztjuk a szavakat
        String[] wordList = words.split(";");
        
        // Előállítjuk a rácsot karakterlistaként
        char[][] grid = new char[10][10];
        for (int i = 0; i < 10; i++) {
            grid[i] = crossword.get(i).toCharArray();
        }
        
        // Backtracking megoldás
        solveCrossword(grid, wordList, 0);
        
        // Eredmény visszaadása
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(new String(grid[i]));
        }
        return result;
    }

    // Backtracking megoldás
    private static boolean solveCrossword(char[][] grid, String[] words, int index) {
        if (index == words.length) {
            return true; // Ha az összes szó elhelyezésre került
        }
        
        String word = words[index];
        // Próbáljuk vízszintesen és függőlegesen is elhelyezni
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (canPlaceHorizontally(grid, word, i, j)) {
                    boolean[] placed = placeWordHorizontally(grid, word, i, j);
                    if (solveCrossword(grid, words, index + 1)) {
                        return true;
                    }
                    removeWordHorizontally(grid, word, i, j, placed);
                }
                if (canPlaceVertically(grid, word, i, j)) {
                    boolean[] placed = placeWordVertically(grid, word, i, j);
                    if (solveCrossword(grid, words, index + 1)) {
                        return true;
                    }
                    removeWordVertically(grid, word, i, j, placed);
                }
            }
        }
        return false;
    }

    // Ellenőrizzük, hogy elhelyezhető-e vízszintesen
    private static boolean canPlaceHorizontally(char[][] grid, String word, int row, int col) {
        if (col + word.length() > 10) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row][col + i] != '-' && grid[row][col + i] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Ellenőrizzük, hogy elhelyezhető-e függőlegesen
    private static boolean canPlaceVertically(char[][] grid, String word, int row, int col) {
        if (row + word.length() > 10) return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[row + i][col] != '-' && grid[row + i][col] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Vízszintes elhelyezés
    private static boolean[] placeWordHorizontally(char[][] grid, String word, int row, int col) {
        boolean[] placed = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (grid[row][col + i] == '-') {
                grid[row][col + i] = word.charAt(i);
                placed[i] = true;
            }
        }
        return placed;
    }

    // Vízszintes törlés (backtrack)
    private static void removeWordHorizontally(char[][] grid, String word, int row, int col, boolean[] placed) {
        for (int i = 0; i < word.length(); i++) {
            if (placed[i]) {
                grid[row][col + i] = '-';
            }
        }
    }

    // Függőleges elhelyezés
    private static boolean[] placeWordVertically(char[][] grid, String word, int row, int col) {
        boolean[] placed = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (grid[row + i][col] == '-') {
                grid[row + i][col] = word.charAt(i);
                placed[i] = true;
            }
        }
        return placed;
    }

    // Függőleges törlés (backtrack)
    private static void removeWordVertically(char[][] grid, String word, int row, int col, boolean[] placed) {
        for (int i = 0; i < word.length(); i++) {
            if (placed[i]) {
                grid[row + i][col] = '-';
            }
        }
    }

    }


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<String> crossword = IntStream.range(0, 10).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String words = bufferedReader.readLine();

        List<String> result = Result.crosswordPuzzle(crossword, words);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
