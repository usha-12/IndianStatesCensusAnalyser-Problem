package com.brideglabz.Indianstatescensusanalyser;

public class IndiaCensusCSV {
    public String state;

    public int population;

    public int areaInSqKm;

    public int densityPerSqKm;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" + "State='" + state + '\'' + ", Population='" + population + '\'' + ", AreaInSqKm='"
                + areaInSqKm + '\'' + ", DensityPerSqKm='" + densityPerSqKm + '\'' + '}';
    }
}
