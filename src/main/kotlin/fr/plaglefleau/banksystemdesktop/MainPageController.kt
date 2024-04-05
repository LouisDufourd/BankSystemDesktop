package fr.plaglefleau.banksystemdesktop

import fr.plaglefleau.banksystemdesktop.MainApplication.lang
import fr.plaglefleau.banksystemdesktop.MainApplication.stage
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class MainPageController: Controller() {
    lateinit var scene: AnchorPane
    lateinit var balanceLabel: Label
    lateinit var titleLabel: Label
    lateinit var logOffButton: Button
    lateinit var myAccountsButton: Button
    lateinit var sendMoneyButton: Button
    lateinit var parametersButton: Button
    override var previousTitleWidth = 0.0
    private var previousBalancePosition = 0.0

    fun onClickSettings(mouseEvent: MouseEvent) {
        showSettings()
    }
    fun onClickSendMoney(mouseEvent: MouseEvent) {
        showSendMoney()
    }
    fun onClickMyAccounts(mouseEvent: MouseEvent) {
        showMyAccounts()
    }
    fun onClickLogOff(mouseEvent: MouseEvent) {
        showSignIn()
    }

    fun onKeyPressedSettings(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showSettings()
        }
    }
    fun onKeyPressedSendMoney(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showSendMoney()
        }
    }
    fun onKeyPressedMyAccounts(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showMyAccounts()
        }
    }
    fun onKeyPressedLogOff(keyEvent: KeyEvent) {
        if(keyEvent.code.code == enterKey) {
            showSignIn()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun updateLabelsPosition() {
        GlobalScope.launch {
            previousTitleWidth = placeLabelToCenter(previousTitleWidth, titleLabel, scene)
            previousBalancePosition = placeLabelToCenter(previousBalancePosition, balanceLabel, scene)
        }
    }
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        updateLang()
        updateLabelsPosition()
    }
    @OptIn(DelicateCoroutinesApi::class)
    override fun updateLang() {
        stage.title = translator.getTraduction(lang,"title.main_page")
        titleLabel.text = translator.getTraduction(lang, "title.main_page")
        parametersButton.text = translator.getTraduction(lang, "button.settings")
        GlobalScope.launch {
            balanceLabel.text = "${translator.getTraduction(lang, "label.balance")} 500,00 €"
        }
        myAccountsButton.text = translator.getTraduction(lang, "button.my_accounts")
        sendMoneyButton.text = translator.getTraduction(lang, "button.send_money")
        logOffButton.text = translator.getTraduction(lang, "button.log_off")
    }
}