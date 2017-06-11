package com.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.bean.PageBean;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;

@Transactional
public class BookService {
  private BookDao bookDao;

  public void setBookDao(BookDao bookDao) {
      this.bookDao = bookDao;
  }
  public Book findById(int id){
    return bookDao.findById(id);
  }
  
  public void delete(int bid){
    Book book = new Book();
    book.setBid(bid);
    bookDao.delete(book);
  }
  
  public PageBean find(int pageSize, int page){
    int count = bookDao.getCount(); // 总记录数
    int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
    int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
    int length = pageSize; // 每页记录数
    int currentPage = PageBean.countCurrentPage(page);
    List<Book> list = bookDao.getListForPage(offset, length); // 该分页的记录
    // 把分页信息保存到Bean中
    PageBean pageBean = new PageBean();
    pageBean.setPageSize(pageSize);
    pageBean.setCurrentPage(currentPage);
    pageBean.setAllRow(count);
    pageBean.setTotalPage(totalPage);
    pageBean.setList(list);
    pageBean.init();
    return pageBean;
  }
  
  public void save(Book book)
  {
      bookDao.save(book);
  }
}
