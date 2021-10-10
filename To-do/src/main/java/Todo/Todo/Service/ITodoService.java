package Todo.Todo.Service;

import Todo.Todo.DTO.StatusDTO;
import Todo.Todo.Model.TodoDAO;

import java.util.List;
import java.util.Optional;

public interface ITodoService {

    Optional<StatusDTO> create (String desc);
    Optional<List<TodoDAO>> getAll();

}
