public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[]vals;
    private int size = 0;

    public BinarySearchST() {
        keys = (Key[]) new Comparable[20];
        vals = (Value[]) new Object[20];
    }

    public void put(Key k, Value v) {
        if (k == null) {
            System.out.println("key is null");
        }
        if (v == null) {
            delete(k);
            return;
        }

        int i = rank(k);
        if (i < size && keys[i].compareTo(k) == 0) {
            vals[i] = v;
            return; 
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = k;
        vals[i] = v;
        size++;
    }

    public int rank(Key key) {
        if (key == null) {
            System.out.println("key is null");
        }
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compare = key.compareTo(keys[mid]);
            if (compare < 0) {
                high = mid - 1;
            } else if (compare > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public boolean contains(Key key) {
        if (key == null) {
            System.out.println("key is null");
        }
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
            System.out.println("key is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key); 
        if (i < size && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Key max() {
        if (isEmpty()) {
            System.out.println("No elements are available in the Symbol table");
        }
        return keys[size - 1];
    }

    public Key floor(Key key) {
    //  if (key == null) {
    //      System.out.println("key is null");
    //  }
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[size - 1];
        }
    } 

    public void deleteMin() {
        if (isEmpty()) {
            System.out.println("No elements are available in the Symbol table to perform deletion");
        }
        delete(min());
    }

    public Key min() {
        if (isEmpty()) {
            System.out.println("empty symbol table");
        }
        return keys[0]; 
    }

    public void delete(Key key) {
        if (key == null) {
            System.out.println("key is null");
        }

        int i = rank(key);
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < size - 1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        size--;
        keys[size] = null;
        vals[size] = null;
    }

    public String keys() {
        String str = "";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            if (keys[i] != null) {
                str += keys[i] + " " + vals[i] + "\n";
            }
        }
        str += keys[size - 1] + " " + vals[size - 1];
        return str;
    }
}
