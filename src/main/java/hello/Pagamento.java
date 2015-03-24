package hello;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pagamento {
	
	private Integer id;
	private Double total;
	
	@JsonCreator
	public Pagamento(@JsonProperty("total") Double total) {
		this.total = total;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Double getTotal() {
		return total;
	}
	
}
