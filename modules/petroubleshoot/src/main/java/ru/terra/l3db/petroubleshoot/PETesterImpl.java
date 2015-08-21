package ru.terra.l3db.petroubleshoot;

import ru.terra.l3db.shared.MainContext;
import ru.terra.l3db.shared.entity.Browser;
import ru.terra.l3db.shared.entity.PETroubleshoot;

/**
 * Date: 06.08.15
 * Time: 16:27
 */
public class PETesterImpl extends PETroubleshoot {
    private Browser browser;

    @Override
    public void Connect2PE(String peName) {
        browser = MainContext.getInstance().getBrowserManager().getBrowser();
        browser.openPage(configuration.peTestingConfiguration.testWebAddress);
        if (browser.isTextExists(configuration.peTestingConfiguration.testWebHeader)) {
            browser.chooseDropBoxElement(configuration.peTestingConfiguration.netSelectXpath, configuration.peTestingConfiguration.netSelectOptionName);
            browser.chooseDropBoxElement(configuration.peTestingConfiguration.peSelectXpath, peName);
        }
    }

    @Override
    public void getPeType() {

    }

    @Override
    public void checkArpTable(String ipAddress) {

    }

    @Override
    public void checkBGPsession(String ipAddress, String BGPasNumber) {

    }

    @Override
    public void checkInterfaceCounters(String pe_inteface_name) {

    }

    @Override
    public void simplePingText(String pe_inteface_name, String ce_ip_address, String packetQTY) {

    }

    @Override
    public void advancedPingTest(String ce_ip_address, String vrf, String packet_qty, String pattern, String packetSize, String fastOption) {

    }

    @Override
    public void getInterfaceConfiguration(String pe_inteface_name) {

    }
}
