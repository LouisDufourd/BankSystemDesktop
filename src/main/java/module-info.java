module fr.plaglefleau.banksystemdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires TranslationLibrary.main;
    requires kotlinx.coroutines.core;
    requires org.jetbrains.annotations;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires com.google.gson;

    opens fr.plaglefleau.banksystemdesktop to javafx.fxml, com.google.gson;
    exports fr.plaglefleau.banksystemdesktop;
}