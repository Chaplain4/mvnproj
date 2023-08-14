package enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {
    private String description;
    private String details;
    private Severity severity;
    public Problem(String description, Severity severity) {
        this(description, null, severity);
    }
    public void resolve(){
        System.out.println("resolving problem '" + severity.name() + " ... " + severity.getTimeToDo());
    }
}