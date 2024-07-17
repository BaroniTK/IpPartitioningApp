package com.example.apppartizionamento;

public class Subnet {
    private String name;
    private String networkAddress;
    private String subnetMask;
    private String firstHost;
    private String lastHost;
    private String broadcastAddress;
    private String gateway;

    public Subnet(String name, String networkAddress, String subnetMask, String firstHost, String lastHost, String broadcastAddress, String gateway) {
        this.name = name;
        this.networkAddress = networkAddress;
        this.subnetMask = subnetMask;
        this.firstHost = firstHost;
        this.lastHost = lastHost;
        this.broadcastAddress = broadcastAddress;
        this.gateway = gateway;
    }

    public String getName() {
        return name;
    }

    public String getNetworkAddress() {
        return networkAddress;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public String getFirstHost() {
        return firstHost;
    }

    public String getLastHost() {
        return lastHost;
    }

    public String getBroadcastAddress() {
        return broadcastAddress;
    }

    public String getGateway() {
        return gateway;
    }
}
