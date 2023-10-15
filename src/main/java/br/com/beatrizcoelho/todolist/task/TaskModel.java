package br.com.beatrizcoelho.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * 
 * ID
 * Usuário(ID_USUARIO)
 * Título
 * Data de inicio
 * Data de termino
 * Prioridade
 */
@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id //chave primaria
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String title;
    private LocalDateTime startAt; //consegue colocar data e horario
    private LocalDateTime endAt;
    private String priority;

    private UUID idUser;

    @CreationTimestamp //quando a tarefa for criada no banco de dados
    private LocalDateTime createdAt; //informar quando a tarefa foi criada

    public void setTitle(String title) throws Exception{
        if(title.length() > 50){
            throw new Exception("O campo title deve conter no máximo 50 caracteres");
        }
        this.title = title;

    }
}
