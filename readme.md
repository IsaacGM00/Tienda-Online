# Arquitectura Hexagonal

## ¿Qué es la arquitectura de software?
Conjunto de patrones que proporcionan un marco de referencia necesario para guiar la construcción de un software, permitiendo a los programadores, analistas y todo el conjunto de desarrolladores del software compartir una misma línea de trabajo y cubrir todos los objetivos y restricciones de la aplicación. Es considerada el nivel más alto en el diseño de la arquitectura de un sistema puesto que establecen la estructura, funcionamiento e interacción entre las partes del software.

Ejemplos de arquitectura son MVC, la programación por capas, peer-to-peer, orientada a servicios (SOA), cliente-servidor, etc…

## Entonces, ¿Qué es la arquitectura Hexagonal?
La arquitectura hexagonal, a la que también se le conoce como arquitectura de puertos y adaptadores, es una arquitectura de software que se basa en la idea de aislar la lógica comercial central de las preocupaciones externas, por medio de la separación de la aplicación en componentes débilmente acoplados.

## Problemas comunes en el desarrollo de software al no implementar una arquitectura.
Una de las grandes pesadillas en las aplicaciones de software ha sido la infiltración de la lógica del negocio en el código de la interfaz de usuario. Esto trae múltiples problemas:
- Dificulta la automatización de pruebas.
- Impide el cambio de uso de la aplicación.
- Dificulta o impide el uso por otro programa.

Otro gran problema es el acoplamiento con detalles de infraestructura como la base de datos.

## Cuando utilizarla
Arquitectura Hexagonal es ideal cuando la modularidad y el mantenimiento son críticos. Úsala en aplicaciones complejas donde la lógica de negocio debe separarse de los detalles de implementación.

## Objetivo de la Arquitectura Hexagonal
Permitir que una aplicación sea usada de la misma forma por usuarios, programas, pruebas automatizadas o scripts, y sea desarrollada y probada de forma aislada(isolated) de sus eventuales dispositivos y bases de datos en tiempo de ejecución.

Separar nuestra aplicación en distintas capas o regiones con su propia responsabilidad. De esta manera consigue desacoplar capas de nuestra aplicación permitiendo que evolucionen de manera aislada. Además, tener el sistema separado por responsabilidades nos facilitará la reutilización.

Gracias a este desacoplamiento obtenemos también la ventaja de poder testear estas capas sin que intervengan otras externas, falseando el comportamiento con dobles de pruebas, por ejemplo.

## Estructura de la Arquitectura Hexagonal
Esta arquitectura se suele representar con forma de hexágono, pero el número de lados no es lo que importa, sino lo que estos representan. Cada lado representa un puerto hacia dentro o fuera de la aplicación. Por ejemplo, un puerto puede ser el HTTP, y hacer peticiones a nuestra aplicación, otro puerto puede ser el SOAP y también hace peticiones a la aplicación. Otro puede ser un servidor de base de datos en donde persistir los datos de nuestro dominio.
<p align="center">
  <a href="https://medium.com/@edusalguero/arquitectura-hexagonal-59834bb44b7f" target="blank"><img src="https://miro.medium.com/v2/resize:fit:4800/format:webp/1*yR4C1B-YfMh5zqpbHzTyag.png" width="600" alt="Logo" /></a>
</p>

<b>A continuación, exploraremos detalladamente las capas clave que componen la Arquitectura Hexagonal y analizaremos cómo se complementan para lograr un diseño coherente y eficiente.</b>
- <p align="justify"><b>Capa de Dominio:</b> La capa de dominio constituye el núcleo central del hexágono y alberga las reglas de negocio esenciales. Aquí encontramos modelos de datos y sus restricciones, definiendo la esencia misma de la aplicación.</p>
- <p align="justify"><b>Capa de Aplicación:</b> Justo por encima de la capa de dominio, se sitúa la capa de aplicación, donde se definen los distintos casos de uso de la aplicación. Aquí, la lógica de negocio del dominio se implementa en términos de casos de uso específicos.</p>
- <p align="justify"><b>Capa de Infraestructura:</b> La capa de infraestructura se encarga de facilitar la entrada y salida de datos, abordando aspectos técnicos esenciales para la ejecución de la aplicación. Este nivel no contiene lógica de negocio, sino que se centra en cuestiones de infraestructura técnica.</p>
- <p align="justify"><b>Comunicación entre Capas:</b> El código en cada capa describe cómo comunicarse con las demás utilizando interfaces (puertos) e implementaciones (adaptadores). Esta interacción cuidadosamente diseñada garantiza la coherencia y la eficiencia en la transmisión de información entre las capas.</p>

