package menu.model;

import java.util.ArrayList;
import java.util.List;
import menu.exception.CustomIllegalArgumentException;
import menu.exception.ErrorMessage;

public class Crew {

    private final String name;
    private List<String> pickyFoods;
    private List<String> menu;

    public Crew(String name) {
        validName(name);
        this.name = name;
        this.pickyFoods = new ArrayList<>();
        this.menu = new ArrayList<>();
    }


    public void validName(String input) {
        if (input == null || input.isBlank()) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_NAME);
        }

        if (input.length() < 2 || input.length() > 4) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_NAME);
        }
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                ", pickyFoods=" + pickyFoods +
                ", menu=" + menu +
                '}';
    }
}
