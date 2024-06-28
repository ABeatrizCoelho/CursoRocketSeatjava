package br.com.beatrizcoelho.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.beatrizcoelho.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component //toda classe que eu qro que o springer gerencie, preciso usar, é a classe mais generica de gerenciamento
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
       
                    var servletPath = request.getServletPath();

                    if(servletPath.startsWith("/tasks/")){   
                        
                        
                //Pegar a autenticação (usuario e senha)
                var authorization = request.getHeader("Authorization"); //semelhante a colocar dentro do auth as informacoes

                var authEncoded =  authorization.substring("Basic".length()).trim();


                byte[] authDecode = Base64.getDecoder().decode(authEncoded);

                var authString = new String(authDecode);



                String[] credentials = authString.split(":");
                String username = credentials[0];
                String passsword = credentials[1];

            
                //Validar usuario
                var user = this.userRepository.findByUsername(username);
                if(user == null){
                    response.sendError(401);
                }else{
                   //Validar senha
                var passwordVerify = BCrypt.verifyer().verify(passsword.toCharArray(), user.getPassword());
                if(passwordVerify.verified){
                     //Segue viagem
                    request.setAttribute("idUser", user.getId()); //ele recebe um nome e o valor
                    filterChain.doFilter(request, response);
                }else{
                    response.sendError(401);
                }

               

                }


            } else{
                filterChain.doFilter(request, response);
            }
                        
         }

    }
    

