/**
 * Simple use-case: maintain a personal mini poetry notebook and display the
 * latest poem.
 */
public class UseCase_DisplayLatestPoem {

    public static void main(String[] args) {
        PoetryCollection pc = new PoetryCollection1L();

        pc.addPoem("Crave", "There's a raw hunger in me.");
        pc.addPoem("Heavens", "..But what good is a god in love?");
        pc.addPoem("Brown Eyes", "Honey eyes with the warmth of spring.");

        // Show the latest poem title
        System.out.println("Latest poem title: " + pc.getLatestPoem());
        System.out.println("\nAll poems: " + pc.listTitles());

        // Update a poem and print body
        pc.updatePoem("Crave", "A deeper kind of hunger.");
        System.out.println("\nUpdated 'Crave': " + pc.getPoem("Crave"));

        // Print the string representation
        System.out.println("\nCollection summary:\n" + pc.toString());
    }
}
