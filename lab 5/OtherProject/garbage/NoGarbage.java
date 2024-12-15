package hust.soict.dsai.garbage;

public class NoGarbage {
    public static void main(String[] args) {
        StringBuilder garbageBuilder = new StringBuilder();
        long start = System.currentTimeMillis();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            garbageBuilder.append(i); // Sử dụng StringBuilder
            if (i % 100000 == 0) { // Giới hạn bộ nhớ khi lặp
                garbageBuilder.setLength(0);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms");
    }
}
