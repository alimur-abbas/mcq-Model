package com.example.mcqround1.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OptionModel {
    private String optionLabel;
    private String optionDescription;

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

//    @Override
//    public String toString() {
//        return "OptionModel{" +
//                "optionLabel='" + optionLabel + '\'' +
//                ", optionDescription='" + optionDescription + '\'' +
//                '}';
//    }
}


