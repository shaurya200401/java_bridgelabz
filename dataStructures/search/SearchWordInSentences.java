package DataStructures.Search;

/**
 * Class to search for a specific word in a list of sentences using Linear
 * Search.
 */
public class SearchWordInSentences {

    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through the list of sentences
        for (String sentence : sentences) {
            // Check if sentence contains the word
            // Note: simple contains() matches substrings. For exact word, regex or
            // splitting is better.
            // Requirement implies "containing", so contains() is generally acceptable
            // unless strict word boundary is needed.
            // Let's stick to simple contains for now as per "Hint: check if it contains".
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Java is a programming language.",
                "Python is great for data science.",
                "C++ is used for systems programming."
        };
        String target = "data";

        String result = findSentenceWithWord(sentences, target);
        System.out.println("Sentence containing '" + target + "': " + result);
    }
}
