package com.codegym.service;

import com.codegym.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();

    void save(Position position);

    void update(Position position);

    void delete(Long id);

}
