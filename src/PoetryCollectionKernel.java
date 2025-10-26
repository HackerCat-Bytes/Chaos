import components.standard.Standard;

/**
 * Kernel interface for the {@code PoetryCollection} component. Provides the
 * minimal set of methods required to manage a collection of poems, each
 * identified by a unique title and some associated content.
 */
public interface PoetryCollectionKernel extends Standard<PoetryCollection> {

    /**
     * Adds a new poem with the given title and content to this collection.
     *
     * @param title
     *            the title of the poem
     * @param content
     *            the content of the poem
     * @updates this
     * @ensures poem with the given title and content is in this
     */
    void addPoem(String title, String content);

    /**
     * Reports whether a poem with the given title exists in this.
     *
     * @param title
     *            the title to check
     * @return true if a poem with the given title exists in this, false
     *         otherwise
     * @ensures hasPoem = (title is in this)
     */
    boolean hasPoem(String title);

    /**
     * Retrieves the content of the poem with the given title.
     *
     * @param title
     *            the title of the poem
     * @return the content of the poem
     * @requires hasPoem(title)
     * @ensures getPoem = content of poem with title
     */
    String getPoem(String title);

    /**
     * Removes the poem with the given title from this collection.
     *
     * @param title
     *            the title of the poem to remove
     * @return the content of the removed poem
     * @updates this
     * @requires hasPoem(title)
     * @ensures removePoem = content of poem and poem with title is no longer in
     *          this
     */
    String removePoem(String title);

    /**
     * Removes and returns any poem from this collection.
     *
     * @return a title-content pair for the removed poem
     * @updates this
     * @requires this is not empty
     * @ensures removeAny is not in this
     */
    String removeAny();
}