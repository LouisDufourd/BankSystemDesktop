package fr.plaglefleau.banksystemdesktop

import fr.plaglefleau.banksystemdesktop.MainApplication.lang
import fr.plaglefleau.banksystemdesktop.MainApplication.stage
import fr.plaglefleau.translate.Translation
import javafx.beans.value.ObservableValue
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.control.ButtonType
import javafx.scene.control.ChoiceBox
import javafx.scene.control.Dialog
import javafx.scene.control.Label
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

abstract class Controller: Initializable {
    val doubleRegex = Regex("^-?\\d+([.,]\\d{1,2})?\$")
    val integerRegex = Regex("^-?\\d+\$")
    val enterKey = 10
    val translator = Translation()
    abstract var previousTitleWidth:Double
    abstract fun updateLang()
    abstract fun updateLabelsPosition()
    fun placeLabelToCenter(previousLabelWidth: Double, label: Label, scene: Pane): Double {
        var i = 0
        while (previousLabelWidth == label.width || label.width == 0.0) {
            try {
                Thread.sleep(100)
                i++
                if (i >= 150) {
                    println("couldn't found")
                    return 0.0
                }
            } catch (e: InterruptedException) {
                System.err.println(e.message)
                return 0.0
            }
        }
        val pos = (scene.width - label.width) / 2
        label.layoutX = pos
        return label.width
    }
    fun showSettings() {
        val okButtonType = ButtonType("OK")

        val translator = Translation()

        val english = translator.getTraduction(lang, "lang.english")
        val french = translator.getTraduction(lang, "lang.french")

        // Create a ChoiceBox
        val choiceBox = ChoiceBox<String>()
        choiceBox.items.addAll(english, french)
        when (lang) {
            "fr" -> choiceBox.setValue(french)
            "en" -> choiceBox.setValue(english)
        }
        // Create a Dialog
        val dialog = Dialog<String?>()
        dialog.title = "Select an Option"
        dialog.dialogPane.buttonTypes.addAll(okButtonType, ButtonType.CANCEL)
        dialog.dialogPane.content = VBox(choiceBox)


        // Enable/disable OK button based on choice selection
        dialog.dialogPane.lookupButton(okButtonType).isDisable = true
        choiceBox.selectionModel.selectedItemProperty()
            .addListener { _: ObservableValue<out String>?, _: String?, newValue: String? ->
                dialog.dialogPane.lookupButton(okButtonType).isDisable = newValue == null
            }


        // Set the result converter
        dialog.setResultConverter { buttonType: ButtonType ->
            if (buttonType == okButtonType) {
                return@setResultConverter choiceBox.value
            }
            null
        }


        // Show the dialog and wait for user input
        val result = dialog.showAndWait()


        // Process the result
        result.ifPresent { selectedOption: String? ->
            when (selectedOption) {
                translator.getTraduction(lang, "lang.english") -> lang = "en"
                translator.getTraduction(lang, "lang.french") -> lang = "fr"
            }
        }
        updateLang()
        updateLabelsPosition()
    }
    fun showSignIn() {
        val fxmlLoader = FXMLLoader(MainApplication::class.java.getResource("sign-in.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = translator.getTraduction(lang, "title.sign_in")
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
    fun showRegister() {
        val fxmlLoader = FXMLLoader(MainApplication::class.java.getResource("register.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = translator.getTraduction(lang, "title.register")
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
    fun showSendMoney() {
        val fxmlLoader = FXMLLoader(MainApplication::class.java.getResource("send-money.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = translator.getTraduction(lang, "title.send_money")
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
    fun showMyAccounts() {
        val fxmlLoader = FXMLLoader(MainApplication::class.java.getResource("my-accounts.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = translator.getTraduction(lang, "title.my_accounts")
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
    fun showMainPage() {
        val fxmlLoader = FXMLLoader(MainApplication::class.java.getResource("main-page.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = translator.getTraduction(lang, "title.main-page")
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
}