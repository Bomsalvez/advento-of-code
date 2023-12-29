package dev.senzalla.dayone;

import java.util.*;

public class Trebuchet {

    public int start() {
        List<String> puzzleInput = DocumentCalibration.getPuzzle();
        int calibration = 0;

        for (String line : puzzleInput) {
            Map<Integer, String> positions = getPositions(line);
            String primary = getPrimary(positions);
            String last = getLast(positions);

            String signal = String.format("%s%s", primary, last);
            calibration += Integer.parseInt(signal);
        }
        return calibration;
    }

    private static String getPrimary(Map<Integer, String> s) {
        List<Map.Entry<Integer, String>> positions = new ArrayList<>(s.entrySet());
        positions.sort(Map.Entry.comparingByKey());
        return positions.get(0).getValue();
    }

    private static String getLast(Map<Integer, String> s) {
        List<Map.Entry<Integer, String>> positions = new ArrayList<>(s.entrySet());
        positions.sort(Map.Entry.comparingByKey(Comparator.reverseOrder()));
        return positions.get(0).getValue();
    }

    private static Map<Integer, String> getPositions(String s) {
        Map<Integer, String> positions = new HashMap<>();
        for (Numbers n : Numbers.values()) {
            addPositionIfExists(s, n, n.getName(), positions);
            addPositionIfExists(s, n, String.valueOf(n.getDigit()), positions);
        }
        return positions;
    }

    private static void addPositionIfExists(String s, Numbers n, String target, Map<Integer, String> positions) {
        int index = -1;
        while ((index = s.indexOf(target, index + 1)) != -1) {
            positions.put(index, String.valueOf(n.getDigit()));
        }
    }
}
