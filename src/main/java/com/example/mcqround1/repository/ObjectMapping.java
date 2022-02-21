package com.example.mcqround1.repository;

import com.example.mcqround1.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.w3c.dom.NameList;

import java.io.*;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Repository
public class ObjectMapping {
    @Autowired
    private JdbcTemplate jdbcTemplate;




    private static final String CSV_FILE_PATH = "C:\\Users\\Alimur\\Desktop\\SpringBoot\\mcq-round-1\\src\\main\\resources\\mcq.csv";
    private static final String INSERT = "INSERT INTO TBL_EXAMINATION(EXAM_ID,EXAM_CODE,EXAM_TITLE,EXAM_DESC,EXAM_DATE,EXAM_TIME,EXAM_DURATION) VALUES (?,?,?,?,?,?,?)";
    private static final String INSERT_QUESTION = "INSERT INTO TBL_QUESTION(QUESTION_ID,EXAM_ID,QUESTION_LABEL,QUESTION_DESC,ANSWER_LABEL) VALUES (?,?,?,?,?)";
    private static final String INSERT_ANSWER = "INSERT INTO TBL_USER_ANSWER(QUESTION_ID,ANSWER_LABEL,ATTEMPT_ID,SUBMITTED_AT) VALUES (?,?,?,?)";
    private static final String INSERT_ATTEMPT = "INSERT INTO TBL_USER_ATTEMPT(USER_ACCOUNT_ID,ATTEMPT_ID,EXAM_ID,EXAM_TYPE,STARTED_AT,END_AT,RESULT,SCORE) VALUES (?,?,?,?,?,?,?,?)";
    private static final String INSERT_OPTION = "INSERT INTO TBL_OPTION(OPTION_ID,QUESTION_ID,OPTION_LABEL,OPTION_DESC) VALUES (?,?,?,?)";
    private static final String SELECT_EXAM_MODEL = "SELECT * FROM TBL_EXAMINATION WHERE EXAM_CODE=?";
    private static final String SELECT_QUESTION_MODEL = "SELECT * FROM TBL_QUESTION WHERE EXAM_ID=?";
    private static final String SELECT_OPTION_MODEL = "SELECT * FROM TBL_OPTION WHERE QUESTION_ID=?";
    private static final String SELECT_QUESTION_RESULT = "SELECT T1.QUESTION_ID ,T1.ANSWER_LABEL AS A1, T2.ANSWER_LABEL AS A2 , STRCMP(T1.ANSWER_LABEL, T2.ANSWER_LABEL) AS RESULT" +
            " FROM TBL_QUESTION T1 LEFT JOIN TBL_USER_ANSWER T2" +
            " ON T1.QUESTION_ID = T2.QUESTION_ID";
    private static final String UPDATE_TBL_ATTEMPT = "UPDATE TBL_USER_ATTEMPT SET RESULT =? , SCORE =? WHERE ATTEMPT_ID =?";
    private static final String GET_RESULT_DETAIL = "SELECT USER_ACCOUNT_ID,RESULT,SCORE FROM TBL_USER_ATTEMPT WHERE ATTEMPT_ID = ?";
//    select t1.question_id ,t1.answer_label as A1, t2.answer_label as A2 , strcmp(t1.answer_label, t2.answer_label)
//    -> from tbl_question t1 left join tbl_user_answer t2
//    -> on t1.question_id = t2.question_id;
//    public static void main(String[] args) throws IOException {
//
//        // save exam
//        // batch save questions
//        // batch save options
//
//        ObjectMapping obj = new ObjectMapping();
//        ExaminationModel examinationModel = obj.read().get(0);
//        List<QuestionModel> questionModelList = examinationModel.getQuestionModelList();
//        List<OptionModel> optionModels = questionModelList.stream().map(e -> {
//            return e.getOptionModelList();
//        }).flatMap(Collection::stream).collect(Collectors.toList());
//        ExaminationModel ex = obj.getExamModel("1102");
//        System.out.println(ex);
////        System.out.println(questionModelList);
////        System.out.println(optionModels);
//    }

