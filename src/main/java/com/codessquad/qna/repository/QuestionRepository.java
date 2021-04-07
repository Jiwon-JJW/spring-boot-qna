package com.codessquad.qna.repository;

import com.codessquad.qna.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
    @Override
    Page<Question> findAll(Pageable pageable);
}
