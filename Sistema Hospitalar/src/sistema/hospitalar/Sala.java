package sistema.hospitalar;

public class Sala {

    private Integer quartos;
    
    private Integer subsetor_id;

    public Integer getSubsetor_id() {
        return subsetor_id;
    }

    public void setSubsetor_id(Integer subsetor_id) {
        this.subsetor_id = subsetor_id;
    }

    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }

    public Integer getQuartos() {
        return quartos;
    }

}
