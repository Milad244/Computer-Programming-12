package com.milad.Module3_4;

import java.util.ArrayList;

/**
 * Class that takes in an ArrayList and sorts the players by various criteria
 * using a mergesort.
 */

public class PlayerSorter {
    //The following fields are the different sort types:
    public static int GAMESPLAYED = 0;
    public static int ATBATS = 1;
    public static int RUNS = 2;
    public static int PERCENTRUNS = 3; // Calculated by: runs/atBats
    public static int PERCENTONBASE = 4; // Calculated by (hits + doubles + triples) / atBats

    /**
     * This method is an interface that allows the sorting of a player given based on
     * certain criteria.  There are 5 options to sort a player which are by Games played,
     * at bats, runs, percent runs, percent on base.
     * The sort is in descending order (Largest to smallest)
     * This method calls one of 5 private methods that will do the sort based on the chosen criteria.
     * @param list List of players containing the statistics
     * @param sortType How the user wants the players sorted.  The value should be chosed from one of
     *                 the 5 static fields from the class.
     * @return An ArrayList that is sorted according to the users specification.
     */
    public static ArrayList<PlayerBattingStats> sort(ArrayList<PlayerBattingStats> list, int sortType) {
        // Recursive control 'if' statement.
        if(list.size() <= 1) {
            return list;
        }
        int midpoint = list.size() / 2;

        // Declare and initialize left and right arrays.
        ArrayList<PlayerBattingStats> left = new ArrayList<>(list.subList(0, midpoint));
        ArrayList<PlayerBattingStats> right = new ArrayList<>(list.subList(midpoint, list.size()));

        // Recursive call for left and right arrays.
        left = sort(left, sortType);
        right = sort(right, sortType);

        // Return the sorted merged array.
        if (left != null && right != null) {
            return switch (sortType) {
                case 0 -> merge0(left, right);
                case 1 -> merge1(left, right);
                case 2 -> merge2(left, right);
                case 3 -> merge3(left, right);
                case 4 -> merge4(left, right);
                default -> {
                    System.out.println("Error: sort type does not exist");
                    yield null;
                }
            };
        } else {
            return null;
        }
    }

    /**
     * Takes left and right array and sorts by descending order of games played
     * @param left left array
     * @param right right array
     * @return sorted merged array
     */
    private static ArrayList<PlayerBattingStats> merge0(ArrayList<PlayerBattingStats> left, ArrayList<PlayerBattingStats> right) {
        // Merged result array.
        ArrayList<PlayerBattingStats> result = new ArrayList<>();
        // Declare and initialize pointers for all arrays.
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        // While there are items in either array...
        while(leftPointer < left.size() || rightPointer < right.size()) {
            // If there are items in BOTH arrays...
            if(leftPointer < left.size() && rightPointer < right.size()) {
                // If right item ranks higher than left item...
                if(right.get(rightPointer).getGames() > left.get(leftPointer).getGames()) {
                    result.add(resultPointer++, right.get(rightPointer++));
                } else {
                    result.add(resultPointer++, left.get(leftPointer++));
                }
            }
            // If there are only items in the left array...
            else if(leftPointer < left.size()) {
                result.add(resultPointer++, left.get(leftPointer++));
            }
            // If there are only items in the right array...
            else {
                result.add(resultPointer++, right.get(rightPointer++));
            }
        }
        return result;
    }

    /**
     * Takes left and right array and sorts by descending order of at bats
     * @param left left array
     * @param right right array
     * @return sorted merged array
     */
    private static ArrayList<PlayerBattingStats> merge1(ArrayList<PlayerBattingStats> left, ArrayList<PlayerBattingStats> right) {
        // Merged result array.
        ArrayList<PlayerBattingStats> result = new ArrayList<>();
        // Declare and initialize pointers for all arrays.
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        // While there are items in either array...
        while(leftPointer < left.size() || rightPointer < right.size()) {
            // If there are items in BOTH arrays...
            if(leftPointer < left.size() && rightPointer < right.size()) {
                // If right item ranks higher than left item...
                if(right.get(rightPointer).getAtBats() > left.get(leftPointer).getAtBats()) {
                    result.add(resultPointer++, right.get(rightPointer++));
                } else {
                    result.add(resultPointer++, left.get(leftPointer++));
                }
            }
            // If there are only items in the left array...
            else if(leftPointer < left.size()) {
                result.add(resultPointer++, left.get(leftPointer++));
            }
            // If there are only items in the right array...
            else {
                result.add(resultPointer++, right.get(rightPointer++));
            }
        }
        return result;
    }

