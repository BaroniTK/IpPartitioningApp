package com.example.apppartizionamento;

import java.util.ArrayList;
import java.util.List;

public class SubnetCalculator {

    public List<Subnet> createSubnets(String baseIp, int prefix, List<SubnetInfo> hostsRequired) {
        List<Subnet> subnets = new ArrayList<>();

        // Convert the base IP to an integer
        int baseIpInt = ipToInt(baseIp);

        // Calculate the initial subnet mask and total number of IPs
        int initialSubnetMask = 32 - prefix;
        int totalIps = (int) Math.pow(2, initialSubnetMask);

        // Initialize the current IP to the base IP
        int currentIp = baseIpInt;

        // Loop through each requirement and create the subnets
        for (SubnetInfo info : hostsRequired) {
            int requiredHosts = info.getHosts();
            int subnetSize = calculateSubnetSize(requiredHosts);
            int subnetMask = 32 - (int) (Math.log(subnetSize) / Math.log(2));

            String networkAddress = intToIp(currentIp);
            String subnetMaskStr = intToIp(~((1 << (32 - subnetMask)) - 1));
            String firstHost = intToIp(currentIp + 1);
            String lastHost = intToIp(currentIp + subnetSize - 2);
            String broadcastAddress = intToIp(currentIp + subnetSize - 1);
            String gateway = intToIp(currentIp + 1);

            subnets.add(new Subnet(info.getName(), networkAddress, subnetMaskStr, firstHost, lastHost, broadcastAddress, gateway));

            currentIp += subnetSize;
        }

        return subnets;
    }

    private int ipToInt(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        return (Integer.parseInt(parts[0]) << 24) | (Integer.parseInt(parts[1]) << 16) | (Integer.parseInt(parts[2]) << 8) | Integer.parseInt(parts[3]);
    }

    private String intToIp(int ip) {
        return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
    }

    private int calculateSubnetSize(int requiredHosts) {
        int subnetSize = 2;
        while (subnetSize - 2 < requiredHosts) {
            subnetSize *= 2;
        }
        return subnetSize;
    }
}
