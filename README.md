# Android Custom View

Talk sobre a criação de Custom View no Android.

## Meetup Android Curitiba

Evento [Meetup Online #9 - Android Custom View](https://www.meetup.com/Android-Curitiba/events/273427543/) foi realizado no dia foi realizado no dia 29/09/2020,  sendo transmitido através do [YouTube](https://www.youtube.com/watch?v=eeXp0CVDrNQ). A apresenção esta diponível no [link](https://docs.google.com/presentation/d/1WG0Qm7902IJ95gXS9FnyyCPcG-vi61LXvg6VF2F28_Y/edit?usp=sharing).

## Detalhes do projeto

O projeto foi dividido em  três módulos, sendo dois módulos core. 

### No módulo `app`

Este módulo contém a aplicação demo, onde, temos três activity's, sendo elas:

* A [MainActivity](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/main/java/io/github/viniciusalvesmello/androidcustomviewcomponents/MainActivity.kt) é a tela inicial da aplicação com links para as demais;
* A [CustomEditTextActivity](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/main/java/io/github/viniciusalvesmello/androidcustomviewcomponents/CustomEditTextActivity.kt) possui todos os formatos disponíveis do CustomEditText;
* A [CustomButtonActivity](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/main/java/io/github/viniciusalvesmello/androidcustomviewcomponents/CustomButtonActivity.kt) possui todos os formatos disponíveis do CustomButtom.

### No módulo `:core:design`

Este módulo centraliza toda a parte de design system do app, controlando os estilos da aplicação.

Este módulo também centraliza as Custom View do projeto, conforme abaixo:

* O [CustomEditText](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/design/src/main/java/io/github/viniciusalvesmello/design/components/edittext/CustomEditText.kt) possui a implementação de vários formatos de entrada de texto, como o texto, apenas número, reais, telefone, CPF e CNPJ. Na parte de validações e mascaras foi utilizado a lib [Android Canarinho](https://github.com/concretesolutions/canarinho).
* O [CustomButton](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/design/src/main/java/io/github/viniciusalvesmello/design/components/button/CustomButton.kt) possui a implementação de vários formatos de botões, além de diponibilizar a opção de loading. Dentro dos formatos temos o padrão, WhatsApp (Com e sem o número) e telefone (Com e sem o número), podendo todos estarem no estado desabilitado.

### No módulo `:core:test`

Este módulo compartilha a base do **Robot Pattern** entre os módulos que possuem testes instrumentais.

Dentro deste módulo podemos destacar:

* A classe [ActionRobot](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/test/src/main/java/io/github/viniciusalvesmello/test/robot/ActionRobot.kt) responsável por disponibilizar as ações, como por exemplo, Click em botões, Preenchimento de texto no edittext, etc;
* A classe [AssertRobot.kt](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/test/src/main/java/io/github/viniciusalvesmello/test/robot/AssertRobot.kt) disponibiliza mecanismo de checagem da screen do android, como por exemplo, checagem se um texto esta visível na tela, se um checkbox esta marcado ou não, se o custom buttom esta em modo de loading, etc;
* O arquivo [Actions](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/test/src/main/java/io/github/viniciusalvesmello/test/customs/Actions.kt) fornece funções personalizadas, utilizadas pela classe [ActionRobot](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/test/src/main/java/io/github/viniciusalvesmello/test/robot/ActionRobot.kt);
* O arquivo [Matchers](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/test/src/main/java/io/github/viniciusalvesmello/test/customs/Matchers.kt) fornece funções personalizadas, utilizadas pela classe [AssertRobot.kt](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/test/src/main/java/io/github/viniciusalvesmello/test/robot/AssertRobot.kt).


### Testes Instrumentais com Espresso

Os testes instrumentais foram criados no módulo app, onde temos as a [CustomEditTextActivity](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/main/java/io/github/viniciusalvesmello/androidcustomviewcomponents/CustomEditTextActivity.kt) e a [CustomButtonActivity](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/main/java/io/github/viniciusalvesmello/androidcustomviewcomponents/CustomButtonActivity.kt).

Para cada tela foi criado um arquivo de teste, sendo eles:

* O arquivo [CustomButtonActivityTest.kt](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/androidTest/java/io/github/viniciusalvesmello/androidcustomviewcomponents/test/CustomButtonActivityTest.kt) é responsável pelo teste da [CustomEditTextActivity](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/main/java/io/github/viniciusalvesmello/androidcustomviewcomponents/CustomEditTextActivity.kt);
	* Para realizar os testes é utilizado o arquivo [CustomButtonActivityRobot.kt](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/androidTest/java/io/github/viniciusalvesmello/androidcustomviewcomponents/robot/CustomButtonActivityRobot.kt) que faz parte da arquitetura do **Robot Pattern**;
* O arquivo [CustomEditTextActivityTest.kt](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/androidTest/java/io/github/viniciusalvesmello/androidcustomviewcomponents/test/CustomEditTextActivityTest.kt) é responsável por fazer o teste da [CustomButtonActivity](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/main/java/io/github/viniciusalvesmello/androidcustomviewcomponents/CustomButtonActivity.kt);
	* Para realizar os testes é utilizado o arquivo [CustomEditTextActivityRobot.kt](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/app/src/androidTest/java/io/github/viniciusalvesmello/androidcustomviewcomponents/robot/CustomEditTextActivityRobot.kt) que faz parte da arquitetura do **Robot Pattern**.

### Testes Unitários com Mockk

Neste projeto foi implementado os testes unitários do [CustomButton](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/design/src/main/java/io/github/viniciusalvesmello/design/components/button/CustomButton.kt), utilizando como fonte o artigo [Unit Testing Custom View in Android](https://levelup.gitconnected.com/unit-testing-custom-view-in-android-56cab3eb0d7e). Para mais detalhes consulte o código da classe de teste [CustomButtonTest](https://github.com/viniciusalvesmello/androidCustomViewComponents/blob/master/core/design/src/test/java/io/github/viniciusalvesmello/design/components/CustomButtonTest.kt).

