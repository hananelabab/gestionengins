package ma.gestiongr.exeption;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.Data;

@Data
public class ExceptionResponse {

	private LocalDateTime timestamp;
	private Integer status;
	private Integer businessCode;
	private String message;
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(Integer businessCode) {
		this.businessCode = businessCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
		@Override
	public int hashCode() {
		return Objects.hash(businessCode, message, status, timestamp);
	}
	
	
	

	
	
}
