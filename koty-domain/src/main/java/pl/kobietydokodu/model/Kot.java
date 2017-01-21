package pl.kobietydokodu.model;

import java.util.Date;

/**
 * Created by Jarek on 2016-12-11.
 */
public class Kot {

    private String imie;
    private Date dataUrodzenia;
    private Float waga;
    private String imieOpiekuna;

    public String przedstawSie(){
        return "Jestem " + imie+
                ", urodzony:" + dataUrodzenia +
                ", ważę:" +  waga+
                ", opiekun: "+ imieOpiekuna +
                "\n";
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUr) {
        this.dataUrodzenia = dataUr;
    }

    public Float getWaga() {
        return waga;
    }

    public void setWaga(Float waga) {
        this.waga = waga;
    }

    public String getImieOpiekuna() {
        return imieOpiekuna;
    }

    public void setImieOpiekuna(String imieOpiekuna) {
        this.imieOpiekuna = imieOpiekuna;
    }
}
