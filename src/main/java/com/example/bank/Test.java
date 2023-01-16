package com.example.bank;

import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import java.io.File;
import java.net.URL;

public class Test {

    @SneakyThrows
    public static void main(String[] args) {
        JAXBContext jaxbContext = JAXBContext.newInstance(Curs.class);
        Curs curs = (Curs) jaxbContext.createUnmarshaller()
                .unmarshal(new File("E:\\java_repos\\bank\\src\\main\\resources\\example.xml"));
        System.out.println(curs);
    }
}
