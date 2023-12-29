package dev.senzalla.dayone;

import java.util.List;

public class Trebuchet {

    public int start() {
        List<String> puzzleInput = DocumentCalibration.getPuzzle();
        int calibration = 0;

        for (String line : puzzleInput) {
            line = line.replaceAll("\\D", "");
            String signal = String.format("%s%s", line.charAt(0), line.charAt(line.length() - 1));
            calibration += Integer.parseInt(signal);
        }
        return calibration;
    }
}
