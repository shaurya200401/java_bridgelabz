package collectionsFramework.mapInterface;

import java.util.*;

/**
 * Voting System.
 * - HashMap: Store Candidate -> Votes
 * - TreeMap: Display results in sorted order (Alphabetical by Candidate Name
 * here, or typically by votes if custom comparator used)
 * - LinkedHashMap: Maintain order of votes coming in (simulated sequence of
 * candidate names)
 */
public class VotingSystem {

    public static void main(String[] args) {
        // Incoming votes sequence
        String[] rawVotes = { "Alice", "Bob", "Alice", "Charlie", "Bob", "Alice" };

        // 1. Maintain order of votes (Unique Candidates in order of appearance?)
        // The requirements say "LinkedHashMap is used to maintain the order of votes".
        // This likely means keeping the order candidates were added/discovered.
        Map<String, Integer> insertionOrderMap = new LinkedHashMap<>();

        // 2. HashMap for random access updates
        Map<String, Integer> voteCountMap = new HashMap<>();

        System.out.println("Processing votes: " + Arrays.toString(rawVotes));

        for (String candidate : rawVotes) {
            // Update HashMap
            voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);

            // Update LinkedHashMap (To show we respect insertion order of first appearance)
            if (!insertionOrderMap.containsKey(candidate)) {
                insertionOrderMap.put(candidate, 1);
            } else {
                insertionOrderMap.put(candidate, insertionOrderMap.get(candidate) + 1);
            }
        }

        System.out.println("Votes (HashMap - Unordered): " + voteCountMap);
        System.out.println("Votes (LinkedHashMap - Insertion Order): " + insertionOrderMap);

        // 3. TreeMap for sorted results
        // Sorting by Candidate Name (Natural Ordering of String Keys)
        Map<String, Integer> sortedResults = new TreeMap<>(voteCountMap);
        System.out.println("Results Sorted by Candidate Name (TreeMap): " + sortedResults);
    }
}
