import java.util.*;
class HashTableLP{
	private final int thirty = 30001;
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
        values[i] = value;
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
    }

    public boolean contains(final String k) {
        return get(k) != minusone;
    }

    public void display() {
    	System.out.print("{");
    	for(int i=0; i<keys.length-1;i++) {
    		System.out.print(keys[i]+":"+values[i]+",");
    	}
    	System.out.println(keys[num1]+":"+values[num1]+"}");
    }
}
