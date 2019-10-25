public class IndexMinPQTests {
    public static void main(String[] args) {
        IndexMinPQ<Character> q = new IndexMinPQ<Character>(5);
        q.insert(0, 'd');
        q.insert(1, 'a');
        System.out.println("Should be true: " + q.contains(1));
        System.out.println("Should be false: " + q.contains(2));
        System.out.println("Should be a: " + q.minKey());
        System.out.println("Should be 1: " + q.minIndex());
        q.insert(2, 'e');
        q.deleteMin();
        q.insert(1, 'f');
        System.out.println("Should be d: " + q.minKey());
        System.out.println("Should be e: " + q.delete(2));
    }
}