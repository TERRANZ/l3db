package ru.terra.l3db;

import ru.terra.l3db.gui.GuiMain;
import ru.terra.l3db.gui.stages.GuiWindow;
import ru.terra.l3db.shared.MainContext;

/**
 * Date: 15.06.15
 * Time: 11:03
 */
public class L3DBMain {
    private MainContext mainContext = MainContext.getInstance();
    private GuiWindow guiWindow;

    public void start(String... args) {
        GuiMain.main(args);
        guiWindow = GuiMain.getGuiWindow();
    }
}
