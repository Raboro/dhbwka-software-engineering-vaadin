package io.github.raboro.basicvaadin.views.collection;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

/**
 * @author MariusWoerfel
 */
@PermitAll
@PageTitle("Collection")
@Route("/collection")
public class CollectionView extends AppLayout {

    public CollectionView() {
        setContent(constructContent());
    }

    private Component constructContent() {
        Div content = new Div();
        content.add(new DatePicker("Date Picker"));
        content.add(new TimePicker("Time Picker"));
        content.add(new DateTimePicker("Date Time Picker"));
        content.add(new MessageInput());
        content.add(new Upload());
        content.add(new TextField("Text field"));
        TextArea textArea = new TextArea();
        textArea.setValue("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, " +
                "sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam");
        content.add(textArea);
        content.add(constructSelect());
        content.add(new MultiSelectComboBox<>("Elements", "Hi", "Hello", "Hola", "Hello There"));
        content.add(constructRadioButtonGroup(true));
        content.add(constructRadioButtonGroup(false));
        addStylingToContent(content);
        return content;
    }

    private Select<String> constructSelect() {
        Select<String> select = new Select<>();
        select.setLabel("Sort by");
        select.setItems("Most recent first", "Rating: high to low",
                "Rating: low to high", "Price: high to low",
                "Price: low to high");
        select.setValue("Most recent first");
        return select;
    }

    private RadioButtonGroup<String> constructRadioButtonGroup(boolean readonly) {
        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.setLabel("Status");
        radioGroup.setItems("In progress", "Done", "Cancelled");
        radioGroup.setValue("In progress");
        radioGroup.setReadOnly(readonly);
        radioGroup.setHelperText("This is a helper text");
        return radioGroup;
    }

    private void addStylingToContent(Div content) {
        content.getStyle()
                .setMargin("5%")
                .setBorder("3px solid black")
                .setPadding("2%")
                .set("border-radius", "10px")
                .set("gap", "1%")
                .set("flex-wrap", "wrap")
                .set("margin-top", "15%")
                .setBoxShadow("0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)")
                .setDisplay(Style.Display.FLEX);
    }
}