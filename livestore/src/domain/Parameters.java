package domain;

public class Parameters {
	private String category_id;
	private String method;
	public Parameters() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parameters(String category_id, String method) {
		super();
		this.category_id = category_id;
		this.method = method;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	
	
	
}
