package com.brideglabz.Indianstatescensusanalyser;

public class IndiaCodeCSV {
    @CsvBindByName(column = "SrNo", required = true)
    public String srNo;

    @CsvBindByName(column = "State Name", required = true)
    public String stateName;

    @CsvBindByName(column = "TIN", required = true)
    public int tin;

    @CsvBindByName(column = "StateCode", required = true)
    public String stateCode;

    @Override
    public String toString() {
        return "IndiaCodeCSV [srNo=" + srNo + ", stateName=" + stateName + ", tin=" + tin + ", stateCode=" + stateCode
                + "]";
    }
}
