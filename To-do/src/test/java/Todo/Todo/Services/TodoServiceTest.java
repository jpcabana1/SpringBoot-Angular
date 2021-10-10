package Todo.Todo.Services;

import Todo.Todo.DTO.StatusDTO;
import Todo.Todo.Repository.TodoRepository;
import Todo.Todo.Service.Implementation.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import javax.persistence.PersistenceException;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @InjectMocks
    private TodoService service;

    @Mock
    private TodoRepository todoRepository;

    private static final String MESSAGE_OK = "Novo To-do adicionado!";
    private static final String MESSAGE_FAILS = "Erro: PersistenceException";
    private static final String DESC = "Ler";

    @Test
    public void create_when_CREATED() {
        Optional<StatusDTO> expected = fakeStatus(false);
        Optional<StatusDTO> response = service.create(DESC);

        assertEquals(expected, response);
    }

    @Test
    public void create_when_BAD_REQUEST() {
        String message = "PersistenceException";
        Optional<StatusDTO> expected = fakeStatus(true);
        PersistenceException exception = new PersistenceException(message);
        when(todoRepository.save(any())).thenThrow(exception);

        Optional<StatusDTO> response = service.create(DESC);

        assertEquals(expected, response);
    }

    @Test
    public void getAll() {
        assertDoesNotThrow(() -> service.getAll());
    }


    private Optional<StatusDTO> fakeStatus(Boolean fails) {
        return Optional.of(StatusDTO.builder()
                .code(fails ? HttpStatus.BAD_REQUEST.value() : HttpStatus.CREATED.value())
                .message(fails ? MESSAGE_FAILS : MESSAGE_OK)
                .build());
    }

}
