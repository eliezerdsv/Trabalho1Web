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

  // DEL /api/pagamentos -> listar todos os pagamentos ou um pagamento dado um código de jogador
  @GetMapping("/pagamentos")
  public ResponseEntity<List<Pagamento>> getAllPagamentos(
      @RequestParam(required = false) String id) {

    try {
      List<Pagamento> listPag = new ArrayList<Pagamento>();   //Cria um vetor que terá todos os pagamentos

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
    }
  }

  // POST /api/pagamentos -> criar pagamento
  @PostMapping("/pagamentos")
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

      return new ResponseEntity<>(_pagamento, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  
  @PostMapping("/pagamentos/{id}")
  public ResponseEntity<Pagamento> updatePagamento(@PathVariable("id") int id, @RequestBody Pagamento pagamento) {
   
    Optional<Pagamento> data = prep.findById(id);

    if (data.isPresent()) {
      Pagamento pag = data.get();
      pag.setMes(pagamento.getMes());
      pag.setAno(pagamento.getMes());
      pag.setValor(pagamento.getValor());
      pag.setCod_pagamento(pagamento.getCod_pagamento());

      return new ResponseEntity<>(prep.save(pag), HttpStatus.NOT_FOUND);
    }
    else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // DEL /api/pagamentos/:cod_pagamento -> remover pagamento dado id
  @DeleteMapping("/pagamentos/{id}")
  public ResponseEntity<HttpStatus> deletePagamento(@PathVariable("cod_pagamento") int id) {
    try {
      prep.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // DEL /api/pagamentos -> remover todos os pagamentos
  @DeleteMapping("/pagamentos")
  public ResponseEntity<HttpStatus> deleteAllPagamento() {
    try {
      prep.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}