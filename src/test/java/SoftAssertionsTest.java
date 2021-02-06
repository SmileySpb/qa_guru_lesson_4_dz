import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {
    @Test
    public void junit5ShouldBeTest() {
        open("https://github.com/");
        $("header[role='banner']").shouldBe(visible);
        $("input[name='q']").setValue("Selenide").pressEnter();
        $$(".repo-list a").first().shouldHave(text("selenide/selenide")).click();
        $("span[data-content='Wiki']").shouldBe(visible).click();
        $x("//li//a[.='Soft assertions']").click();
        $("#wiki-wrapper h1").shouldBe(visible);
        $("#wiki-body").scrollIntoView(true)
                .$("#wiki-content ol[start='3']").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
