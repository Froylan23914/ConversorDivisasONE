# Conversor de Divisas
_Conversor de Divisas para el Programa ONE (Oracle Next Education) en java._
## Introducción:
_Se nos solicitó crear un conversor de divisas utilizando el lenguaje Java._
### Requisitos:
_El convertidor de monedas debe:_
```
* Convertir de la moneda de tu país a Dólar.
* Convertir de la moneda de tu país a Euros.
* Convertir de la moneda de tu país a Libras Esterlina.
* Convertir de la moneda de tu país a Yen Japonés.
* Convertir de la moneda de tu país a Won sul-coreano.
```
_Recordando que también debe ser posible convertir inversamente, es decir:_
```
* Convertir de Dólar a la moneda de tu país.
* Convertir de Euros a la moneda de tu país.
* Convertir de Libras Esterlina a la moneda de tu país.
* Convertir de Yen Japonés a la moneda de tu país.
* Convertir de Won sul-coreano a la moneda de tu país.
```
### Extras:
_Como desafío extra te animamos a que dejes fluir tu creatividad, si puedo convertir divisas, ¿tal vez pueda añadir a mi programa otros tipos de conversiones como temperatura por ejemplo?_
## Desarrollo:
_Las mondeas tienen diferentes valores de cambio con respecto a otras monedas extranjeras(Divisa). Esto se debe a varios factores como lo es la oferta y demanda._
_Aqui podemos observar que para cada par de **divisas** tenemos un **Factor de Conversión** y que dependiendo del orden de estas **divisas** el factor es inversamente proporcional_
### Modelado de las Clases base:
_Para este Proyecto se modelara las siguientes Clases con sus atributos y metodos:_
```
FactorConversion
-divisa1:String 
-divisa2:String 
-factor:double
+FactorConversion(divisa1:String, divisa2:String,factor:double)
+getFactor(divisa1:String, divisa2:String):double
+isDivisa(divisa:String):boolean
+getDivisa1():String
+getDivisa2():String
+toString():String
+equals(o:Object):boolean
+hashCode():int

Convertidor
-divisas:HashSet<FactorConversion>
+Convertidor()
+getFactorConversion(divisa1:String,divisa2:String):double
+getArrayListDivisas():ArrayList<String>
+toString():String
```
_Con estas 2 clases, ya se puede trabajar ya sea en consola o en interfaz gráfica_
### Modelado de las Clases para manejar un Grafical User Interface(GUI):
_Se creo la siguiente clase para el manejo del GUI:_
```
GUIConversor
-convertidor:Convertidor
-listaDivisas:List<String>
-miFrame:JFrame
-jcbDivisaEntrada:JComboBox
-jcbDivisaSalida:JComboBox
-jtfCantidad:JTextField
+GUIConversor()
-agregarElementosalFrame():void
-setSizeOf(c:Component,size:Dimension):void
-agregarPanel(panelPadre:JPanel,componentes:List<Component>):void
+actionPerformed(evento:ActionEvent):void
```
## Compilado y ejecución:
_Para compilar primero ejecuta el siguiente comando estando en la raiz del proyecto_
```
mkdir bin
javac -d ./bin ./src/conversor/*.java
```
_Se mostrara una estructura de carpetas parecida a esta:_
```
![Imagen de la estructura de carpeta](https://github.com/Froylan23914/ConversorDivisasONE/blob/main/img/estructuraProyecto.png)
```
_Posteriormente para ejecutarlo, primero entra en la carpeta bin y ejecuta lo siguiente:_
```
cd bin
java conversor.TestConversor
```
```
![Imagen del Programa](https://github.com/Froylan23914/ConversorDivisasONE/blob/main/img/principal.png)
```
_Cuando ejecutes el boton **Intercambiar Divisas** Cambiara el orden de las divisas que están elejidas_
```
![Imagen boton Intercambiar Divisas](https://github.com/Froylan23914/ConversorDivisasONE/blob/main/img/botonIntercambiarDivisa.png)
```
_A continuación, si oprime el boton **Convertir** mientras esta vacio el *inputText* de cantidad, mostrará lo siguiente:_
```
![Imagen Warning input vacio](https://github.com/Froylan23914/ConversorDivisasONE/blob/main/img/warningCampoVacio.png)
```
_Ahora, si la cantidad tiene letras, mostrará el siguiente error mostrando la cadena que entro:_
```
![Imagen error en el input](https://github.com/Froylan23914/ConversorDivisasONE/blob/main/img/errorEntrada.png)
```
_Por ultimo, si la cantidad es un valor aceptable(un número), devolvera el cambio de divisa de esa cantidad:_
```
![Imagen Resultado](https://github.com/Froylan23914/ConversorDivisasONE/blob/main/img/resultado.png)
```
## Autor:
* **Froylan Aguilar Contreras** - *Trabajo Total* - [Froylan23914](https://github.com/Froylan23914)
## Fuentes:
* La Base de datos de las divisas fue tomada el dia 03 marzo 2023 desde el buscador de google.
* [JAVA SE 8 API](https://docs.oracle.com/javase/8/docs/api/index.html)
* Manejo de [Layouts](https://docs.oracle.com/javase/tutorial/uiswing/layout/index.html)
* Manejo de [Components](https://docs.oracle.com/javase/tutorial/uiswing/components/index.html)
* Manipulacion del archivo [README.md](https://gist.github.com/Villanuevand/6386899f70346d4580c723232524d35a)
## Muestras de gratitud:
* **Andrés Villanueva** - *Gracias por ayudarme con tu plantilla del archivo Readme.md* - [villanuevand](https://github.com/villanuevand)
