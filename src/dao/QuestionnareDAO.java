package dao;


import model.Questionnare;

public class QuestionnareDAO extends BaseDAO<Questionnare>{
	private static final long serialVersionUID = 4049902808322409191L;

	public void closeConnection() {
		emf.close();
	}
}
