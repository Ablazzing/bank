package com.example.bank;

import lombok.SneakyThrows;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class MyController {

    @SneakyThrows
    @GetMapping("/bank")
    public Map<String, BigDecimal> getCurrency(@RequestParam BigDecimal money) {
       JAXBContext jaxbContext = JAXBContext.newInstance(Curs.class);
        Curs curs = (Curs) jaxbContext.createUnmarshaller()
                .unmarshal(new URL("https://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002"));
        HashMap<String, BigDecimal> result = new HashMap<>();

        curs.getValute().stream().forEach(e -> {result.put(e.getName(), money.divide(new BigDecimal(e.getValue().replaceAll(",", ".")), 2));});
        return result;
    }
}
