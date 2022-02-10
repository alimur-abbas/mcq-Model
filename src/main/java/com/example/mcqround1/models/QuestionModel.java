package com.example.mcqround1.models;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class QuestionModel  extends OptionModel{
    private String questionId;
    private String questionDescription;
    private String answerLabel;
    List<OptionModel> optionModelList;


    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getAnswerLabel() {
        return answerLabel;
    }

    public void setAnswerLabel(String answerLabel) {
        this.answerLabel = answerLabel;
    }

    public List<OptionModel> getOptionModelList() {
        return optionModelList;
    }

    public void setOptionModelList(List<OptionModel> optionModelList) {
        this.optionModelList = optionModelList;
    }

//    @Override
//    public String toString() {
//        return "QuestionModel{" +
//                "questionId='" + questionId + '\'' +
//                ", questionDescription='" + questionDescription + '\'' +
//                ", answerLabel='" + answerLabel + '\'' +
//                ", optionModelList=" + optionModelList +
//                '}';
//    }
}
