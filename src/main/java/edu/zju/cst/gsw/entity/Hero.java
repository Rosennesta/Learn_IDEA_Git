package edu.zju.cst.gsw.entity;

public class Hero {
    private Integer id;
    private String name;
    private Float hp;
    private Integer damage;

    @Override
    public String toString() {
        return "Hero{" +
                "name = '" + name + '\'' +
                ", hp = " + hp +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHp() {
        return hp;
    }

    public void setHp(Float hp) {
        this.hp = hp;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
