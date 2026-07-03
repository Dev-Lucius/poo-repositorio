package main.java.br.edu.projeto.permissoes.domain.permission;

// Representa uma única permissão
public final class Permission {
    private final String name;
    private final String description;

    public Permission(String name, String description) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "O nome da Permissão não deve ser Nulo");
        }

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException(
                    "A Descrição não deve ser Nula");
        }

        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Verifica se o Nome da Permissão Corresponde à Ação solicitada
    public boolean matches(String action) {
        return name.equalsIgnoreCase(action);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Permission{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
