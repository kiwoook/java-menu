package menu.model;

import static menu.utils.Constants.ENTER;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import menu.utils.StringUtils;

public class Crews {

    private final List<Crew> items;

    public Crews() {
        this.items = new ArrayList<>();
    }

    public static Crews create() {
        return new Crews();
    }

    public void addCrews(String input) {
        String[] split = StringUtils.split(",", input, null);

        for (String name : split) {
            items.add(new Crew(name));
        }

    }

    public List<Crew> getCrews() {
        return items;
    }

    public String toResult() {
        StringJoiner joiner = new StringJoiner(ENTER);

        for (Crew crew : items) {
            joiner.add(crew.toResult());
        }

        return joiner.toString();
    }

    @Override
    public String toString() {
        return "Crews{" +
                "items=" + items +
                '}';
    }
}