    public List<ExaminationModel> read() throws IOException {
        FileReader fileReader = new FileReader(CSV_FILE_PATH);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
        final ExaminationModel examinationModel = new ExaminationModel();
        List<ExaminationModel> examinationModelList = csvReader.readAll().stream().map(data -> {
            if (examinationModel.getExamCode() == null) {
                examinationModel.setExaminationId(UUID.randomUUID().toString());
                examinationModel.setExamCode(data[0]);
//             System.out.println(examinationModel.setExamCode(Integer.parseInt(data[1])));
                examinationModel.setExamTitle(data[1]);
                examinationModel.setExamDesc(data[2]);
                examinationModel.setExamDate(data[3]);
                examinationModel.setExamTime(data[4]);
                examinationModel.setExamDuration(data[5]);
                examinationModel.setQuestionModelList(new ArrayList<>());
            }

            List<QuestionModel> questionModelList = examinationModel.getQuestionModelList();

            QuestionModel questionModel = new QuestionModel();
            questionModel.setExaminationId(examinationModel.getExaminationId());
            questionModelList.add(questionModel);
            questionModel.setQuestionLabel(data[6]);
            questionModel.setQuestionDescription(data[7]);
            questionModel.setAnswerLabel(data[8]);
            questionModel.setQuestionId(UUID.randomUUID().toString());
            questionModel.setOptionModelList(new ArrayList<>());

            List<OptionModel> optionModelList = questionModel.getOptionModelList();


            OptionModel optionModel = new OptionModel();
            optionModel.setOptionId(UUID.randomUUID().toString());
            optionModel.setQuestionId(questionModel.getQuestionId());
            optionModel.setOptionLabel(data[9]);
            optionModel.setOptionDescription(data[13]);

            OptionModel optionModel1 = new OptionModel();
            optionModel1.setOptionId(UUID.randomUUID().toString());
            optionModel1.setQuestionId(questionModel.getQuestionId());
            optionModel1.setOptionLabel(data[10]);
            optionModel1.setOptionDescription(data[14]);

            OptionModel optionModel2 = new OptionModel();
            optionModel2.setOptionId(UUID.randomUUID().toString());
            optionModel2.setQuestionId(questionModel.getQuestionId());
            optionModel2.setOptionLabel(data[11]);
            optionModel2.setOptionDescription(data[15]);

            OptionModel optionModel3 = new OptionModel();
            optionModel3.setOptionId(UUID.randomUUID().toString());
            optionModel3.setQuestionId(questionModel.getQuestionId());
            optionModel3.setOptionLabel(data[12]);
            optionModel3.setOptionDescription(data[16]);

            optionModelList.add(optionModel);
            optionModelList.add(optionModel1);
            optionModelList.add(optionModel2);
            optionModelList.add(optionModel3);


            return examinationModel;
        }).collect(Collectors.toList());
//        examinationModelList.forEach(System.out::println);
        return examinationModelList;
    }

