# TrabalhoCompiladores

Para criar as classes para o analisador léxico e sintático, vá, pelo terminal, até a pasta onde elas se encontram e executem os seguintes comandos:

Na pasta onde está .flex, execute este comando pelo terminal
  - java -jar jflex-1.6.1.jar Lexer.flex

Na pasta onde está .cup, execute este comando pelo terminal
  - java -jar java-cup-11b.jar -parser Parser -symbols Sym Parser.cup

