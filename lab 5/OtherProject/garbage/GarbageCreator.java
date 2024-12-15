package hust.soict.dsai.garbage;

public class GarbageCreator {
    public static void main(String[] args) {
        String garbage = "";
        long start = System.currentTimeMillis();

        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                garbage += i; // Tạo rất nhiều "garbage"
            }
        } catch (OutOfMemoryError e) {
            System.err.println("OutOfMemoryError encountered!");
        }

        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms");
    }
}
