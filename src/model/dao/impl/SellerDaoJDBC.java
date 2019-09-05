package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;

	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// Comando executar no BD
			st = conn.prepareStatement(

					"SELECT seller.*,department.Name as DepName "

							+ "FROM seller INNER JOIN department "

							+ "ON seller.DepartmentId = department.Id "

							+ "WHERE seller.Id = ?");
			// ? e igual 1 recebendo o ID de valor
			st.setInt(1, id);
			// executeQuery() recebera o resultado do BD
			rs = st.executeQuery();
			// if rs.next ocndicaõa de verificacão se a registro no BD, caso não estiver
			// retornara NULL . Caso contrario retorna a tabela BD
			if (rs.next()) {

				Department dep = instantiateDepartment(rs);

				Seller obj = instantiateSeller(rs, dep);

				return obj;

			}

			return null;

		}

		catch (SQLException e) {

			throw new DbException(e.getMessage());

		}

		finally {

			DB.closeStatement(st);

			DB.closeResultSet(rs);

		}

	}

	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
