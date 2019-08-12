package br.com.clebersantos.anbima.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Create by Cleber Santos on 11/08/2019
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class SelicAcumuladoResponse {
    private String ano;
    private String acumulado;
}
