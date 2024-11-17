 # 🚩 **Reconquering-the-land-of-fantasy** 🚩

Buenas profes! Algunas consideraciones para que tengan en cuenta si prueban el codigo (sobre todo para Lucas).

# Test de FileReader 🔴
Lo mas probable es que si intentan ejecutar el codigo de este test (si no me equivoco Lucas usa ubuntu), va tirar una excepcion, ya que para que ninguno de los tests printee **nada** en cosola al ejecutarlos, alguna de las salidas las mande a **"NULL"**, si no me equivoco, en Windows difiere con Linux, ya que en Linux deberia haber redirigido la salida de los Sysout.println a  **"/dev/null"** es una consideracion para que tengan en cuenta.

# Tests en General 💠
Si ven que la ejecucion de los test demora al inicio es porque se testearon tambien los **Console Animation**, los cuales utilizan un thread de sleep para que la salida por consola se vea linda, el problema era que si no los testeabamos ibamos a tener problemas con el coverage.

Por otro lado, el **main** no fue testeado ya que lo pedido eran pruebas **unitarias**.

# Integrantes 🟢
💠Gonzalez, Luca
💠Abaca,  Ivan
💠Coronati, Augusto
💠Fernandez, Rocio
💠Licarzi, Florencia
💠Zabalgoitia, Agustin
