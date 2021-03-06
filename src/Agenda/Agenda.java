package Agenda;

import people.Client;
import people.Persoon;
import people.Zorgpartner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class Agenda {

    private ArrayList<Afspraak> afspraken;

    public Agenda(){
        afspraken = new ArrayList<>();
    }

    public ArrayList<Afspraak> getAfspraken() {
        return afspraken;
    }

    private ArrayList<Afspraak> getCertainAfspraken(Function<Afspraak, Boolean> f) {
        ArrayList<Afspraak> nieuweAfspraken = new ArrayList<>();

        for(Afspraak afspraak : afspraken){
            if(f.apply(afspraak)){
                nieuweAfspraken.add(afspraak);
            }
        }

        return nieuweAfspraken;
    }
    public ArrayList<Afspraak> getAfspraken(int maand) {
        return getCertainAfspraken(e -> e.getDatum().getMaand() == maand);
    }

    public ArrayList<Afspraak> getAfspraken(Persoon persoon){
        return getCertainAfspraken(e -> e.getClient() == persoon || e.getZorgpartner() == persoon);
    }

    private void sorteerAfspraken(){
        Collections.sort(afspraken);
    }

    public void nieuweAfspraak(String datum, Client client, Zorgpartner zorgpartner){
        nieuweAfspraak(new Afspraak(client, zorgpartner, datum));
    }

    public void nieuweAfspraak(Afspraak afspraak){
        this.afspraken.add(afspraak);
        sorteerAfspraken();
    }

}

