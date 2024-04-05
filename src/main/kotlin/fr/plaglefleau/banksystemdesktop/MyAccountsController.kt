package fr.plaglefleau.banksystemdesktop

import fr.plaglefleau.banksystemdesktop.MainApplication.lang
import fr.plaglefleau.banksystemdesktop.MainApplication.stage
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*

class MyAccountsController: Controller() {

    lateinit var scene: AnchorPane
    lateinit var titleLabel: Label
    lateinit var accountsListView: ListView<Any>
    lateinit var settingsButton: Button
    lateinit var backButton: Button
    override var previousTitleWidth: Double = 0.0

    @OptIn(DelicateCoroutinesApi::class)
    override fun updateLabelsPosition() {
        GlobalScope.launch {
            previousTitleWidth = placeLabelToCenter(previousTitleWidth, titleLabel, scene)
        }
    }
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        updateLang()
        updateLabelsPosition()
    }
    override fun updateLang() {
        stage.title = translator.getTraduction(lang,"title.my_accounts")
        titleLabel.text = translator.getTraduction(lang, "title.my_accounts")
        backButton.text = translator.getTraduction(lang, "button.back")
        settingsButton.text = translator.getTraduction(lang, "button.settings")
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

    fun onClickBack(mouseEvent: MouseEvent) {
        showMainPage()
    }
    fun onClickSettings(mouseEvent: MouseEvent) {
        showSettings()
    }
}