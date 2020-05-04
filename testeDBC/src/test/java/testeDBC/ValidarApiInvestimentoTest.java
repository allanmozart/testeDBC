package testeDBC;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ValidarApiInvestimentoTest {

	@Test
	public void validarInvestimento() {
		// Fazer Get da api
		given().
		when().
			get("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador").
			
			// Validar response da API e Pensar como validar o response
			then()
				.assertThat().body("id", Matchers.equalTo(1))
				.assertThat().body("meses", Matchers.contains("112", "124", "136", "148"))
				.assertThat().body("valor", Matchers.contains("2.802", "3.174", "3.564", "3.971"));
	}

}
