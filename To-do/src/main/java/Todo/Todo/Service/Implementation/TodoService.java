package Todo.Todo.Service.Implementation;

import Todo.Todo.DTO.StatusDTO;
import Todo.Todo.Model.TodoDAO;
import Todo.Todo.Repository.TodoRepository;
import Todo.Todo.Service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Optional<StatusDTO> create(String desc) {
        try {
            todoRepository.save(TodoDAO.builder()
                    .desc(desc)
                    .dtCreate(LocalDateTime.now(Clock.systemDefaultZone()))
                    .dtUpdate(LocalDateTime.now(Clock.systemDefaultZone()))
                    .build());
            return Optional.of(StatusDTO.builder()
                    .code(HttpStatus.CREATED.value())
                    .message("Novo To-do adicionado!")
                    .build());
        } catch (Exception e) {
            return Optional.of(StatusDTO.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(String.format("Erro: %s", e.getMessage()))
                    .build());
        }
    }

    @Override
    public Optional<List<TodoDAO>> getAll() {
        return Optional.of(todoRepository.findAll());
    }
}
