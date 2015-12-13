/**
 * Container class that holds (pairs) two objects
 * @param <A> type of first object
 * @param <B> type of second object
 */
public class Pair<A, B> {
    public final A first;
    public final B second;

    /**
     * Creates a pair
     * @param first First part of the pair.
     * @param second Second part of the pair.
     */
    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }

    /**
     * Creates a hash code.
     * @return Returns a hash code.
     */
    public int hashCode() {
        int hashFirst = first != null ? first.hashCode() : 0;
        int hashSecond = second != null ? second.hashCode() : 0;

        return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    /**
     * Checks if two pair are equal, i.e. both values are equal.
     * @param other An other pair.
     * @return True or false.
     */
    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return
                    ((  this.first == otherPair.first ||
                            ( this.first != null && otherPair.first != null &&
                                    this.first.equals(otherPair.first))) &&
                            (	this.second == otherPair.second ||
                                    ( this.second != null && otherPair.second != null &&
                                            this.second.equals(otherPair.second))) );
        }
        return false;
    }

    /**
     * Returns the string representation of the pair.
     * @return A string of the pairs.
     */
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }
}