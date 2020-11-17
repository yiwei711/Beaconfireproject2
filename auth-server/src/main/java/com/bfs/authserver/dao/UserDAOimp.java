package com.bfs.authserver.dao;


import com.bfs.authserver.domain.User;
import com.bfs.authserver.dbconfig.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

@Repository("employeeHibernateDao")
public class UserDAOimp implements UserDAO{

    HibernateConfig hibernateConfig;

    @Autowired
    private void setHibernateConfig(HibernateConfig h){
        this.hibernateConfig =h;
    }
    @Override
    public List<User> getAllUser() {
        List<User> result = new ArrayList<User>();
        SessionFactory lsfb = (SessionFactory) hibernateConfig.sessionFactory();
        Session Hsession = lsfb.openSession();
        String hql = "From user U";
        Query query = Hsession.createQuery(hql);
        result = query.list();
        return result;
    }
}
