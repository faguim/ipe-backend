package dao;

import javax.persistence.Query;

import model.Student;

public class StudentDAO extends BaseDAO<Student>{
	private static final long serialVersionUID = 4049902808322409191L;

	public Student findByName(String name){
		String queryString = "SELECT stutent FROM " + Student.class.getName() +" AS student WHERE student.name = :name";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("name", name);
		if (query.getResultList().size() != 0)
			return (Student) query.getSingleResult();
		else return null;
	}

}
