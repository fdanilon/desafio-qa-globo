import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestApi {

    @Test
    @DisplayName("Verificar o ID de cada elemento da API")
    public void VerificaId(){
        baseURI = "https://www.assineglobo.com.br/";
        basePath = "/services/rest/products";

        List<String> id = new ArrayList<>();

        id.add("AT");
        id.add("CJ");
        id.add("CV");
        id.add("CF");
        id.add("EN");
        id.add("GC");
        id.add("GL");
        id.add("GR");
        id.add("GQ");
        id.add("MC");
        id.add("PE");
        id.add("VG");


        for (int i=0;i<id.size();i++){
            String idApi = given()
                                .contentType(ContentType.JSON)
                           .when()
                           .get()
                           .then()
                               .extract()
                               .path("id["+i+"]");

            System.out.println("Id da lista: "+id.get(i)+" - Id recebido da API: "+idApi);
            Assertions.assertEquals(id.get(i),idApi);
        }

    }
}
