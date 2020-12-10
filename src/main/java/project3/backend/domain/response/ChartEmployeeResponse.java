package project3.backend.domain.response;

import java.util.List;

public class ChartEmployeeResponse extends BaseResponse{

    int score[];

    int mistakeCount[];

    String mistakeName[];

    int rank;

    int bad;

    int total;

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }


    public int[] getMistakeCount() {
        return mistakeCount;
    }

    public void setMistakeCount(int[] mistakeCount) {
        this.mistakeCount = mistakeCount;
    }

    public String[] getMistakeName() {
        return mistakeName;
    }

    public void setMistakeName(String[] mistakeName) {
        this.mistakeName = mistakeName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
