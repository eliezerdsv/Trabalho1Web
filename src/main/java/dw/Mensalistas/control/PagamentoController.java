package dw.Mensalistas.control;


import dw.Mensalistas.model.Jogador;
import dw.Mensalistas.model.Pagamento;
import dw.Mensalistas.repository.Jogadorrepository;
import dw.Mensalistas.repository.Pagamentorepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Importação de Pacotes e Bibliotecas

@RestController
@RequestMapping("/api")
public class PagamentoController {   
  @Autowired
  Pagamentorepository prep;
  @Autowired
  Jogadorrepository jrep;

  
  @GetMapping("/pagamentos")
  public ResponseEntity<List<Pagamento>> getAllPagamentos(    //Pegar todos os pagamentos através do ID de um jogador
      @RequestParam(required = false) String id) {

    try {
      List<Pagamento> listPag = new ArrayList<Pagamento>();   //Cria um vetor que terá todos os pagamentos

<<<<<<< HEAD
      if (id == null) {   //Se não houver ID
        pagRep.findAll().forEach(listPag::add);
      } else {
          int id2 = Integer.parseInt(id);
		 
		listPag.add(pagRep.findById(id2).get());
      }

      if (listPag.isEmpty()) {    //Se não houverem pagamentos
        return new ResponseEntity<>(HttpStatus.OK);   //É retornada uma entidade de resposta que mostra que o objeto não tem conteúdo
      }

      return new ResponseEntity<>(listPag, HttpStatus.ACCEPTED);    //Retorna o pagamento

    } catch (Exception e) {     //Tenta pegar uma exceção
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);     //Se for pega uma exceção é porque provavelmente ocorreu um erro de comunicação com o banco
=======
      if (id == null) {
        prep.findAll().forEach(listPag::add);
      } else {
          int id2 = Integer.parseInt(id);
		  //findById retorna somente um objeto. forEach nao é aplicado.
		listPag.add(prep.findById(id2).get());//.forEach(listPag::add);
      }

      if (listPag.isEmpty()) {    //Se o objeto não possuir conteúdo
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);   //É retornada uma entidade de resposta que mostra que o objeto não tem conteúdo
      }

      return new ResponseEntity<>(listPag, HttpStatus.ACCEPTED);  //Retorna o pagamento

    } catch (Exception e) {   //Tenta pegar uma exceção
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  //Se for pega uma exceção é porque provavelmente ocorreu um erro de comunicação com o banco
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    }
  }

  
  @PostMapping("/pagamentos")
<<<<<<< HEAD
  public ResponseEntity<Pagamento> createPagamento(@RequestBody Pagamento pagamento) {    //Cria um novo pagamento
    
    try {
      Pagamento _pagamento = pagRep.save(new Pagamento(pagamento.getCod_pagamento(), pagamento.getAno(),
          pagamento.getMes(), pagamento.getValor()));  //Cria um novo pagamento com o ID, ano, mês e valor

      return new ResponseEntity<>(_pagamento, HttpStatus.CREATED);    //Se não houver exceção é retornada uma entidade de resposta com a informação de que o pagamento foi criado
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);    //Se for pega uma exceção é porque provavelmente ocorreu um erro de comunicação com o banco
    }
  }
 
  @PostMapping("/pagamentosid/{id}")
  public ResponseEntity<Pagamento> createPagamento2(@PathVariable("id") int id, @RequestBody Pagamento pagamento) {    //Cria um novo pagamento através da ID de um jogador
    Optional<Jogador> data = jRep.findById(id);   //Cria uma variável data com os dados do jogador cujo ID foi informado
    try {
      Pagamento _pagamento = pagRep.save(new Pagamento(pagamento.getCod_pagamento(), pagamento.getAno(),  
          pagamento.getMes(), pagamento.getValor(), data.get()));   //Cria um novo pagamento com Id, ano, mês e valor
=======
  public ResponseEntity<Pagamento> createPagamento(@RequestBody Pagamento pagamento) {   //Cria um novo pagamento
    
    try {
      Pagamento _pagamento = prep.save(new Pagamento(pagamento.getCod_pagamento(), pagamento.getAno(),   
          pagamento.getMes(), pagamento.getValor()));      //Cria um novo pagamento com o ID, ano, mês e valor

      return new ResponseEntity<>(_pagamento, HttpStatus.CREATED);    //Se não houver exceção é retornada uma entidade de resposta com a informação de que o pagamento foi criado
    } catch (Exception e) {     //Tenta pegar a exceção
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);    //Se for pega uma exceção é porque provavelmente ocorreu um erro de comunicação com o banco
    }
  }
  
  @PostMapping("/pagamentosd/{id}")
  public ResponseEntity<Pagamento> createPagamento2(@PathVariable("id") int id, @RequestBody Pagamento pagamento) {
    Optional<Jogador> data = jrep.findById(id);
    try {
      Pagamento _pagamento = prep.save(new Pagamento(pagamento.getCod_pagamento(), pagamento.getAno(),
          pagamento.getMes(), pagamento.getValor(), data.get()));
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a

      return new ResponseEntity<>(_pagamento, HttpStatus.CREATED);  //Se não houver exceção, retorna uma entidade de resposta
    } catch (Exception e) {     //Tenta pegar uma exceção
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);    //Se for pega uma exceção é porque provavelmente ocorreu um erro de comunicação com o banco
    }
  }

  
