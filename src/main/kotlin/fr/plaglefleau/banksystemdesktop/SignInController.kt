package fr.plaglefleau.banksystemdesktop

import fr.plaglefleau.api.Api
import fr.plaglefleau.banksystemdesktop.MainApplication.lang
import fr.plaglefleau.banksystemdesktop.MainApplication.stage
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*


class SignInController: Controller() {

    lateinit var scene: AnchorPane

    lateinit var titleLabel: Label
    lateinit var errorLabel: Label
    lateinit var usernameLabel: Label
    lateinit var passwordLabel: Label

    lateinit var registerButton: Button
    lateinit var settingsButton: Button
    lateinit var signInButton: Button

    lateinit var passwordField: PasswordField

    lateinit var usernameTextField: TextField

    private var previousErrorWidth = 0.0
    override var previousTitleWidth = 0.0

    fun onKeyPressedSignIn(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            signIn()
        }
    }
    fun onKeyPressedSettings(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showSettings()
        }
    }
    fun onKeyPressedRegister(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showRegister()
        }
    }

    fun onClickSignIn(mouseEvent: MouseEvent) {
        signIn()
    }
    fun onClickSettings(mouseEvent: MouseEvent) {
        showSettings()
    }
    fun onClickRegister(mouseEvent: MouseEvent) {
        showRegister()
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
        stage.title = translator.getTraduction(lang,"title.sign_in")
        usernameLabel.text = "${translator.getTraduction(lang, "label.username")} : "
        passwordLabel.text = "${translator.getTraduction(lang, "label.password")} : "
        settingsButton.text = translator.getTraduction(lang, "button.settings")
        signInButton.text = translator.getTraduction(lang, "button.sign_in")
        registerButton.text = translator.getTraduction(lang, "button.register")
        usernameTextField.promptText = translator.getTraduction(lang, "prompt.username")
        passwordField.promptText = translator.getTraduction(lang, "prompt.password")
        titleLabel.text = translator.getTraduction(lang,"title.sign_in")
        if(errorLabel.text != "") {
            errorLabel.text = translator.getTraduction(lang, "label.error.sign_in")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun signIn() {
        GlobalScope.launch {
            val response = Api.bankApi.login(usernameTextField.text, passwordField.text).execute()
            when(response.code()) {
                200 -> {
                    showMainPage()
                    return@launch
                }
                403 -> {
                    errorLabel.text = translator.getTraduction(lang, "label.error.sign_in")
                }
                else -> {
                    errorLabel.text = translator.getTraduction(lang, "label.error.server_unreachable")
                }
            }
            updateLabelsPosition()
        }
    }
}