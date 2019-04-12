package com.AlliedTesting;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("ValCurs")
public class ValCurs {


    @XStreamAlias("Date")
    @XStreamAsAttribute
    private String date;

    @XStreamAlias("name")
    @XStreamAsAttribute
    private String name;

    @XStreamImplicit
    private List<Valute> valutes;

    public ValCurs(String date, String name, List<Valute> valutes) {
        this.date = date;
        this.name = name;
        this.valutes = valutes;
    }

    @Override
    public String toString() {
        return "ValCurs{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", valutes=" + valutes +
                '}';
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public  List<Valute> getValutes() {
        return valutes;
    }

    public int getNumberOfValutes(){
       return this.valutes.size();
    }
}
