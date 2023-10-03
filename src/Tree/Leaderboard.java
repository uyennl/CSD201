package Tree;

import java.util.*;

public class Leaderboard {
    private PriorityQueue<Integer> maxHeap;
    private int maxSize;

    public Leaderboard(int k) {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxSize = k;
    }

    public void addScore(int score) {
        maxHeap.offer(score);
        if (maxHeap.size() > maxSize) {
            maxHeap.poll();
        }
    }

    public List<Integer> getTopScores() {
        List<Integer> topScores = new ArrayList<>(maxHeap);
        Collections.sort(topScores, Collections.reverseOrder());
        return topScores;
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard(6);
        leaderboard.addScore(100);
        leaderboard.addScore(90);
        leaderboard.addScore(95);
        leaderboard.addScore(85);
        leaderboard.addScore(110);
        leaderboard.addScore(105);
        List<Integer> topScores = leaderboard.getTopScores();
        System.out.println("Top Scores: " + topScores);
    }
}