## Pros de la Arquitectura Hexagonal

- <p align="justify"><b>Mejora en la Testabilidad:</b> La estructura clara de la Arquitectura Hexagonal facilita la escritura y ejecución de pruebas unitarias, asegurando la robustez del código y reduciendo los errores.</p>
- <p align="justify"><b>Promoción de la Modularidad:</b> La separación de responsabilidades entre el núcleo y los adaptadores fomenta la creación de módulos independientes, facilitando la escalabilidad y el mantenimiento del sistema.</p>
- <p align="justify"><b>Adaptabilidad a Cambios:</b> La flexibilidad inherente permite adaptarse rápidamente a cambios en los requisitos o en el entorno externo, manteniendo la agilidad del desarrollo.</p>


## Contras de la Arquitectura Hexagonal
- <p align="justify"><b>Complejidad Inicial:</b> Implementar la Arquitectura Hexagonal puede requerir una planificación cuidadosa y un entendimiento profundo de los principios, lo que puede aumentar la complejidad inicial del desarrollo.</p>
- <p align="justify"><b>Curva de Aprendizaje:</b> Para los desarrolladores nuevos en esta metodología, puede haber una curva de aprendizaje significativa al comprender la estructura y los patrones de diseño específicos de la Arquitectura Hexagonal.</p></p>

## A cerca de este proyecto (arquetipo maven)
Este proyecto es una base para desarrollar con arquitectura hexagonal, tiene 5 adaptadores o puertos que son:
- Bases de datos relacionales como Postgres,Oracle,H2,MySql (uso de JPA)
- MongoDB
- Redis cache
- Consumo de API´s REST con Feign
- Kafka (consumidor y productor)


# Reglas del juego 🌟
Este proyecto está estructurado de manera modular comprendido por los siguientes módulos:

## Capa de Aplicación (Application) 📱

- La capa de aplicación es donde reside la lógica de la aplicación y actúa como un intermediario entre la interfaz de usuario y el dominio. 
- Es responsable de interpretar los comandos o solicitudes recibidas desde la interfaz de usuario y orquestar la ejecución de las operaciones necesarias para satisfacer esas solicitudes.
- Aquí se definen los casos de uso de la aplicación y se implementan como servicios de aplicación o controladores.
- Esta capa maneja la transacción, la seguridad y la coordinación de operaciones.

## Capa de Arranque (Bootloader) 🚀

- La capa de arranque inicializa y configura la aplicación.

## Capa de Dominio (Domain) 🌐

- La capa de dominio contiene la lógica central y las reglas de negocio de la aplicación.
- Aquí se definen las entidades y servicios del dominio, independientes de la tecnología.

## Capa de Infraestructura (Infrastructure) 💻
- La capa de infraestructura proporciona implementaciones concretas de los puertos definidos en la capa de aplicación, permitiendo que la aplicación interactúe con recursos externos, como bases de datos, servicios web, sistemas de archivos, etc.
- Incluye adaptadores que conectan la lógica de la aplicación con recursos externos.
- Los detalles de implementación específicos de la infraestructura están encapsulados en esta capa.

Esta arquitectura promueve la modularidad, la reutilización y la testabilidad del código, facilitando el mantenimiento y la evolución del sistema a lo largo del tiempo.

#  Patrones de diseño implementados🛠️
## Patrón CQRS (Command Query Responsibility Segregation) 🔄

El patrón CQRS (Command Query Responsibility Segregation) es un patrón arquitectónico que sugiere separar las operaciones de lectura (queries) de las operaciones de escritura (commands) en un sistema. En lugar de tener un único modelo de dominio para manejar tanto las consultas como las modificaciones de los datos, el patrón CQRS propone tener dos modelos distintos: uno para realizar consultas y otro para manejar comandos.

## Principios del Patrón CQRS

- **Separación de responsabilidades**: Divide las operaciones de lectura y escritura en modelos separados, lo que permite optimizar cada modelo para su tarea específica.
- **Modelado del dominio enfocado**: Permite modelar los comandos y consultas según las necesidades del negocio, sin comprometer la simplicidad o la eficiencia.
- **Escalabilidad**: Al tener modelos de lectura y escritura separados, es posible escalar y optimizar cada uno de forma independiente, según los requerimientos de rendimiento.
- **Consistencia eventual**: Dado que los comandos pueden modificar el estado del sistema de forma asíncrona, el patrón CQRS tiende a ser más adecuado para escenarios donde la consistencia eventual es aceptable.

