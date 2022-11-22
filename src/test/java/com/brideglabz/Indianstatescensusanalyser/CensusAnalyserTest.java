package com.brideglabz.Indianstatescensusanalyser;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "E:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_FILE_TYPE_PATH = "C:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.pdf";
    private static final String WRONG_DELIMITER_FILE_PATH = "C:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WITHOUT_HEADER_FILE_PATH = "C:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.csv";

    private static final String INDIA_CODE_CSV_FILE_PATH = "C:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode.csv";
    private static final String CODE_WRONG_CSV_FILE_PATH = "E:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode.csv";
    private static final String CODE_WRONG_FILE_TYPE_PATH = "C:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode.pdf";
    private static final String CODE_WRONG_DELIMITER_FILE_PATH = "C:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode.csv";
    private static final String CODE_WITHOUT_HEADER_FILE_PATH = "C:\\Users\\User\\Desktop\\210_RPF\\IndianStatesCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode.csv";

    private static CensusAnalyser censusAnalyser;

    @BeforeClass
    public static void createcensusAnalyser() {
        censusAnalyser = new CensusAnalyser();
        System.out.println("Welcome to the Indian States Census Analyser Program.. ");
    }

    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException censusAnalyserException) {
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException censusAnalyserException) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,
                    censusAnalyserException.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongTypeFile_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_FILE_TYPE_PATH);
        } catch (CensusAnalyserException censusAnalyserException) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, censusAnalyserException.type);
        }
    }

    @Test
    public <ExpectedException> void givenIndiaCensusData_WithWrongDelimeter_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_DELIMITER_FILE_PATH);
        } catch (CensusAnalyserException censusAnalyserException) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, censusAnalyserException.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WithoutHeader_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WITHOUT_HEADER_FILE_PATH);
        } catch (CensusAnalyserException censusAnalyserException) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, censusAnalyserException.type);
        }
    }

    @Test
    public void givenIndianCodeCSVFileReturnsCorrectRecords() {
        try {
            int numOfRecords = censusAnalyser.loadIndiaCodeData(INDIA_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37, numOfRecords);
        } catch (CensusAnalyserException CensusAnalyserException) {
        }
    }

    @Test
    public void givenIndiaCodeData_WithWrongFile_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCodeData(CODE_WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException censusAnalyserException) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,
                    censusAnalyserException.type);
        }
    }

    @Test
    public void givenIndiaCodeData_WithWrongTypeFile_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCodeData(CODE_WRONG_FILE_TYPE_PATH);
        } catch (CensusAnalyserException censusAnalyserException) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, censusAnalyserException.type);
        }
    }

    @Test
    public void givenIndiaCodeData_WithWrongDelimeter_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCodeData(CODE_WRONG_DELIMITER_FILE_PATH);
        } catch (CensusAnalyserException censusAnalyserException) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, censusAnalyserException.type);
        }
    }

    @Test
    public void givenIndiaCodeData_WithoutHeader_ShouldThrowException1() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCodeData(CODE_WITHOUT_HEADER_FILE_PATH);
        } catch (CensusAnalyserException censusAnalyserException) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, censusAnalyserException.type);
        }
    }

    @Test
    public void givenIndianCensusData_WhenSortedOnState_ShouldReturnSortedResult() {
        String sortedCensusData = null;
        try {
            sortedCensusData = censusAnalyser.getStateWiseSortedCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            IndiaCensusCSV[] censusCSV = new Gson().fromJson(sortedCensusData, IndiaCensusCSV[].class);
            Assert.assertEquals("Andhra Pradesh", censusCSV[0].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCensusData_WhenSortedOnStateCode_ShouldReturnSortedResult() {
        String sortedCensusData = null;
        sortedCensusData = censusAnalyser.getStateCodeWiseSortedData(INDIA_CODE_CSV_FILE_PATH);
        System.out.println(sortedCensusData);
        IndiaCodeCSV[] censusCSV = new Gson().fromJson(sortedCensusData, IndiaCodeCSV[].class);
        Assert.assertNotEquals("AD", censusCSV[0].stateCode);

    }
}
