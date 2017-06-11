package com.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.PageBean;
import com.ssh.model.Book;
import com.ssh.model.Product;
import com.ssh.service.BookService;

public class BookAction extends ActionSupport implements ModelDriven<Book>{
  private BookService bookService;
  private int page;
  private PageBean pageBean;
  private Book book = new Book();
  private int bookId;
  
  public String delete(){
    if(bookId==0){
      return SUCCESS;
    }
    bookService.delete(bookId);
    return SUCCESS;
  }
  
  public String update(){
    if(bookId==0 && book.getBid()==null){
      return "create";
    }
    if(book.getBid()!=null){
      if(book.getBname()==null||book.getBname().equals("")){
        return "create";
      }
      bookService.save(book);
      return SUCCESS;
    }
    
    book = bookService.findById(bookId);
    if(book==null){
      return "create";
    }else{
      return INPUT;
    }
  }
  
  public String getPageList() {
    this.pageBean = bookService.find(5, page);
    return SUCCESS;
  }

  public String save() {
    if(book.getBname()==null||book.getBname().equals("")){
      return INPUT;
    }
    bookService.save(book);
    return SUCCESS;
  }
  
  public Book getModel() {
    return book;
}
  
  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public void setBookService(BookService bookService) {
    this.bookService = bookService;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public PageBean getPageBean() {
    return pageBean;
  }

  public void setPageBean(PageBean pageBean) {
    this.pageBean = pageBean;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }


  
}
