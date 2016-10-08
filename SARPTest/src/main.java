import org.jboss.resteasy.client.ClientResponse;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class main {

	public static void main(String[] args) {
		try {
			
			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://52.52.100.160:8080/SARPService/adminService/puesto");

			String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";

			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = (String) response.getEntity(String.class);
			System.out.println(output);



			

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
