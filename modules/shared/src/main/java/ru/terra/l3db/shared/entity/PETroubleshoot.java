package ru.terra.l3db.shared.entity;

/**
 * Date: 24.06.15
 * Time: 11:33
 */
public interface PETroubleshoot {
    public void Connect2PE(String peName);

    public void getPeType();

    public void checkArpTable(String ipAddress);

    public void checkBGPsession(String ipAddress, String BGPasNumber);

    public void checkInterfaceCounters(String pe_inteface_name);

    public void simplePingText(String pe_inteface_name, String ce_ip_address);

    public void advancedPingTest(String ce_ip_address, String vrf, String packet_qty, String pattern, String packetSize, String fastOption);

    public void getInterfaceConfiguration(String pe_inteface_name);
}
