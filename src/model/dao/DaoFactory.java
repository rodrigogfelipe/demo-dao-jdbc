package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	// SellerDao recebe o retorno do createSellerDao()
	public static SellerDao createSellerDao() {
		
		return new SellerDaoJDBC(DB.getConnection());
		
	}

}
