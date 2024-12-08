package menu.model;

import java.util.ArrayList;
import java.util.List;
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
            // 이름 중복에 대한 검증이 필요할까?
            items.add(new Crew(name));
        }

    }


    @Override
    public String toString() {
        return "Crews{" +
                "items=" + items +
                '}';
    }
}
