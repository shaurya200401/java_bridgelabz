package json;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.*;

/**
 * Application that reads IPL match data from JSON and CSV files,
 * processes the data based on censorship rules, and writes back newly sanitized
 * data.
 */
public class IPLCensorAnalyzer {

    // Constant string definitions
    private static final String REDACTED_POM = "REDACTED";
    private static final String OBFUSCATED = "***";

    public static void main(String[] args) {
        String jsonInput = "D:/club/internship/capgemini/Java_Bridgelabz/json/ipl_input.json";
        String csvInput = "D:/club/internship/capgemini/Java_Bridgelabz/json/ipl_input.csv";
        String jsonOutput = "D:/club/internship/capgemini/Java_Bridgelabz/json/ipl_censored.json";
        String csvOutput = "D:/club/internship/capgemini/Java_Bridgelabz/json/ipl_censored.csv";

        // Ensure dummy input data exists
        createDummyInputs(jsonInput, csvInput);

        // Trigger censoring workflows
        processJsonFile(jsonInput, jsonOutput);
        processCsvFile(csvInput, csvOutput);

        System.out.println("Censorship workflow completed. Check output files.");
    }

    // Helper to evaluate and censor team names
    private static String censorTeamName(String teamName) {
        if (teamName == null || teamName.isEmpty())
            return teamName;
        String[] parts = teamName.split(" ");
        return parts[0] + " " + OBFUSCATED;
    }

    // Core logic to parse, mutate and output JSON
    private static void processJsonFile(String inputPath, String outputPath) {
        try {
            // Read all content
            String content = readFile(inputPath);
            JSONArray array = new JSONArray(content);

            // Loop array modifications
            for (int i = 0; i < array.length(); i++) {
                JSONObject match = array.getJSONObject(i);

                // Censor top-level attributes
                match.put("team1", censorTeamName(match.optString("team1")));
                match.put("team2", censorTeamName(match.optString("team2")));
                match.put("winner", censorTeamName(match.optString("winner")));
                match.put("player_of_match", REDACTED_POM);

                // Inspect and censor nested score object
                if (match.has("score")) {
                    JSONObject scoreNode = match.getJSONObject("score");
                    JSONObject newScoreNode = new JSONObject();
                    for (String key : scoreNode.keySet()) {
                        newScoreNode.put(censorTeamName(key), scoreNode.get(key));
                    }
                    match.put("score", newScoreNode);
                }
            }

            // Sink updated data to new file
            writeToFile(outputPath, array.toString(4));

        } catch (Exception e) {
            System.err.println("JSON Processing Error: " + e.getMessage());
        }
    }

    // Core logic to process CSV line formatting
    private static void processCsvFile(String inputPath, String outputPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String header = reader.readLine();
            // Stop early if file has no header
            if (header == null)
                return;
            writer.write(header);
            writer.newLine();

            String line;
            // Advance through each line
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",", -1);
                // Based on CSV structure:
                // match_id,team1,team2,score_team1,score_team2,winner,player_of_match
                if (tokens.length >= 7) {
                    tokens[1] = censorTeamName(tokens[1]);
                    tokens[2] = censorTeamName(tokens[2]);
                    tokens[5] = censorTeamName(tokens[5]);
                    tokens[6] = REDACTED_POM;
                }

                // Re-merge processed column attributes
                writer.write(String.join(",", tokens));
                writer.newLine();
            }

        } catch (Exception e) {
            System.err.println("CSV processing error: " + e.getMessage());
        }
    }

    // Helper to extract file body to single String
    private static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
        }
        return sb.toString();
    }

    // Helper to save string payload into destination paths
    private static void writeToFile(String path, String data) throws IOException {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(data);
        }
    }

    // Dummy initialization to test on environments missing the input files
    private static void createDummyInputs(String jsonTarget, String csvTarget) {
        String jsonPayload = "[\n" +
                "  {\n" +
                "    \"match_id\": 101,\n" +
                "    \"team1\": \"Mumbai Indians\",\n" +
                "    \"team2\": \"Chennai Super Kings\",\n" +
                "    \"score\": {\n" +
                "      \"Mumbai Indians\": 178,\n" +
                "      \"Chennai Super Kings\": 182\n" +
                "    },\n" +
                "    \"winner\": \"Chennai Super Kings\",\n" +
                "    \"player_of_match\": \"MS Dhoni\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"match_id\": 102,\n" +
                "    \"team1\": \"Royal Challengers Bangalore\",\n" +
                "    \"team2\": \"Delhi Capitals\",\n" +
                "    \"score\": {\n" +
                "      \"Royal Challengers Bangalore\": 200,\n" +
                "      \"Delhi Capitals\": 190\n" +
                "    },\n" +
                "    \"winner\": \"Royal Challengers Bangalore\",\n" +
                "    \"player_of_match\": \"Virat Kohli\"\n" +
                "  }\n" +
                "]";
        String csvPayload = "match_id,team1,team2,score_team1,score_team2,winner,player_of_match\n" +
                "101,Mumbai Indians,Chennai Super Kings,178,182,Chennai Super Kings,MS Dhoni\n" +
                "102,Royal Challengers Bangalore,Delhi Capitals,200,190,Royal Challengers Bangalore,Virat Kohli";

        try {
            if (!new File(jsonTarget).exists())
                writeToFile(jsonTarget, jsonPayload);
            if (!new File(csvTarget).exists())
                writeToFile(csvTarget, csvPayload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
