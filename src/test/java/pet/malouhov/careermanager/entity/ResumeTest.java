package pet.malouhov.careermanager.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResumeTest {

    @Test
    @DisplayName("Инициализация объекта Resume")
    public void instantiateResumeTest() {

        Resume testResume = new Resume("Sber",
                "Java Developer",
                "Required Middle Java Dev.");

        System.out.println(testResume);


    }

}