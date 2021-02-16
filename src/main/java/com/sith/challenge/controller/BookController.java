package com.sith.challenge.controller;

import com.sith.challenge.models.DaoBook;
import com.sith.challenge.models.entities.Book;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/sithChallenge")
public class BookController {
    private Book aux = new Book();

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks(){   //method which gets and returns a list with all the books on database
        DaoBook db = new DaoBook();
        return db.readAll();
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooksFromAuthor(@RequestParam int author_id){
        System.out.println("Author ID: " + author_id);
        DaoBook db = new DaoBook();
        return db.readAll();
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book findById(@PathVariable int id) {
        DaoBook db = new DaoBook();
        return db.read(id);
    }


    @PostMapping(value = "/books")
    public boolean insert(@RequestBody Book obj) {
        DaoBook db = new DaoBook();
        return db.insert(obj);
    }

//    @RequestMapping(value = "/books", method = RequestMethod.PUT)
//    public boolean update (@RequestBody Book aux) {   //method which update some books's information on database
//        DaoBook db = new DaoBook();
//        if (aux.getId() != 0) {
//            if (db.read(aux.getId()) != null) {
//                return db.update(aux);
//            }
//        }
//        return false;
//    }
//
//    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
//    public boolean delete(@PathVariable int id) {   //method which delete an books from database
//        DaoBook db = new DaoBook();
//        if (id != 0) {
//            if (db.read(id) != null) {
//                return db.delete(id);
//            }
//        }
//        return false;
//    }
}
