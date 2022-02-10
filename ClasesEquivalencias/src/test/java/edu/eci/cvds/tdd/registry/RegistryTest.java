package edu.eci.cvds.tdd.registry;


import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {
        Person person = new Person("Fabio lozada", 1000000001, 45, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void valitadeUndargeVoterIsValid() {
        Person person = new Person("Andres Ruiz", 1000000001, 18, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateUndargeVoterIsNotValid() {

        Person person = new Person("Sebastian Rojas", 1000000002, 14, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateVoterIsDuplicated(){

        Person person = new Person("Fabio lozada", 1000000001, 45, Gender.MALE, true);
        registry.registerVoter(person);


        Person person1 = new Person("Fabio lozada", 1000000001, 45, Gender.MALE, true);
        RegisterResult result1 = registry.registerVoter(person1);


        Assert.assertEquals(RegisterResult.DUPLICATED, result1);
    }

    @Test
    public void validateVoterHasInvalidAge(){
        Person person= new Person("Andrea Gonzales", 1000000004, 154, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);


        Assert.assertEquals(RegisterResult.INVALID_AGE, result);

    }

    @Test
    public void validateVoterHasNegativeAge(){
        Person person= new Person("Andrea Gonzales", 1000000004, -154, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);


        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateVoterIsDead(){
        Person person= new Person("Franchesco", 1000000005, 25, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);


        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateVoterNameIsBlank(){

        Person person= new Person(" ", 1000000006, 25, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);


        Assert.assertEquals(RegisterResult.BLANK_SPACE, result);
    }
}