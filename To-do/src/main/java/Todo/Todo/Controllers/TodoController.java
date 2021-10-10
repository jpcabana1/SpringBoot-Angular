package Todo.Todo.Controllers;

import Todo.Todo.DTO.StatusDTO;
import Todo.Todo.Model.TodoDAO;
import Todo.Todo.Service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @CrossOrigin()
    @PostMapping(value = "/newTodo")
    public ResponseEntity<StatusDTO> create(@Validated @RequestHeader("desc") String desc) {
        return ResponseEntity.of(todoService.create(desc));
    }

    @CrossOrigin()
    @GetMapping(value = "/getTodos")
    public ResponseEntity<List<TodoDAO>> get() {
        return ResponseEntity.of(todoService.getAll());
    }

}
