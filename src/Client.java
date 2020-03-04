
import Controller.Controller;
import model.Model;
import view.View;

/*
 * please switch to Maven projct and update the Maven project
 * switch the jdk to 1.8 before running the client.
 * 
 * example account:
 * 		Teacher
 * 				id: 20020004
 * 				pw: password
 * 
 * 		Class director
 * 				id: 20020002
 * 				pw: password
 * 
 * 		PTT director
 * 				id: 20020003
 * 				pw: password
 * 
 * 		Administrator
 * 				id: 20020001
 * 				pw: password
 * 
 * 		Other accounts can be see and edit in the Database.json file.
 */
public class Client {

	public static void main(String[] args) {
		
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(model, controller);
		controller.setView(view);
		
	}
}
