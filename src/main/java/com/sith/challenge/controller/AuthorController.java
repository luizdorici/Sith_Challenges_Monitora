package com.sith.challenge.controller;

import com.sith.challenge.models.entities.Author;
import com.sith.challenge.models.DaoAuthor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sithChallenge")
public class AuthorController {
    private Author aux = new Author();

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> getAuthors(){   //method which gets and returns a list with all the authors on database
        DaoAuthor db = new DaoAuthor();
        return db.readAll();
    }

    // Challenge 3
    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public Author findById(@PathVariable int id) {
        DaoAuthor db = new DaoAuthor();
        return db.read(id);
    }

    //Challenge 3
    @PostMapping(value = "/authors")
    public boolean insert(@RequestBody Author obj) {
        DaoAuthor db = new DaoAuthor();
        return db.insert(obj);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.PUT)
    public boolean update (@RequestBody Author aux) {   //method which update some author's information on database
        DaoAuthor db = new DaoAuthor();
        if (aux.getId() != 0) {
            if (db.read(aux.getId()) != null) {
                return db.update(aux);
            }
        }
        return false;
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id) {   //method which delete an author from database
        DaoAuthor db = new DaoAuthor();
        if (id != 0) {
            if (db.read(id) != null) {
                return db.delete(id);
            }
        }
        return false;
    }
}