<<<<<<< HEAD
  @PutMapping("/pagamentos/{cod_pagamento}")
  public ResponseEntity<Pagamento> updatePagamento(@PathVariable("cod_pagamento") int cod_pagamento, @RequestBody Pagamento pagamento) {
   
    Optional<Pagamento> data = pagRep.findById(cod_pagamento);     //Cria uma variável data que irá receber os dados de do pagamento com o ID fornecido
=======
  @PostMapping("/pagamentos/{id}")
  public ResponseEntity<Pagamento> updatePagamento(@PathVariable("id") int id, @RequestBody Pagamento pagamento) {
   
    Optional<Pagamento> data = prep.findById(id);
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a

    if (data.isPresent())   //Se houver conteúdo nesse ID
    {
      Pagamento pag = data.get();   //Cria uma variável do tipo Pagamento que irá receber os dados de data
      pag.setMes(pagamento.getMes());   //Atualiza o Mês
      pag.setAno(pagamento.getAno());    //Atualiza o Ano
      pag.setValor(pagamento.getValor()); //Atualiza o Valor
      

<<<<<<< HEAD
      return new ResponseEntity<>(pagRep.save(pag), HttpStatus.OK);   //Retorna uma entidade de resposta informando que a ação foi realizada com sucesso
=======
      return new ResponseEntity<>(prep.save(pag), HttpStatus.NOT_FOUND);
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    }
    else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);    //Retorna uma entidade de resposta informando que não foram encontrados dados
    }
  }

  
  @DeleteMapping("/pagamentos/{cod_pagamento}")
  public ResponseEntity<HttpStatus> deletePagamento(@PathVariable("cod_pagamento") int cod_pagamento) {   //Deleta o pagamento através de um ID
    try {
<<<<<<< HEAD
      pagRep.deleteById(cod_pagamento);     //Deleta o pagamento através do ID fornecido 
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);   //Retorna uma entidade de resposta mostrando que o objeto que teve o pagamento deletado não tem mais este conteúdo
=======
      prep.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    }
    catch (Exception e) {     //Tenta pegar uma exceção
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);    //Se houver excessão, provavelmente será devido a uma falha de comunicação com o banco
    }
  }

  
  @DeleteMapping("/pagamentos")
  public ResponseEntity<HttpStatus> deleteAllPagamento() {    //Irá deletar todos os pagamentos
    try {
<<<<<<< HEAD
      pagRep.deleteAll();   //Deleta todos os pagamentos
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);    //Retorna uma entidade de resposta mostrando que o objeto que teve o pagamento deletado não tem mais este conteúdo
=======
      prep.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
>>>>>>> 794015f14949e6821590bda2b5f2e8e00a098b6a
    }
    catch (Exception e) {   //Tenta pegar uma exceção
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);    //Se houver excessão, provavelmente será devido a uma falha de comunicação com o banco
    }
  }
}