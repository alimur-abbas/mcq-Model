package com.example.mcqround1.models;

import java.util.List;

public class UserExamResult {
   private String accountId;
   private List<UserQuestionResult> questionResults;
   private int score;
   private String attemptId;

    public String getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(String attemptId) {
        this.attemptId = attemptId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<UserQuestionResult> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(List<UserQuestionResult> questionResults) {
        this.questionResults = questionResults;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
