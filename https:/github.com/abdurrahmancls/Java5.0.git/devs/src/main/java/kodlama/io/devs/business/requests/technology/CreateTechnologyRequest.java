package kodlama.io.devs.business.requests.technology;

import kodlama.io.devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnologyRequest {

	private String name;
	private Language language;
}
