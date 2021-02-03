package com.example.service;

import com.example.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {

    List<Question> findAll();

    Page<Question> findAll(Pageable pageable);

    Question findOne(Long id);

    void save(Question question);

    void delete(Long id);

    Page<Question> findByTitleContaining(Pageable pageable, String title);
}
