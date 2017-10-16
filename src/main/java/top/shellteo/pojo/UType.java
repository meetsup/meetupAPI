package top.shellteo.pojo;

public class UType {
    private Integer id;

    private String father;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father == null ? null : father.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}