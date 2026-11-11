# HANDSIGN — Android

Primeira estrutura do teclado Android HANDSIGN.

- Nome: HANDSIGN
- Application ID: `com.elizierdias.handsign`
- `minSdk`: 26 (Android 8.0)
- Kotlin + Android `InputMethodService`
- Interface inicial nativa, sem dependência de Compose.

## Abrir e compilar

1. Abra a pasta do projeto no Android Studio.
2. Aguarde a sincronização do Gradle.
3. Compile com **Build > Build APK(s)**.
4. Instale o APK no Android.
5. Abra HANDSIGN e toque em **Ativar teclado HANDSIGN**.
6. Ative HANDSIGN nas definições de teclados.
7. Volte à aplicação e toque em **Selecionar HANDSIGN**.

## Estado desta versão

O teclado já possui a estrutura de serviço IME e teclas que inserem texto.
As representações gráficas das configurações de mão de Libras ainda não estão implementadas.
Não são usados emojis de mãos genéricos como se fossem sinais corretos.

## Próximas etapas

1. Produzir e validar os desenhos vetoriais A–Z e Ç com referência linguística de Libras.
2. Mostrar o glifo de mão na tecla e na faixa de pré-visualização.
3. Adicionar alternância entre letras, números e pontuação.
4. Implementar sequência visual exportável como imagem/sticker.
5. Testar em diferentes aplicações e versões Android.

## Nota sobre package name

O identificador fornecido terminava em ponto (`com.elizierdias.handsign.`).
O ponto final foi removido porque um application ID Android não deve terminar com ponto.
