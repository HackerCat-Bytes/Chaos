import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Kernel implementation for the PoetryCollection component.
 *
 * Representation: {@code poems} is a java.util.HashMap mapping poem titles to
 * their content.
 *
 * Convention: - poems != null - for every key k in poems: k != null &&
 * k.length() > 0 - for every value v in poems: v != null - each title appears
 * at most once (enforced by HashMap)
 *
 * Correspondence: The abstract PoetryCollection is the set of pairs {(title,
 * poems.get(title))} for every title in poems.keySet().
 */
public class PoetryCollection1L extends PoetryCollectionSecondary {

    /*
     * Representation
     */
    private Map<String, String> poems{
        ...
    }

    /*
     * createNewRep: helper to initialize representation
     */
    private void createNewRep() {
        this.poems = new HashMap<>();
    }

    /**
     * Default constructor: constructs an empty PoetryCollection.
     *
     * @ensures this = {}
     */
    public PoetryCollection1L() {
        super();
        createNewRep();
    }

    /**
     * Creates a new instance of this implementation (for
     * Standard.newInstance()).
     *
     * @return new instance
     * @ensures result is a fresh, empty PoetryCollection1L
     */
    @Override
    public PoetryCollection newInstance() {
        return new PoetryCollection1L();
    }

    /**
     * Removes all poems from this.
     *
     * @updates this
     * @ensures this = {}
     */
    @Override
    public void clear() {
        this.poems.clear();
    }

    /**
     * Transfers all poems from source into this. Leaves source empty.
     *
     * @param source
     *            the source collection
     * @updates this, source
     * @requires source != null
     * @ensures this = #this ∪ #source and source = {}
     */
    @Override
    public void transferFrom(PoetryCollection source) {
        assert source != null : "Violation of: source is not null";
        if (source == this) {
            return; // nothing to do
        }

        // Move entries out of source using only kernel methods.
        while (source.size() > 0) {
            Map.Entry<String, String> entry = source.removeAny();
            // entry may be an AbstractMap.SimpleEntry, but we only rely on key/value.
            this.poems.put(entry.getKey(), entry.getValue());
        }
    }

    // WARNING - Entering Kernel Methods Zone

    /**
     * Adds a poem (title ft. content). If title already exists, replace
     * content.
     *
     * @param title
     *            the title
     * @param content
     *            the poem content
     * @updates this
     * @ensures poem with title and content is in this
     */
    @Override
    public void addPoem(String title, String content) {
        assert title != null : "Violation of: title is not null";
        assert content != null : "Violation of: content is not null";
        // Convention requires non-empty title; enforce with assertion:
        assert title.length() > 0 : "Violation of: title is not empty";
        this.poems.put(title, content);
    }

    /**
     * Reports True if a poem with the given title exists in this collection,
     * false otherwise.
     *
     * @param title
     *            the title to check
     * @return true iff a poem with title exists in this
     * @ensures hasPoem = (title is in this)
     */
    @Override
    public boolean hasPoem(String title) {
        assert title != null : "Violation of: title is not null";
        return this.poems.containsKey(title);
    }

    /**
     * Returns the content of the poem with the given title.
     *
     * @param title
     *            the title to retrieve
     * @return the poem's content
     * @requires hasPoem(title)
     * @ensures getPoem = content of poem with title
     */
    @Override
    public String getPoem(String title) {
        assert title != null : "Violation of: title is not null";
        assert this.hasPoem(title) : "Violation of: hasPoem(title)";
        return this.poems.get(title);
    }

    /**
     * Removes and returns the content of the poem with the given title.
     *
     * @param title
     *            the title to remove
     * @return the content of the removed poem
     * @updates this
     * @requires hasPoem(title)
     * @ensures removePoem = content of removed poem and its title is no longer
     *          in this
     */
    @Override
    public String removePoem(String title) {
        assert title != null : "Violation of: title is not null";
        assert this.hasPoem(title) : "Violation of: hasPoem(title)";
        return this.poems.remove(title);
    }

    /**
     * Removes and returns any poem entry from this collection.
     *
     * @return a title-content pair for the removed poem
     * @updates this
     * @requires this /= {}
     * @ensures removeAny is not in this
     */
    @Override
    public Map.Entry<String, String> removeAny() {
        if (this.poems.isEmpty()) {
            throw new java.util.NoSuchElementException(
                    "removeAny on empty collection");
        }
        Iterator<Map.Entry<String, String>> it = this.poems.entrySet()
                .iterator();
        Map.Entry<String, String> e = it.next();
        // Make a safe copy to return (so caller can use it even after removal
        // (because sometimes I overthink these things).
        Map.Entry<String, String> copy = new java.util.AbstractMap.SimpleEntry<>(
                e.getKey(), e.getValue());
        it.remove(); // remove from map
        return copy;
    }

    /**
     * Reports the number of poems in this collection.
     *
     * @return number of poems
     * @ensures size = number of title and poem pairs in this
     */
    @Override
    public int size() {
        return this.poems.size();
    }
}
