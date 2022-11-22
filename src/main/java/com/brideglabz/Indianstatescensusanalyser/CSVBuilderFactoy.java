package com.brideglabz.Indianstatescensusanalyser;

public class CSVBuilderFactoy {
    public static ICSVBuilder createCsvBuilder() {
        return new OpenCSVBuilder();



    }
}
