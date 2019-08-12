package br.com.clebersantos.anbima.service;

import br.com.clebersantos.anbima.domain.request.SelicRequest;
import br.com.clebersantos.anbima.domain.response.SelicAcumuladoResponse;
import br.com.clebersantos.anbima.domain.response.SelicMediaResponse;
import br.com.clebersantos.anbima.domain.response.SelicResponse;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create by Cleber Santos on 08/08/2019
 */
@Service
public class SelicService {

    @Autowired
    private List<SelicResponse> baseExample;

    public List<SelicResponse> estimativasSelic() {
        return baseExample;
    }

    public List<SelicResponse> buscaSelicPorAnoMes(SelicRequest selicRequest) {
        if (selicRequest.getMes() != null && !StringUtils.isEmpty(selicRequest.getMes())) {
            return baseExample.stream().filter(selic ->
                    (LocalDate.parse(selic.getData_referencia()).getMonth().getValue() == Integer.parseInt(selicRequest.getMes())))
                    .filter(selic -> (LocalDate.parse(selic.getData_referencia()).getYear() == Integer.parseInt(selicRequest.getAno())))
                    .collect(Collectors.toList());
        } else {
            return baseExample.stream().filter(selic ->
                    (LocalDate.parse(selic.getData_referencia()).getYear() == Integer.parseInt(selicRequest.getAno())))
                    .collect(Collectors.toList());
        }
    }

    public SelicMediaResponse buscaMediaSelicPorAno(SelicRequest selicRequest) {
        double media = baseExample.stream().filter(selic -> (LocalDate.parse(selic.getData_referencia()).getYear() == Integer.parseInt(selicRequest.getAno())))
                .map(selicResponse -> selicResponse.getEstimativa_taxa_selic())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
        return new SelicMediaResponse(selicRequest.getAno(), Precision.round(media, 2));
    }

    public List<SelicAcumuladoResponse> acumuladoAnual() {
        List<SelicAcumuladoResponse> listReturn = new ArrayList<>();
        Map<String, Double> map = new HashMap<>();
        baseExample.forEach(selic -> {
            if(map.containsKey(selic.getData_referencia())){
                map.put(selic.getData_referencia(), map.get(selic.getData_referencia())+selic.getEstimativa_taxa_selic());
            }else{
                map.put(selic.getData_referencia(), selic.getEstimativa_taxa_selic());
            }
        });
        map.forEach((key, value) -> {
            listReturn.add(new SelicAcumuladoResponse(key, Double.toString(Precision.round(value, 2))));
        });
        return listReturn;
    }

}
