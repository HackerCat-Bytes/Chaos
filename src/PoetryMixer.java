import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Use-case: combine two poetry collections and pick a random "mixed" poem.
 */
public class UseCase_PoetryMixer {

    public static void main(String[] args) {
        PoetryCollection a = new PoetryCollection1L();
        PoetryCollection b = new PoetryCollection1L();

        a.addPoem("Dawn", "Light folds over the hills.");
        a.addPoem("Echo", "A memory repeats softly.");
        b.addPoem("Midnight", "The world exhales in silver.");
        b.addPoem("Rain", "Water traces the cheek of night.");

        // Merge b into a (using transferFrom for demo; note transferFrom empties source)
        a.transferFrom(b);
        System.out.println("After merging, titles: " + a.listTitles());

        // Create a simple 'mixer' that picks random poems and concatenates first half + second half
        List<String> bodies = new ArrayList<>();
        for (String t : a.listTitles()) {
            bodies.add(a.getPoem(t));
        }

        if (bodies.size() >= 2) {
            Random r = new Random();
            String first = bodies.get(r.nextInt(bodies.size()));
            String second = bodies.get(r.nextInt(bodies.size()));
            String mixed = mixHalves(first, second);
            System.out.println("\nA little mixed poem:\n" + mixed);
        } else {
            System.out.println("Not enough poems to mix.");
        }
    }

    private static String mixHalves(String a, String b) {
        int splitA = Math.max(1, a.length() / 2);
        int splitB = Math.max(1, b.length() / 2);
        return a.substring(0, splitA).trim() + " ... "
                + b.substring(splitB).trim();
    }
}
