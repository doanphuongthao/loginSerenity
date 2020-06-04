package loginSerenity.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import loginSerenity.ui.InputBox;

public class Input implements Task {

    private final String Email;
    private final String Password;

    protected Input( String email, String password)
    {
        this.Email = email;
        this.Password = password;
    }

    @Step("Input for #Email")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(Email)
                     .into(InputBox.EMAIL_FIELD),
                Enter.theValue(Password)
                     .into(InputBox.PASSWORD_FIELD),
                Click.on(InputBox.LOGIN_BUTTON)
        );

    }


    public static Input forTheTerm(String email, String password) {

        return instrumented(Input.class, email,password);
    }

}
