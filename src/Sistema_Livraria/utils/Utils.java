package Sistema_Livraria.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Utils {

    public static LocalDate convertDate(String data) {
        if (data == null) {
            throw new IllegalArgumentException("A data de nascimento não pode ser nula.");
        }

        if (data.isEmpty()) {
            throw new IllegalArgumentException("A data de nascimento precisa ser preenchida.");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate formattedData = LocalDate.parse(data, formatter);
            return formattedData;
        } catch (DateTimeParseException dateException) {
            throw new IllegalArgumentException("A data fornecida não está no formato correto (dd/MM/yyyy).", dateException);
        } catch (Exception error) {
            throw new IllegalArgumentException("Ocorreu um erro com a data");
        }
    }
    public static boolean checkName(String nome) {
        boolean isNameValid = nome.matches("[a-zA-Z\\s]+");
        if (!isNameValid) {
            System.out.println("O input deve conter apenas letras e espaços.");
            return false;
        }
        return true;
    }

    public static boolean checkEmail(String email){
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isEmail = Pattern.matches(regex, email);
        return isEmail;
    }
}
