package dev.senzalla.daytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
                idGame += processGame(game);
            }
            return idGame;
        }
    }

    private int processGame(String game) {
        List<String> round = List.of(game.substring(game.indexOf(": ") + 1).split(";"));
        List<Cube> red = new ArrayList<>();
        List<Cube> blue = new ArrayList<>();
        List<Cube> green = new ArrayList<>();
        for (String r : round) {
            for (String s : r.split(",")) {
                if (s.contains("red")) {
                    red.add(extractCube(s));
                } else if (s.contains("blue")) {
                    blue.add(extractCube(s));
                } else if (s.contains("green")) {
                    green.add(extractCube(s));
                }
            }
        }

        return powerRound(red, blue, green);
    }

    private int powerRound(List<Cube> red, List<Cube> blue, List<Cube> green) {
        int fewerRed = maximum(red);
        int fewerBlue = maximum(blue);
        int fewerGreen = maximum(green);
        return fewerGreen * fewerRed * fewerBlue;
    }

    private int maximum(List<Cube> red) {
        int max = 0;
        for (Cube cube : red) {
            if (cube.getNumber() > max) {
                max = cube.getNumber();
            }
        }
        return max;
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
