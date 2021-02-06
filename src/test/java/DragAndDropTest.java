import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    @Test
    public void dragAtoBtest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement dragElement = $("#column-a");
        SelenideElement dropElement = $("#column-b");
        // Doesn't work
        dragElement.dragAndDropTo(dropElement);
        dragElement.dragAndDropTo("#column-b");
        dragElement.shouldHave(text("B"));
        dropElement.shouldHave(text("A"));
    }
}
