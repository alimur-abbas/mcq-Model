package com.example.mcqround1;

import com.example.mcqround1.models.ExaminationModel;
import com.example.mcqround1.models.OptionModel;
import com.example.mcqround1.models.QuestionModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapping {
    private static final String CSV_FILE_PATH ="C:\\Users\\Alimur\\Desktop\\SpringBoot\\mcq-round-1\\src\\main\\resources\\mcq.csv";

    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        FileReader fileReader = new FileReader(CSV_FILE_PATH);
        CSVReader csvReader = new CSVReaderBuilder(fileReader).build();
//        String [] record ;
//        while ((record = csvReader.readNext())!= null){
//            for (String output:record) {
//                System.out.print(output);
//            }
//            System.out.println();
//        }



        List<ExaminationModel> examinationModelList = csvReader.readAll().stream().map(data->{
            ExaminationModel examinationModel = new ExaminationModel();
            examinationModel.setExaminationId(data[0]);


            List<QuestionModel> questionModelList = new ArrayList<>();

            QuestionModel questionModel = new QuestionModel();
            questionModel.setQuestionId(data[1]);
            questionModel.setQuestionDescription(data[2]);
            questionModel.setAnswerLabel(data[3]);


            List<OptionModel> optionModelList = new ArrayList<>();


            OptionModel optionModel = new OptionModel();
            optionModel.setOptionLabel(data[4]);
            optionModel.setOptionDescription(data[8]);

            OptionModel optionModel1 = new OptionModel();
            optionModel1.setOptionLabel(data[5]);
            optionModel1.setOptionDescription(data[9]);

            OptionModel optionModel2 = new OptionModel();
            optionModel2.setOptionLabel(data[6]);
            optionModel2.setOptionDescription(data[10]);

            OptionModel optionModel3 = new OptionModel();
            optionModel3.setOptionLabel(data[7]);
            optionModel3.setOptionDescription(data[11]);

            optionModelList.add(optionModel);
            optionModelList.add(optionModel1);
            optionModelList.add(optionModel2);
            optionModelList.add(optionModel3);

            questionModel.setOptionModelList(optionModelList);

            questionModelList.add(questionModel);

            examinationModel.setQuestionModelList(questionModelList);

            return examinationModel;
        }).collect(Collectors.toList());
//        examinationModelList.forEach(System.out::println);


//        for (ExaminationModel ex : examinationModelList){
//            System.out.println("exam id = "+ex.getExaminationId());
////            for (QuestionModel qm : ex.getQuestionModelList()){
////                System.out.println(qm.getAnswerLabel());
////                System.out.println(qm.getQuestionDescription());
////                System.out.println(qm.getQuestionId());
////                for (OptionModel om : qm.getOptionModelList()){
////                    System.out.println(om.getOptionDescription());
////                    System.out.println(om.getOptionLabel());
////                }
////            }
////        }
//
        for (ExaminationModel ex : examinationModelList){

        System.out.println(gson.toJson(ex));
        }
        FileWriter file = new FileWriter("output.json");
        file.write(gson.toJson(examinationModelList));
        file.close();
    }


}
