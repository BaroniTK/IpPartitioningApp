package com.example.apppartizionamento;

public class SubnetInfo {
    private int hosts;
    private String name;

    public SubnetInfo(int hosts, String name) {
        this.hosts = hosts;
        this.name = name;
    }

    public int getHosts() {
        return hosts;
    }

    public String getName() {
        return name;
    }
}
