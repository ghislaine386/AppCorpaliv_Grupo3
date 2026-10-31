# AppCorpaliv — Plataforma Móvil de Impacto Social y Vinculación
Aplicación móvil Android (MVP) que centraliza la propuesta de valor de CORPALIV y su Red Sociolaboral Alba Lab, desarrollada con Kotlin, Jetpack Compose y arquitectura MVVM.

**Colaboradores de Proyecto:** Kevin Pincheira - Ghislaine Carrasco
Proyecto de la asignatura DSY1105 · Desarrollo de Aplicaciones Móviles (Duoc UC · CITT) · Grupo 3.

---

## ¿Qué es AppCorpaliv?
AppCorpaliv es una aplicación móvil para dar a conocer el trabajo de CORPALIV (Corporación de Padres y Amigos por el Limitado Visual) y de Alba Lab, su red de inclusión social y laboral de personas con discapacidad múltiple. Permite a potenciales donantes, empresas y colaboradores conocer los programas, ver el catálogo de productos y servicios con impacto social, y manifestar su interés en colaborar. El equipo de vinculación recibe y gestiona esos registros.
La app está construida con una interfaz en Jetpack Compose y Material Design 3, con navegación centralizada mediante ViewModels y diseño adaptable a distintos tamaños de pantalla.

## ¿Para qué sirve y qué problemas resuelve?
Hoy la información sobre cómo colaborar con CORPALIV está dispersa en reuniones, presentaciones, redes sociales y contacto directo, por lo que el interés inicial de una empresa o donante rara vez se concreta. AppCorpaliv centraliza ese proceso.

**Problemas que resuelve:**
- Los interesados no encuentran en un solo lugar qué hace la organización ni cómo pueden colaborar.
- Es difícil comprender el impacto social y el destino de los aportes.
- No hay un canal claro para pasar del interés a una acción concreta (donación, alianza, voluntariado, compra de productos o capacitación).
- El equipo de vinculación no cuenta con un registro ordenado de los interesados.

**Lo que AppCorpaliv ofrece:**
- Información institucional y propósito de CORPALIV y Alba Lab.
- Programas de inclusión laboral explicados de forma simple.
- Catálogo de productos y servicios con impacto social.
- Casos de éxito e indicadores de impacto, anonimizados.
- Formulario de contacto para registrar interés en cada modalidad de colaboración.
- Pantalla de resumen que confirma el envío y vuelve al inicio automáticamente a los 15 segundos.
- Pantalla de login para el equipo de vinculación.
- Modo accesible, con preferencia guardada en el dispositivo mediante DataStore.
- Navegación con barra inferior y menú lateral, y diseño adaptable a pantallas compactas, medianas y expandidas.

## Stack Tecnológico
| Componente | Tecnología | Versión |
| ---------- | ---------- | ------- |
| Lenguaje | Kotlin | 2.2.10 |
| Interfaz de usuario | Jetpack Compose (Compose BOM) | 2026.02.01 |
| Sistema de diseño | Material Design 3 | — |
| Navegación | Navigation Compose | 2.7.7 |
| Arquitectura | MVVM (ViewModel + StateFlow / SharedFlow) | — |
| ViewModel en Compose | Lifecycle ViewModel Compose | 2.8.0 |
| Persistencia local | DataStore Preferences | 1.1.1 |
| Diseño adaptable | Material3 Window Size Class | — |
| Asincronía | Kotlin Coroutines | 1.7.3 |
| Compilación | Android Gradle Plugin / Gradle | 9.4.1 / 9.6.0 |
| Versiones de Android | minSdk / targetSdk | 24 / 37 |
| Control de versiones | Git / GitHub | — |

## Pantallas

| Pantalla | Responsabilidad |
| -------- | --------------- |
| Inicio | Presentación institucional y propósito de CORPALIV y Alba Lab. |
| Programas | Programas de inclusión laboral. |
| Catálogo | Productos y servicios con impacto social. |
| Impacto | Casos de éxito e indicadores (datos ficticios o anonimizados). |
| Contacto | Formulario para registrar interés en colaborar. |
| Resumen | Confirmación del envío y retorno automático al inicio. |
| Estado | Modo accesible, con preferencia guardada con DataStore. |
| Login | Acceso para el equipo de vinculación. |

## Requisitos previos

- Android Studio reciente, con soporte para Jetpack Compose.
- JDK 11 o superior (incluido con Android Studio).
- Emulador Android o celular con Android 7.0 (API 24) o superior.
- Módulo del equipo de vinculación para gestionar el estado de cada registro (nuevo, contactado, concretado).
