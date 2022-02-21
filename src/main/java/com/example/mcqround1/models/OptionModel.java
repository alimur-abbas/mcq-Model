package com.example.mcqround1.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OptionModel {
    private String optionId;
    private String optionLabel;
    private String optionDescription;
    private String questionId;


    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getOptionLabel() {
        return optionLabel;
    }

    public void setOptionLabel(String optionLabel) {
        this.optionLabel = optionLabel;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
    }

    @Override
    public String toString() {
        return "OptionModel{" +
                "optionId='" + optionId + '\'' +
                ", optionLabel='" + optionLabel + '\'' +
                ", optionDescription='" + optionDescription + '\'' +
                ", questionId='" + questionId + '\'' +
                '}';
    }
}


