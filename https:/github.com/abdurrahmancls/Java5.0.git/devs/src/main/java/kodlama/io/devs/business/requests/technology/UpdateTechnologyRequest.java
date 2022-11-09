package kodlama.io.devs.business.requests.technology;

import kodlama.io.devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTechnologyRequest {
	private String name;
	private Language language;

}
