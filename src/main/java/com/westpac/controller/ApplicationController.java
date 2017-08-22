package com.westpac.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.xml.ws.Response;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.westpac.entity.Applicant;
import com.westpac.entity.Application;
import com.westpac.service.IApplicationService;

@Controller
@RequestMapping("westpac")

public class ApplicationController {
	@Autowired
	private IApplicationService applicationService;
	@GetMapping("application/{id}") //WORKING
	public ResponseEntity<Application> getApplicationById(@PathVariable("id") Integer id) {
		Application application = applicationService.getApplicationById(id);
		return new ResponseEntity<Application>(application, HttpStatus.OK);
	}
	@GetMapping("applications")//WORKING
	public ResponseEntity<List<Application>> getAllApplications() {
		List<Application> list = applicationService.getAllApplications();
		return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
	}
	@GetMapping("200")//WORKING
	public ResponseEntity<String> getStub200() {
		// Creating JOSNObject
		JSONObject obj=new JSONObject();
		obj.put("applicationId","1");
		obj.put("title","CC");
		obj.put("category","Credit Cards Category");
		try (FileWriter file = new FileWriter("./\\src\\main\\resources\\200.JSON")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}catch(IOException io) {
			io.printStackTrace();
		}


		/* try {
		  obj.writeJSONString(out);
		  jsonText = out.toString();
		  }catch(IOException io) {
			  io.printStackTrace();
		  }
		  System.out.print(jsonText);*/
		//String hello = "successFull right";
		/*		int code = 200;
		String respose = "";
		StringBuilder content = new StringBuilder("");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("200.JSON").getFile());
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String currentLine;
			while((currentLine=br.readLine()) !=null)
			{
				content.append(currentLine).append("\n");
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}*/
		return new ResponseEntity<String>("200_Stub response is saved under ./src/main/resournces/", HttpStatus.OK);
	}
	@GetMapping("300")//WORKING
	public ResponseEntity<String> getStub300() {
		// Creating JOSNObject
		JSONObject obj=new JSONObject();
		obj.put("errorCode","300");
		obj.put("errorDescription","The value returned when an external ID exists in more than one record. The response body contains the list of matching records.");
		try (FileWriter file = new FileWriter("./\\src\\main\\resources\\300.JSON")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}catch(IOException io) {
			io.printStackTrace();
		}
		return new ResponseEntity<String>("300_Stub response is saved under ./src/main/resournces/", HttpStatus.MULTIPLE_CHOICES);
		}
	@GetMapping("400")//WORKING
	public ResponseEntity<String> getStub400() {
		// Creating JOSNObject
		JSONObject obj=new JSONObject();
		obj.put("errorCode","400");
		obj.put("errorDescription","The request couldn’t be understood, usually because the JSON or XML body contains an error.");
		try (FileWriter file = new FileWriter("./\\src\\main\\resources\\400.JSON")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}catch(IOException io) {
			io.printStackTrace();
		}
		ResponseEntity<String> response = new ResponseEntity<String>("400_Stub response is saved under ./src/main/resournces/", HttpStatus.BAD_REQUEST); 
		System.out.println(response.getStatusCode());
		return response; 
		}
	
	/*private String getStatusCode() {
		try {
			URIBuilder builder = new URIBuilder(authorizationUrl + "/oauth/authorize"); 

			builder.addParameter("response_type", "code");
			builder.addParameter("grant_type","authorization_code");
			builder.addParameter("client_id", sshClientId);
			URI url = new URI(builder.toString());
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			HttpStatus statusCode = response.getStatusCode();
			if (statusCode!=HttpStatus.FOUND) {
				throw new CloudFoundryException(statusCode);
			}
			String loc = response.getHeaders().getFirst("Location");
			if (loc==null) {
				throw new CloudOperationException("No 'Location' header in redirect response");
			}
			List<NameValuePair> qparams = URLEncodedUtils.parse(new URI(loc), "utf8");
			for (NameValuePair pair : qparams) {
				String name = pair.getName();
				if (name.equals("code")) {
					return pair.getValue();
				}
			}
			throw new CloudOperationException("No 'code' param in redirect Location: "+loc);
		} catch (URISyntaxException e) {
			throw new CloudOperationException(e);
		}
	}
*/	
	private ResponseEntity<String> getStub(ResponseEntity<String> response){
		return new ResponseEntity<String>("400_Stub response is saved under ./src/main/resournces/", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("500")//WORKING
	public ResponseEntity<String> getStub500() {
		String templatePath = "./\\src\\main\\templates\\";
		String targetPath = "./\\src\\main\\resources\\";
		String jsonExt = ".JSON";
		String statusCode = "500";
		//Read the .JSON Template for 500
		JSONParser parser = new JSONParser();
		String errorCode ="";
		String errorDescription ="";
		JSONObject jsonObj=null;
		try {
			Object obj=parser.parse(new FileReader(templatePath+statusCode+jsonExt));
			 jsonObj = (JSONObject)obj;
			System.out.println(jsonObj);
			 errorCode = (String) jsonObj.get("errorCode");
            System.out.println(errorCode);
			 errorDescription = (String) jsonObj.get("errorDescription");
            System.out.println(errorDescription);
        }catch(IOException io) {
		}catch (ParseException e) {
            e.printStackTrace();
        }
		// Creating JOSNObject
		//JSONObject obj=new JSONObject();
		//jsonObj.put(errorCode,"500");
		jsonObj.put("errorDescription","An error has occurred within Force.com, so the request couldn’t be completed. Contact Salesforce Customer Support.");
		try (FileWriter file = new FileWriter(targetPath+statusCode+jsonExt)) {
			file.write(jsonObj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + jsonObj);
		}catch(IOException io) {
			io.printStackTrace();
		}
		return new ResponseEntity<String>("500_Stub response is saved under ./src/main/resournces/", HttpStatus.INTERNAL_SERVER_ERROR);
		}


	@PostMapping("application")
	public ResponseEntity<Void> addApplication(@RequestBody Application application, UriComponentsBuilder builder) {
		boolean flag = applicationService.addApplication(application);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/application/{id}").buildAndExpand(application.getApplicationId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("application/{id}") //WORKING
	public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
		applicationService.updateApplication(application);
		return new ResponseEntity<Application>(application, HttpStatus.OK);
	}
	@DeleteMapping("application/{id}") // WORKING
	public ResponseEntity<Void> deleteApplication(@PathVariable("id") Integer id) {
		applicationService.deleteApplication(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/*	private Response stubTheClient() {
		int code = 200;
		String respose = "";
		StringBuilder content = new StringBuilder("");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("200.JSON").getFile());

		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String currentLine;
			while((currentLine=br.readLine()) !=null)
			{
				content.append(currentLine).append("\n");

			}

		}
		catch(IOException e){
			e.printStackTrace();
		}
		respose = content.toString();
		code = 200;
		return Response.status(code).entity(respose).build();

	}
	 */
	

} 