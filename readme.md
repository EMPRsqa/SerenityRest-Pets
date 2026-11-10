# 🐾 ¡El Gran Robot de la Tienda de Mascotas! 🤖

¡Hola! Bienvenido a la guía oficial de nuestro proyecto de automatización. Si alguna vez te has preguntado cómo los superhéroes de la programación hacen para probar páginas web y aplicaciones sin tocar el teclado, ¡estás en el lugar correcto!

Aquí construimos un **robot inteligente** que va solito a una tienda de mascotas virtual (la API de Petstore) a crear cuentas, buscarlas y actualizarlas usando un archivo de Excel como si fuera un mapa del tesoro.

## 🛠️ ¿Qué superpoderes (herramientas) usamos?

Para armar este proyecto, juntamos varias tecnologías geniales:

1. **Java 23 y Gradle 8.10:** Es el motor y la gasolina de nuestro cohete. Le dice a la computadora cómo compilar y organizar las piezas.\
   - **Verificar el compilador en IntelliJ:**Asegurar compatibilidad con Java 23 y Gradle 8.10.\
   Ve a **File** > **Settings** > **Build, Execution, Deployment** > **Build Tools** > **Gradle**. \
   En la opción **Distribution** asegurate de seleccionar tu instalación local de Gradle-8.10 en la ruta correcta.\
   En la opción **Gradle JVM**, despliega la lista y selecciona tu ruta de **Amazon Corretto 23**. *Verification:* El selector de Gradle JVM muestra explícitamente la versión 23 de Corretto.

2. **Cucumber:** Es nuestro libro de cuentos en español. Ahí escribimos las misiones del robot usando palabras sencillas como:

   * *Dado* que nos conectamos a la tienda...

   * *Cuando* leemos el Excel...

   * *Entonces* el servidor nos responde con una gran sonrisa (código 200).

3. **Serenity BDD:** Es nuestro camarógrafo y reportero estrella. Mientras el robot trabaja, Serenity toma fotos y anota todo para armar un informe final súper colorido.

4. **El Patrón Screenplay:** Es la obra de teatro de nuestro robot. En lugar de hacer mil cosas a la vez, dividimos al actor (`AutomationUser`) en tareas organizadas: *Crear usuario*, *Consultar usuario* y *Actualizar usuario*.

5. **Apache POI:** Es el cofre secreto donde guardamos los datos de nuestros usuarios en un archivo de Excel (`.xlsx`).

## 🚀 ¿Cómo poner a correr al robot?

Es muy fácil. Solo abre tu terminal (o tu programa IntelliJ) en la carpeta del proyecto y escribe este comando mágico:

```
gradle clean test

```

El robot se despertará, leerá el Excel, hablará con el servidor de internet y hará toda la magia en menos de un minuto.

## 📊 ¿Dónde veo el resultado?

Una vez que el robot termine su misión con éxito (`BUILD SUCCESSFUL`), podrás ver un informe fotográfico y detallado ingresando a esta ruta secreta en tu computadora:

📂 [`target/site/serenity/index.html`](target/site/serenity/index.html)

¡Hazle doble clic y verás el reporte oficial de todo lo que logró el robot paso a paso! 🎉