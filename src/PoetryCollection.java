import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Proof-of-concept for the PoetryCollection component. Represents a small
 * collection of poems with simple add, get, remove, and list operations.
 */
public class PoetryCollection {

    // ------------------------------
    // Fields
    // ------------------------------
    private Map<String, String> poems;

    // ------------------------------
    // Constructor
    // ------------------------------
    public PoetryCollection() {
        this.poems = new HashMap<>();
    }

    // ------------------------------
    // Kernel Methods
    // ------------------------------

    /**
     * Adds a poem with a title and content.
     */
    public void addPoem(String title, String content) {
        this.poems.put(title, content);
    }

    /**
     * Gets a poem's content by title.
     */
    public String getPoem(String title) {
        return this.poems.get(title);
    }

    /**
     * Removes a poem by title.
     */
    public void removePoem(String title) {
        this.poems.remove(title);
    }

    /**
     * Removes and returns any poem from the collection. Useful for iteration.
     */
    public Map.Entry<String, String> removeAny() {
        Iterator<Map.Entry<String, String>> it = this.poems.entrySet()
                .iterator();
        if (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            it.remove();
            return entry;
        }
        return null;
    }

    // ------------------------------
    // Secondary Methods
    // ------------------------------

    /**
     * Lists all poem titles.
     */
    public List<String> listTitles() {
        return new ArrayList<>(this.poems.keySet());
    }

    /**
     * Updates the content of an existing poem.
     */
    public void updatePoem(String title, String newContent) {
        if (this.poems.containsKey(title)) {
            this.poems.put(title, newContent);
        }
    }

    /**
     * Gets the most recently added poem (roughly).
     */
    public String getLatestPoem() {
        if (this.poems.isEmpty()) {
            return null;
        }
        List<String> titles = new ArrayList<>(this.poems.keySet());
        return titles.get(titles.size() - 1);
    }

    // ------------------------------
    // Demo (main)
    // ------------------------------
    public static void main(String[] args) {
        PoetryCollection myCollection = new PoetryCollection();

        // Add poems
        myCollection.addPoem("Crave",
                "There's a raw hunger in me. Something ancient. Something that existed before I came to be. ");
        myCollection.addPoem("Heavens",
                "..But what good is a god in love? What good is a god that's already fallen?");
        myCollection.addPoem("Brown Eyes",
                "Honey eyes with the warmth of everlasting hearth and earth kissed by spring rains");

        // Get and print a poem
        System.out.println("Poem 'Crave': " + myCollection.getPoem("Crave"));

        // Update a poem
        myCollection.updatePoem("Crave",
                "There's a hunger in me still. Ancient, endless, and quietly alive.");
        System.out.println("Updated 'Crave': " + myCollection.getPoem("Crave"));

        // List all titles
        System.out.println("All poem titles: " + myCollection.listTitles());

        // Get the latest poem
        System.out.println("Latest poem: " + myCollection.getLatestPoem());

        // Remove a poem
        myCollection.removePoem("Heavens");
        System.out.println(
                "After removing 'Heavens': " + myCollection.listTitles());

        // Test removeAny
        Map.Entry<String, String> removed = myCollection.removeAny();
        if (removed != null) {
            System.out.println("Removed any poem: " + removed.getKey());
        }
        System.out.println("Remaining poems: " + myCollection.listTitles());
    }
}