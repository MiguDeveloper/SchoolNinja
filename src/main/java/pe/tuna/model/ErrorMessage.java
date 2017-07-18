package pe.tuna.model;

public class ErrorMessage {
	private String fielName;
	private String message;

	public ErrorMessage(String fielName, String message) {
		this.fielName = fielName;
		this.message = message;
	}

	public String getFielName() {
		return fielName;
	}

	public void setFielName(String fielName) {
		this.fielName = fielName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