    public String convertToJson(List<UserQuestionResult> uq) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        String json = "";
        for (UserQuestionResult usr : uq) {

            //System.out.println(gson.toJson(ex));
            json = json + gson.toJson(usr);
        }
//        FileWriter file = new FileWriter("output.json");
//        file.write(gson.toJson(examinationModelList));
//        file.close();
        return json;
    }

    public void saveAttempt(UserExamAttempt ua) {
        String result = " ";
        int score = 0;
        Object[] ob = new Object[]{ua.getAccountId(), ua.getAttemptId(), ua.getExamId(), ua.getExamType(), ua.getStartedAt(), ua.getEndAt(), result, score};
        jdbcTemplate.update(INSERT_ATTEMPT, ob);
    }

    public void save(ExaminationModel ex) {
        jdbcTemplate.update(INSERT, new Object[]{ex.getExaminationId(), ex.getExamCode(), ex.getExamTitle(), ex.getExamDesc(), ex.getExamDate(), ex.getExamTime(), ex.getExamDuration()});

        List<QuestionModel> questionModelList = ex.getQuestionModelList();
        List<OptionModel> optionModels = questionModelList.stream().map(e -> {
            return e.getOptionModelList();
        }).flatMap(Collection::stream).collect(Collectors.toList());
        saveQuestion(questionModelList);//cut ex.getExaminationId()
        saveOption(optionModels);

    }

    private int[] saveOption(List<OptionModel> op) {
        return jdbcTemplate.batchUpdate(INSERT_OPTION, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, op.get(i).getOptionId());
                ps.setString(2, op.get(i).getQuestionId());
                ps.setString(3, op.get(i).getOptionLabel());
                ps.setString(4, op.get(i).getOptionDescription());
            }

            @Override
            public int getBatchSize() {
                return op.size();
            }
        });
    }

    private int[] saveQuestion(List<QuestionModel> op) {
        return jdbcTemplate.batchUpdate(INSERT_QUESTION, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, op.get(i).getQuestionId());
                ps.setString(2, op.get(i).getExaminationId());//euuid
                ps.setString(3, op.get(i).getQuestionLabel());
                ps.setString(4, op.get(i).getQuestionDescription());
                ps.setString(5, op.get(i).getAnswerLabel());

            }

            @Override
            public int getBatchSize() {
                return op.size();
            }
        });

    }

    public ExaminationModel getExamModel(String exam_code) {
        Object[] ob = new Object[]{exam_code};
        ExaminationModel ex = jdbcTemplate.queryForObject(SELECT_EXAM_MODEL, new ExamRowMapper(), ob);
        return ex;
    }

    public List<QuestionModel> getQuestionModel(String examinationId) {
        Object[] ob = new Object[]{examinationId};
        List<QuestionModel> qm = jdbcTemplate.query(SELECT_QUESTION_MODEL, new QuestionRowMapper(), ob);
        return qm;
    }

    public List<OptionModel> getOptionModel(String questionId) {
        Object[] ob = new Object[]{questionId};
        List<OptionModel> om = jdbcTemplate.query(SELECT_OPTION_MODEL, new OptionRowMapper(), ob);
        return om;
    }

    public int saveUserAnswer(UserAnswerModel ua) {
        ua.setSubmitedAt(System.currentTimeMillis());
        return jdbcTemplate.update(INSERT_ANSWER, new Object[]{ua.getQuestionUuid(), ua.getAnswerLabel(), ua.getAttemptId(), ua.getSubmitedAt()});
    }

    public String result(UserResultQueryRequest ua) {
        int count = 0;
        List<UserQuestionResult> list = jdbcTemplate.query(SELECT_QUESTION_RESULT, new ResultMapper());
       // userExamResult.setQuestionResults(list);
        for (UserQuestionResult uq : list) {
            if (uq.getResult() == 0) {
                count++;
            }
        }
        String listOfJson = convertToJson(list);
        //if(not calculated)
        Object[] ob = new Object[]{listOfJson, count, ua.getAttemptId()};
        jdbcTemplate.update(UPDATE_TBL_ATTEMPT, ob);
        viewResult(ua.getAttemptId(),list);

        return listOfJson;
    }

    public void viewResult(String attemptId,List<UserQuestionResult> list) {
        Object[] ob = new Object[]{attemptId};


    }

    public static class ExamRowMapper implements RowMapper<ExaminationModel> {

        @Override
        public ExaminationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            String uuid = rs.getString("EXAM_ID");
            String exam_code = rs.getString("EXAM_CODE");
            String exam_title = rs.getString("EXAM_TITLE");
            String exam_desc = rs.getString("EXAM_DESC");
            String exam_date = rs.getString("EXAM_DATE");
            String exam_time = rs.getString("EXAM_TIME");
            String exam_dur = rs.getString("EXAM_DURATION");

            ExaminationModel ex = new ExaminationModel();
            ex.setExaminationId(uuid);
            ex.setExamCode(exam_code);
            ex.setExamTitle(exam_title);
            ex.setExamDesc(exam_desc);
            ex.setExamDate(exam_date);
            ex.setExamTime(exam_time);
            ex.setExamDuration(exam_dur);


            return ex;
        }
    }

    public static class QuestionRowMapper implements RowMapper<QuestionModel> {
        @Override
        public QuestionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            String uuid = rs.getString("QUESTION_ID");
            String exam_id = rs.getString("EXAM_ID");
            String ql = rs.getString("QUESTION_LABEL");
            String question_desc = rs.getString("QUESTION_DESC");
            String al = rs.getString("ANSWER_LABEL");

            QuestionModel q = new QuestionModel();
            q.setQuestionId(uuid);
            q.setExaminationId(exam_id);
            q.setQuestionLabel(ql);
            q.setQuestionDescription(question_desc);
            q.setAnswerLabel(al);

            return q;
        }
    }

    public static class OptionRowMapper implements RowMapper<OptionModel> {

        @Override
        public OptionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            String opid = rs.getString("OPTION_ID");
            String qid = rs.getString("QUESTION_ID");
            String optionLabel = rs.getString("OPTION_LABEL");
            String option_desc = rs.getString("OPTION_DESC");

            OptionModel op = new OptionModel();
            op.setOptionId(opid);
            op.setQuestionId(qid);
            op.setOptionLabel(optionLabel);
            op.setOptionDescription(option_desc);

            return op;
        }
    }

    public static class ResultMapper implements RowMapper<UserQuestionResult> {

        @Override
        public UserQuestionResult mapRow(ResultSet rs, int rowNum) throws SQLException {
            String question_id = rs.getString("question_id");
            String actual_answer = rs.getString("A1");
            String user_answer = rs.getString("A2");
            int result = rs.getInt("RESULT");

            UserQuestionResult uq = new UserQuestionResult();
            uq.setQuestionId(question_id);
            uq.setActualAnswerLabel(actual_answer);
            uq.setUserSubmittedAnswerLabel(user_answer);
            uq.setResult(result);

            return uq;
        }
    }
    public static class FinalResultMapper implements RowMapper<UserExamResult>{
        @Override
        public UserExamResult mapRow(ResultSet rs, int rowNum) throws SQLException {
            String userId = rs.getString("USER_ACCOUNT_ID");
          String result = rs.getString("RESULT");

            String score = rs.getString("SCORE");
//            ObjectMapper mapper = new ObjectMapper();
//            List<UserQuestionResult> list = mapper.readValue( result,)
            Gson gson = new Gson();
            NameList nameList = gson.fromJson(result,NameList.class);
            List<UserQuestionResult> list = nameList.getList();
            UserExamResult uer = new UserExamResult();
            uer.setAccountId(userId);
            uer.setQuestionResults(result);
            return null;
        }
    }
}
//    public void saveQuestion() {
//
//            jdbcTemplate.update(INSERT_QUESTION, new Object[]{q.getQuestionId(), ex.getExaminationId(), q.getQuestionLabel(), q.getQuestionDescription(), q.getAnswerLabel()});
//        }


//    public void saveOption(ExaminationModel ex) {
//        for (OptionModel op : ex.getOptionModelList()) {
//            String ouuid=UUID.randomUUID().toString();
//            op.setOptionId(ouuid);
//            jdbcTemplate.update(INSERT_OPTION, new Object[]{ex.getQuestionId(),ex.getOptionId(), ex.getOptionLabel(), ex.getOptionDescription()});
//        }
//
//
//    }




