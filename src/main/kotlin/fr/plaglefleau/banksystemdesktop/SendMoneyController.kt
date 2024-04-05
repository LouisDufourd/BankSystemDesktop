package fr.plaglefleau.banksystemdesktop

import fr.plaglefleau.banksystemdesktop.MainApplication.lang
import fr.plaglefleau.banksystemdesktop.MainApplication.stage
import javafx.scene.control.Button
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class SendMoneyController : Controller() {

    lateinit var scene: AnchorPane

    lateinit var titleLabel: Label
    lateinit var amountLabel: Label
    lateinit var targetAccountLabel: Label
    lateinit var sourceAccountLabel: Label

    lateinit var sendMoneyButton: Button
    lateinit var settingsButton: Button
    lateinit var backButton: Button

    lateinit var amountTextField: TextField
    lateinit var targetAccountTextField: TextField

    lateinit var sourceAccountComboBox: ComboBox<String>

    override var previousTitleWidth = 0.0

    @OptIn(DelicateCoroutinesApi::class)
    override fun updateLabelsPosition() {
        GlobalScope.launch {
            previousTitleWidth = placeLabelToCenter(previousTitleWidth, titleLabel, scene)
        }
    }
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        amountTextField.textProperty().addListener { _, _, newValue ->
            if (!newValue.matches(doubleRegex) && newValue != "") {
                if(newValue[newValue.length-1] == ',' || newValue[newValue.length-1] == '.') {
                    amountTextField.text += "00"
                } else {
                    amountTextField.style += "-fx-border-color: red;"
                }
            } else {
                amountTextField.style += "-fx-border-color: rgb(186,186,186);"
            }
            canSendMoney()
        }
        targetAccountTextField.textProperty().addListener { _, _, newValue ->
            if (!newValue.matches(integerRegex) && newValue != "") {
                targetAccountTextField.style += "-fx-border-color: red;"
            } else {
                targetAccountTextField.style += "-fx-border-color: rgb(186,186,186);"
            }
            canSendMoney()
        }
        sourceAccountComboBox.valueProperty().addListener { _, _, _ ->
            canSendMoney()
        }
        canSendMoney()
        updateLang()
        updateLabelsPosition()
    }
    override fun updateLang() {
        stage.title = translator.getTraduction(lang,"title.send_money")
        titleLabel.text = translator.getTraduction(lang, "title.send_money")
        sourceAccountLabel.text = translator.getTraduction(lang, "label.source_account")
        targetAccountLabel.text = translator.getTraduction(lang, "label.target_account")
        amountLabel.text = translator.getTraduction(lang, "label.amount")
        backButton.text = translator.getTraduction(lang, "button.back")
        settingsButton.text = translator.getTraduction(lang, "button.settings")
        sendMoneyButton.text = translator.getTraduction(lang, "button.send_money")
        targetAccountTextField.promptText = translator.getTraduction(lang, "prompt.target_account")
        amountTextField.promptText = translator.getTraduction(lang, "prompt.amount")
    }

    fun onClickBack(mouseEvent: MouseEvent) {
        showMainPage()
    }
    fun onClickSettings(mouseEvent: MouseEvent) {
        showSettings()
    }
    fun onClickSendMoney(mouseEvent: MouseEvent) {
        showMainPage()
    }

    fun onKeyPressedBack(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showMainPage()
        }
    }
    fun onKeyPressedSettings(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showSettings()
        }
    }
    fun onKeyPressedSendMoney(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showMainPage()
        }
    }

    private fun canSendMoney() {
        val sourceAccount = sourceAccountComboBox.value
        if(sourceAccount == null) {
            sendMoneyButton.isDisable = true
        } else {
            sendMoneyButton.isDisable = !(amountTextField.text.matches(doubleRegex) && targetAccountTextField.text.matches(integerRegex) && sourceAccount.matches(integerRegex))
        }
    }
}