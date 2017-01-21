package pl.kobietydokodu.DAO;

import pl.kobietydokodu.model.Kot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jarek on 2016-12-19.
 */
public class KotDAO {
    List<Kot> koty= new LinkedList<Kot>();
    Map<Integer,Kot> kociaMapa = new HashMap<Integer,Kot>();


	

    public int wielkoscMapy(){
            return kociaMapa.size();
    }

    public void dodajKotaDoMapy(Integer index,Kot kot){
        kociaMapa.put(index,kot);
    }

    public Kot wezKota(Integer index){
        return kociaMapa.get(index);
    }

    public Map pokazWszystkieKoty(){
        return kociaMapa;
    }

    public void dodajKota(Kot kot){
        koty.add(kot);
    }

    public List<Kot> getKoty() { return koty; }
}
