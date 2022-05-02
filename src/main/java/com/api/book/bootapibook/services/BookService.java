package com.api.book.bootapibook.services;

import java.util.List; 

import com.api.book.bootapibook.dao.BookRepository;
import com.api.book.bootapibook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService 
{                                                                  
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list=new ArrayList<>();

    // static
    // {
    //     list.add(new Book(2,"Python","XYZ"));
    //     list.add(new Book(3,"C++","MNO"));
    //     list.add(new Book(4,"JS","QRS"));
    // }

    public List<Book> getAllBooks()
    {
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id)
    {
        Book book=null;
        try{
            book=this.bookRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b)
    {
        Book result=this.bookRepository.save(b);
        return result;
    }

    //we want to delete that book with given id
    //in that code we are printing that books where book id != id 
    //it automatically remove that book with given id
    public void deleteBook(int id)
    {
        //list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book,int id)
    {
        // list=list.stream().map(b->{
        //     if(b.getId()==id)
        //     {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(id);
        bookRepository.save(book);
    }
}
