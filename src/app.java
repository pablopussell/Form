import static spark.Spark.*;

import java.util.HashMap;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class app {
	
	private static String RESOURCES_PATH="/resources";

	public static void main(String[] args) {
		staticFileLocation(RESOURCES_PATH);

		FreeMarkerEngine templateEngine= createTemplateEngine();
		
		get("/",(req, res) ->{
			res.status(301);
			res.redirect("/clients/create");
			return "";
		});
		
		get("/clients/create", (req, res) ->{
			HashMap<String, Object> root=new HashMap<String, Object>();
			return new ModelAndView(root,"/views/clients/create.ftl");
			
		}, templateEngine);

		post("/clients/create",(req, res) ->{
			String name = req.queryParams("name");
			String surName = req.queryParams("surName");


			res.redirect("clients/thanksyou");
			return "";
		});
		
		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(app.class, "/resources");
		freeMarkerEngine.setConfiguration(configuration);
		

	}
private static FreeMarkerEngine createTemplateEngine() {
	// TODO Auto-generated method stub
	return null;
}

}
