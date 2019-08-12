package br.com.clebersantos.anbima.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Create by Cleber Santos on 07/08/2019
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelicRequest {
    private String ano;
    private String mes;
}
