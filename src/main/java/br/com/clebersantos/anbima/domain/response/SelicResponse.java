package br.com.clebersantos.anbima.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Create by Cleber Santos on 07/08/2019
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class SelicResponse {
    private String data_referencia;
    private double estimativa_taxa_selic;
}
