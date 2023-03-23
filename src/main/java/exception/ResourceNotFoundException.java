package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    String resourcename;
    String fieldname;
    Object fieldValue;

    public ResourceNotFoundException(String resourcename, String fieldname, Object fieldValue) {
        this.resourcename = resourcename;
        this.fieldname = fieldname;
        this.fieldValue = fieldValue;

    }

    public String getResourcename() {
        return resourcename;
    }

    public String getFieldname() {
        return fieldname;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
