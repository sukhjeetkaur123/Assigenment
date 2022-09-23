package comJson_parsing_getSet;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSON_parsing_test {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[] jsonData=Files.readAllBytes(Paths.get("C:\\Users\\SukhjeetKaur\\RestAPI\\TestData\\empData.json"));
		ObjectMapper mapper = new ObjectMapper();
		Person person=mapper.readValue(jsonData, Person.class);
		System.out.println(person.getEmail());
		System.out.println(person.getAddress().getState());
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
		System.out.println(person.getAddress().getabc().getDist());
	}

}
