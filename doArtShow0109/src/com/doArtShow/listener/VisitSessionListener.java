package com.doArtShow.listener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

import com.doArtShow.dao.ManagerDao;

@WebListener
public class VisitSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		if(event.getSession().isNew()){
            execute(event);
        }
	}
	
	private void execute(HttpSessionEvent event) {
		HttpSession session = event.getSession();

		try {
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/artshowdb");
			ManagerDao managerDao = new ManagerDao();
			managerDao.setDataSource(ds);
			
			managerDao.setVisitDate();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {}

}
