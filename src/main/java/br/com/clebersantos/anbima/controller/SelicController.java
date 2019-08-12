package br.com.clebersantos.anbima.controller;

import br.com.clebersantos.anbima.domain.request.SelicRequest;
import br.com.clebersantos.anbima.domain.response.SelicAcumuladoResponse;
import br.com.clebersantos.anbima.domain.response.SelicMediaResponse;
import br.com.clebersantos.anbima.domain.response.SelicResponse;
import br.com.clebersantos.anbima.exception.SelicException;
import br.com.clebersantos.anbima.service.SelicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by Cleber Santos on 07/08/2019
 */
@RestController
@RequestMapping("/selic")
public class SelicController {

    @Autowired
    private SelicService selicService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/estimativasSelic")
    public List<SelicResponse> estimativasSelic() throws SelicException {
        return selicService.estimativasSelic();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/consultaEstimativaSelic")
    public List<SelicResponse> consultaEstimativaSelic(@RequestBody SelicRequest selicRequest) throws SelicException {
        if (selicRequest.getAno() == null || StringUtils.isEmpty(selicRequest.getAno()))
            throw new SelicException("Ao menos o ano deve ser informado!");

        return selicService.buscaSelicPorAnoMes(selicRequest);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/consultaMediaSelic")
    public SelicMediaResponse consultaMediaSelic(@RequestBody SelicRequest selicRequest) {
        if (selicRequest.getAno() == null || StringUtils.isEmpty(selicRequest.getAno()))
            throw new SelicException("O ano deve ser informado!");
        return selicService.buscaMediaSelicPorAno(selicRequest);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/acumuladoAnual")
    public List<SelicAcumuladoResponse> acumuladoAnual() {
        return selicService.acumuladoAnual();
    }

}
