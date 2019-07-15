package ooc.finals.nameconverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NameConverterApplicationTests {

    @Autowired
    ResourceLoader resourceLoader;

    @LocalServerPort
    int randomServerPort;

	@Test
	public void contextLoads() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + randomServerPort + "/convert";
        URI uri = new URI(baseUrl);

        Resource resource = resourceLoader.getResource("classpath:test-cases.csv");
        InputStream input = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        reader.readLine();
        while(reader.ready()) {
            String line = reader.readLine();
            String[] arr = line.split(",");
            System.out.println("name: " + arr[0].trim()+" type: " + arr[1].trim()+" format: " + arr[2].trim());

            FormatSpecification spec = new FormatSpecification(arr[0].trim(),arr[1].trim(),arr[2].trim());

            ResponseEntity<String> response = restTemplate.postForEntity(uri,spec,String.class);
            assertEquals(200 ,response.getStatusCodeValue() );
            assertEquals(arr[3].trim(),response.getBody());
        }
	}

}
