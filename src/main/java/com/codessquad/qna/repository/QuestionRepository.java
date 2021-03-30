package com.codessquad.qna.repository;

import com.codessquad.qna.domain.Question;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
    List<Question> findAllByDeletedIsFalse();
}
