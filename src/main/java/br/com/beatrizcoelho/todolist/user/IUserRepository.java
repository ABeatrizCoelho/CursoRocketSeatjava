package br.com.beatrizcoelho.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<UserModel, UUID>{
    UserModel findByUsername(String username);
    
}
// quando a gente utiliza a palavra extends, a minha interface vai extender tudo que eu tenho dentro do JpaRepository