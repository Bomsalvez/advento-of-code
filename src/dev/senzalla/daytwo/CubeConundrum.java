package dev.senzalla.daytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CubeConundrum {
    public int start() {
        try {
            return processInputFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int processInputFile() throws IOException {
        try (BufferedReader reader = createBufferedReader()) {
            int idGame = 0;
            String game;
            while ((game = reader.readLine()) != null) {
                if (processGame(game)) {
                    String round = game.substring(game.indexOf(" "), game.indexOf(":")).trim();
                    idGame += Integer.parseInt(round);
                }
            }
            return idGame;
        }
    }

    private boolean processGame(String game) {

        List<String> round = List.of(game.substring(game.indexOf(": ") + 1).split(";"));
        for (String r : round) {
            if (!processRound(r)) {
                return false;
            }
        }
        return true;
    }

    private boolean processRound(String round) {
        boolean validRound = true;
        for (String s : round.split(",")) {
            validRound = checkCube(s);
            if (!validRound) {
                return validRound;
            }
        }
        return validRound;
    }

    private boolean checkCube(String s) {
        boolean valid = true;
        var cube = extractCube(s);
        for (CubeEnum d : CubeEnum.values()) {
            if (d.getCor().equals(cube.getCor()) && d.getNumber() < cube.getNumber()) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    private Cube extractCube(String ss) {
        String[] dice = ss.trim().split(" ");
        return new Cube(Integer.parseInt(dice[0]), dice[1]);
    }

    private BufferedReader createBufferedReader() {
        InputStream inputStream = CubeConundrum.class.getResourceAsStream("input.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return new BufferedReader(inputStreamReader);
    }
}
