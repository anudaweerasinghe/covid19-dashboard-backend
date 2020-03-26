package anuda.me.coronaback.responses;

public class SLData {

    private int confirmedCases;
    private int newCases;
    private int underObservation;
    private int recoveries;
    private int critical;
    private int deaths;
    private int newDeaths;
    private double casesPerMillion;
    private double deathsPerMillion;

    public int getConfirmedCases() {
        return confirmedCases;
    }

    public void setConfirmedCases(int confirmedCases) {
        this.confirmedCases = confirmedCases;
    }

    public int getNewCases() {
        return newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public int getUnderObservation() {
        return underObservation;
    }

    public void setUnderObservation(int underObservation) {
        this.underObservation = underObservation;
    }

    public int getRecoveries() {
        return recoveries;
    }

    public void setRecoveries(int recoveries) {
        this.recoveries = recoveries;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public double getCasesPerMillion() {
        return casesPerMillion;
    }

    public void setCasesPerMillion(double casesPerMillion) {
        this.casesPerMillion = casesPerMillion;
    }

    public double getDeathsPerMillion() {
        return deathsPerMillion;
    }

    public void setDeathsPerMillion(double deathsPerMillion) {
        this.deathsPerMillion = deathsPerMillion;
    }
}
