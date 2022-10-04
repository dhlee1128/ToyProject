package com.project.scheduler.service;

import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.project.scheduler.dao.TodoMapper;
import com.project.scheduler.dto.TodoDto;

@DisplayName("TODO 리스트")
public class TodoServiceTest {

    @InjectMocks private TodoService todoService;

    @Mock private TodoMapper todoMapper;

    // @DisplayName("Todo 생성")
    // @Test
    // void given_when_then() {
    //     TodoDto dto = new TodoDto();

    // }

    @DisplayName("Todo 리스트를 조회하면 Todo리스트가 나타난다.")
    @Test
    void given_when_then2() {
        // // given
        // given(todoMapper.getAllTodoList()).willReturn(new TodoDto());

        // // when
        // TodoDto todoList = todoService.getAllTodoList();

        // then

    }

    @DisplayName("Todo 수정")
    @Test
    void given_when_then3() {

    }

    @DisplayName("Todo 삭제")
    @Test
    void given_when_then4() {

    }
    

}
