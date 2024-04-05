package fr.plaglefleau.banksystemdesktop;

import fr.plaglefleau.translate.Translation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;


public class MainApplication extends Application {

    public static String lang = "en";

    public static Stage stage;

    @Override
    public void start(@NotNull Stage stage) throws IOException {
        MainApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("sign-in.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(new Translation().getTraduction(lang, "title.sign_in"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        setupLang();
        launch();
    }

    public static void setupLang() {
        setupLangEn();
        setupLangFr();
    }
    public static void setupLangEn() {
        try {
            Translation translator = new Translation();

            //LABELS
            translator.setTraduction("en", "label.username", "Username");
            translator.setTraduction("en", "label.password", "Password");
            translator.setTraduction("en", "label.error.sign_in", "Wrong username or password");
            translator.setTraduction("en", "label.error.missing_parameters", "You have to fill all the fields");
            translator.setTraduction("en", "label.error.user_already_exist", "Username already used");
            translator.setTraduction("en", "label.error.server_unreachable", "Server not accessible");
            translator.setTraduction("en", "label.firstname", "Firstname");
            translator.setTraduction("en", "label.lastname", "Lastname");
            translator.setTraduction("en", "label.address", "Address");
            translator.setTraduction("en", "label.birthday", "Birthday");
            translator.setTraduction("en", "label.balance", "Total Balance");
            translator.setTraduction("en", "label.source_account", "Source account");
            translator.setTraduction("en", "label.target_account", "Target Account");

            //BUTTONS
            translator.setTraduction("en", "button.settings", "Settings");
            translator.setTraduction("en", "button.sign_in", "Sign In");
            translator.setTraduction("en", "button.register", "Register");
            translator.setTraduction("en", "button.cancel", "Cancel");
            translator.setTraduction("en", "button.log_off", "Log off");
            translator.setTraduction("en", "button.my_accounts", "My accounts");
            translator.setTraduction("en", "button.send_money", "Send Money");
            translator.setTraduction("en", "button.back", "Back");

            //PROMPTS
            translator.setTraduction("en", "prompt.username", "Type your username");
            translator.setTraduction("en", "prompt.password", "Type your password");
            translator.setTraduction("en", "prompt.firstname", "Type your firstname");
            translator.setTraduction("en", "prompt.lastname", "Type your lastname");
            translator.setTraduction("en", "prompt.address", "Type your address");
            translator.setTraduction("en", "prompt.birthday", "DD/MM/YYYY");
            translator.setTraduction("en", "prompt.target_account", "Enter the target account number");
            translator.setTraduction("en", "prompt.amount", "Enter the amount of money you want to transfert");

            //TITLES
            translator.setTraduction("en", "title.sign_in", "Sign in");
            translator.setTraduction("en", "title.register", "Register");
            translator.setTraduction("en", "title.main_page", "My Account");
            translator.setTraduction("en", "title.send_money", "Send money");
            translator.setTraduction("en", "label.amount", "Amount");
            translator.setTraduction("en", "title.my_accounts", "My accounts");

            //LANGUAGES
            translator.setTraduction("en", "lang.english", "English");
            translator.setTraduction("en", "lang.french", "French");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void setupLangFr() {
        try {
            Translation translator = new Translation();

            //LABELS
            translator.setTraduction("fr", "label.username", "Nom d'utilisateur");
            translator.setTraduction("fr", "label.password", "Mots de passe");
            translator.setTraduction("fr", "label.error.sign_in", "Mauvais nom d'utilisateur ou mots de passe");
            translator.setTraduction("fr", "label.error.missing_parameters", "Vous devez remplir tous les champs");
            translator.setTraduction("fr", "label.error.user_already_exist", "Nom d'utilisateur déjà utilisé");
            translator.setTraduction("fr", "label.error.server_unreachable", "Le serveur n'est pas accessible");
            translator.setTraduction("fr", "label.firstname", "Prénom");
            translator.setTraduction("fr", "label.lastname", "Nom de famille");
            translator.setTraduction("fr", "label.address", "Adresse");
            translator.setTraduction("fr", "label.birthday", "Date de naissance");
            translator.setTraduction("fr", "label.balance", "Solde total");
            translator.setTraduction("fr", "label.source_account", "Compte source");
            translator.setTraduction("fr", "label.target_account", "Compte cible");
            translator.setTraduction("fr", "label.amount", "Montant");

            //BUTTONS
            translator.setTraduction("fr", "button.settings", "Paramètres");
            translator.setTraduction("fr", "button.sign_in", "Connection");
            translator.setTraduction("fr", "button.register", "Inscription");
            translator.setTraduction("fr", "button.cancel", "Annuler");
            translator.setTraduction("fr", "button.log_off", "Déconnexion");
            translator.setTraduction("fr", "button.my_accounts", "Mes comptes");
            translator.setTraduction("fr", "button.send_money", "Envoyez de l'argents");
            translator.setTraduction("fr", "button.back", "Retour");

            //PROMPTS
            translator.setTraduction("fr", "prompt.username", "Taper votre nom d'utilisateur");
            translator.setTraduction("fr", "prompt.password", "Taper votre mots de passe");
            translator.setTraduction("fr", "prompt.firstname", "Taper votre prénom");
            translator.setTraduction("fr", "prompt.lastname", "Taper votre nom de famille");
            translator.setTraduction("fr", "prompt.address", "Taper votre adresse");
            translator.setTraduction("fr", "prompt.birthday", "JJ/MM/AAAA");
            translator.setTraduction("fr", "prompt.target_account", "Saisissez le numéro de compte de la cible");
            translator.setTraduction("fr", "prompt.amount", "Saisissez le montant que vous souhaitez transférer");

            //TITLES
            translator.setTraduction("fr", "title.sign_in", "Connection");
            translator.setTraduction("fr", "title.register", "Inscription");
            translator.setTraduction("fr", "title.main_page", "Mon Compte");
            translator.setTraduction("fr", "title.send_money", "Envoyer de l'argents");
            translator.setTraduction("fr", "title.my_accounts", "Mes Comptes");

            //LANGUAGES
            translator.setTraduction("fr", "lang.english", "Anglais");
            translator.setTraduction("fr", "lang.french", "Français");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}