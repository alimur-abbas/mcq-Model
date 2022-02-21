package com.example.mcqround1.models;

public class UserAnswerModel {
    private String questionUuid;
    private String answerLabel;
    private String attemptId;
    private Long submitedAt ;

    public String getQuestionUuid() {
        return questionUuid;
    }

    public void setQuestionUuid(String questionUuid) {
        this.questionUuid = questionUuid;
    }

    public String getAnswerLabel() {
        return answerLabel;
    }

    public void setAnswerLabel(String answerLabel) {
        this.answerLabel = answerLabel;
    }

    public String getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(String attemptId) {
        this.attemptId = attemptId;
    }

    public Long getSubmitedAt() {
        return submitedAt;
    }

    public void setSubmitedAt(Long submitedAt) {
        this.submitedAt = submitedAt;
    }
}

