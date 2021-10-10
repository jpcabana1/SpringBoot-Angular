package Todo.Todo.Controllers;

import Todo.Todo.DTO.StatusDTO;
import Todo.Todo.Service.ITodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TodoControllerTest {

    @InjectMocks
    private TodoController todoController;

    @Mock
    private ITodoService todoService;

    @Test
    public void create_when_inserts() {
        Optional<StatusDTO> expected = fakeStatus();
        Mockito.when(todoService.create(any())).thenReturn(expected);

        StatusDTO returnDTO = todoController.create("Test").getBody();

        assertEquals(returnDTO, expected.get());
    }

    @Test
    public void get_when_OK() {
        assertDoesNotThrow(() -> todoController.get());
    }

    private Optional<StatusDTO> fakeStatus() {
        return Optional.of(StatusDTO.builder()
                .code(HttpStatus.CREATED.value())
                .message("Novo To-do adicionado!")
                .build());
    }
}
