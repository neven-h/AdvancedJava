import java.util.Iterator;

public class Minimum {
    protected  <E extends Comparable<E>> E Minimum(Set<E> set) {
        E temp;
        Iterator<E> setIterator = set.iterator();
        E min = setIterator.next();

        while ((setIterator.hasNext())) {
            temp = setIterator.next();
            if (min.compareTo(temp) > 0)
                min = temp;
        }

        return min;
    }
}
