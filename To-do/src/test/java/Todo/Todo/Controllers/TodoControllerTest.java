package Todo.Todo.Controllers;

import Todo.Todo.Model.TodoDAO;
import Todo.Todo.Repository.TodoRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TodoControllerTest {

    @InjectMocks
    private TodoController todoController;

    @Mock
    private TodoRepository todoRepository;

    @DisplayName("Inserts Successful")
    @Test
    public void create_when_inserts() {

        Mockito.when(todoRepository.save(any())).thenReturn(Optional.of(fakeDao()));

        assertDoesNotThrow(() -> todoController.create("Test"));

    }


    private TodoDAO fakeDao() {
        return TodoDAO.builder()
                .id(1)
                .desc("Test")
                .build();
    }

}
