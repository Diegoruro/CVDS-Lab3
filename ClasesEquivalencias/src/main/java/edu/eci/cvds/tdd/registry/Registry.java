package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;
import java.util.Objects;

public class Registry {
    private ArrayList<Integer> personId = new ArrayList<Integer>();
    public RegisterResult registerVoter(Person p) {
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        } else if (p.getAge() > 120 || p.getAge() <0) {
            return RegisterResult.INVALID_AGE;
        } else if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        } else if (this.personId.contains(p.getId())) {
            return RegisterResult.DUPLICATED;
        } else if (Objects.equals(p.getName(), " ")){
            return RegisterResult.BLANK_SPACE;
        }
        this.personId.add(p.getId());
        return RegisterResult.VALID;
    }
}
