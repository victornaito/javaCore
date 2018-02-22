package Classe;

public class Carro {
    String name;
    Long portas;
    String marca;

    public Carro(String name, Long portas, String marca) {
        this.name = name;
        this.portas = portas;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "name='" + name + '\'' +
                ", portas=" + portas +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPortas() {
        return portas;
    }

    public void setPortas(Long portas) {
        this.portas = portas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
