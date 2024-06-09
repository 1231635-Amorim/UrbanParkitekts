module pt.ipp.isep.dei.esoft.project.ui.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.apache.commons.lang3;
    requires eu.hansolo.tilesfx;
    requires java.logging;
    requires AuthLib;

    opens pt.ipp.isep.dei.esoft.project.ui.gui to javafx.fxml;
    exports pt.ipp.isep.dei.esoft.project.ui.gui;
}
