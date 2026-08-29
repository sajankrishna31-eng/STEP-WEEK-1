public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Empty log");
            return;
        }

        char maxColor = signalLog.charAt(0);
        int maxLen = 1;
        char currentColor = signalLog.charAt(0);
        int currentLen = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentLen++;
            } else {
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentLen = 1;
            }
        }

        // check last streak
        if (currentLen > maxLen) {
            maxLen = currentLen;
            maxColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", maxColor, maxLen);
    }

    public static void main(String[] args) {
        System.out.println("--- Traffic Signal Streak Analyzer ---");
        findLongestStreak("RRGGGYYRR");
        findLongestStreak("RRRRYYGG");
    }
}