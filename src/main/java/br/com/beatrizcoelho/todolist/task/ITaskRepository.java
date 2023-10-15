package br.com.beatrizcoelho.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
//entidade e id
import java.util.List;

public interface ITaskRepository extends JpaRepository <TaskModel, UUID> {
    List<TaskModel> findByIdUser(UUID idUser); //ele vai fazer uma lista de taskModel baseado nesse meu usuario, o que nao for, ele n retorna
    // TaskModel findByIdAndByIdUser(UUID id, UUID idUser);
}
