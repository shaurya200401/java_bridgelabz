package DataStructures.StackandQueues;

/**
 * CircularTour class finds the starting petrol pump to complete a circular
 * tour.
 * 
 * Problem: Given a set of petrol pumps with petrol and distance to the next
 * pump, determine the starting point for completing a circular tour.
 * Hint: Use a queue to simulate the tour, keeping track of surplus petrol at
 * each pump.
 */
public class CircularTour {

    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // Method to find the starting point of the circular tour
    public static int printTour(PetrolPump[] arr, int n) {
        int start = 0;
        int end = 1;
        int curr_petrol = arr[start].petrol - arr[start].distance;

        // If current petrol is negative, remove the starting petrol pump.
        // Change start to the next petrol pump.
        while (end != start || curr_petrol < 0) {
            // If current petrol is negative, remove the starting petrol pump.
            while (curr_petrol < 0 && start != end) {
                // Remove starting petrol pump. Change start
                curr_petrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;

                // If 0 is being considered as start again, then there is no possible solution
                if (start == 0)
                    return -1;
            }

            // Add a petrol pump to current tour
            curr_petrol += arr[end].petrol - arr[end].distance;
            end = (end + 1) % n;
        }

        return start;
    }

    // Main method to test the CircularTour class
    public static void main(String[] args) {
        PetrolPump[] arr = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };
        int n = arr.length;

        System.out.println("Petrol Pumps (Petrol, Distance):");
        for (PetrolPump p : arr) {
            System.out.println("(" + p.petrol + ", " + p.distance + ")");
        }

        int start = printTour(arr, n);

        if (start == -1)
            System.out.println("No solution");
        else
            System.out.println("Start at Petrol Pump Index: " + start);
    }
}
