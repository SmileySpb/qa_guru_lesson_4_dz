import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {
    @Test
    public void junit5ShouldBeTest() {
        open("https://github.com/");
        $("header[role='banner']").shouldBe(visible);
        $("input[name='q']").setValue("Selenide").pressEnter();
        SelenideElement selenideLink = $$(".repo-list a").first();
        selenideLink.shouldHave(text("selenide/selenide"), Duration.ofSeconds(10));
        selenideLink.click();
        SelenideElement linkToWiki = $("span[data-content='Wiki']");
        linkToWiki.shouldBe(visible);
        linkToWiki.click();
        $x("//li//a[.='Soft assertions']").click();
        $("#wiki-wrapper h1").shouldBe(visible);
        SelenideElement wikiBody = $("#wiki-body");
        wikiBody.scrollIntoView(true);
        wikiBody.$("#wiki-content ol[start='3']").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
