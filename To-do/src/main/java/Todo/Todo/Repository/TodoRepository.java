package Todo.Todo.Repository;

import Todo.Todo.Model.TodoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoDAO, Integer> {
}
