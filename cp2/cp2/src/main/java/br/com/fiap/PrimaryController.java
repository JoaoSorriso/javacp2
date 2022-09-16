package br.com.fiap;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.fiap.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController implements Initializable{
    @FXML private TextField textFieldTitulo;
    @FXML private TextField textFieldGenero;
    @FXML private TextField textFieldDescricao;
    @FXML private TextField textFieldNota;
    @FXML private ChoiceBox<String> choiceBoxZerado;

    @FXML private ListView<Usuario> listView;

    private List<Usuario> lista = new ArrayList<>();

    public void salvar() throws Exception{
        validarContaDoFormulario();
        limparFormulario();
        atualizarListView();
    }
    private void atualizarListView() {
        listView.getItems().clear();
        listView.getItems().addAll(lista);
    }

    private void limparFormulario() {
        textFieldTitulo.setText("");
        textFieldGenero.setText("");
        textFieldDescricao.setText("");
        textFieldNota.setText("");
        choiceBoxZerado.getSelectionModel().clearSelection();;
    }

    private void mostraAlerta(String mensagem) {
        var alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(mensagem);
        alert.show();
    }

    private Usuario carregarDadosDoFormulario(String titulo, String genero, String descricao, double nota, String zerado) {
            return new Usuario(titulo, genero, descricao, nota, zerado);            
    }

    private void validarContaDoFormulario() throws Exception {
        try {
            String titulo = textFieldTitulo.getText();
            String genero = textFieldGenero.getText();
            String descricao = textFieldDescricao.getText();
            double nota = Double.valueOf(textFieldNota.getText());
            String zerado = choiceBoxZerado.getValue();
            if (nota < 0 || nota > 10) {
                throw new IllegalArgumentException();
            }
            if (titulo == null || genero == null || descricao == null || zerado == null) {
                throw new NullPointerException();
            }
            lista.add(carregarDadosDoFormulario(titulo, genero, descricao, nota, zerado));
            mostraAlerta("Conta cadastrada com sucesso");

            } catch (NumberFormatException e) {
                mostraAlerta(
                        "Todos os dados devem preenchidos");
            } catch (IllegalArgumentException e) {
                mostraAlerta("A nota não deve ser maior que 10 e menor que 0.");
            } catch (NullPointerException e) {
                mostraAlerta("Nenhum campo pode ser vazio");
            }
        }

    public void ordenarPorNota(){
        lista.sort((o1, o2) -> Double.compare(o1.getNota(), o2.getNota()));
        atualizarListView();
    }

    public void ordenarPorGenero(){
        lista.sort((o1, o2) -> o1.getGenero().compareTo(o2.getGenero()) );
        atualizarListView();
    }

    public void ordenarPorTitulo(){
        lista.sort((o1, o2) -> o1.getTitulo().compareTo(o2.getTitulo()) );
        atualizarListView();
    }

    public void ordenarPorZerado(){
        lista.sort((o1, o2) -> o1.getZerado().compareTo(o2.getZerado()) );
        atualizarListView();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBoxZerado.getItems().addAll("Zerado", "Não zerado");
    }
}
