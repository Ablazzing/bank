package com.example.bank;

import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlType()
@ToString
public class Curs {
    private List<Currency> valute;

    public Curs() {
    }

    public List<Currency> getValute() {
        return valute;
    }

    @XmlElement(name = "Valute")
    public void setValute(List<Currency> valute) {
        this.valute = valute;
    }
}
