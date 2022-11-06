package pro.sky.homework25;

import jdk.internal.icu.text.UnicodeSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import pro.sky.homework25.exseption.EmployeeAlreadyAddedException;
import pro.sky.homework25.model.Employee;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.homework25.ConstantTest.*;


public class EmployeeServiceTest {
    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(FIRST_NAME_IVAN, LAST_NAME_IVANOV, DEPARTMENT_1, SALARY_10000d)
        );
    }

    @Test
    public void addTest() {
        Employee actual =out.add(FIRST_NAME_IVAN, LAST_NAME_IVANOV, DEPARTMENT_1, SALARY_10000d);
        Employee expected = new Employee(FIRST_NAME_IVAN, LAST_NAME_IVANOV, DEPARTMENT_1, SALARY_10000d);
        assertEquals(actual, expected);
    }

    @Test
    public void addTestThrows() {
        Employee actual = out.add(FIRST_NAME_IVAN, LAST_NAME_IVANOV, DEPARTMENT_1, SALARY_10000d);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.add(FIRST_NAME_IVAN, LAST_NAME_IVANOV, DEPARTMENT_1, SALARY_10000d));
    }

    @Test
    public void removeTest() {
        Employee expected = new Employee(FIRST_NAME_IVAN, LAST_NAME_IVANOV, DEPARTMENT_1, SALARY_10000d);
        out.add(FIRST_NAME_IVAN, LAST_NAME_IVANOV, DEPARTMENT_1, SALARY_10000d);
        Employee actual = out.remove(FIRST_NAME_IVAN, LAST_NAME_IVANOV);
        assertEquals(actual, expected);
    }
    @Test
    public void findTest() {

        out.add(FIRST_NAME_IVAN, LAST_NAME_IVANOV, DEPARTMENT_1, SALARY_10000d);
        Employee expected = new Employee(FIRST_NAME_IVAN, LAST_NAME_IVANOV, DEPARTMENT_1, SALARY_10000d);
        Employee actual = out.find(FIRST_NAME_IVAN, LAST_NAME_IVANOV);
        assertEquals(actual, expected);
    }

}
