package Todo.Todo.Controllers;

import Todo.Todo.DTO.StatusDTO;
import Todo.Todo.Model.TodoDAO;
import Todo.Todo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping(value = "/newTodo")
    public ResponseEntity<StatusDTO> create(@RequestHeader("desc") String desc) {
        try {
            todoRepository.save(TodoDAO.builder()
                    .desc(desc)
                    .build());
            return ResponseEntity.ok(StatusDTO.builder()
                    .code(HttpStatus.CREATED.value())
                    .message("Novo Todo adicionado!")
                    .build());
        } catch (Exception e) {
            return ResponseEntity.ok(StatusDTO.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(String.format("Erro: %s", e.getMessage()))
                    .build());
        }
    }

    @GetMapping(value = "/getTodos")
    public ResponseEntity<List<TodoDAO>> get(){
        return ResponseEntity.ok(todoRepository.findAll());
    }

}
