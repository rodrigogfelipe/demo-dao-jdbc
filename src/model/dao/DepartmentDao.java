package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	// insert sera responsavel de inserir no BD
	void insert(Department obj);

	void update(Department obj);

	void deleteById(Integer id);

	// Department e responsavel para consulta o ID no BD. Se existe vai retorna, se
	// nao voltara null
	Department finfById(Integer id);

	List<Department> findAll();

}
