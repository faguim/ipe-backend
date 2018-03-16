package dao;


import model.QuestionnareTest;

public class QuestionnareTestDAO extends BaseDAO<QuestionnareTest>{
	private static final long serialVersionUID = 4049902808322409191L;

	public void closeConnection() {
		emf.close();
	}
}
