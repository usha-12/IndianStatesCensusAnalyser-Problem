package com.brideglabz.Indianstatescensusanalyser;

import java.io.Reader;

public class CsvToBeanBuilder<T> {
    public CsvToBeanBuilder(Reader reader) {
    }

    public void withType(Class<T> indiaCensusCSVClass) {
    }

    public void withIgnoreLeadingWhiteSpace(boolean b) {
    }

    public <CsvToBean> CsvToBean build() {
        return CsvToBean;
    }
}
