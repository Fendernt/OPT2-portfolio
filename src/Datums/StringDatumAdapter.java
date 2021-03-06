package Datums;

import formats.IFormat;

import java.util.*;
public class StringDatumAdapter implements IDatum {
    private int dag;
    private int maand;
    private int jaar;

    public StringDatumAdapter(String datum){
        convertDatum( datum);
    }

    private void convertDatum(String datum){
        Scanner scanner = new Scanner(datum.replace("/", " "));
        this.dag = scanner.nextInt();
        this.maand = scanner.nextInt();

        if(scanner.hasNextInt()) {
            this.jaar = scanner.nextInt();
        } else{
            this.jaar = getCurrentJaar();
        }
        scanner.close();
    }

    public int getDag() {
        return dag;
    }

    public int getMaand() {
        return maand;

    }
    public int getJaar() {
        return jaar;
    }

    public String getString(IFormat format){
        return format.dateToString(getDag(), getMaand(), getJaar());
    }

    private int getCurrentJaar(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }


}
