package com.brideglabz.Indianstatescensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser<CsvToBean> {
    public <CsvToBean> int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        int noOfEateries = 0;
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> iterator = csvToBean.iterator();
            Iterable<IndiaCensusCSV> iterable = () -> iterator;
            noOfEateries = (int) StreamSupport.stream(iterable.spliterator(), false).count();
        } catch (NoSuchFileException e) {
            if (!csvFilePath.contains(".csv")) {
                throw new CensusAnalyserException(e.getMessage(),
                        CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
            }
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.NO_SUCH_FILE);
        }
        return noOfEateries;
    }

    public int loadIndiaCodeData(String csvFilePath) throws CensusAnalyserException {
        int noOfEateries = 0;
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBeanBuilder<IndiaCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCodeCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCodeCSV> codeCSVIterator;
           codeCSVIterator = csvToBean.iterator();
            while (codeCSVIterator.hasNext()) {
                noOfEateries++;
                IndiaCodeCSV codeData = codeCSVIterator.next();
            }
        } catch (NoSuchFileException e) {
            if (!csvFilePath.contains(".csv")) {
                throw new CensusAnalyserException(e.getMessage(),
                        CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
            }
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.NO_SUCH_FILE);
        }
        return noOfEateries;
    }
}
