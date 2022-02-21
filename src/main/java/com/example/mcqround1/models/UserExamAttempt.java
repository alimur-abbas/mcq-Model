package com.example.mcqround1.models;

 public class UserExamAttempt{
 private String attemptId;
 private Long startedAt;
 private Long endAt;
 private String examId;
 private String accountId;
 private ExamType examType;

   public String getAccountId() {
     return accountId;
   }

   public void setAccountId(String accountId) {
     this.accountId = accountId;
   }

   public String getExamId() {
     return examId;
   }

   public void setExamId(String examId) {
     this.examId = examId;
   }

   public ExamType getExamType() {
     return examType;
   }

   public void setExamType(ExamType examType) {
     this.examType = examType;
   }

   public String getAttemptId() {
    return attemptId;
  }

  public void setAttemptId(String attemptId) {
    this.attemptId = attemptId;
  }

  public Long getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(Long startedAt) {
    this.startedAt = startedAt;
  }

  public Long getEndAt() {
    return endAt;
  }

  public void setEndAt(Long endAt) {
    this.endAt = endAt;
  }
//List<UserQuestionResult> questionResults;
}