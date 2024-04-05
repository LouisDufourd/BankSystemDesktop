package fr.plaglefleau.banksystemdesktop

import fr.plaglefleau.banksystemdesktop.MainApplication.lang
import fr.plaglefleau.banksystemdesktop.MainApplication.stage
import javafx.scene.control.*
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class RegisterController : Controller() {
    lateinit var scene: AnchorPane

    lateinit var settingsButton: Button
    lateinit var registerButton: Button
    lateinit var cancelButton: Button

    lateinit var firstNameTextField: TextField
    lateinit var lastNameTextField: TextField
    lateinit var addressTextField: TextField
    lateinit var usernameTextField: TextField

    lateinit var passwordField: PasswordField

    lateinit var birthdayTextField: DatePicker

    lateinit var titleLabel: Label
    lateinit var firstNameLabel: Label
    lateinit var lastNameLabel: Label
    lateinit var addressLabel: Label
    lateinit var birthdayLabel: Label
    lateinit var usernameLabel: Label
    lateinit var passwordLabel: Label
    lateinit var errorLabel: Label

    override var previousTitleWidth = 0.0
    private var previousErrorWidth = 0.0
    private var currentError = 0


    fun onClickRegister(mouseEvent: MouseEvent) {
        register()
    }
    fun onClickSettings(mouseEvent: MouseEvent) {
        showSettings()
    }
    fun onClickCancel(mouseEvent: MouseEvent) {
        showSignIn()
    }

    fun onKeyPressedRegister(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            register()
        }
    }
    fun onKeyPressedSettings(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showSettings()
        }
    }
    fun onKeyPressedCancel(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showSignIn()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun updateLabelsPosition() {
        GlobalScope.launch {
            previousTitleWidth = placeLabelToCenter(previousTitleWidth, titleLabel, scene)
            previousErrorWidth = placeLabelToCenter(previousErrorWidth, errorLabel, scene)
        }
    }
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        updateLang()
        updateLabelsPosition()
    }
    override fun updateLang() {
        stage.title = translator.getTraduction(lang,"title.register")
        firstNameLabel.text = "${translator.getTraduction(lang, "label.firstname")} : "
        lastNameLabel.text = "${translator.getTraduction(lang, "label.lastname")} : "
        addressLabel.text = "${translator.getTraduction(lang, "label.address")} : "
        birthdayLabel.text = "${translator.getTraduction(lang, "label.birthday")} : "
        usernameLabel.text = "${translator.getTraduction(lang, "label.username")} : "
        passwordLabel.text = "${translator.getTraduction(lang, "label.password")} : "

        firstNameTextField.promptText = translator.getTraduction(lang, "prompt.firstname")
        lastNameTextField.promptText = translator.getTraduction(lang, "prompt.lastname")
        addressTextField.promptText = translator.getTraduction(lang, "prompt.address")
        birthdayTextField.promptText = translator.getTraduction(lang, "prompt.birthday")
        usernameTextField.promptText = translator.getTraduction(lang, "prompt.username")
        passwordField.promptText = translator.getTraduction(lang, "prompt.password")
        registerButton.text = translator.getTraduction(lang, "button.register")
        cancelButton.text = translator.getTraduction(lang, "button.cancel")
        passwordField.promptText = translator.getTraduction(lang, "prompt.password")
        titleLabel.text = translator.getTraduction(lang, "title.register")
        println(currentError)
        if(currentError != 0) {
            when(currentError) {
                1 -> errorLabel.text = translator.getTraduction(lang, "label.error.user_already_exist")
                2 -> errorLabel.text = translator.getTraduction(lang, "label.error.missing_parameters")
                else -> return
            }
        }
    }


    private fun register() {
        if(firstNameTextField.text != "" && lastNameTextField.text != ""
            && addressTextField.text != "" && birthdayTextField.valueProperty().get() != null
            && usernameTextField.text != "" && passwordField.text != ""
        ) {
            showSignIn()
        } else {
            errorLabel.text = translator.getTraduction(lang, "label.error.missing_parameters")
            currentError = 2
            if(firstNameTextField.text == "") {
                firstNameTextField.style += "-fx-border-color: red;"
            } else {
                firstNameTextField.style += "-fx-border-color: rgb(186,186,186);"
            }
            if(lastNameTextField.text == "") {
                lastNameTextField.style += "-fx-border-color: red;"
            } else {
                lastNameTextField.style += "-fx-border-color: rgb(186,186,186);"
            }
            if(addressTextField.text == "") {
                addressTextField.style += "-fx-border-color: red;"
            } else {
                addressTextField.style += "-fx-border-color: rgb(186,186,186);"
            }
            if(birthdayTextField.valueProperty().get() == null) {
                birthdayTextField.style += "-fx-border-color: red;"
            } else {
                birthdayTextField.style += "-fx-border-color: rgb(186,186,186);"
            }
            if(usernameTextField.text == "") {
                usernameTextField.style += "-fx-border-color: red;"
            } else {
                usernameTextField.style += "-fx-border-color: rgb(186,186,186);"
            }
            if(passwordField.text == "") {
                passwordField.style += "-fx-border-color: red;"
            } else {
                passwordField.style = "-fx-border-color: rgb(186,186,186);"
            }

            updateLabelsPosition()
        }
    }
}
