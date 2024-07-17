
# IpPartitioningApp

IpPartitioningApp is an Android application that allows users to calculate and visualize the subnets of a specified network. Users can input a base IP address with CIDR notation and host requirements for various subnets. The app calculates and displays the resulting subnets.

## Features

- Input a base IP address in CIDR notation
- Input the number of hosts required for each subnet, with an optional subnet name
- Calculate subnets and display subnet details, including network address, subnet mask, first and last host, broadcast address, and gateway

## Project Structure

- `MainActivity.java`: Handles the user interface and main operations
- `Subnet.java`: Class representing a subnet
- `SubnetCalculator.java`: Class containing the logic for subnet calculation
- `SubnetInfo.java`: Class representing the host requirements and optional subnet name
- `activity_main.xml`: User interface layout
- `icon`: Application icon

## Requirements

- Android Studio
- Android SDK

## Installation

1. Clone the repository:
   ```
   git clone https://github.com/your-username/AppPartizionamento.git
   ```

2. Open the project with Android Studio.

3. Build and run the application on an emulator or Android device.

## Usage

1. Enter a base IP address in CIDR notation in the "Enter Base IP Address/CIDR" field.
2. Enter the number of hosts required for each subnet in the "Enter Hosts Information" field, following the format `nHost;subnetName`, separating multiple subnets with a comma.
3. Click the "Calculate" button to calculate and display the subnets.

## Contributions

Contributions, bug reports, and feature requests are welcome! Feel free to open an issue or a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE.md) file for details.

## Contact

For any questions or information, please contact [baroni.buildati@gmail.com](mailto:baroni.buildati@gmail.com).
