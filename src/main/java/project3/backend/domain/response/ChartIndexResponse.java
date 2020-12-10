package project3.backend.domain.response;

import project3.backend.model.Employee;
import project3.backend.model.Mistake;

import java.util.List;

public class ChartIndexResponse extends BaseResponse{
    //đếm số lượt chăm soc trong năm
    int[] countCustomerCare;

    //thống kê điểm số cuộc gọi
    int[] countScore;

    //tiêu chí phân loại cuộc gọi
    String[] countScoreName;

    //danh sashc tên nhân viên
    String[] nameEmployee;

    //danh sách điểm nhân viên
    int[] scoreEmployee;

    //tên lỗi
    String[] mistakeName;

    //số lần mắc
    int[] countMistake;

    public int[] getCountCustomerCare() {
        return countCustomerCare;
    }

    public void setCountCustomerCare(int[] countCustomerCare) {
        this.countCustomerCare = countCustomerCare;
    }

    public int[] getCountScore() {
        return countScore;
    }

    public void setCountScore(int[] countScore) {
        this.countScore = countScore;
    }

    public String[] getCountScoreName() {
        return countScoreName;
    }

    public void setCountScoreName(String[] countScoreName) {
        this.countScoreName = countScoreName;
    }

    public String[] getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String[] nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int[] getScoreEmployee() {
        return scoreEmployee;
    }

    public void setScoreEmployee(int[] scoreEmployee) {
        this.scoreEmployee = scoreEmployee;
    }

    public String[] getMistakeName() {
        return mistakeName;
    }

    public void setMistakeName(String[] mistakeName) {
        this.mistakeName = mistakeName;
    }

    public int[] getCountMistake() {
        return countMistake;
    }

    public void setCountMistake(int[] countMistake) {
        this.countMistake = countMistake;
    }
}
