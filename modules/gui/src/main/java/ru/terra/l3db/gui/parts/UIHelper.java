package ru.terra.l3db.gui.parts;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.terra.l3db.gui.C;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 12.05.14
 * Time: 14:05
 */
public class UIHelper {

    private static Map<String, ImageView> images = new HashMap<>();

    public static ImageView createImage(String name) {
        ImageView ret = images.get(name);
        if (ret == null) {
            ret = new ImageView(new Image(AbstractUIController.class.getResourceAsStream(C.IMAGES + name)));
            images.put(name, ret);
        }
        return ret;
    }
}
