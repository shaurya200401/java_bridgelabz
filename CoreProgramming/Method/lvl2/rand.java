package Method.lvl2;

public class rand {
    public int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        // Generate random 4-digit numbers
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int) (Math.random() * 9000);
        }
        return arr;
    }

    public double[] findAverageMinMax(int[] numbers) {
        double sum = 0, min = numbers[0], max = numbers[0];
        for (int n : numbers) {
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return new double[] { sum / numbers.length, min, max };
    }
}