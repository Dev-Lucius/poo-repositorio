// class value-object
public class CPF {
    
    private String value;

    public CPF(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio.");
        }

        value = value.replaceAll("\\D", ""); // Remove caracteres não numéricos
        
        if (value.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos.");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getFormattedString() {
        return String.format("%s.%s.%s-%s", 
            value.substring(0, 3), 
            value.substring(3, 6), 
            value.substring(6, 9), 
            value.substring(9, 11));
    }
}
