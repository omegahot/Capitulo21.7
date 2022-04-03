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
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = conn.prepareStatement("select seller.id, "
					+ "seller.name, "
					+ "seller.email, "
					+ "seller.birthDate, "
					+ "seller.baseSalary, "
					+ "seller.departmentId, "
					+ "d.name as depName "
					+ "from seller "
					+ "inner join department d on seller.departmentId = d.id "
					+ " where seller.Id = ?");
			
			// Parametros para a cláusula where
			ps.setInt(1, id);
			
			// Executa a consulta no banco
			rs = ps.executeQuery();
			
			if (rs.next()) {
				/*
				Department dep = new Department();
				dep.setId(rs.getInt("departmentId"));
				dep.setName(rs.getString("depName"));
				
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("name"));
				obj.setEmail(rs.getString("email"));
				obj.setBirthDate(rs.getDate("birthDate"));
				obj.setBaseSalary(rs.getDouble("baseSalary"));
				obj.setDepartment(dep);
				
				return obj;
				*/
				Seller obj = new Seller(rs.getInt("Id"), 
										rs.getString("name"), 
										rs.getString("email"),
										rs.getDate("birthDate"),
										rs.getDouble("baseSalary"), 
										new Department(rs.getInt("departmentId"), 
													   rs.getString("depName")));
				
				return obj;
			}
			
			
		} 
		catch (SQLException e) {
		   throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}

		return null;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