## Componentes del Patrón CQRS

- **Comandos (Commands)**: Representan las operaciones de escritura que modifican el estado del sistema. Los comandos suelen ser imperativos y desencadenan acciones que afectan al dominio de la aplicación.
- **Consultas (Queries)**: Representan las operaciones de lectura que recuperan datos del sistema sin modificar su estado. Las consultas suelen ser declarativas y devuelven información para su visualización o procesamiento posterior.
- **Modelo de escritura (Write Model)**: Es el modelo de dominio encargado de manejar los comandos y realizar las modificaciones en el estado del sistema.
- **Modelo de lectura (Read Model)**: Es el modelo de dominio optimizado para realizar consultas de manera eficiente. Este modelo puede estar denormalizado y precalculado para mejorar el rendimiento en las operaciones de lectura.

## Beneficios del Patrón CQRS

- **Mejora el rendimiento**: Al tener modelos de lectura optimizados, se pueden ejecutar consultas de manera más eficiente, lo que mejora el rendimiento del sistema.
- **Simplicidad en el modelado del dominio**: Al separar los comandos de las consultas, se puede modelar cada aspecto del negocio de manera más simple y enfocada.
- **Escalabilidad**: Permite escalar los componentes de lectura y escritura por separado, lo que facilita el manejo de grandes volúmenes de datos y picos de carga.
- **Flexibilidad**: Al tener modelos de lectura y escritura separados, se pueden adaptar y evolucionar de forma independiente según los cambios en los requisitos del negocio.

El patrón CQRS es especialmente útil en aplicaciones donde la carga de lectura y escritura son significativamente diferentes, o donde se requiere un modelado del dominio complejo y flexible.

## Patrón Value Object (¡tu decides implementarlo! 😎)

El patrón Value Object es un patrón de diseño que se utiliza para representar un objeto que no tiene una identidad propia, sino que se valora únicamente por sus atributos o valores. A diferencia de las entidades, los objetos de valor son inmutables y comparables por sus valores internos en lugar de por identificadores únicos.

## Características del Patrón Value Object

- **Inmutabilidad**: Los objetos de valor son inmutables, lo que significa que una vez creados, sus valores no pueden modificarse.
- **Comparabilidad por valor**: La igualdad entre dos objetos de valor se determina comparando sus valores internos en lugar de referencias de memoria.
- **Identidad basada en los valores**: Dos objetos de valor con los mismos valores internos se consideran iguales, independientemente de su instancia.

## Ejemplos de Value Objects

- **Fecha de nacimiento**: Representa una fecha específica en el calendario. Dos fechas con el mismo día, mes y año se consideran iguales, independientemente de su instancia.
- **Correo electrónico**: Representa una dirección de correo electrónico. Dos correos electrónicos con la misma dirección se consideran iguales, independientemente de su instancia.

## Beneficios del Patrón Value Object

- **Expresa intenciones**: Los objetos de valor encapsulan un concepto específico del dominio y expresan claramente la intención del código.
- **Promueve la inmutabilidad**: Al ser inmutables, los objetos de valor evitan efectos secundarios no deseados y hacen que el código sea más fácil de razonar y mantener.
- **Simplifica la comparación**: La comparabilidad basada en valores simplifica la lógica de igualdad y reduce la necesidad de implementar métodos de comparación personalizados.

En el proyecto en la capa de infraestructura encontraras paquetes nombrados como:  
- **repository**: se recomienda para operaciones de escritura.
- **DAO**: se recomineda para operaciones de lectura.

Por ejemplo al consumir un API REST en una clase repository tendriamos los verbos:
- **POST**
- **PUT**
- **DELETE**

En una clase DAO: 
- **GET**

## Recomendaciones para desarrollar con este proyecto:

Esta guía proporciona una recomendación general sobre cómo desarrollar con CQRS junto con el patrón Repository y DAO. Estas son algunas sugerencias sobre cómo podrías abordar el desarrollo de cada capa en tu aplicación.

## Capa de Dominio (Domain Layer) 🌐

