public class Dub {
    public Integer[] table;

    //Doesn't support resizing
    public Dub() {
        table = new Integer[11];
    }

    public void insert(int key) {
        // primitive = object
        // int       = Integer
        // char      = Character
        // boolean   = Boolean
        // float     = Float
        // double    = Double
        // long      = Long
        // short     = Short
        // byte      = Byte
        

        int original_index = hash1(key);
        int index = original_index;

        if(table[index] == null) {
            table[index] = key;
            return;
        }

        int index2 = hash2(key);
        while(table[index] != null) {
            index += index2;
            index = index % table.length;
            if(index == original_index) {
                System.out.println("Failed to insert: " + key);
                return; //TODO resizing
            }
        }
        table[index] = key;
    }

    public boolean search(int key) {
        int original_index = hash1(key);
        int index = original_index;

        if(table[index] != null && table[index] == key) {
            return true;
        } else if(table[index] == null) {
            return false;
        }

        int index2 = hash2(key);
        while(table[index] != null && table[index] != key) {
            index += index2;
            index = index % table.length;
            if(index == original_index) {
                return false;
            }
        }

        return table[index] != null;
        
    }

    private int hash1(int key) {
        int res = key % 11;
        if(res < 0) {
            res += 11;
        }
        return res;
    }

    private int hash2(int key) {
        int res = key % 10;
        if(res < 0) {
            res += 10;
        }
        res += 1;
        return res;
    }

    public static void main(String[] args) {
        Dub dub = new Dub();
        dub.insert(1231);
        dub.insert(0);
        dub.insert(-45);
        System.out.println(dub.search(1231) + "");
        System.out.println(dub.search(-45) + "");
        System.out.println(dub.search(0) + "");
        System.out.println(dub.search(5839) + "");
    }
}