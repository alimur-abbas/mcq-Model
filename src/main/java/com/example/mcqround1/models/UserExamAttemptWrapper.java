package com.example.mcqround1.models;

public class UserExamAttemptWrapper {
    ExaminationModel examinationModel;
    UserExamAttempt userExamAttempt;

    public ExaminationModel getExaminationModel() {
        return examinationModel;
    }

    public void setExaminationModel(ExaminationModel examinationModel) {
        this.examinationModel = examinationModel;
    }

    public UserExamAttempt getUserExamAttempt() {
        return userExamAttempt;
    }

    public void setUserExamAttempt(UserExamAttempt userExamAttempt) {
        this.userExamAttempt = userExamAttempt;
    }
}
