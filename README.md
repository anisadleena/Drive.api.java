Spring initializr
1. Project: Maven
2. Language: Java
3. Spring Boot Version: Latest stable
4. Dependencies:
-> Spring Web (For REST API)
-> Spring Boot DevTools (For hot reload)
-> Spring Data JPA (For database)
-> MySQL Driver (For database connection)
-> Spring Security (For authentication)
-> JWT (For token-based authentication)

Flower Columns:
id (Integer, Primary Key) – Unique identifier for each flower. (Already included)
name (String) – Common name of the flower. (Already included)
type (String) – Category or classification of the flower (e.g., Rose, Tulip, Orchid). (Already included)
description (String) – A brief description of the flower. (Already included)
scientific_name (String) – Botanical or Latin name of the flower.
color (String) – Primary color of the flower.
bloom_season (String) – The season when the flower blooms (e.g., Spring, Summer).
native_region (String) – Where the flower originates or is commonly found.
sunlight_requirement (String) – Light conditions required (e.g., Full Sun, Partial Shade).
water_requirement (String) – Frequency of watering (e.g., Low, Medium, High).
price (Decimal/Double) – Cost of the flower (if applicable).
stock_quantity (Integer) – Quantity available in stock (useful if it's for sales).
added_date (Timestamp) – When the flower record was added to the system.
updated_date (Timestamp) – When the flower record was last updated.
image_url - flower image


=====================================================
to run Java terminal: mvn spring-boot:run
=====================================================