    /**
     * Takes left and right array and sorts by descending order of runs
     * @param left left array
     * @param right right array
     * @return sorted merged array
     */
    private static ArrayList<PlayerBattingStats> merge2(ArrayList<PlayerBattingStats> left, ArrayList<PlayerBattingStats> right) {
        // Merged result array.
        ArrayList<PlayerBattingStats> result = new ArrayList<>();
        // Declare and initialize pointers for all arrays.
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        // While there are items in either array...
        while(leftPointer < left.size() || rightPointer < right.size()) {
            // If there are items in BOTH arrays...
            if(leftPointer < left.size() && rightPointer < right.size()) {
                // If right item ranks higher than left item...
                if(right.get(rightPointer).getRuns() > left.get(leftPointer).getRuns()) {
                    result.add(resultPointer++, right.get(rightPointer++));
                } else {
                    result.add(resultPointer++, left.get(leftPointer++));
                }
            }
            // If there are only items in the left array...
            else if(leftPointer < left.size()) {
                result.add(resultPointer++, left.get(leftPointer++));
            }
            // If there are only items in the right array...
            else {
                result.add(resultPointer++, right.get(rightPointer++));
            }
        }
        return result;
    }

    /**
     * Takes left and right array and sorts by descending order of percent runs i.e. runs/at bat
     * @param left left array
     * @param right right array
     * @return sorted merged array
     */
    private static ArrayList<PlayerBattingStats> merge3(ArrayList<PlayerBattingStats> left, ArrayList<PlayerBattingStats> right) {
        // Merged result array.
        ArrayList<PlayerBattingStats> result = new ArrayList<>();
        // Declare and initialize pointers for all arrays.
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        // While there are items in either array...
        while(leftPointer < left.size() || rightPointer < right.size()) {
            // If there are items in BOTH arrays...
            if(leftPointer < left.size() && rightPointer < right.size()) {
                // If right item ranks higher than left item...
                double rightPercentRuns = (double) right.get(rightPointer).getRuns() / right.get(rightPointer).getAtBats();
                double leftPercentRuns = (double) left.get(leftPointer).getRuns()/left.get(leftPointer).getAtBats();
                if(rightPercentRuns > leftPercentRuns) {
                    result.add(resultPointer++, right.get(rightPointer++));
                } else {
                    result.add(resultPointer++, left.get(leftPointer++));
                }
            }
            // If there are only items in the left array...
            else if(leftPointer < left.size()) {
                result.add(resultPointer++, left.get(leftPointer++));
            }
            // If there are only items in the right array...
            else {
                result.add(resultPointer++, right.get(rightPointer++));
            }
        }
        return result;
    }

    /**
     * Takes left and right array and sorts by descending order of percent on base i.e. (hits + doubles + triples) / atBats
     * @param left left array
     * @param right right array
     * @return sorted merged array
     */
    private static ArrayList<PlayerBattingStats> merge4(ArrayList<PlayerBattingStats> left, ArrayList<PlayerBattingStats> right) {
        // Merged result array.
        ArrayList<PlayerBattingStats> result = new ArrayList<>();
        // Declare and initialize pointers for all arrays.
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        // While there are items in either array...
        while(leftPointer < left.size() || rightPointer < right.size()) {
            // If there are items in BOTH arrays...
            if(leftPointer < left.size() && rightPointer < right.size()) {
                // If right item ranks higher than left item...
                double rightPercentOnBase = (double)
                        (right.get(rightPointer).getHits() + right.get(rightPointer).getDoubles() + right.get(rightPointer).getTriples())
                        / right.get(rightPointer).getAtBats();
                double leftPercentOnBase = (double)
                        (left.get(leftPointer).getHits() + left.get(leftPointer).getDoubles() + left.get(leftPointer).getTriples())
                        /left.get(leftPointer).getAtBats();
                if(rightPercentOnBase > leftPercentOnBase) {
                    result.add(resultPointer++, right.get(rightPointer++));
                } else {
                    result.add(resultPointer++, left.get(leftPointer++));
                }
            }
            // If there are only items in the left array...
            else if(leftPointer < left.size()) {
                result.add(resultPointer++, left.get(leftPointer++));
            }
            // If there are only items in the right array...
            else {
                result.add(resultPointer++, right.get(rightPointer++));
            }
        }
        return result;
    }
}
