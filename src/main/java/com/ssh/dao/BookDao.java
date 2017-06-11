package com.ssh.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ssh.model.Book;
import com.ssh.model.User;

public class BookDao extends HibernateDaoSupport {

  public void delete(Book book) {
    this.getHibernateTemplate().delete(book);
  }
  
 public int getCount() {
   String hql = "select count(*) from Book as book";
   return ((Long)getHibernateTemplate().iterate(hql).next()).intValue();
  }

  public List getListForPage(final int offset,
      final int length) {
    
    String hql ="from Book";
    @SuppressWarnings("unchecked")
    List list = (List) getHibernateTemplate().execute(

        new HibernateCallback() {

          public Object doInHibernate(Session session)

              throws HibernateException {

            Query query = session.createQuery(hql);

            query.setFirstResult(offset);

            query.setMaxResults(length);

            List list = query.list();

            return list;

          }

        });

    return list;

  }


  
  public void save(Book book) {
    this.getHibernateTemplate().saveOrUpdate(book);
  }
  
  public Book findById(int id){
    String hql= "from Book u where u.bid=?" ;
    List bookList =  this.getHibernateTemplate().find(hql, id);
    if(bookList==null || bookList.size()==0){
      return null;
    }else{
      return (Book)bookList.get(0);
    }
  }
}

