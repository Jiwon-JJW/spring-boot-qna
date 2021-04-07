package com.codessquad.qna.service;

import com.codessquad.qna.domain.Question;
import com.codessquad.qna.domain.Result;
import com.codessquad.qna.domain.User;
import com.codessquad.qna.exception.NoQuestionException;
import com.codessquad.qna.repository.QuestionRepository;
import com.codessquad.qna.web.PageList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public void save(User sessionUser, String title, String contents) {
        Question question = new Question(sessionUser, title, contents);
        questionRepository.save(question);
    }

    @Transactional
    public Result delete(Long id, boolean isLogin, User sessionUser) {
        Question question = getQuestionById(id);
        Result result = valid(isLogin, sessionUser, question);
        if (!result.isValid()) {
            return result;
        }
        questionRepository.delete(question);
        return result;
    }

    @Transactional
    public Page<Question> questionListAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber-1, 15, Sort.Direction.DESC, "id");
        return questionRepository.findAll(pageable);
    }

    public PageList getPageList(Page page) {
        Pageable pageable = page.getPageable();
        return new PageList(page, pageable);
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(NoQuestionException::new);
    }

    @Transactional
    public void updateQuestion(Long id, String updateTitle, String updateContents) {
        Question question = getQuestionById(id);
        question.update(updateTitle, updateContents);
    }

    public Result valid(boolean isLoginUser, User sessionUser, Question question) {
        if (!isLoginUser) {
            return Result.fail("로그인을 먼저 진행해주세요.");
        }

        if (!question.isMatchingWriter(sessionUser)) {
            return Result.fail("수정할 수 있는 권한이 없습니다.");
        }

        return Result.ok();
    }

    public Result valid(boolean isLoginUser) {
        if (!isLoginUser) {
            return Result.fail("로그인을 먼저 진행해주세요.");
        }
        return Result.ok();
    }

}
