package dw.Mensalistas.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;





import dw.Mensalistas.model.Jogador;
import dw.Mensalistas.repository.JogadorRepository;

import java.util.List;
//import java.util.Optional;
import java.util.ArrayList;
@RestController
@RequestMapping("/api")
public class JogadorController {
    @Autowired
    JogadorRepository rep;
    //get: /api/jogadores
    @GetMapping("/jogadores")
    public ResponseEntity<List<Jogador>> getAllJogadores(@RequestParam(required = false) String nome){
        try {
            List<Jogador> lj = new ArrayList<Jogador>();
            if(nome == null){
                rep.findAll().forEach(lj::add); 
            }else rep.findByNomeContaining(nome).forEach(lj::add);

            if(lj.isEmpty()){
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lj,HttpStatus.OK);

            
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //POST: /api/jogadores
    @PostMapping("/jogadores")
    public ResponseEntity<Jogador> createJogador(@RequestBody Jogador j){
        
        try {
            Jogador _j = rep.save(new Jogador(j.getNome(),j.getEmail(),j.getDatanasc()));
            return new ResponseEntity<>(_j,HttpStatus.CREATED);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /* @GetMapping("/jogadores/{cod_jogador}")
    public ResponseEntity<Jogador> getJogadorById(@PathVariable("cod_jogador") long cod_jogador)
    {   
        
        Optional<Jogador> data = rep.findById(cod_jogador);
        if (data.isPresent()) {
            return new ResponseEntity<>(data.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(data.get(),HttpStatus.NOT_FOUND);
        }
    } */

     /*
    * PUT /api/jogadores/:id : atualizar artigo dado um id
    */
    /* @PutMapping("/jogadores/{id}")
    public ResponseEntity<Jogador> updateJogador(@PathVariable("id") long id, @RequestBody Jogador j)
    {
        Optional<Jogador> data = rep.findById(id);

        if (data.isPresent())
        {
            Jogador jr = data.get();
            jr.setNome(j.getNome());
            jr.setEmail(j.getEmail());
            jr.setDatanasc(j.getDatanasc());
            

            return new ResponseEntity<>(rep.save(jr), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    } */

     /*
    * DEL /api/artigos/:id : remover artigo dado um id
    */
/*     @DeleteMapping("/jogadores/{id}")
    public ResponseEntity<HttpStatus> deleteJogador(@PathVariable("id") long id)
    {
        try {
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
 */
     /*
    * DEL /api/artigos : remover todos os artigos
    */
    @DeleteMapping("/jogadores")
    public ResponseEntity<HttpStatus> deleteAllJogador()
    {
        try {
            rep.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
