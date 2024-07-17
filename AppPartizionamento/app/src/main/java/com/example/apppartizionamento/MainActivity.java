package com.example.apppartizionamento;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText ipInput;
    private EditText hostsInput;
    private Button calculateButton;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipInput = findViewById(R.id.ipInput);
        hostsInput = findViewById(R.id.hostsInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultView = findViewById(R.id.resultView);

        calculateButton.setOnClickListener(v -> {
            String ipAddress = ipInput.getText().toString();
            String hostsData = hostsInput.getText().toString();

            if (ipAddress.isEmpty() || hostsData.isEmpty()) {
                resultView.setText("Please enter both IP address and hosts information.");
                return;
            }

            String results = calculateSubnets(ipAddress, hostsData);
            resultView.setText(results);
        });
    }

    private String calculateSubnets(String ipAddress, String hostsData) {
        StringBuilder results = new StringBuilder();

        String[] ipParts = ipAddress.split("/");
        if (ipParts.length != 2) {
            return "Invalid IP address format. Please enter in CIDR notation.";
        }

        String baseIp = ipParts[0];
        int prefix = Integer.parseInt(ipParts[1]);

        String[] hostsInfo = hostsData.split(",");
        List<SubnetInfo> hostsRequired = new ArrayList<>();

        for (String info : hostsInfo) {
            String[] parts = info.split(";");
            int hosts = Integer.parseInt(parts[0]);
            String name = parts.length > 1 ? parts[1] : "Subnet " + (hostsRequired.size() + 1);
            hostsRequired.add(new SubnetInfo(hosts, name));
        }

        // Calculate the subnets
        SubnetCalculator calculator = new SubnetCalculator();
        List<Subnet> subnets = calculator.createSubnets(baseIp, prefix, hostsRequired);

        // Print the results
        for (Subnet subnet : subnets) {
            results.append("Subnet: ").append(subnet.getName()).append("\n")
                    .append("Network Address: ").append(subnet.getNetworkAddress()).append("\n")
                    .append("Subnet Mask: ").append(subnet.getSubnetMask()).append("\n")
                    .append("First Host: ").append(subnet.getFirstHost()).append("\n")
                    .append("Last Host: ").append(subnet.getLastHost()).append("\n")
                    .append("Broadcast Address: ").append(subnet.getBroadcastAddress()).append("\n")
                    .append("Gateway: ").append(subnet.getGateway()).append("\n\n");
        }

        return results.toString();
    }
}
