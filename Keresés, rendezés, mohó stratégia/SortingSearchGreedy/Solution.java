import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridlandMetro' function below.
     *
     * The function is expected to return a LONG.
     * The function accepts following parameters:
     *  1. INTEGER n (number of rows)
     *  2. INTEGER m (number of columns)
     *  3. INTEGER k (number of tracks)
     *  4. 2D_INTEGER_ARRAY track (list of tracks)
     */

    public static long gridlandMetro(int n, int m, int k, List<List<Integer>> track) {
        // Térkép (map) a soronkénti sín tartományok tárolására
        Map<Integer, List<int[]>> rowTracks = new HashMap<>();

        // Sínek csoportosítása sorok szerint
        for (List<Integer> t : track) {
            int row = t.get(0);
            int start = t.get(1);
            int end = t.get(2);
            rowTracks.computeIfAbsent(row, x -> new ArrayList<>()).add(new int[]{start, end});
        }

        long occupiedCells = 0;

        // Minden sor sínjeinek feldolgozása
        for (Map.Entry<Integer, List<int[]>> entry : rowTracks.entrySet()) {
            List<int[]> tracks = entry.getValue();
            
            // Sínek rendezése a kezdőpozíciójuk alapján
            tracks.sort(Comparator.comparingInt(a -> a[0]));
            
            // Tartományok egyesítése
            int currentStart = tracks.get(0)[0];
            int currentEnd = tracks.get(0)[1];
            
            for (int i = 1; i < tracks.size(); i++) {
                int[] currentTrack = tracks.get(i);
                int nextStart = currentTrack[0];
                int nextEnd = currentTrack[1];
                
                // Ha a következő sín átfedi az előzőt vagy hozzáér, egyesítjük őket
                if (nextStart <= currentEnd + 1) {
                    currentEnd = Math.max(currentEnd, nextEnd);
                } else {
                    // A jelenlegi egyesített sín hosszának kiszámítása
                    occupiedCells += (currentEnd - currentStart + 1);
                    // Új sín kezdése
                    currentStart = nextStart;
                    currentEnd = nextEnd;
                }
            }
            
            // Ne felejtsük el az utolsó egyesített tartományt a sorban
            occupiedCells += (currentEnd - currentStart + 1);
        }

        // Az összes cella a rácsban
        long totalCells = (long) n * m;
        // Szabad cellák = Összes cella - Foglalt cellák
        return totalCells - occupiedCells;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);
        int k = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> track = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                track.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.gridlandMetro(n, m, k, track);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
