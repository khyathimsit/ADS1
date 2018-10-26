import java.util.*;
class HashTableLP{
    private final int thirty = 10;
    private final int minusone = -1;
    private final int hex = 0x7fffffff;
    private final int num1 = thirty;
    private String[] keys = new String[num1];
    private int[] values = new int[num1];
    int size = 0;

    HashTableLP() {

    }
    private int hash(final String key) {
        return (key.hashCode() * 11) % num1;
    }

    public void put(String key, int value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % num1) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        // System.out.println(key + "key");
        values[i] = value;
        // System.out.println(value + "value");
        size++;
        // System.out.println(Arrays.toString(keys) + "keys");
    }

    public int get(String key) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % num1) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return minusone;
    }

    public void delete(String key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % num1;
        }
        keys[i] = null;
        values[i] = minusone;

        i = (i + 1) % num1;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            String keyToRehash = keys[i];
            int valToRehash = values[i];
            keys[i] = null;
            values[i] = minusone;
            size--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % num1;
        }
    }

    public boolean contains(final String k) {
        return get(k) != minusone;
    }

    public void display() {
        String str = "{";
        for(int i=0; i<size;i++) {
            if (keys[i] != null) {
                str += keys[i] + ":" + values[i] + ",";
            }
        }
        if (str != "{") {
            str = str.substring(0, str.length() - 2);
            str = str + "}";
            System.out.println(str);
        } else {
            System.out.println("{}");
        }
    }
}
