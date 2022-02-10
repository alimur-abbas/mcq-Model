package com.example.mcqround1.models;

import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class ExaminationModel extends QuestionModel {
    private String examinationId;
    List<QuestionModel> questionModelList;

    public String getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(String examinationId) {
        this.examinationId = examinationId;
    }

    public List<QuestionModel> getQuestionModelList() {
        return questionModelList;
    }

    public void setQuestionModelList(List<QuestionModel> questionModelList) {
        this.questionModelList = questionModelList;
    }
//
//    @Override
//    public String toString() {
//        return "ExaminationModel{" +
//                "examinationId='" + examinationId + '\'' +
//                ", questionModelList=" + questionModelList +
//                '}';
//    }
}
