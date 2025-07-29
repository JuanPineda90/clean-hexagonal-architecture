# Proyecto: Microservicios con Arquitectura Hexagonal

Este repositorio contiene dos microservicios desarrollados en Java con Spring Boot utilizando el scaffold de Bancolombia y aplicando los principios de la arquitectura hexagonal. Los microservicios son:

* `customer-service`: Gestiona clientes y sus productos asociados.
* `product-service`: Gestiona los productos disponibles en el sistema.

---

## Tecnologías Utilizadas

* Java 17
* Spring Boot
* Gradle (multi-módulo)
* JPA/Hibernate
* Arquitectura Hexagonal (Clean Architecture)
* Lombok
* Docker (opcional)
* GitHub Actions (opcional para CI)

---

## Estructura de Carpetas (por microservicio)

```bash
/customer-service/
│
├── app-service/                  # Spring Boot Application principal
├── model/                        # Módulo de dominio (entidades, gateways, excepciones)
├── usecase/                      # Lógica de negocio (casos de uso)
├── infrastructure/
│   ├── helpers/                  # Excepciones técnicas
│   └── driven-adapters/
│       └── jpa-repository/       # Adaptador para JPA (repositorio de datos)
└── entry-points/
    └── rest/                     # Controladores REST
```

---

## Cómo Ejecutar los Microservicios

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/clean-hexagonal-architecture.git
cd clean-hexagonal-architecture
```

### 2. Construir los proyectos

```bash
cd customer-service
./gradlew clean build

cd ../product-service
./gradlew clean build
```

### 3. Ejecutar localmente

```bash
# Desde la carpeta del microservicio deseado
./gradlew bootRun
```

---

## Endpoints Principales

### Customer Service

| Método | Endpoint                 | Descripción                             |
| ------ | ------------------------ | --------------------------------------- |
| GET    | `/customers/{id}`        | Obtener un cliente por ID               |
| GET    | `/customers`             | Listar todos los clientes               |
| POST   | `/customers`             | Crear un nuevo cliente                  |
| PUT    | `/customers/{id}`        | Actualizar un cliente existente         |
| GET    | `/customers/code/{code}` | Obtener cliente con detalles por código |

### Product Service (Ejemplo)

| Método | Endpoint         | Descripción                |
| ------ | ---------------- | -------------------------- |
| GET    | `/products/{id}` | Obtener un producto        |
| GET    | `/products`      | Listar todos los productos |

---

## Manejo de Errores

Se utiliza una estructura centralizada para excepciones:

* **BusinessException**: errores de lógica del dominio (por ejemplo, cliente no encontrado).
* **TechnicalException**: errores técnicos como conexión a base de datos, timeouts, etc.

Estas excepciones se transforman en respuestas HTTP significativas mediante un `@RestControllerAdvice`.

---

## TODO

* [ ] Implementar integración con servicio de transacciones
* [ ] Agregar pruebas unitarias y de integración
* [ ] Dockerizar ambos servicios para despliegue
* [ ] Configurar CI/CD

---

## Autor

Juan Camilo Pineda Atehortua
Ingeniero Electrónico | Backend Developer Junior | QA Engineer
