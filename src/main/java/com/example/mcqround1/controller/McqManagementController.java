package com.example.mcqround1.controller;

import com.example.mcqround1.models.*;
import com.example.mcqround1.repository.ObjectMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class McqManagementController {
    @Autowired
    private ObjectMapping objectMapping;

    @GetMapping("/init")
    public String init() {
        return "Project is running";
    }


    @GetMapping("/enter")
    public void data() throws IOException {
        List<ExaminationModel> list = objectMapping.read();

        objectMapping.save(list.get(0));

    }

    @GetMapping("/detail/{exam_code}")
    public ResponseEntity<UserExamAttemptWrapper> getModel(@PathVariable String exam_code) {
        ExaminationModel ex = objectMapping.getExamModel(exam_code);
        UserExamAttempt userExamAttempt = new UserExamAttempt();
        userExamAttempt.setAttemptId(UUID.randomUUID().toString());
        userExamAttempt.setExamId(ex.getExaminationId());
        userExamAttempt.setAccountId("user");
        userExamAttempt.setExamType(ExamType.RETAKE);
        long startTime = System.currentTimeMillis();
        userExamAttempt.setStartedAt(startTime);
        userExamAttempt.setEndAt(startTime + 3600000);
        objectMapping.saveAttempt(userExamAttempt);

        //start at and end at

//create user attempt by using inputs from ex ,save user attempt to db
        List<QuestionModel> list = objectMapping.getQuestionModel(ex.getExaminationId());
        ex.setQuestionModelList(list);
        List<OptionModel> optionModelList = new ArrayList<>();
        for (QuestionModel op : list) {
            optionModelList = objectMapping.getOptionModel(op.getQuestionId());
            op.setOptionModelList(optionModelList);
        }
        UserExamAttemptWrapper userExamAttemptWrapper = new UserExamAttemptWrapper();
        userExamAttemptWrapper.setExaminationModel(ex);
        userExamAttemptWrapper.setUserExamAttempt(userExamAttempt);
        //System.out.println(list);
        // System.out.println(ex);
        return ResponseEntity.ok(userExamAttemptWrapper);
    }

    @PostMapping("/save-user-answer")
    public ResponseEntity<UserAnswerModel> saveUserAnswer(@RequestBody UserAnswerModel ua) {
        objectMapping.saveUserAnswer(ua);
        return ResponseEntity.ok(ua);
    }

    @PostMapping("/result")
    public ResponseEntity<String> userResult(@RequestBody UserResultQueryRequest ur) {
        String result = objectMapping.result(ur);
        return ResponseEntity.ok(result);
    }


}

