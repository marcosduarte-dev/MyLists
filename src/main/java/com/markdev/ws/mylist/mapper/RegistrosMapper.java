package com.markdev.ws.mylist.mapper;

import com.markdev.ws.mylist.dto.RegistrosDTO;
import com.markdev.ws.mylist.model.*;

public class RegistrosMapper {

    public static Registros fromDtoToEntity(RegistrosDTO dto,
                                            Listas lista,
                                            Tipos tipo,
                                            ApiConsumida apiConsumida,
                                            Pais pais, Status status) {
        return Registros.builder()
                .id(dto.getId())
                .lista(lista)
                .poster(dto.getPoster())
                .nome(dto.getNome())
                .sinopse(dto.getSinopse())
                .tipo(tipo)
                .apiConsumida(apiConsumida)
                .pais(pais)
                .status(status)
                .temporadas(dto.getTemporadas())
                .totalEpisodios(dto.getTotalEpisodios())
                .episodiosAssistidos(dto.getEpisodiosAssistidos())
                .rating(dto.getRating())
                .comentarios(dto.getComentarios())
                .dataComeco(dto.getDataComeco())
                .dataFinal(dto.getDataFinal())
                .ativo(dto.getAtivo())
                .build();
    }

}
