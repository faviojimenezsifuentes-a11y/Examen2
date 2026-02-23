# full_Api_Pc - Consulta RUC SUNAT (Decolecta) + Historial en Postgres

Proyecto Spring Boot (Maven) que consulta RUC a través de la API externa de Decolecta usando OpenFeign y guarda:
- Datos de la empresa (`company`)
- Historial de consultas (`consulta`) con SUCCESS / ERROR

## Requisitos
- Java 17 (JDK 17)
- Maven 3.x
- PostgreSQL 15+
- Token de Decolecta (variable de entorno)

## Configuración (application.properties)
```properties
spring.application.name=full_Api_Pc
spring.datasource.url=jdbc:postgresql://localhost:5432/SunatBd
spring.datasource.username=postgres
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

decolecta.token=${DECOLECTA_TOKEN}
decolecta.base-url=https://api.decolecta.com
