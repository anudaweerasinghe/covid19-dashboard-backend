package anuda.me.coronaback.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dateText;
    private int localNewCases;
    private int localConfirmedCases;
    private int globalNewCases;
    private int globalConfirmedCases;

    public String getDateText() {
        return dateText;
    }

    public void setDateText(String dateText) {
        this.dateText = dateText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocalNewCases() {
        return localNewCases;
    }

    public void setLocalNewCases(int localNewCases) {
        this.localNewCases = localNewCases;
    }

    public int getLocalConfirmedCases() {
        return localConfirmedCases;
    }

    public void setLocalConfirmedCases(int localConfirmedCases) {
        this.localConfirmedCases = localConfirmedCases;
    }

    public int getGlobalNewCases() {
        return globalNewCases;
    }

    public void setGlobalNewCases(int globalNewCases) {
        this.globalNewCases = globalNewCases;
    }

    public int getGlobalConfirmedCases() {
        return globalConfirmedCases;
    }

    public void setGlobalConfirmedCases(int globalConfirmedCases) {
        this.globalConfirmedCases = globalConfirmedCases;
    }
}
