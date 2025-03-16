package com.cdh.apilibreria.model.mappers;

public interface Mapper<E, D> {
    public E mapToEntity(D dto);
}
