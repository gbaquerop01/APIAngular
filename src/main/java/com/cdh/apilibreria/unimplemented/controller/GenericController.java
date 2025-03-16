package com.cdh.apilibreria.unimplemented.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericController<T, K> {
    public ResponseEntity<List<T>> get();
    public ResponseEntity<T> post(T t);
    public ResponseEntity<T> put(T t);
    public ResponseEntity<T> delete(K id);
}
