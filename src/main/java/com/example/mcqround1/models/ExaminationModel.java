package com.example.mcqround1.models;

import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class ExaminationModel  {
    private String examinationId;
    private String examCode;
    private String examTitle;
    private String examDesc;
    private String examDate;
    private String examTime;
    private String examDuration;//long millisecond(convert minutes to milliseconds)
    List<QuestionModel> questionModelList;


    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public String getExamDesc() {
        return examDesc;
    }

    public void setExamDesc(String examDesc) {
        this.examDesc = examDesc;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(String examDuration) {
        this.examDuration = examDuration;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }


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

    @Override
    public String toString() {
        return "ExaminationModel{" +
                "examinationId='" + examinationId + '\'' +
                ", examCode='" + examCode + '\'' +
                ", examTitle='" + examTitle + '\'' +
                ", examDesc='" + examDesc + '\'' +
                ", examDate='" + examDate + '\'' +
                ", examTime='" + examTime + '\'' +
                ", examDuration='" + examDuration + '\'' +
                ", questionModelList=" + questionModelList +
                '}';
    }
}


