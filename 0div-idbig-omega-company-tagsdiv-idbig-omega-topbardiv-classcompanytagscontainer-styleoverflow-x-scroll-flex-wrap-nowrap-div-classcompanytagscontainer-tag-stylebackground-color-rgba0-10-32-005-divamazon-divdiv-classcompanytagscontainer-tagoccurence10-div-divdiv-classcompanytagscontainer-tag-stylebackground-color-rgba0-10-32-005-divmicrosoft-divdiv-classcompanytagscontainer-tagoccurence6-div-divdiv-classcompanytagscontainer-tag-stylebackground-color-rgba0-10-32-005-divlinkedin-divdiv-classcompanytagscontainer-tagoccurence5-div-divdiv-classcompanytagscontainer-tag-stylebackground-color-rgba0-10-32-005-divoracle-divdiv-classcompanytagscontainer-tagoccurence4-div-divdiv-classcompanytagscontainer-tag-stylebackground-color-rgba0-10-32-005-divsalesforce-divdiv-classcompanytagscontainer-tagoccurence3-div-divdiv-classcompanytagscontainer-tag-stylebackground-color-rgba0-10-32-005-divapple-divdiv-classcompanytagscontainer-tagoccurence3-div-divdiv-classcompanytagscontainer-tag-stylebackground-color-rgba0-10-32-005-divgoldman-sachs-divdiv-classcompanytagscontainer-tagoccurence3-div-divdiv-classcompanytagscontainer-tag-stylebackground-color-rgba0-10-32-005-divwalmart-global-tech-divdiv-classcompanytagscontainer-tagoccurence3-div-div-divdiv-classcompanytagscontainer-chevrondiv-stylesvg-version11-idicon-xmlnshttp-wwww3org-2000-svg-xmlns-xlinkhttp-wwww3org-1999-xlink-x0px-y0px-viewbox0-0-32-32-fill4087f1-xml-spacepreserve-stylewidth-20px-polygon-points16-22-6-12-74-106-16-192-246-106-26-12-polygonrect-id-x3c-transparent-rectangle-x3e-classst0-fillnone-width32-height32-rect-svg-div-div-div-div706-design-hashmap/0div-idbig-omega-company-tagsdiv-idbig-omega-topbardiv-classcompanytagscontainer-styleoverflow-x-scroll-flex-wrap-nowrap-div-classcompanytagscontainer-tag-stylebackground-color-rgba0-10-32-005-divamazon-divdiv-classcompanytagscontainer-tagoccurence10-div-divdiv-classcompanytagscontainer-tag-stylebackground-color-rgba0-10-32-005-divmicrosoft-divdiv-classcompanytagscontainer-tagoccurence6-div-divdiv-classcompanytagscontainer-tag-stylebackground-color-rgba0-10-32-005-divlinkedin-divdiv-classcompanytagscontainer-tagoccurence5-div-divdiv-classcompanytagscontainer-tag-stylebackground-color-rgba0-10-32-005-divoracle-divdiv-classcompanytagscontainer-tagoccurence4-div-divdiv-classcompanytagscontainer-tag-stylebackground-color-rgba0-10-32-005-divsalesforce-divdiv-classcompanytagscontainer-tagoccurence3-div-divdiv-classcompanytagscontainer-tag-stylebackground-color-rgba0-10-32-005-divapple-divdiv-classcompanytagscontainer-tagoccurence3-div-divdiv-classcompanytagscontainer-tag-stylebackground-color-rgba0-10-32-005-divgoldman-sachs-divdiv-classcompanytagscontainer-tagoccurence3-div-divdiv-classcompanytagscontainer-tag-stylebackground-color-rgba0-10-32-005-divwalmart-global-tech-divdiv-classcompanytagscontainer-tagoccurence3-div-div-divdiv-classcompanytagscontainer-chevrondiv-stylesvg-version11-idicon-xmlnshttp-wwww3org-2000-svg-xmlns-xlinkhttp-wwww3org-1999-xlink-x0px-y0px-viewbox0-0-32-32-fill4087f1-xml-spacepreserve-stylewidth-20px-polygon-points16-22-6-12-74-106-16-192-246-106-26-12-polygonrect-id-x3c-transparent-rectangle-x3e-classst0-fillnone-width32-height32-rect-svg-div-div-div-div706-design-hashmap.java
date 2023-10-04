class MyHashMap{
    LinkedList<Entry>[] map;
    public static int SIZE = 769;
    public MyHashMap(){
        map = new LinkedList[SIZE];
    }
    
    public void put(int key, int value){
        int bucket = key%SIZE;
        if(map[bucket] == null){
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key,value));
        }
        else{
            for(Entry entry:map[bucket]){
                if(entry.key == key){
                    entry.val = value;
                    return;
                }
            }
            map[bucket].add(new Entry(key,value));
        }
    }
    
    public int get(int key){
        int bucket = key%SIZE;
        LinkedList<Entry> entries = map[bucket];
        if(entries == null) return -1;
        for(Entry entry : entries){
            if(entry.key == key){
                return entry.val;
            }
        }
        return -1;
    }
    
    public void remove(int key){
        int bucket = key%SIZE;
        if(map[bucket] == null) return;
        Entry toRemove = null;
        
        for(Entry entry:map[bucket]){
            if(entry.key == key){
                toRemove = entry;
            }
        }
        if(toRemove == null) return;
        map[bucket].remove(toRemove);
    }
}

public class Entry{
    int key;
    int val;
    
    public Entry(int key,int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */