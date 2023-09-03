package homework.list.task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Lecturer implements Person {
    private String name;
    private String emailAddress;
    private List<String> taughtCourses;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<String> getTaughtCourses() {
        return taughtCourses;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }
}
