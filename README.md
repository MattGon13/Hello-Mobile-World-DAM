# Assignment 1 - Building Your First Android App
**Course:** Desenvolvimento de Aplicações Móveis (DAM)  
**Student(s):** Matilde Gonçalves (51706)  
**Date:** 08/03/2026  
**Repository URL:** `https://github.com/MattGon13/Hello-Mobile-World-DAM.git`


## 1. Introduction
Este trabalho tinha como objetivo desenvolver a nossa primeira aplicação móvel para o sistema operativo Android, de forma a nos familiarizar com o ambiente de desenvolvimento Android Studio, a linguagem Kotlin e o design de interfaces através de ficheiros XML (View system). Esta aplicação, deveria depois ser melhorada adicionando mais componentes (Views), formando uma nova versão da aplicação e permitindo explorar mais componentes do Android Studio.

## 2. System Overview
A solução consiste numa aplicação Android simples de ecrã único. A interface do utilizador, na primeira versão, apresenta mensagens simples ("Hello World"), tal como pedido do enunciado. Já na segunda versão, foram adicionadas mais componentes como TextViews (texto), ImageViews (imagens) e CalenderViews (calendários). Por fim, na última versão, foram adicionados mais três componentes: um Switch (interruptor), um Button (botão) e mais uma ImageView (imagem). O botão permite alterar as imagens que aparecem na aplicação e o switch permite alternar entre o modo claro e o modo escuro personalizado da aplicação, guardando as preferências do utilizador para utilizações futuras.
## 3. Architecture and Design
A aplicação segue a estrutura padrão gerada pela opção "Empty Views Activity" no Android Studio. 
* A arquitetura está dividida em duas camadas principais: a camada de apresentação visual (Layouts XML) e a camada organizacional e de lógica (Activity Kotlin). 
* A interface gráfica foi desenhada utilizando um `ConstraintLayout`, permitindo posicionar os elementos no ecrã através de restrições gráficas e criar designs responsivos sem a necessidade de aninhamento excessivo. 
* Para a persistência de dados (estado do modo escuro), optou-se pela utilização do padrão `SharedPreferences`, que armazena pares chave-valor localmente no dispositivo.

## 4. Implementation
A implementação encontra-se dividida fundamentalmente entre dois ficheiros, respeitando a separação de conceitos do Android:

**Interface Gráfica (`activity_main.xml`):**
* **TextViews:** Duas caixas de texto estruturadas verticalmente. A primeira com o texto extraído para os recursos (`@string/hello_world`) a roxo e em negrito. A segunda configurada dinamicamente para ocupar toda a largura (`0dp`) com um fundo amarelo.
* **ImageViews:** Foram utilizadas duas imagens sobrepostas (`r2d2` e `c3po`) armazenadas na pasta `drawable` e com descrições (`contentDescription`) para manter a acessibilidade. Cada imagem tinha uma visibilidade oposta à outra, ou seja, quando a primeira imagem se encontrava visível, a segunda encontrava-se invisível, de modo a poder-se fazer a comutação entre imagens.
* **CalendarView & Interatividade:** Inserção de um calendário base, acompanhado por um `Switch` (para alternar entre o modo escuro e claro) e um `Button` (para trocar imagens) configurados via sistema de restrições (`ConstraintLayout`). 
* **Modo escuro:** Adicionou-se no ficheiro “themes.xml (night)” um modo escuro personalizado para a aplicação e no ficheiro “themes.xml” um modo claro. Estes modos foram atribuídos a cada elemento no ficheiro “activity_main.xml”.
* **ícone personalizado:** Foi adicionado também um ícone à aplicação, mudando a imagem existente no ficheiro “ic_launcher”.

**Lógica (`MainActivity.kt`):**
* **Logcat:** Acrescentou-se ao método `onCreate` código para enviar uma mensagem dinâmica formatada (`activity_oncreate_msg`) para a consola Logcat.
* **Gestão do modo (modo escuro e claro):** Utilizou-se a API `SharedPreferences` em modo privado (`MODE_PRIVATE`) para verificar a preferência do utilizador quanto ao modo ("night_mode"). O método `AppCompatDelegate.setDefaultNightMode()` é invocado conforme o estado do switch, e o editor do SharedPreferences guarda (`apply()`) a nova seleção.
* **Comutação entre imagens:** O botão (Button) utiliza um `setOnClickListener` e uma variável de controlo booleana (`change`) para alternar a propriedade `visibility` entre `View.VISIBLE` e `View.INVISIBLE` para as duas imagens (R2D2 e C3PO).

