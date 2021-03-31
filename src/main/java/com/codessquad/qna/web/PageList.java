package com.codessquad.qna.web;

import com.codessquad.qna.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageList {
    private final int COUNT_NUMBERS_TO_SHOW = 5;
    private final int PAGE_INDEX_TO_SHOW = 1;
    private int previous;
    private int next;
    private Page<Question> questions;
    private Pageable pageable;
    private List<Integer> pageNumbers;


    public PageList(Page<Question> questions, Pageable pageable) {
        this.questions = questions;
        this.pageable = pageable;

    }

    public int getPrevious() {
        return pageable.previousOrFirst().getPageNumber() + PAGE_INDEX_TO_SHOW;
    }

    public int getNext() {
        return pageable.next().getPageNumber() + PAGE_INDEX_TO_SHOW;
    }

    public Page<Question> getQuestions() {
        return questions;
    }

    public List<Integer> getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(List<Integer> pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public boolean hasNext() {
        return questions.hasNext();
    }

    public boolean hasPrev() {
        return questions.hasPrevious();
    }

}
