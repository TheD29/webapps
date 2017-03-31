/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.validators;

/**
 *
 * @author us9522
 */

import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ua.ticket.web.validators.LoginValidator")
public class LoginValidator implements Validator {

//    @Override
//    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
//
//        ResourceBundle bundle = ResourceBundle.getBundle("ua.training.web.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
//
//        try {
//            String newValue = value.toString();
//
//            if (newValue.length() < 5) {
//                throw new IllegalArgumentException(bundle.getString("login_length_error"));
//            }
//
//            if (!Character.isLetter(newValue.charAt(0))) {
//                throw new IllegalArgumentException(bundle.getString("first_letter_error"));
//            }
//
//            if (getTestArray().contains(newValue)) {
//                throw new IllegalArgumentException(bundle.getString("used_name"));
//            }
//
//
//        } catch (IllegalArgumentException e) {
//            FacesMessage message = new FacesMessage(e.getMessage());
//            message.setSeverity(FacesMessage.SEVERITY_ERROR);
//            throw new ValidatorException(message);
//        }
//
//    }

    private ArrayList<String> getTestArray() {
        ArrayList<String> list = new ArrayList<String>();// заглушка, желательно делать запрос в базу данных для проверки существующего имени
        list.add("username");
        list.add("login");
        return list;
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}