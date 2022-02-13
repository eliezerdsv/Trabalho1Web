package dw.Mensalistas.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





import dw.Mensalistas.model.Jogador;
import dw.Mensalistas.repository.Jogadorrepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

//Importação de Bibliotecas e Pacotes
@RestController
@RequestMapping("/api")
public class JogadorController {
    @Autowired
    Jogadorrepository rep;

    @GetMapping("/jogadores")
    public ResponseEntity<List<Jogador>> getAllJogadores(@RequestParam(required = false) String nome){  //Coloca todos os jogadores em um vetor
        try {
            List<Jogador> lj = new ArrayList<Jogador>();    //Cria um vetor que irá conter os jogadores
            if(nome == null){   //Se o nome do jogador for nulo
                rep.findAll().forEach(lj::add); 
            }else rep.findByNomeContaining(nome).forEach(lj::add);

            if(lj.isEmpty()){       //Se o objeto não tiver conteúdo
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);    //Retorna uma entidade de resposta que informa que o objeto não tem conteúdo
            }
            return new ResponseEntit
y<>(lj,HttpStatus.OK);      //Retorna uma entidade de resposta que informa que a ação foi realizada com sucesso
            
        } catch (Exception e) {    //Tenta pegar uma exceção
            
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);     //Se houver exceção é provavelmente devido a uma falha de conexão com o banco
        }
    }


    //POST: /api/jogadores
    @PostMapping("/jogadores")
    public ResponseEntity<Jogador> createJogador(@RequestBody Jogador j){   //Cria um novo jogador
        
        try {
            Jogador _j = rep.save(new Jogador(j.getNome(),j.getEmail(),j.getDatanasc()));   //Cria um novo jogador com nome, email e data de nascimento
            return new ResponseEntity<>(_j,HttpStatus.CREATED);     //Retorna uma entidade de resposta que informa que o jogador foi criado
        } catch (Exception e) { //Tenta pegar a exceção
            
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);     //Se houver exceção é provavelmente devido a uma falha de conexão com o banco
        }
    }

    @GetMapping("/jogadores/{cod_jogador}")
    public ResponseEntity<Jogador> getJogadorById(@PathVariable("cod_jogador") int cod_jogador)     //Retorna um jogador através do ID
    {   
        
        Optional<Jogador> data = rep.findById(cod_jogador);     //Cria uma variável data para verificar se o objeto tem conteúdo
        if (data.isPresent()) {     //Se o objeto com o ID informado tiver conteúdo
            return new ResponseEntity<>(data.get(),HttpStatus.OK);      //Retorna os dados do jogador
        } else {    //Se o objeto não tiver conteúdo
            return new ResponseEntity<>(data.get(),HttpStatus.NOT_FOUND);  //Retorna uma Entidade de Resposta informando que o objeto não tem conteúdo
        }
    }

    
    @PutMapping("/jogadores/{cod_jogador}")
    public ResponseEntity<Jogador> updateJogador(@PathVariable("cod_jogador") int cod_jogador, @RequestBody Jogador j)    //Atualiza os atributos do jogador
    {
        Optional<Jogador> data = rep.findById(cod_jogador);     //Cria uma variável para verificar se o objeto tem conteúdo

        if (data.isPresent())   //Se o objeto tiver conteúdo
        {
            Jogador jr = data.get();    
            jr.setNome(j.getNome());        //Atualiza o nome
            jr.setEmail(j.getEmail());      //Atualiza o E-mail
            jr.setDatanasc(j.getDatanasc());//Atualiza a Data de Nascimento
            

            return new ResponseEntity<>(rep.save(jr), HttpStatus.OK);   //Retorna uma entidade de resposta informando que o objeto foi atualizado   

        }
        else    //Se o objeto não tiver o conteúdo
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  //Retorna uma entidade de resposta informando que o objeto deletado não tem conteúdo   

    }

     /*
    * DEL /api/artigos/:id : remover artigo dado um id
    */
    @DeleteMapping("/jogadores/{id}")
    public ResponseEntity<HttpStatus> deleteJogador(@PathVariable("id") int id)     //Deleta um jogador através do ID
    {
        try {
            rep.deleteById(id);     //Deleta o objeto de jogador com id informado
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);     //Retorna uma entidade de resposta informando que o objeto deletado não tem conteúdo   
            
        } catch (Exception e) {     //Tenta pegar uma exceção
            
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);      //Se houver exceção é provavelmente devido a uma falha de conexão com o banco
        }
        
    }

    
    @DeleteMapping("/jogadores")
    public ResponseEntity<HttpStatus> deleteAllJogador()      //Deleta todos os jogadores
    {
        try {
            rep.deleteAll();    //Deleta todos os jogadores
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  //Retorna uma mensagem de resposta informando que o objeto deletado não tem conteúdo   
            
        } catch (Exception e) {     //Tenta pegar uma exceção
            
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);   //Se houver exceção é provavelmente devido a uma falha de conexão com o banco
        }
        
    }
}
