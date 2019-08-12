package br.com.clebersantos.anbima.domain;

import br.com.clebersantos.anbima.domain.response.SelicResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Create by Cleber Santos on 08/08/2019
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListSelic {
    private List<SelicResponse> selics;
}
