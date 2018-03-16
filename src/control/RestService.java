package control;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.QuestionnareTestDAO;
import dao.StudentDAO;
import model.QuestionnareTest;
import model.Student;

import org.json.JSONObject;

@Path("")
public class RestService {
	private QuestionnareTestDAO questionnareTestDAO = new QuestionnareTestDAO();
	private StudentDAO studendDAO = new StudentDAO();

	@GET
	@Path("/student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(@PathParam("id") int id) {
		System.out.println(id);
		Student student = studendDAO.findById(Student.class, id);
		
		return Response.ok()
				.entity(student)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@GET
	@Path("/questionnares")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent() {
		return Response.ok()
//				.entity(student)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Path("/questionnare/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveQuestionnare(String questionnareParam) {
		questionnareTestDAO.startOperation();

		System.out.println(questionnareParam);
		JSONObject questionnareJSON = new JSONObject(questionnareParam);
		QuestionnareTest questionnareTest = new QuestionnareTest();
		
		questionnareTest.setName(questionnareJSON.getString("name"));
		questionnareTest.setAnimation(questionnareJSON.getInt("animation"));
		questionnareTest.setLayout(questionnareJSON.getInt("layout"));
		questionnareTest.setNarrative(questionnareJSON.getInt("narrative"));
		questionnareTest.setVideo(questionnareJSON.getInt("video"));

		questionnareTest.setQuestion3(questionnareJSON.getString("question3"));
		questionnareTest.setQuestion4(questionnareJSON.getBoolean("question4"));

		questionnareTest.setQuestion2(questionnareJSON.get("question2").toString());
		questionnareTest.setQuestion2Others(questionnareJSON.getString("question2Others"));
        System.out.println(questionnareTest);
        
        questionnareTestDAO.save(questionnareTest);
        questionnareTestDAO.stopOperation(true);
//        questionnareTestDAO.closeConnection();
		return Response.ok()
				.entity(questionnareTest)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
//	@GET
//	@Path("/cases")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getCases() {
//		List<MedicalCase> cases = new ArrayList<>();
//
//		cases = caseDAO.findAll(MedicalCase.class);
//		GenericEntity< List<MedicalCase> > casesReturn = new GenericEntity<List<MedicalCase>>(cases){};
//		
//		return Response.ok()
//				.entity(casesReturn)
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//				.build();
//
////		return medicalCase;
//	}
	
//	@GET
//	@Path("/casejsonp")
//    @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON + ";charset=utf-8" })
//	public JSONWithPadding getCaseJSONP(@QueryParam("callback") String callback) {
//		Integer id = 1;
//		
//		MedicalCase medicalCase = caseDAO.findById(MedicalCase.class, id);
//
//        return new JSONWithPadding(new GenericEntity<MedicalCase>(medicalCase) {}, callback);
//	}
//	

}
