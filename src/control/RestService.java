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

import dao.StudentDAO;
import model.Student;


@Path("")
public class RestService {
	private StudentDAO studendDAO = new StudentDAO();
	
	@GET
	@Path("/case/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCase(@PathParam("id") int id) {
		System.out.println(id);
		Student student = studendDAO.findById(Student.class, id);
		
		return Response.ok()
//				.entity(medicalCase)
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
//	@POST
//	@Path("/case/save")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response saveCase(String medicalCaseParam) {
//		caseDAO.startOperation();
//
//		System.out.println(medicalCaseParam);
//		JSONObject medicalcaseJSON = new JSONObject(medicalCaseParam);
//		MedicalCase medicalCase = new MedicalCase();
//		
//		medicalCase.setName(medicalcaseJSON.getString("name"));
//		medicalCase.setWon_text(medicalcaseJSON.getString("won_text"));
//		medicalCase.setLost_text(medicalcaseJSON.getString("lost_text"));
//		medicalCase.setRandomize_actions(medicalcaseJSON.getBoolean("randomize_actions"));
//		medicalCase.setAllow_negative_score(medicalcaseJSON.getBoolean("allow_negative_score"));
//		medicalCase.setTimeout(medicalcaseJSON.getInt("timeout"));
//
//		JSONArray states = medicalcaseJSON.getJSONArray("states");
//        for (int i = 0; i < states.length(); i++) {
//        	State state = new State();
//        	
//        	state.setTitle(states.getJSONObject(i).getString("title"));
//        	state.setDescription(states.getJSONObject(i).getString("description"));
//        	state.setFeedback(states.getJSONObject(i).getString("feedback"));
////        	state.setIdent(states.getJSONObject(i).getInt("ident"));
//        	
//            JSONArray actions = states.getJSONObject(i).getJSONArray("actions");
//            
//            for (int j = 0; j < actions.length(); j++) {
//            	Action action = new Action();
//            	action.setCorrect(actions.getJSONObject(j).getBoolean("correct"));
//            	action.setProceed(actions.getJSONObject(j).getBoolean("proceed"));
//            	action.setText(actions.getJSONObject(j).getString("text"));
//            	action.setTarget(actions.getJSONObject(j).getInt("target"));
//            	
//            	state.getActions().add(action);
//            	action.setState(state);
//			}
//            
//            medicalCase.getStates().add(state);
//            state.setMedicalCase(medicalCase);
//        }
//        
////        for (int i = 0; i < states.length(); i++) {
////            JSONArray actions = states.getJSONObject(i).getJSONArray("actions");
////            for (int j = 0; j < actions.length(); j++) {
////            	State target = medicalCase.getStates().get();
////            	medicalCase.getStates().get(i).getActions().get(j).setTarget(target);
////			}
////        }
//        
//        System.out.println(medicalCase);
//        
//		caseDAO.save(medicalCase);
//		caseDAO.stopOperation(true);
//		caseDAO.closeConnection();
//		return Response.ok()
//				.entity(medicalCaseParam)
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//				.build();
//	}
}
