package ru.terra.l3db.shared.entity;

/**
 * Date: 24.06.15
 * Time: 11:33
 */
public abstract class PETroubleshoot extends Configurable {
    public abstract void Connect2PE(String peName);

    public abstract void getPeType();

    public abstract void checkArpTable(String ipAddress);

    public abstract void checkBGPsession(String ipAddress, String BGPasNumber);

    public abstract void checkInterfaceCounters(String pe_inteface_name);

    public abstract void simplePingText(String vrf, String ce_ip_address, String packetQTY);

    public abstract void advancedPingTest(String ce_ip_address, String vrf, String packet_qty, String pattern, String packetSize, String fastOption);

    public abstract void getInterfaceConfiguration(String pe_inteface_name);
}
