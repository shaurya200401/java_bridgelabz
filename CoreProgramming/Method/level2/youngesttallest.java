package Method.level2;

/*
 * Program: Youngest and Tallest Finder
 * Purpose: Finds the youngest student and the tallest student from a set of parallel arrays.
 */
public class youngesttallest {
    public static void main(String[] args) {
        String[] names = { "Amar", "Akbar", "Anthony" };
        int[] ages = { 20, 18, 22 };
        double[] heights = { 170, 185, 175 };

        // Find youngest and tallest
        System.out.println("Youngest index: " + findYoungest(ages));
        System.out.println("Tallest index: " + findTallest(heights));
    }

    public static int findYoungest(int[] ages) {
        int minIdx = 0;
        for (int i = 1; i < ages.length; i++)
            if (ages[i] < ages[minIdx])
                minIdx = i;
        return minIdx;
    }

    public static int findTallest(double[] h) {
        int maxIdx = 0;
        for (int i = 1; i < h.length; i++)
            if (h[i] > h[maxIdx])
                maxIdx = i;
        return maxIdx;
    }
}
