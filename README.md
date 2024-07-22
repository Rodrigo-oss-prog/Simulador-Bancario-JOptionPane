[![Print](Simulador-Bnacario-JOptionPane/metodo JOptionPane.png)]

# JOptionPane
O método JOptionPane.showMessageDialog é usado para exibir uma caixa de diálogo simples com uma mensagem.
Ele faz parte da biblioteca Swing do Java e é muito útil para mostrar informações ao usuário de forma rápida e fácil. 


## código comentado
### 1.	Sintaxe Básica:

### Java
````JOptionPane.showMessageDialog(null, "Sua mensagem aqui");````

- O primeiro parâmetro (null) indica que a caixa de diálogo não tem um componente pai específico e será centralizada na tela.
- O segundo parâmetro é a mensagem que você deseja exibir.

### 2.	Exemplo com Título e Tipo de Mensagem:

````JOptionPane.showMessageDialog(null, "Sua mensagem aqui", "Título da Janela", JOptionPane.INFORMATION_MESSAGE);````
- 	O terceiro parâmetro é o título da janela.
- 	O quarto parâmetro define o tipo de mensagem (por exemplo, INFORMATION_MESSAGE, ERROR_MESSAGE, etc.).

O método JOptionPane.showInputDialog é usado para exibir uma caixa de diálogo que solicita ao usuário uma entrada de texto. Ele faz parte da biblioteca Swing do Java e é muito útil para capturar informações do usuário de forma interativa. Aqui está um resumo de como ele funciona:

- Este código exibe uma caixa de diálogo com uma mensagem solicitando ao usuário que digite algo. O valor digitado é retornado como uma string.

### 2.	Exemplo com Título e Tipo de Mensagem:

````String input = JOptionPane.showInputDialog(null, "Digite seu nome:", "Entrada de Nome", JOptionPane.QUESTION_MESSAGE);````
- O primeiro parâmetro (null) indica que a caixa de diálogo não tem um componente pai específico.
- O segundo parâmetro é a mensagem exibida na caixa de diálogo.
- O terceiro parâmetro é o título da janela.
-	O quarto parâmetro define o tipo de mensagem (por exemplo, QUESTION_MESSAGE).

### 3.	Exemplo com Valor Inicial:

`````String input = JOptionPane.showInputDialog(null, "Digite sua idade:", "Entrada de Idade", JOptionPane.QUESTION_MESSAGE, null, null, "18").toString();`````

- Este exemplo inclui um valor inicial (“18”) no campo de entrada.

### 4.	Tipos de Mensagens:

 - JOptionPane.INFORMATION_MESSAGE: Mensagem informativa.
 - JOptionPane.WARNING_MESSAGE: Mensagem de aviso.
 - JOptionPane.ERROR_MESSAGE: Mensagem de erro.
 - JOptionPane.QUESTION_MESSAGE: Mensagem de pergunta.

   ````Integer.parseInt(JOptionPane.showInputDialog````
   
   Para converter a entrada de um JOptionPane.showInputDialog em um número inteiro, você pode usar o método Integer.parseInt.
   
   ````int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número:"));````
   
   ### 1.	Exibir a Caixa de Diálogo:
  - JOptionPane.showInputDialog("Digite um número:") exibe uma caixa de diálogo solicitando ao usuário que digite um número. O valor retornado é uma string.

    
  ### 2.	Converter a String para Inteiro:
  -	Integer.parseInt(...) converte a string retornada pelo showInputDialog em um número inteiro.

  ### Exemplo Completo:
````
import javax.swing.JOptionPane;

public class Exemplo {
    public static void main(String[] args) {
        try {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número:"));
            JOptionPane.showMessageDialog(null, "Você digitou: " + numero);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número inteiro.");
        }
    }
}
````
![icons8-java](https://user-images.githubusercontent.com/76852813/172716937-4574740e-2d2e-4326-af3b-4a42bad058c1.svg)

### Consultas
<a href="https://stackoverflow.com/questions/3120922/joptionpane-input-to-int">stackoverflow</a>











 
