import java.util.HashSet;
import java.util.Set;

public class MyMap {

    Entry[] bucket;
    int capacity;
    int count;
    public MyMap() {
        this.bucket = new Entry[16];
        this.capacity = 16;
        this.count = 0;

        // initialize
        for (int i = 0; i < capacity; i++) {
            Entry myEntry = new Entry();
            this.bucket[i] = myEntry;

            this.bucket[i].value = Integer.MIN_VALUE;
        }

    }

    public MyMap(int capacity) {
        this.bucket = new Entry[capacity];
        this.capacity = capacity;
        this.count = 0;

        // initialize
        for (int i = 0; i < capacity; i++) {
            Entry myEntry = new Entry();
            this.bucket[i] = myEntry;

            this.bucket[i].value = Integer.MIN_VALUE;
        }

    }

    public void resize() {
        this.capacity = (int) (this.capacity * 1.5);
        //this.count = 0;

        Entry[] newBucket = new Entry[this.capacity];

        for (int i = 0; i < newBucket.length; i++) {
            Entry ne = new Entry();
            ne.key = Integer.MIN_VALUE;
            ne.value = Integer.MIN_VALUE;
            newBucket[i] = ne;

        }

        for (Entry b : this.bucket) {

            int index = getIndex(b.key);
            if(newBucket[index].key!=b.key){
                System.out.println("replace");
            }
            newBucket[index].key = b.key;
            newBucket[index].value = b.value;
        }

        this.bucket = newBucket;
    }

    public int getIndex(int key) {
        int hashCode = String.valueOf(key).hashCode();
        int index = hashCode % this.capacity;

        return index;
    }

    public void put(int key, int value) {
        if (count >= capacity * 0.75) {
            resize();
        }

        int index = getIndex(key);

        Entry myEntry = new Entry();
        myEntry.key = key;
        myEntry.value = value;

        bucket[index] = myEntry;
        this.count++;
    }

    public String get(int key) {
        int index = getIndex(key);

        if (this.bucket[index].value == Integer.MIN_VALUE || this.bucket[index].key != key) {
            return "nil";
        } else {
            return String.valueOf(this.bucket[index].value);
        }
    }

    public Set<Integer> keySet() {
        Set<Integer> keySet = new HashSet<>();
        for (Entry e : this.bucket) {
            if (e.value != Integer.MIN_VALUE) {
                keySet.add(e.key);
            }
        }

        return keySet;
    }

    class Entry {
        int key;
        int value;
    }
}