* **Landscape layout:** Adicionalmente, foi criado um layout para caso o dispositivo estiver em modo paisagem (landscape), onde apenas se teve de reorganizar os elementos já existentes no layout original.

## 5. Testing and Validation
Para testar cada versão da aplicação, foi utilizado o emulador Android Virtual Device (AVD) configurado para o Pixel 9 Pro e API 34 (UpsideDownCake) e um dispositivo móvel Android físico. Adicionalmente foi utilizado o Logcat de modo a verificar se a mensagem enviada aparecia no log. A estratégia de teste passou por simplesmente visualizar nestes dispositivos se todos os componentes apareciam e produziam o resultado esperado na sua interação. 
Exemplos de tests cases que foram realizados foram verificar se a ativação do switch se traduzia na mudança para o modo escuro da aplicação e para o modo claro no caso da sua desativação e que ao sair da aplicação com o modo escuro ativado e voltar entrar na mesma, o modo escuro continuava ativo. Para o botão foi feito um test case parecido, onde apenas se clicava no botão e verificava-se se as imagens tinham mudado. 

## 6. Usage Instructions
1. Abrir o Android Studio (versão Panda 1 | 2025.3.1 ou superior) e selecionar `Open` apontando para a diretoria do projeto.
2. No Gestor de Dispositivos (Device Manager), iniciar um AVD (ex: Pixel 9 Pro) ou ligar um dispositivo android compatível por usb.
3. Clicar no botão "Play" (verde) na barra de ferramentas ou utilizar `Shift + F10` para compilar e instalar o APK no emulador.
4. Interagir com a interface

---

# Development Process

## 12. Version Control and Commit History
O desenvolvimento da aplicação foi seguido e guardado através de um repositório Git local. No início foi feito um commit inicial e à medida que era cumprida uma funcionalidade, era feito um commit. Infelizmente, como inicialmente pensei que apenas seria realizado um repositório para todos os exercícios do enunciado e depois tive de separar os exercícios em diferentes repositórios, perderam-se alguns commits e existem alguns commits baralhados.

## 13. Difficulties and Lessons Learned
* **Desafios:** O principal desafio envolveu a gestão e alinhamento do `ConstraintLayout`, em particular o processo de remover e adicionar restrições gráficas arrastando as âncoras sem sobrepor elementos. Adicionalmente, perceber o fluxo de edição assíncrono do `SharedPreferences.Editor` (`apply()` vs `commit()`) exigiu atenção especial.
* **Lições Retiradas:** Forte consolidação do conhecimento sobre como associar as *Views* criadas no XML às variáveis do Kotlin através de `findViewById`. Ficou clara a utilidade das propriedades dinâmicas extraídas para o ficheiro `strings.xml` para organizar as definições globais da aplicação.

O principal desafio sentido foi trabalhar no Android Studio, já que foi a primeira vez, e perceber para que servia cada ficheiro e design de interfaces através de ficheiros XML. Mas ao pesquisar mais sobre o assunto, essa dificuldade facilmente passou. Também achei complicado, inicialmente, perceber como é que passava os estilos que tinha feito nos ficheiros “theme.xml” para as views da aplicação, mas, novamente, ao pesquisar sobre o assunto, fiquei mais esclarecida. 
Algumas coisas que aprendi com o desenvolvimento da aplicação foi para sempre colocar as strings no ficheiro “strings.xml” de modo a não ter strings hardcoded, colocar sempre constraints nos elementos e não esquecer que, ao criar um layout para paisagem, tem de se colocar todas as componentes que se tem no layout normal e que são utilizadas no “MainActivity.kt”, se não a aplicação vai dar erro e não vai abrir.

## 14. Future Improvements
Algumas melhorias que poderiam ser realizadas seriam a adição de mais componentes interativos ou animações. 

## 15. AI Usage Disclosure (Mandatory)
Tal como foi proposto no enunciado, nenhum destes exercícios foi desenvolvido usando inteligência artificial. Devido a ter começado a aprender sobre como usar o Android Studio e Kotlin, decidi também não utilizar autocomplete de modo a conseguir ter uma aprendizagem mais ativa.
