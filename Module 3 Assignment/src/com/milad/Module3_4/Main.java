package com.milad.Module3_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<PlayerBattingStats> players;

    /**
     * Takes in a comma sperated values file and parses the data.  It takes the data and
     * creates a PlayerBattingStats object and adds it to the players list.  The CSV file
     * must be in the format of:
     * Name,Team,Gamesplayed,At bats, runs, hits, doubles, triples, home runs, rbi's
     * @param file containg the data
     */
    public static void parseCSVData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splitter = line.split(",");
            String name = splitter[0];
            String team = splitter[1];
            int gamesPlayed = Integer.parseInt(splitter[2]);
            int atBats = Integer.parseInt(splitter[3]);
            int runs = Integer.parseInt(splitter[4]);
            int hits = Integer.parseInt(splitter[5]);
            int doubles = Integer.parseInt(splitter[6]);
            int triples = Integer.parseInt(splitter[7]);
            int homeRunes = Integer.parseInt(splitter[8]);
            int rbis = Integer.parseInt(splitter[9]);
            players.add(new PlayerBattingStats(name, team, gamesPlayed, atBats, runs, hits, doubles, triples, homeRunes, rbis));
        }

    }

    public static void main(String[] args) {
        players = new ArrayList<>();
        try {
            parseCSVData(new File("src/com/milad/Module3_4/PlayerData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (PlayerBattingStats player : players) {
            //System.out.println(player);
        }

        System.out.println("GAMES PLAYED SORT");
        ArrayList<PlayerBattingStats> gamesSort = PlayerSorter.sort(players, PlayerSorter.GAMESPLAYED);
        assert gamesSort != null;
        for (PlayerBattingStats player : gamesSort) {
            System.out.println(player);
        }

        System.out.println("AT BATS SORT");
        ArrayList<PlayerBattingStats> atBatsSort = PlayerSorter.sort(players, PlayerSorter.ATBATS);
        assert atBatsSort != null;
        for (PlayerBattingStats player : atBatsSort) {
            System.out.println(player);
        }

        System.out.println("RUNS SORT");
        ArrayList<PlayerBattingStats> runsSort = PlayerSorter.sort(players, PlayerSorter.RUNS);
        assert runsSort != null;
        for (PlayerBattingStats player : runsSort) {
            System.out.println(player);
        }

        System.out.println("PERCENT RUNS SORT");
        ArrayList<PlayerBattingStats> percentRunsSort = PlayerSorter.sort(players, PlayerSorter.PERCENTRUNS);
        assert percentRunsSort != null;
        for (PlayerBattingStats player : percentRunsSort) {
            System.out.println(player);
        }

        System.out.println("PERCENT ON BASE SORT");
        ArrayList<PlayerBattingStats> percentOnBaseSort = PlayerSorter.sort(players, PlayerSorter.PERCENTONBASE);
        assert percentOnBaseSort != null;
        for (PlayerBattingStats player : percentOnBaseSort) {
            System.out.println(player);
        }
    }
}
