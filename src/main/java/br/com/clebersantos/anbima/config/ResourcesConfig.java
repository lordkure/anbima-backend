package br.com.clebersantos.anbima.config;

import br.com.clebersantos.anbima.domain.response.SelicResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Create by Cleber Santos on 08/08/2019
 */
@Configuration
public class ResourcesConfig {

    @Value("classpath:arquivo_base/ESTIMATIVA_SELIC[1505].JSON")
    private Resource resourceFile;

    @Bean(name = "baseExample")
    public List<SelicResponse> getBaseExample() {
        try {
            String data = readFromInputStream(resourceFile.getInputStream());
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(data, new TypeToken<List<SelicResponse>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

}
