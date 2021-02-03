package com.example.service.impl;

import com.example.model.QuestionType;
import com.example.repository.QuestionTypeRepository;
import com.example.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeImpl implements QuestionTypeService {

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
