package com.example.bank;

import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlType
@ToString
public class Currency {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    @XmlElement(name = "Value")
    public void setValue(String value) {
        this.value = value;
    }
}
