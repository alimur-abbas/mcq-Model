package com.example.mcqround1.models;

public class UserQuestionResult {
    private String questionId;
    private String actualAnswerLabel;
    private String userSubmittedAnswerLabel;
    private int result;// actualAnswerLabel.equals(userSubmittedAnswerLabel);

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getActualAnswerLabel() {
        return actualAnswerLabel;
    }

    public void setActualAnswerLabel(String actualAnswerLabel) {
        this.actualAnswerLabel = actualAnswerLabel;
    }

    public String getUserSubmittedAnswerLabel() {
        return userSubmittedAnswerLabel;
    }

    public void setUserSubmittedAnswerLabel(String userSubmittedAnswerLabel) {
        this.userSubmittedAnswerLabel = userSubmittedAnswerLabel;
    }
}
