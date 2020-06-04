package loginSerenity.features.search;

import loginSerenity.tasks.Input;
import loginSerenity.ui.InputBox;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import loginSerenity.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void login_pass() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(Input.forTheTerm("doanthao3797@gmail.com","123456aA@"));

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("CucumberStudio | Projects list"))));

    }

    @Test
    public void login_fail() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(Input.forTheTerm("doanthao@gmail.com","123456aA@"));

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("CucumberStudio - Agile test management tool"))));

    }
}