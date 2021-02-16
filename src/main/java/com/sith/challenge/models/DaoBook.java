package com.sith.challenge.models;

import com.sith.challenge.models.entities.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoBook {

    public Book read(int id) {

        Database db = new Database();
        Connection con = db.getConnection();

        String sql = "SELECT * FROM BOOK WHERE ID = ?";
        try{
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, id);  //protection against sql injection
            ResultSet rs = query.executeQuery();
            Book aux = (rs.next())? getBookFromResultSet(rs) : null;
            rs.close();
            query.close();
            return aux;
        }catch(SQLException e){
            System.out.println("Error on read, DaoAuthor: " + e);
        }
        return null;
    }

    public List<Book> readAll(){

        Database db = new Database();
        Connection con = db.getConnection();

        String sql= "SELECT * FROM BOOK";
        try{
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            List<Book> list = new ArrayList<Book>();
            while(rs.next()){
                list.add(getBookFromResultSet(rs));
            }
            rs.close();
            query.close();
            return list;
        }catch(SQLException e){
            System.out.println("Error on readAll, DaoAuthor: " + e);
        }
        return null;
    }

    public Book getBookFromResultSet(ResultSet rs) {

        Book aux = new Book();
        try {
            aux.setId(rs.getInt("ID"));
            aux.setTitle(rs.getString("TITLE"));
            aux.setAuthor(rs.getString("AUTHOR"));
            aux.setEdition(rs.getString("EDITION"));
            return aux;
        }catch(SQLException e){
            System.out.println("Error on getBookFromResultSet, DaoBook: " + e);
        }
        return null;
    }
}