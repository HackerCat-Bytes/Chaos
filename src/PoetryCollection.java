<<<<<<<HEAD

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Enhanced interface for the {@code PoetryCollection} component. Extends the
 * kernel with additional methods, such as listing, upadating, and retrieving.
 */
public interface PoetryCollection extends PoetryCollectionKernel {

    /**
     * Updates the content of the poem with the given title.
     *
     * @param title
     *            the title of the poem to update
     * @param newContent
     *            the new poem content
     * @updates this
     * @requires hasPoem(title)
     * @ensures poem with title now has newContent
     */
    void updatePoem(String title, String newContent);

    /**
     * Returns a list of all poem titles in this collection.
     *
     * @return a list containing all titles currently in this
     * @ensures listTitles = [all poem titles in this]
     */
    List<String> listTitles();

    /**
     * Returns the title of the most recently added poem.
     *
     * @return the title of the most recent poem (or nothing if no poem exists?)
     * @ensures getLatestPoem = title of last poem added or null if empty
     */
    String getLatestPoem();

    /**
     * Returns a string representation of this collection.
     *
     * @return a formatted string listing all poems
     * @ensures toString = string representation of all poems in this
     */
    @Override
    String toString();>>>>>>>interfaces
}