- Comienza por definir tus entidades de dominio y las reglas de negocio que las rodean. Estas entidades deben representar conceptos fundamentales de tu dominio.
- Define interfaces para tus repositorios que especifican los métodos necesarios para interactuar con las entidades de dominio. Estas interfaces deben centrarse en las operaciones de lectura y escritura relacionadas con las entidades.
- No te preocupes demasiado por la implementación de los métodos en esta etapa, ya que se completarán en la capa de infraestructura.

## Capa de Infraestructura (Infrastructure Layer) 💻

- Implementa los repositorios concretos y los DAOs que interactúan con la base de datos. Estos repositorios deben implementar las interfaces definidas en la capa de dominio.
- Crea las clases y métodos necesarios para realizar operaciones de lectura y escritura en la base de datos. Asegúrate de que estas operaciones sean coherentes con el modelo de dominio definido anteriormente.
- En esta etapa, puedes utilizar herramientas y tecnologías específicas para acceder y manipular la base de datos, como JDBC, JPA, Hibernate, etc.

## Capa de Aplicación (Application Layer) 📱

- Implementa los servicios de aplicación que actúan como intermediarios entre la interfaz de usuario y las operaciones de lectura y escritura en la base de datos.
- Utiliza los repositorios definidos en la capa de infraestructura para realizar operaciones de lectura y escritura en la base de datos.
- Define los casos de uso de la aplicación y los controladores que interactúan con los servicios de aplicación. Estos casos de uso deben reflejar las funcionalidades específicas que la aplicación ofrece a los usuarios.

## Pruebas y Refactorización 🛠️

- Una vez que hayas completado la implementación de cada capa, realiza pruebas exhaustivas para garantizar que todas las funcionalidades se comporten como se espera.
- Si es necesario, realiza refactorizaciones para mejorar la claridad y la mantenibilidad del código. Esto puede incluir la extracción de métodos, la reorganización de clases o la simplificación de la lógica compleja.

Recuerda que estas etapas no son necesariamente lineales y pueden superponerse en ciertos puntos del desarrollo. Además, es importante mantener un enfoque iterativo en el desarrollo de software, lo que significa que puedes revisar y ajustar tu diseño a medida que avanzas en el desarrollo y adquieres más conocimiento sobre los requisitos y desafíos de tu aplicación.

# ¡Anuncio Importante! 🚀

## Cambios Flexibles con la Capa de Infraestructura

¡Nuestra aplicación permite una integración flexible con cualquier framework o tecnología en la capa de infraestructura!

### ¿Qué significa esto?

La capa de infraestructura es donde se implementan los detalles específicos de cómo nuestra aplicación interactúa con recursos externos, como bases de datos, servicios web y más. Lo emocionante es que ahora puedes elegir el framework o tecnología que mejor se adapte a tus necesidades y preferencias.

### ¿Por qué es importante?

- **Flexibilidad**: No estás limitado a un único framework o tecnología. Puedes adaptar la capa de infraestructura para utilizar cualquier herramienta que se ajuste mejor a tu proyecto.

- **Eficiencia**: Al utilizar herramientas familiares o las que mejor se ajusten a tu proyecto, puedes aumentar la eficiencia y reducir el tiempo de desarrollo.

- **Innovación**: Mantenemos nuestras opciones abiertas para adoptar nuevas tecnologías y aprovechar las últimas innovaciones en el desarrollo de software.

### ¿Cómo funciona?

Simplemente elige el framework o tecnología que prefieras y sigue las pautas de integración proporcionadas en nuestra documentación. ¡Es así de fácil!


## Bibliografía
- [Arquitectura Hexagonal](https://medium.com/@edusalguero/arquitectura-hexagonal-59834bb44b7f)
- [Explorando la Arquitectura Hexagonal](https://es.linkedin.com/pulse/explorando-la-arquitectura-hexagonal-un-enfoque-en-su-mu%C3%B1oz-garro-nhyee)
- [Hexagonal Architecture, there are always two sides to every story](https://medium.com/ssense-tech/hexagonal-architecture-there-are-always-two-sides-to-every-story-bc0780ed7d9c)
- [Aprende Arquitectura Hexagonal](https://www.youtube.com/watch?v=eNFAJbWCSww&ab_channel=CodelyTV-Redescubrelaprogramaci%C3%B3n)

## Contribución 🤝

¡Contribuye a nuestro proyecto y ayúdanos a hacerlo aún más genial! Aquí tienes algunas formas de contribuir:

- Realiza pruebas y envía informes de errores 🐞
- Agrega nuevas características 🛠️
- Mejora la documentación 📖
