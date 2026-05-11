package ObjectValue;

// object-value class
public class Nome {
    private String value;

    public Nome(String value) {
        // validate value
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Nome nao pode ser nulo ou vazio");
        
        // normalize value
        // "  vini  MaChado   " => "VINI MACHADO"
            value = value.trim();
            value = value.replaceAll("\\s+", " ");
            value = value.toUpperCase();

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}