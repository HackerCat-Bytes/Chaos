import java.util.Map;

public abstract class PoetryCollectionSecondary implements PoetryCollection {

    /**
     * Default constructor for PoetryCollectionSecondary
     */
    public PoetryCollectionSecondary() {
        super();
    }

    /** 𓏲 ˖ /ᐠ - ˕ -マ࿔ . .ᐟ ›
     * Secondary method examples
     */ 𓏲 ˖ /ᐠ - ˕ -マ࿔ . .ᐟ ›

    @Override
    public final boolean hasPoem(String title) {
        assert title != null : "Violation of: title is not null";
        // use kernel methods like getPoem and try-catch or other kernel checks
        // pseudocode
        boolean found = false;
        PoetryCollection temp = this.newInstance();
        temp.transferFrom(this);

        while (temp.size() > 0) {
            Map.Entry<String, String> e = temp.removeAny();
            if (e.getKey().equals(title)) {
                found = true;
            }
            this.addPoem(e.getKey(), e.getValue());
        }
        return found;
    }

    @Override
    public final String getLatestPoem() {
        assert this.size() > 0 : "Violation of: this is not empty";
        // possible logic to find most recently added poem if tracked by kernel
        // otherwise, "any" poem if not temporal
        Map.Entry<String, String> e = this.removeAny();
        String poem = e.getValue();
        this.addPoem(e.getKey(), poem);
        return poem;
    }

    // ==========================
    // Common Object methods
    // ==========================

    @Override
    public final String toString() {
        PoetryCollection temp = this.newInstance();
        temp.transferFrom(this);
        String result = "{";
        while (temp.size() > 0) {
            Map.Entry<String, String> e = temp.removeAny();
            result += "\"" + e.getKey() + "\": \"" + e.getValue() + "\"";
            if (temp.size() > 0) {
                result += ", ";
            }
            this.addPoem(e.getKey(), e.getValue());
        }
        result += "}";
        return result;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PoetryCollection)) {
            return false;
        }
        PoetryCollection other = (PoetryCollection) obj;
        boolean same = true;

        PoetryCollection temp1 = this.newInstance();
        PoetryCollection temp2 = other.newInstance();
        temp1.transferFrom(this);
        temp2.transferFrom(other);

        while (temp1.size() > 0 && same) {
            Map.Entry<String, String> e = temp1.removeAny();
            if (!temp2.hasPoem(e.getKey())) {
                same = false;
            } else {
                String poem1 = e.getValue();
                String poem2 = temp2.getPoem(e.getKey());
                if (!poem1.equals(poem2)) {
                    same = false;
                }
            }
            this.addPoem(e.getKey(), e.getValue());
        }
        while (temp2.size() > 0) {
            Map.Entry<String, String> e = temp2.removeAny();
            other.addPoem(e.getKey(), e.getValue());
        }
        return same;
    }
}