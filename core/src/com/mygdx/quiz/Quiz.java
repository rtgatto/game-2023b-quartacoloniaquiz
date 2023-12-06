package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.quiz.events.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz extends Event {
    private String question;
    private List<String> options;
    private String correctOption;
    public ArrayList<Quiz> quizzes;

    public Quiz(String question, List<String> options, String correctOption, Texture quizTexture) {
        super(1);
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
        this.texture = quizTexture;
    }
    public Quiz(){
        super(1);
        quizzes = new ArrayList<>();
        createQuizzes();
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectOption(){
        return correctOption;
    }

    public List<String> getOptions() {
        return options;
    }

    public Quiz getRandomQuiz(){
        return quizzes.get((int) (Math.random() * quizzes.size()));
    }

    @Override
    public String getMessage(Player player) {
        return null;
    }

    @Override
    public void applyEvent(Player player) {

    }

    public void createQuizzes(){
        quizzes.add(new Quiz("Qual é a altura do Monte Grappa?",Arrays.asList("1) 465 metros","2) 470 metros","3) 475 metros","4) 480 metros","5) 485 metros"), "1) 465 metros",new Texture(Gdx.files.internal("img/monte_grappa.png"))));
        quizzes.add(new Quiz("Em que cidade da Quarta Colônia se encontra o Monte Grappa?",Arrays.asList("1) Faxinal do Soturno","2) Nova Palma","3) Dona Francisca","4) Ivorá","5) Silveira Martins"), "4) Ivorá",new Texture(Gdx.files.internal("img/monte_grappa.png"))));
        quizzes.add(new Quiz("Em que cidade da Quarta Colônia se encontra o Monumento do Imigrante Italiano?",Arrays.asList("1) Faxinal do Soturno","2) Nova Palma","3) Dona Francisca","4) Restinga Seca","5) Silveira Martins"), "5) Silveira Martins",new Texture(Gdx.files.internal("img/monumento_imigrante.png"))));
        quizzes.add(new Quiz("Em que cidade da Quarta Colônia se encontra a Cascata Cara de Índio?",Arrays.asList("1) Nova Palma","2) Ivorá","3) Dona Francisca","4) São João do Polêsine","5) Silveira Martins"), "2) Ivorá",new Texture(Gdx.files.internal("img/cascata_cara_indio.png"))));
        quizzes.add(new Quiz("Quantas cascatas tem a cidade de Ivorá?",Arrays.asList("1) 10","2) 12","3) 15","4) 17","5) 20"), "4) 17",new Texture(Gdx.files.internal("img/ivora.png"))));
        quizzes.add(new Quiz("Em qual cidade da Quarta Colônia nasceu Alberto Pasqualini?",Arrays.asList("1) Nova Palma","2) Dona Francisca","3) Ivorá","4) São João do Polêsine","5) Silveira Martins"), "3) Ivorá",new Texture(Gdx.files.internal("img/ivora.png"))));
        quizzes.add(new Quiz("Este lugar localizado a 10km de Ivorá possui trilhas que acessam a antiga 'roça' e possui o lema 'ver; escutar e sentir'. Trata-se do(a):",Arrays.asList("1) Monte Grapa","2) Monumento do Imigrante Italiano","3) Cerro da Figueira","4) Balneário Municipal Atílio Aléssio","5) Caminho da Harmonia"), "5) Caminho da Harmonia",new Texture(Gdx.files.internal("img/caminho_harmonia.png"))));
        quizzes.add(new Quiz("No topo do local a __________ simboliza a fé sem medidas do casal Claudio Casassola e Lourdes Pauletto. Dois devotos que idealizaram o espaço como agradecimento às graças recebidas. Os visitantes também podem escrever pedidos em um papel.",Arrays.asList("1) igreja matriz São Roque","2) Ermida de São Pio de Pietrelcina","3) Monumento do Imigrante Italiano -","4) Igreja da matriz","5) Santuário Mãe Rainha"), "2) Ermida de São Pio de Pietrelcina",new Texture(Gdx.files.internal("img/ermida_de_sao_pio_de_pietrelcina.png"))));
        quizzes.add(new Quiz("Este lugar remonta a história da imigração italiana com uma coleção de utensílios usados pelos primeiros que vieram viver na região. O lugar conta com objetos de uma casa da época; além de ferramentas da lavoura e itens da igreja como vestes sacerdotais. Trata-se do(a):",Arrays.asList("1) Museu Geringonça","2) Vale Vêneto","3) Recanto Maestro","4) Monumento do Imigrante Italiano","5) Museu Fotográfico"), "1) Museu Geringonça",new Texture(Gdx.files.internal("img/museu_geringonca.png"))));
        quizzes.add(new Quiz("Onde se encontra o Centro de Apoio à Pesquisa Paleontológica (Cappa)?",Arrays.asList("1) São João do Polêsine","2) Faxinal do Soturno","3) Agudo","4) Nova Palma","5) Santa Maria"), "1) São João do Polêsine",new Texture(Gdx.files.internal("img/cappa.png"))));
        quizzes.add(new Quiz("Quem fizer uma pausa no caminho da Ermida de São Pio de Pietrelcina é presenteado com a vista do __________. Localizado em uma altura de 528 metros ele permite uma visualização completa da cidade de __________ e de boa parte da região.",Arrays.asList("1) Monte Grappa - Nova Palma","2) Mirante do Cerro Comprido - Faxinal do Soturno","3) Cerro da Figueira - Agudo","4) Parque Histórico Municipal Obaldino Tessele - Dona Francisca","5) Pienezza Café - Ivorá"), "2) Mirante do Cerro Comprido - Faxinal do Soturno",new Texture(Gdx.files.internal("img/mirante_cerro_comprido.png"))));
        quizzes.add(new Quiz("É um dinossauro original da Quarta Colônia e está exposto no CAPPA:",Arrays.asList("1) Braquiossauro","2) Tiranossauro","3) Estegossauro","4) Bagualossauro","5) Mosassauro"), "4) Bagualossauro",new Texture(Gdx.files.internal("img/cappa.png"))));
        quizzes.add(new Quiz("É um dinossauro original da Quarta Colônia e está exposto no CAPPA:",Arrays.asList("1) Triceratope","2) Velociraptor","3) Buriolestes","4) Compsognato","5) Brontossauro"), "3) Buriolestes",new Texture(Gdx.files.internal("img/cappa.png"))));
        quizzes.add(new Quiz("Onde é considerado o berço da imigração italiana na região da Quarta Colônia?",Arrays.asList("1) Silveira Martins","2) Nova Palma","3) Vale Vêneto","4) Ivorá","5) Agudo"), "1) Silveira Martins",new Texture(Gdx.files.internal("img/silveira_martins.png"))));
        quizzes.add(new Quiz("Qual o local da Quarta Colônia que foi nomeado em homenagem à região dos imigrantes vindos do norte da Itália?",Arrays.asList("1) Ivorá","2) Itaara","3) Agudo","4) Silveira Martins","5) Vale Vêneto"), "5) Vale Vêneto",new Texture(Gdx.files.internal("img/vale_veneto.png"))));
        quizzes.add(new Quiz("Quem é considerado o fundador de Vale Vêneto?",Arrays.asList("1) Antonio Meneghetti","2) Paulo Bortoluzzi","3) Alberto Pasqualini","4) Gaspar da Silveira Martins","5) Luiz Sponchiado"), "2) Paulo Bortoluzzi",new Texture(Gdx.files.internal("img/vale_veneto.png"))));
        quizzes.add(new Quiz("Onde fica o Monumento do Imigrante Italiano?",Arrays.asList("1) Silveira Martins","2) Nova Palma","3) Vale Vêneto","4) Agudo","5) Restinga Sêca"), "1) Silveira Martins",new Texture(Gdx.files.internal("img/monumento_imigrante.png"))));
        quizzes.add(new Quiz("O __________ é um sítio que contempla o patrimônio cultural e abriga monumentos em homenagem a Giuseppe Garibaldi e Gaspar Silveira Martins; além do Obelisco em alusão aos 50 anos da imigração e o prédio do Antigo Colégio Bom Conselho; onde funciona o Espaço Multidisciplinar de Pesquisa e Extensão da Universidade Federal de Santa Maria (UFSM).",Arrays.asList("1) CAPPA","2) Museu Geringonça","3) Centro Histórico de Silveira Martins","4) Museu Fotográfico","5) Jardim Botânico"), "3) Centro Histórico de Silveira Martins",new Texture(Gdx.files.internal("img/silveira_martins.png"))));
    }
}